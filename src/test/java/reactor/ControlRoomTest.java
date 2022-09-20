package reactor;

import fundamentals.util.ResponseParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.Reactor;
import reactor.model.ReactorData;

import java.util.List;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.CAN_NOT_PASS;
import static reactor.Constants.incorrectValue;
import static reactor.ReactorSpecification.setupReactorPower;

class ControlRoomTest extends ReactorBase {

    @Test
    @DisplayName("control room test")
    void controlRoomTest() {

       var response = ReactorService.getControlRoom(key, SC_OK);

        var fuelRods = ResponseParser.parse(response, Reactor.class);

        System.out.println(fuelRods);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    @DisplayName("try to get to control room using incorrect key test")
    void controlNegativeRoomTest() {

        var response = ReactorService.getControlRoom(incorrectValue, SC_FORBIDDEN);

        assertThat(response.getBody().asString())
                .contains(CAN_NOT_PASS);
    }
}