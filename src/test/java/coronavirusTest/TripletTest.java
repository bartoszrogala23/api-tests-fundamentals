package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.*;
import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static coronavirus.util.Util.fetchTriplet;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TripletTest {
    User user;
    RequestSpecification requestSpecification;
    final int invalidTripletId = 100;
    final String tripletToAdd = "AAA";

    @BeforeEach
    public void setup() {
        user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("DELETE triplet test")
    void deleteTriplet() {

        var response = CoronavirusService.deleteTriplet(requestSpecification, 1, SC_ACCEPTED);

        assertThat(response.getBody().asString())
                .contains(DELETE_TRIPLET_INFO);
    }

    @Test
    @DisplayName("DELETE invalid triplet test")
    void deleteInvalidTriplet() {

        var response = CoronavirusService.deleteTriplet(requestSpecification, invalidTripletId, SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(TRIPLET_OUT_OF_BOUND);
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
    @DisplayName("GET invalid triplet test")
    void getInvalidTriplet() {

        var response = CoronavirusService.getTriplet(requestSpecification, invalidTripletId, SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(TRIPLET_OUT_OF_BOUND);
    }



    @Test
    @DisplayName("PATCH triplet test")
    void patchTriplet() {

        var response = CoronavirusService.patchTriplet(requestSpecification, 1, tripletToAdd, SC_OK);

        assertThat(response.getBody().asString())
                .contains(PATCH_TRIPLET_INFO);
    }

    @Test
    @DisplayName("PATCH invalid triplet test")
    void patchInvalidTriplet() {

        var response = CoronavirusService.patchTriplet(requestSpecification, invalidTripletId, tripletToAdd, SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(TRIPLET_OUT_OF_BOUND);
    }

    @Test
    @DisplayName("PUT triplet test")
    void putTriplet() {

        var response = CoronavirusService.putTriplet(requestSpecification, tripletToAdd, SC_OK);

        assertThat(response.getBody().asString())
                .contains(TRIPLET_PUT_INFO);
    }

    @Test
    @DisplayName("POST triplet test")
    void addTriplet() {

        var response = CoronavirusService.addTriplet(requestSpecification, tripletToAdd, SC_CREATED);

        assertThat(response.getBody().asString())
                .contains(TRIPLET_ADD_INFO);
    }
}
