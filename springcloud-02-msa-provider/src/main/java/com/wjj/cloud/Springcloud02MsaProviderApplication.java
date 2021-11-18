package com.wjj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Springcloud02MsaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud02MsaProviderApplication.class, args);
    }

}
