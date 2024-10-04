package io.github.aofeng.threadpool4j.autoconfigure.config;

import lombok.Data;

/**
 * 定时任务配置信息。
 *
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2020年6月16日
 */
@Data
public class JobConfig {

    private boolean jobSwitch;

    private int interval;

}
