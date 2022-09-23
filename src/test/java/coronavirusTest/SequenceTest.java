package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import coronavirus.util.Constant;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.FIRST_SEQUENCE_COPIED_INFO;
import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class SequenceTest {
    User user;
    RequestSpecification requestSpecification;

    @BeforeEach
    public void setup() {
        user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("GET first sequence test")
    void getFirstSequenceTest() {

        var response = CoronavirusService.getPrimarySequence(requestSpecification, SC_OK);

        assertThat(response.getBody().asString())
                .contains(Constant.FIRST_SEQUENCE_INFO);
    }

    @Test
    @DisplayName("GET sample sequence test")
    void getSampleSequenceTest() {

        var response = CoronavirusService.getSampleSequence(requestSpecification, SC_OK);

        assertThat(response.getBody().asString())
                .isNotEmpty();
    }

    @Test
    @DisplayName("GET first sequence copy test")
    void getFirstSequenceCopyTest() {

        var response = CoronavirusService.getCopy(requestSpecification, SC_OK);

        assertThat(response.getBody().asString())
                .contains(FIRST_SEQUENCE_COPIED_INFO);
    }
}
