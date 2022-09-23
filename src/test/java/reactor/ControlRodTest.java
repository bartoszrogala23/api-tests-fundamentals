package reactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.CheckIn;
import reactor.model.User;

import java.util.Map;

import static fundamentals.util.Values.KEY;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.*;
import static reactor.util.Parser.parseCheckInResponse;
import static reactor.util.ReactorSpecification.createUser;

public class ControlRodTest {
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
    @DisplayName("try to put control rod test")
    void putControlRodTest() {

        ReactorService.getControlRoom(key, SC_OK);

        Map<String, String> pathParams = Map.of(
                KEY, key,
                ROD_NUMBER, "1"
        );

        var response = ReactorService.putControlRod(pathParams, SC_OK);

        assertThat(response.getBody().asString())
                .containsAnyOf(
                        String.format(CONTROL_ROD_PUT, username),
                        String.format(CONTROL_ROD_ALREADY_IN_PLACE, username));
    }

    @Test
    @DisplayName("try to delete control rod test")
    void deleteControlRodTest() {

        ReactorService.getControlRoom(key, SC_OK);

        Map<String, String> pathParams = Map.of(
                KEY, key,
                ROD_NUMBER, "1"
        );

        var response = ReactorService.deleteControlRod(pathParams, SC_ACCEPTED);

        assertThat(response.getBody().asString())
                .containsAnyOf(
                        String.format(CONTROL_ROD_REMOVED, username),
                        String.format(CONTROL_ROD_ALREADY_REMOVED, username));
    }
}
