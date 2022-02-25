package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_OK;
import static reactor.Constans.CHECK_IN_MESSAGE;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {
        String name = faker.name().fullName();

        var response = ReactorService.postCheckIn(toJson(name), SC_OK);

        softly.assertThat(response.body().asString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
