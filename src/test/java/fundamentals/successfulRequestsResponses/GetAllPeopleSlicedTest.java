package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.getSingleRecordByNumberFromPeople;
import static fundamentals.util.Values.FIRST_NAME;
import static fundamentals.util.Values.INVALID_VALUE;
import static fundamentals.util.Values.LAST_NAME;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.assertj.core.api.Assertions.assertThat;

class GetAllPeopleSlicedTest extends FundamentalsBase {

    @Test
    @DisplayName("check if response is sliced by query parameters test")
    void getSlicedResponseUsingParamsTest() {

        var response = FundamentalsService.getAllPeopleSliced(getSingleRecordByNumberFromPeople(), SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("getPeopleSchema")));

        assertThat(response.body().asString()).containsOnlyOnce(FIRST_NAME);
        assertThat(response.body().asString()).containsOnlyOnce(LAST_NAME);
    }

    @Test
    @DisplayName("check if response does not accept invalid variable type test")
    void getResponseUsingInvalidParamsTest() {
        int upToNumber = 15;

        Map<String, Object> params = Maps.of(
                "from_number", INVALID_VALUE,
                "up_to_number", upToNumber
        );

        var response = FundamentalsService.getAllPeopleSliced(params, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsQueryParams));
    }
}
