package io.github.aofeng.threadpool4j.autoconfigure.config;

import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 多线程池配置信息。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020/6/16
 */
@Data
@Component
@ConfigurationProperties(prefix = "threadpool4j")
public class Threadpool4jProperties {

    private boolean enable;

    private List<PoolConfig> pool;

    private JobConfig threadpoolstate;

    private JobConfig threadstate;

    private JobConfig threadstack;

}
