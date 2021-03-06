package com.wjj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud03GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud03GatewayApplication.class, args);
    }

}
