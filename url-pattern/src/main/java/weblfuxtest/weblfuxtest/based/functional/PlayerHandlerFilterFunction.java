package weblfuxtest.weblfuxtest.based.functional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Slf4j
class PlayerHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest,
                                       HandlerFunction<ServerResponse> handlerFunction) {

        log.info("handler filter call");
        serverRequest.exchange().getResponse()
                .getHeaders().add("pattern-from-handler-filter", serverRequest.exchange().getAttributes().get(RouterFunctions.MATCHING_PATTERN_ATTRIBUTE).toString());
        return handlerFunction.handle(serverRequest);
    }
}