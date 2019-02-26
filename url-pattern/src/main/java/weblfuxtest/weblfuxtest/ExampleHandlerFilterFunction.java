package weblfuxtest.weblfuxtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Slf4j
class ExampleHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest,
                                       HandlerFunction<ServerResponse> handlerFunction) {

        if (serverRequest.pathVariable("name").equalsIgnoreCase("test")) {
            return ServerResponse.status(FORBIDDEN).build();
        }
        serverRequest.exchange().getResponse()
                .getHeaders().add("pattern", serverRequest.exchange().getAttributes().get(RouterFunctions.MATCHING_PATTERN_ATTRIBUTE).toString());
        return handlerFunction.handle(serverRequest);
    }
}