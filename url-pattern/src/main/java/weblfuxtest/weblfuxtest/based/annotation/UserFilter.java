package weblfuxtest.weblfuxtest.based.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class UserFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        log.info("web filter call");

        return webFilterChain.filter(serverWebExchange).doOnSuccess(aVoid -> {
            log.info("web filter onSuccess, pattern: " + serverWebExchange.getAttributes().get(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
        });
    }
}
