package com.wjj.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wjj
 * @create 2021/11/21
 * @Description  路由可以通过配置文件配置，也可以通过编码方式，此处为编码方式实现
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("test_route_config", r->r.path("/test/**").uri("lb://msa-provider")).build();
        return routes.build();
    }
}
