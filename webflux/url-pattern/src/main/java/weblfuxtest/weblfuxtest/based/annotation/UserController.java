package weblfuxtest.weblfuxtest.based.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{name}")
    public Mono<String> getName(@PathVariable String name) {
        return Mono.just(name);
    }
}
