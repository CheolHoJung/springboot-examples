package weblfuxtest.weblfuxtest.based.annotation;

import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserFilterTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testUrlPattern() {
        webTestClient.get()
                .uri("/users/{name}", 14)
                .exchange()
                .expectStatus().isOk();
    }

}