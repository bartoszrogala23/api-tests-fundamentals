package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.REGISTER_INFO;
import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.Assertions.assertThat;

public class RegisterTest {

    @Test
    @DisplayName("register test")
    void getInformationTest() {
        final User user = createRandomUser();

        var response = CoronavirusService.register(toJson(user), SC_CREATED);

        assertThat(response.getBody().asString())
                .contains(String.format(REGISTER_INFO, user.getUsername()));
    }
}
