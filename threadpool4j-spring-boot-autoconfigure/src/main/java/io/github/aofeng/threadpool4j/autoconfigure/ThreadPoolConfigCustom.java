package io.github.aofeng.threadpool4j.autoconfigure;

import java.util.List;

import cn.aofeng.threadpool4j.ThreadPoolConfig;
import cn.aofeng.threadpool4j.ThreadPoolInfo;
import io.github.aofeng.threadpool4j.autoconfigure.config.PoolConfig;
import io.github.aofeng.threadpool4j.autoconfigure.config.Threadpool4jProperties;

/**
 * 从配置文件（application.properties 或 application.yml）读取配置信息并存储在内存中。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020/6/17
 */
public class ThreadPoolConfigCustom extends ThreadPoolConfig {

    private Threadpool4jProperties props;

    public void setThreadpool4jProperties(Threadpool4jProperties props) {
        this.props = props;
    }

    @Override
    public void init() {
        List<PoolConfig> poolConfigList = props.getPool();
        for (PoolConfig poolConfig : poolConfigList) {
            ThreadPoolInfo info = new ThreadPoolInfo();
            info.setName(poolConfig.getName());
            info.setCoreSize(poolConfig.getCorePoolSize());
            info.setMaxSize(poolConfig.getMaxPoolSize());
            info.setThreadKeepAliveTime(poolConfig.getKeepAliveTime());
            info.setQueueSize(poolConfig.getWorkQueueSize());

            _multiThreadPoolInfo.put(info.getName(), info);
        }

        _threadPoolStateSwitch = props.getThreadpoolstate().isJobSwitch();
        _threadPoolStateInterval = props.getThreadpoolstate().getInterval();

        _threadStateSwitch = props.getThreadstate().isJobSwitch();
        _threadStateInterval = props.getThreadstate().getInterval();

        _threadStackSwitch = props.getThreadstack().isJobSwitch();
        _threadStackInterval = props.getThreadstack().getInterval();
    }

}
