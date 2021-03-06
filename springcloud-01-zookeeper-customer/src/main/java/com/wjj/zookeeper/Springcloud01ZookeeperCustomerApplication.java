package com.wjj.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud01ZookeeperCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01ZookeeperCustomerApplication.class, args);
    }

}
