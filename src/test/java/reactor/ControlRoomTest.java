package reactor;

import fundamentals.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.CheckIn;
import reactor.model.User;
import reactor.util.ReactorSpecification;

import java.util.Map;

import static fundamentals.util.Values.KEY;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.*;
import static reactor.util.Parser.parseCheckInResponse;
import static reactor.util.ReactorSpecification.*;

class ControlRoomTest {

    public CheckIn checkIn;
    public String key;
    public User user;
    public String username;

    @BeforeEach
    public void setup(){
        user = createUser();
        username = user.getName();
        checkIn = parseCheckInResponse(toJson(user));
        key = checkIn.getKey();
    }

    @Test
    @DisplayName("control room test")
    void controlRoomTest() {

        var response = ReactorService.getControlRoom(key, SC_OK);

        assertThat(response.getBody().asString())
                .contains(String.format(REACTOR_UUID, key));
    }

    @Test
    @DisplayName("try to get to control room using incorrect key test")
    void controlNegativeRoomTest() {

        var response = ReactorService.getControlRoom(incorrectValue, SC_FORBIDDEN);

        assertThat(response.getBody().asString())
                .contains(CAN_NOT_PASS);
    }

    @Test
    @DisplayName("try to put fuel rod test")
    void deleteControlRodTest() {

        ReactorService.getControlRoom(key, SC_OK);

        Map<String, String> pathParams = Map.of(
                KEY, key,
                ROD_NUMBER, "1"
        );

        var response = ReactorService.putFuelRod(pathParams, SC_OK);

        assertThat(response.getBody().asString())
                .containsAnyOf(
                        String.format(FUEL_ROD_PUT, username),
                        String.format(FUEL_ROD_ALREADY_IN_PLACE, username));
    }
}