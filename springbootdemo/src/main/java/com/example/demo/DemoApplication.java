package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 声明让spring boot自动给程序进行必要的配置，等价于以默认熟悉使用
 * @configuration，@EnableAutoConfiguration和@ComponentScan
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
