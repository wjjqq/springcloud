package com.wjj.zookeeper.springcloud01zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Springcloud01ZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud01ZookeeperApplication.class, args);
    }

}
