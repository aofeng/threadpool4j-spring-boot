package io.github.aofeng.threadpool4j.autoconfigure;

import cn.aofeng.threadpool4j.ThreadPool;
import cn.aofeng.threadpool4j.ThreadPoolImpl;
import cn.aofeng.threadpool4j.ThreadPoolManager;
import io.github.aofeng.threadpool4j.autoconfigure.config.Threadpool4jProperties;

/**
 * 线程池实例管理。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020/6/17
 */
public class ThreadPoolManagerCustom extends ThreadPoolManager {

    public ThreadPoolManagerCustom() {
        super();
    }

    public void setThreadPool(ThreadPool threadPool) {
        super.setThreadPool(threadPool);
    }

}
