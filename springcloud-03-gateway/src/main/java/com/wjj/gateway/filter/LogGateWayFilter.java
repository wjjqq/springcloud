package com.wjj.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author wjj
 * @create 2021/11/21
 * @Description 网关过滤器自定义配置,非自定义配置见官网
 */
@Component
@Slf4j
public class LogGateWayFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************MY GATEWAY LOG TEST**************");
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
