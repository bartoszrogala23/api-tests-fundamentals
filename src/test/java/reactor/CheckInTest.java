package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.User;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static reactor.Constans.CHECK_IN_MESSAGE;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {
        User userName = User.builder().name(faker.name().fullName()).build();

        var response = ReactorService.postCheckIn(toJson(userName), SC_CREATED);

        //TODO: extract key from response

        softly.assertThat(response.body().asString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
