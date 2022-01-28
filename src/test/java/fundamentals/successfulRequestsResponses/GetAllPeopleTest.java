package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;

class GetAllPeopleTest {

    @Test
    @DisplayName("list of all people test")
    void getResponseOkTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getAllPeople(SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("getPeopleSchema")));

        softly.assertThat(response.body().asString()).contains("first_name", "last_name");
        softly.assertAll();
    }
}
