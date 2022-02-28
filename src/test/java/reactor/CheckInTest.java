package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static reactor.Constans.CHECK_IN_MESSAGE;
import static reactor.util.Parser.parseCheckInResponse;
import static reactor.util.ReactorSpecification.userName;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {
        final String user = toJson(userName);

        var response = parseCheckInResponse(user);
        response.getKey();

        softly.assertThat(response.toString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
