package fundamentals.clientErrorRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.getRandomId;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.assertj.core.api.Assertions.assertThat;

class ThingIdTest extends FundamentalsBase {

    @Test
    @DisplayName("try to GET thing id test")
    void getThingIdTes() {

        var response = FundamentalsService.getThingId(getRandomId(), SC_NOT_FOUND);

        assertThat(response.body().asString()).contains("No resource with thing_id=");
    }

    @Test
    @DisplayName("try to PUT thing id test")
    void putThingIdTes() {

        var response = FundamentalsService.putThingId(getRandomId(), SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsIdUnprocessableEntity));
    }

    @Test
    @DisplayName("try to POST thing id test")
    void postThingIdTes() {

        var response = FundamentalsService.postThingId(getRandomId(), SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsIdUnprocessableEntity));
    }
}
