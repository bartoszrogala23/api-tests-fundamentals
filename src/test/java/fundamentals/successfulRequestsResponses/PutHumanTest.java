package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import fundamentals.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.createRandomBodyForPeople;
import static fundamentals.util.Util.getRandomId;
import static groovy.json.JsonOutput.toJson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_ACCEPTED;

class PutHumanTest {

    @Test
    @DisplayName("put Human Correct Request Test")
    void putHumanCorrectRequestTest() {


        var response = FundamentalsService.putHuman(getRandomId(), toJson(createRandomBodyForPeople()), SC_ACCEPTED);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("putHumanCorrectSchema")));
    }
}
