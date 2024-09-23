package com.netease.thanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.netease.thanos"})
//启注解事务管理
@EnableTransactionManagement
@EnableScheduling
//@EnableAsync //异步servlet3
public class MainAplication {
    public static void main(String[] args) {
        SpringApplication.run(MainAplication.class);
    }
}
