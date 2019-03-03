package weblfuxtest.weblfuxtest.based.functional;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerHandlerFilterFunctionTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testUrlPattern() {
        webTestClient.get()
                .uri("/players/14")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().value("pattern-from-handler-filter", Matchers.equalTo("/players/{name}"));
    }

}