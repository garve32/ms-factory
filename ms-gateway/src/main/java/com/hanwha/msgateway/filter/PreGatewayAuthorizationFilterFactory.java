package com.hanwha.msgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PreGatewayAuthorizationFilterFactory extends
    AbstractGatewayFilterFactory<PreGatewayAuthorizationFilterFactory.Config> {

    public PreGatewayAuthorizationFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // todo : 토큰이 있는데 검증 실패한 경우, 토큰 자체가 없는 경우 분리 필요
            // 검증이 성공하면 테넌트 정보를 헤더에 세팅해서 전달하는게 맞을까??
            if(!exchange.getRequest().getHeaders().containsKey("Authorization")) {
                // fixme : Token 관련 커스텀 exception 으로 변경할 것
                log.info("Token Valid Exception!!");
//                throw new RuntimeException("Authorization header not present");
                return handleUnAuthorized(exchange);
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> handleUnAuthorized(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    public static class Config {

    }
}
