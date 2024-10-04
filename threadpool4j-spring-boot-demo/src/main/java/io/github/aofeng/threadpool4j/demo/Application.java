package io.github.aofeng.threadpool4j.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author <a href="mailto:aofengblog@163.com">聂勇</a>
 * @since 2024/10/4
 */
@SpringBootApplication(scanBasePackages = {"io.github.aofeng.threadpool4j"})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }

}
