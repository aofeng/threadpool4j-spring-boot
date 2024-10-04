package io.github.aofeng.threadpool4j.autoconfigure;

import cn.aofeng.threadpool4j.ThreadPool;
import cn.aofeng.threadpool4j.ThreadPoolImpl;
import io.github.aofeng.threadpool4j.autoconfigure.config.Threadpool4jProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自动配置类。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020/6/16
 */
@Slf4j
@Component
@EnableConfigurationProperties(value = {Threadpool4jProperties.class})
public class Threadpoo4jAutoConfigure implements InitializingBean, DisposableBean {

    @Autowired
    private Threadpool4jProperties threadpool4jProperties;

    private ThreadPoolManagerCustom tpm = new ThreadPoolManagerCustom();

    @Override
    public void afterPropertiesSet() throws Exception {
        ThreadPoolConfigCustom threadPoolConfig = new ThreadPoolConfigCustom();
        threadPoolConfig.setThreadpool4jProperties(threadpool4jProperties);
        threadPoolConfig.init();
        ThreadPoolImplCustom threadPool = new ThreadPoolImplCustom(threadPoolConfig);
        tpm.setThreadPool(threadPool);
        tpm.init();
    }

    @Override
    public void destroy() throws Exception {
        tpm.destroy();
    }

    @ConditionalOnMissingBean(name = {"threadPool4j"})
    @Bean(name = {"threadPool4j"})
    public ThreadPool threadPool4j() {
        return tpm.getThreadPool();
    }

}
