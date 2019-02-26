package weblfuxtest.weblfuxtest;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilterTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void whenPlayerNameIsBaeldung_thenWebFilterIsApplied() {
        EntityExchangeResult<String> result = webTestClient.get()
                .uri("/players/14")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult();

        assertEquals(result.getResponseBody(), "14");
        assertEquals(
                result.getResponseHeaders().getFirst("pattern"),
                "/players/{name}");
    }
}
