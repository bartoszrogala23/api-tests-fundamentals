package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static reactor.Constants.CHECK_IN_MESSAGE;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {

        var response = parseCheckInResponse(toJson(createUser));
        response.getKey();

        softly.assertThat(response.toString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
