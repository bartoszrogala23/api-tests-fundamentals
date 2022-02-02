package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.createRandomBody;
import static fundamentals.util.Values.INVALID_VALUE;
import static groovy.json.JsonOutput.toJson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

class PostHumanTest {
    @Test
    @DisplayName("add new record test")
    void createNewHumanTest() {

        var response = FundamentalsService.postHuman(toJson(createRandomBody()), SC_CREATED);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("postPeopleSchema")));
    }

    @Test
    @DisplayName("add new record without correct body test")
    void createNewHumanWithInvalidDataTest() {

        var response = FundamentalsService.postHuman(INVALID_VALUE, SC_UNPROCESSABLE_ENTITY);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("humanInvalidResultSchema")));
    }
}
