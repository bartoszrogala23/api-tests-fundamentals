package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GetResponse200Test extends FundamentalsBase {

    @Test
    @DisplayName("check if 200 received")
    void getResponseOkTest() {

        var response = FundamentalsService.getResponseOk(SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsGetResponse));

        assertThat(response.body().asString())
                .contains("This is GET example for status code 200")
                .contains("OK")
                .contains("The request has succeeded");
    }
}