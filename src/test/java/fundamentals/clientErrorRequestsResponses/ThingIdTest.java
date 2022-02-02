package fundamentals.clientErrorRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.getRandomId;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class ThingIdTest {

    @Test
    @DisplayName("try to get thing id test")
    void getThingIdTes() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getThingId(getRandomId(), SC_NOT_FOUND);

        softly.assertThat(response.body().asString()).contains("No resource with thing_id=");
        softly.assertAll();
    }

    @Test
    @DisplayName("try to put thing id test")
    void putThingIdTes() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.putThingId(getRandomId(), SC_UNPROCESSABLE_ENTITY);

        softly.assertThat(response.body().asString()).contains("detail", "Not Found");
        softly.assertAll();

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("ThingIdUnprocessableEntitySchema")));
    }

    @Test
    @DisplayName("try to post thing id test")
    void postThingIdTes() {

        var response = FundamentalsService.postThingId(getRandomId(), SC_UNPROCESSABLE_ENTITY);

                       response
                               .then()
                               .body(matchesJsonSchemaInClasspath(getSchema("ThingIdUnprocessableEntitySchema")));

    }
}
