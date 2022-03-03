package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static reactor.Constans.CAN_NOT_PASS;
import static reactor.Constans.incorrectValue;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

class ControlRoomTest extends ReactorBase {

    @Test
    @DisplayName("control room test")
    void controlRoomTest() {
        String user = createUser;

        var checkIn = parseCheckInResponse(user);
        String key = checkIn.getKey();

        var response  = ReactorService.getControlRoom(key,SC_OK);

        ReactorSpecification.setupReactorPower(key);
//
//        softly.assertThat(response.getBody().asString())
//                .contains(key);
//        softly.assertAll();
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
