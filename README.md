threadpool4j的spring boot starter，支持 Spring Boot 2.x。

# 引入依赖

```xml
<dependency>
    <groupId>io.github.aofeng</groupId>
    <artifactId>threadpool4j-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

# 配置日志

properties 格式和 yml 格式，任选一种即可。

## properties 格式

```properties
# 是否启用threadpool4j
threadpool4j.enable=true

# 多个线程池配置
threadpool4j.pool[0].name=default
threadpool4j.pool[0].corePoolSize=5
threadpool4j.pool[0].maxPoolSize=10
threadpool4j.pool[0].keepAliveTime=15
threadpool4j.pool[0].workQueueSize=10000

threadpool4j.pool[1].name=other
threadpool4j.pool[1].corePoolSize=5
threadpool4j.pool[1].maxPoolSize=10
threadpool4j.pool[1].keepAliveTime=15
threadpool4j.pool[1].workQueueSize=10000

# 线程池状态收集汇总配置
# switch: true-开，false-关
# interval: 输出日志的间隔时间（单位：秒)
threadpool4j.threadpoolstate.jobSwitch=true
threadpool4j.threadpoolstate.interval=60

# 线程状态收集汇总配置
# switch: true-开，false-关
# interval: 输出日志的间隔时间（单位：秒)
threadpool4j.threadstate.jobSwitch=true
threadpool4j.threadstate.interval=60

# 线程堆栈收集配置
# switch: true-开，false-关
# interval: 输出日志的间隔时间（单位：秒)
threadpool4j.threadstack.jobSwitch=true
threadpool4j.threadstack.interval=60
```

## yml 格式

```yml
threadpool4j:
  enable: true
  pool:
    -
      name: default
      corePoolSize: 5
      maxPoolSize: 10
      keepAliveTime: 15
      workQueueSize: 100000
    -
      name: other
      corePoolSize: 5
      maxPoolSize: 10
      keepAliveTime: 15
      workQueueSize: 100000
  threadpoolstate:
    jobSwitch: true
    interval: 60
  threadstate:
    jobSwitch: true
    interval: 60
  threadstack:
    jobSwitch: true
    interval: 60
```

# 编写代码

```java
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
                // 模拟执行业务逻辑耗时
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
```

更多的使用方法，请参考《threadpool4j入门指南》中的章节[不同场景的使用](https://github.com/aofeng/threadpool4j/blob/master/doc/guide/02-guide.md#%E4%B8%8D%E5%90%8C%E5%9C%BA%E6%99%AF%E7%9A%84%E4%BD%BF%E7%94%A8)。
