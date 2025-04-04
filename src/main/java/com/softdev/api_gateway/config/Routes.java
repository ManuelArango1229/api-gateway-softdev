package com.softdev.api_gateway.config;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    /**
     * Configura la ruta para el microservicio de usuarios.
     *
     * @return una función de enrutamiento para el microservicio de usuarios.
     */
    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
            .route(RequestPredicates.path("/api/user"), HandlerFunctions.http("http://localhost:8080"))
            .build();
    }
}
