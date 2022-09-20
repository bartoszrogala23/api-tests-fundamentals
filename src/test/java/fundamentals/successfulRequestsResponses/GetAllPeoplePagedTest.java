package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.util.Values.INVALID_VALUE;
import static fundamentals.util.Values.PAGE_NUMBER_VALUE;
import static fundamentals.util.Values.PAGE_SIZE_VALUE;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.assertj.core.api.Assertions.assertThat;

class GetAllPeoplePagedTest extends FundamentalsBase {

    @Test
    @DisplayName("check if response is sliced by query parameters test")
    void getSlicedResponseUsingParamsTest() {
        Map<String, Object> params = Maps.of(
                "page_size", PAGE_SIZE_VALUE,
                "page_number", PAGE_NUMBER_VALUE
        );

        var response = FundamentalsService.getAllPeoplePaged(params, SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsGetPeople));

        assertThat(response.body().asString()).contains("first_name", "last_name");
    }

    @Test
    @DisplayName("check if response does not accept invalid variable type test")
    void getResponseUsingInvalidParamsTest() {
        Map<String, Object> params = Maps.of(
                "page_size", INVALID_VALUE,
                "page_number", PAGE_NUMBER_VALUE
        );

        var response = FundamentalsService.getAllPeoplePaged(params, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsQueryParams));
    }
}
