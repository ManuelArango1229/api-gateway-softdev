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
     * Configura la ruta para el microservicio de usuarios, que se encarga de autenticar.
     *
     * @return una función de enrutamiento para el microservicio de usuarios.
     */
    @Bean
    public RouterFunction<ServerResponse> userAuthServiceRoute() {
        return GatewayRouterFunctions.route("user_auth_service")
            .route(RequestPredicates.path("/auth/**"), HandlerFunctions.http("http://localhost:8080"))
            .build();
    }

    /**
     * Configura la ruta para el microservicio de usuarios, que se encarga de las funciones CRUD de usuarios.
     *
     * @return una función de enrutamiento para el microservicio de usuarios.
     */
    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
                .route(RequestPredicates.path("/usuario/**"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    /**
     * Configura la ruta para el microservicio de productos, que se encarga de las funciones CRUD de productos.
     *
     * @return una función de enrutamiento para el microservicio de productos.
     */
    @Bean
    public RouterFunction<ServerResponse> productoServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/producto/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    
}
