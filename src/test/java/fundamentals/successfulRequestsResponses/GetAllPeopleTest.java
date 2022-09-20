package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class GetAllPeopleTest extends FundamentalsBase {

    @Test
    @DisplayName("list of all people test")
    void getResponseOkTest() {

        var response = FundamentalsService.getAllPeople(SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(fundamentalsGetPeople));

        assertThat(response.body().asString()).contains("first_name", "last_name");
    }
}
