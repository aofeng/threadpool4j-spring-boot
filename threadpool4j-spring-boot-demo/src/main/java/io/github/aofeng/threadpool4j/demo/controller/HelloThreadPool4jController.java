package io.github.aofeng.threadpool4j.demo.controller;

import cn.aofeng.threadpool4j.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2024/10/4
 */
@RestController
public class HelloThreadPool4jController {

    @Autowired
    private ThreadPool threadPool;

    @RequestMapping("/")
    public String index() {
        return "hello threadpool4j";
    }

    @RequestMapping("/submit")
    public String submit(@RequestParam(value = "poolName", required = true) String poolName,
                         @RequestParam(value = "sleepTime", required = true) Long sleepTime) {
        try {
            threadPool.submit(() -> {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, poolName);
        } catch (Exception e) {
            return String.format("submit task to [%s] failed. message:%s", poolName, e.getMessage());
        }

        return String.format("submit task to [%s] success", poolName);
    }

}
