package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;

class GetResponse200Test {

    @Test
    @DisplayName("check if 200 received")
    void getResponseOkTest() {
        SoftAssertions softly = new SoftAssertions();

        var response = FundamentalsService.getResponseOk(SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("getResponseOkSchema")));

        softly.assertThat(response.body().asString())
                .contains("This is GET example for status code 200");
        softly.assertThat(response.body().asString())
                .contains("OK");
        softly.assertThat(response.body().asString())
                .contains("The request has succeeded");
        softly.assertAll();
    }
}