package com.hanwha.msgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public class PreGatewayAuthorizationFilterFactory extends
    AbstractGatewayFilterFactory<PreGatewayAuthorizationFilterFactory> {

    @Override
    public GatewayFilter apply(PreGatewayAuthorizationFilterFactory config) {
        return null;
    }
}
