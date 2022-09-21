package reactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.CheckIn;
import reactor.model.User;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.INFORMATION_MESSAGE;
import static reactor.util.Parser.parseCheckInResponse;
import static reactor.util.ReactorSpecification.createUser;

class InformationTest {

    public CheckIn checkIn;
    public String key;
    public User user;

    @BeforeEach
    public void setup(){
        user = createUser();
        checkIn = parseCheckInResponse(toJson(user));
        key = checkIn.getKey();
    }

    @Test
    @DisplayName("try to get information test")
    void getInformationTest() {

        var response = ReactorService.getInformation(SC_OK);

        assertThat(response.body().asString()).contains(INFORMATION_MESSAGE);
    }
}
