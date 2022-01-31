package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.createRandomBodyForPeople;
import static fundamentals.util.Util.getRandomId;
import static fundamentals.util.Values.INVALID_VALUE;
import static groovy.json.JsonOutput.toJson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class PatchHumanTest {

    @Test
    @DisplayName("put Human Correct Request Test")
    void patHumanCorrectRequestTest() {


        var response = FundamentalsService.patchHuman(getRandomId(), toJson(createRandomBodyForPeople()), SC_ACCEPTED);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("putHumanCorrectSchema")));
    }

    @Test
    @DisplayName("put Human using invalid body Test")
    void putHumanWithIncorrectBodyTest() {


        var response = FundamentalsService.patchHuman(getRandomId(), INVALID_VALUE, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("putHumanIdValidationErrorSchema")));
    }
}
