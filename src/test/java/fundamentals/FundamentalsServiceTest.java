package fundamentals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;

class FundamentalsServiceTest {

    @Test
    @DisplayName("check if 200 received")
    void getResponseOkTest() {
        var response = FundamentalsService.getResponseOk(SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("getResponseOkSchema")));
    }
}