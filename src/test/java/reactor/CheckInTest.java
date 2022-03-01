package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static reactor.Constans.CHECK_IN_MESSAGE;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {

        var response = parseCheckInResponse(createUser);
        response.getKey();

        softly.assertThat(response.toString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
