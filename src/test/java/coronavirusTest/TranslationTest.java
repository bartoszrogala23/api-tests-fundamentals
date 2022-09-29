package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class TranslationTest {
    @Test
    @DisplayName("GET triplet test")
    void getTriplet() {
        User user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        RequestSpecification requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());

        var response = CoronavirusService.getTranslation(requestSpecification, SC_OK);

     assertThat(response.getStatusCode())
             .isEqualTo(SC_OK);
    }
}
