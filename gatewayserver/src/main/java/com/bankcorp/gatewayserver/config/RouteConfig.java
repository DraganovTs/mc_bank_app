package com.bankcorp.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator bankCorpRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(path -> path
                        .path("/bankcorp/accounts/**")
                        .filters(filter -> filter.rewritePath("/bankcorp/accounts/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("accountsCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://ACCOUNTS"))
                .route(path -> path
                        .path("/bankcorp/loans/**")
                        .filters(filter -> filter.rewritePath("/bankcorp/accounts/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LOANS"))
                .route(path -> path
                        .path("/bankcorp/cards/**")
                        .filters(filter -> filter.rewritePath("/bankcorp/accounts/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS"))
                .build();
    }
}
