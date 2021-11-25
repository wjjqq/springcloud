package com.wjj.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud04NacosCluserApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud04NacosCluserApplication.class, args);
    }

}
