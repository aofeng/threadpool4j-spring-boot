package io.github.aofeng.threadpool4j.autoconfigure;

import cn.aofeng.threadpool4j.ThreadPool;
import cn.aofeng.threadpool4j.ThreadPoolImpl;
import io.github.aofeng.threadpool4j.autoconfigure.config.Threadpool4jProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@EnableConfigurationProperties({Threadpool4jProperties.class})
@ConditionalOnProperty(name = "threadpool4j.enable", havingValue = "true")
@ConditionalOnMissingBean(name = "threadPool4j")
@AutoConfiguration
public class Threadpoo4jAutoConfigure {

    @Autowired
    private Threadpool4jProperties threadpool4jProperties;

    @Bean(name = {"threadPool4j"}, initMethod = "init", destroyMethod = "destroy")
    public ThreadPool threadPool4j() {
        ThreadPoolConfigCustom threadPoolConfig = new ThreadPoolConfigCustom();
        threadPoolConfig.setThreadpool4jProperties(threadpool4jProperties);
        threadPoolConfig.init();
        return new ThreadPoolImplCustom(threadPoolConfig);
    }

}
