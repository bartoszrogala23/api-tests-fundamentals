package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.INVALID_VALUE;
import static coronavirus.util.Constant.UNAUTHORIZED;
import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static fundamentals.FundamentalsServiceSpecification.getSchema;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FlagsTest {

    @Test
    @DisplayName("GET Flags positive test")
    void getFlags() {

        final User user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        RequestSpecification requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());

        var response = CoronavirusService.checkFlags(requestSpecification, SC_OK);

        response
                .then()
                .body(matchesJsonSchemaInClasspath(getSchema("flagsSchema")));
    }

    @Test
    @DisplayName("GET Flags negative test")
    void getFlagsUsingInvalidUser() {

        RequestSpecification requestSpecification = setupUsingCredentials(INVALID_VALUE, INVALID_VALUE);

        var response = CoronavirusService.checkFlags(requestSpecification, SC_UNAUTHORIZED);

        assertThat(response.getBody().asString())
                .contains(UNAUTHORIZED);
    }
}