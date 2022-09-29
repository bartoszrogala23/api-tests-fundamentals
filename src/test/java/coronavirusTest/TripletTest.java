package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import coronavirus.util.Constant;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static coronavirus.util.Util.fetchTriplet;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TripletTest {
    User user;
    RequestSpecification requestSpecification;

    @BeforeEach
    public void setup() {
        user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("GET triplet test")
    void getTriplet() {

        final String triplet = fetchTriplet(requestSpecification);

        var response = CoronavirusService.getTriplet(requestSpecification, 1, SC_OK);

        assertThat(response.getBody().asString())
                .contains(triplet);
    }

    @Test
    @DisplayName("DELETE triplet test")
    void deleteTriplet() {

        var response = CoronavirusService.deleteTriplet(requestSpecification, 1, SC_ACCEPTED);

        assertThat(response.getBody().asString())
                .contains(Constant.DELETE_TRIPLET_INFO);
    }


}
