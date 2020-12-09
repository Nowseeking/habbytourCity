package com.mt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.mt.mapper")
@EnableDiscoveryClient
public class CityZwApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityZwApplication.class, args);
    }

}
