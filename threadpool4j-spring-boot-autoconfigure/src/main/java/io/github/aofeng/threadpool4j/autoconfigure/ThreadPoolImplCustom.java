package io.github.aofeng.threadpool4j.autoconfigure;

import cn.aofeng.threadpool4j.ThreadPoolConfig;
import cn.aofeng.threadpool4j.ThreadPoolImpl;

/**
 * 多线程池。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2024/10/4
 */
public class ThreadPoolImplCustom extends ThreadPoolImpl {

    public ThreadPoolImplCustom(ThreadPoolConfig config) {
        super();
        super._threadPoolConfig = config;
    }

}
