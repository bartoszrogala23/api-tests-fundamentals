package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.util.Util.setControlRoomManipulator;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static reactor.Constants.*;

class Az5Test extends ReactorBase {

    @Test
    @DisplayName("Az5 using true value test")
    void Az5PositiveTest() {
        String body = setControlRoomManipulator(true);

        var response = ReactorService.putAz5(key, body, SC_OK);

        assertThat(response.getBody().asString()
                .contains(AZ5_CORRECT)).isTrue();
    }

    @Test
    @DisplayName("Az5 using false value test")
    void Az5NegativeTest() {
        String body = setControlRoomManipulator(false);

        var response = ReactorService.putAz5(key, body, SC_FORBIDDEN);

        assertThat(response.getBody().asString())
                .contains(AZ5_FORBIDDEN);
    }

    @Test
    @DisplayName("Az5 using incorrect body test")
    void Az5IncorrectBodyTest() {

        var response = ReactorService.putAz5(key, toJson(incorrectValue), SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(AZ5_INVALID);
    }
}
