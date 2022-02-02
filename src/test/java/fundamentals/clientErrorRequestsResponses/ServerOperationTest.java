package fundamentals.clientErrorRequestsResponses;

import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class ServerOperationTest {
    @Test
    @DisplayName("try to put unprocessable entity")
    void putServerOperation() {

        final String exampleText = "operationNameExample";

        var response = FundamentalsService.putOperation(exampleText, exampleText,
                SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("ServerOperationUnprocessableEntitySchema")));
    }
}
