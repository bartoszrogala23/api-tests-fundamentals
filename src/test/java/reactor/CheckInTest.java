package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static reactor.Constants.CHECK_IN_MESSAGE;

class CheckInTest extends ReactorBase {
    @Test
    @DisplayName("desk check in test")
    void postCheckInTest() {



        softly.assertThat(checkIn.toString()).contains(CHECK_IN_MESSAGE);
        softly.assertAll();
    }
}
