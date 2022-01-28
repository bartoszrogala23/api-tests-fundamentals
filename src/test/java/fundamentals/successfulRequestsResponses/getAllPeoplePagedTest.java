package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class getAllPeoplePagedTest {
    String invalidValue = "-ABC@";
    int pageSize  = 10;
    int pageNumber  = 10;

    @Test
    @DisplayName("check if response is sliced by query parameters test")
    void getSlicedResponseUsingParamsTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Maps.of(
                "page_size", pageSize,
                "page_number", pageNumber
        );

        var response = FundamentalsService.getAllPeoplePaged(params, SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("getPeopleSchema")));

        softly.assertThat(response.body().asString()).contains("first_name", "last_name");
        softly.assertAll();
    }

    @Test
    @DisplayName("check if response does not accept invalid variable type test")
    void getResponseUsingInvalidParamsTest() {
        Map<String, Object> params = Maps.of(
                "page_size", invalidValue,
                "page_number", pageNumber
        );

        var response = FundamentalsService.getAllPeoplePaged(params, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("queryParamsValidationErrorSchema")));
    }
}
