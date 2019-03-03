package weblfuxtest.weblfuxtest.based.functional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RoutingConfiguration {

    @Autowired
    PlayerHandler playerHandler;

    @Bean
    public RouterFunction<ServerResponse> playerRouter() {
        return RouterFunctions
                .route(GET("/players/{name}"), playerHandler::getName)
                .filter(new PlayerHandlerFilterFunction());
    }
}
