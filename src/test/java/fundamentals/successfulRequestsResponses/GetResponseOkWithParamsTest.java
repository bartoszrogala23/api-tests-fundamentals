package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class GetResponseOkWithParamsTest extends FundamentalsBase {

    String name = "Jose";
    String middleName = "Maria";
    String lastName = "Gonzales";
    int height = 10;

    @Test
    @DisplayName("check if 200 received using query parameters")
    void getResponseUsingParamsTest() {

        Map<String, Object> params = Maps.of(
                "first_name", name,
                "middle_name", middleName,
                "last_name", lastName,
                "height", height
        );

        var response = FundamentalsService.getResponseOkWithParams(params, SC_OK);

        softly.assertThat(response.body().asString())
                .contains(name);
        softly.assertThat(response.body().asString())
                .contains(middleName);
        softly.assertThat(response.body().asString())
                .contains(lastName);
        softly.assertAll();
    }

    @Test
    @DisplayName("check if 422 received using incomplete query parameters")
    void getResponseUsingParamsValidationErrorTest() {
        Map<String, Object> invalidParams = Maps.of(
                "middle_name", middleName,
                "last_name", lastName,
                "height", height
        );

        var response = FundamentalsService.getResponseOkWithParams(invalidParams, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsQueryParams));
    }
}
