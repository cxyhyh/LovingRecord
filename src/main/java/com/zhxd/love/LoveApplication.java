package com.zhxd.love;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zhxd.love.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class LoveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class, args);
    }
}
