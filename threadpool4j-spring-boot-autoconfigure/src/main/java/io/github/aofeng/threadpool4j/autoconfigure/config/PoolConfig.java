package io.github.aofeng.threadpool4j.autoconfigure.config;

import lombok.Data;

/**
 * 线程池配置信息。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020/6/16
 */
@Data
public class PoolConfig {

    private String name;

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveTime;

    private int workQueueSize;

}
