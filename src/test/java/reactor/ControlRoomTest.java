package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.User;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static reactor.Constants.CAN_NOT_PASS;
import static reactor.Constants.incorrectValue;
import static reactor.ReactorSpecification.createUser;

class ControlRoomTest extends ReactorBase {

    @Test
    @DisplayName("control room test")
    void controlRoomTest() {
        User user = createUser;

        var response  = ReactorService.getControlRoom(key,SC_OK);

        ReactorSpecification.setupReactorPower(key);
    }

    @Test
    @DisplayName("try to get to control room using incorrect key test")
    void controlNegativeRoomTest() {

        var response = ReactorService.getControlRoom(incorrectValue,SC_FORBIDDEN);

        softly.assertThat(response.getBody().asString())
                .contains(CAN_NOT_PASS);
        softly.assertAll();
    }
}
