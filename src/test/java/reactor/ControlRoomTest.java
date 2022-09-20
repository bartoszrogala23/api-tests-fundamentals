package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.CAN_NOT_PASS;
import static reactor.Constants.incorrectValue;

class ControlRoomTest extends ReactorBase {

    @Test
    @DisplayName("control room test")
    void controlRoomTest() {

        var response  = ReactorService.getControlRoom(key,SC_OK);

        ReactorSpecification.setupReactorPower(key);
    }

    @Test
    @DisplayName("try to get to control room using incorrect key test")
    void controlNegativeRoomTest() {

        var response = ReactorService.getControlRoom(incorrectValue,SC_FORBIDDEN);

        assertThat(response.getBody().asString())
                .contains(CAN_NOT_PASS);
    }
}