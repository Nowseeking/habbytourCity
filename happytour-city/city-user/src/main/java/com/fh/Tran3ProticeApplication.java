package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.fh.mapper")
public class Tran3ProticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tran3ProticeApplication.class, args);
    }

}
