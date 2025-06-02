package com.softdev.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de rutas para los microservicios.
 */
@Configuration
public class Routes {

    /**
     * Configura las rutas para los microservicios.
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user_service_auth", r -> r.path("/auth/**")
                .uri("lb://user-service"))
            .route("user_service", r -> r.path("/usuario/**")
                .uri("lb://user-service"))
            .route("product_service", r -> r.path("/producto/**")
                .uri("lb://product-service"))
            .build();
    }

}
