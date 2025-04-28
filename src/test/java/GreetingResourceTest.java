import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class GreetingResourceTest {
    @Test
    public void testGreetingJsonResponse() {
        RestAssured.given()
                .accept("application/json")
                .when().get("/greet/Alice?suffix=:)")
                .then()
                .statusCode(200)
                //.body(is("Hello Alice :)"));
                .body("message", equalTo("Hello Alice:)!"));
    }

}
