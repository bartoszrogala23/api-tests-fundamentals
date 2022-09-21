package reactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.model.CheckIn;
import reactor.model.User;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.GOOD_AS_NEW;
import static reactor.util.Parser.parseCheckInResponse;
import static reactor.util.ReactorSpecification.createUser;

class ResetProgressTest {

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
    void analysisTest() {

        var response = ReactorService.getResetProgress(key, SC_OK);

        assertThat(response.body().asString())
                .contains(GOOD_AS_NEW);
    }
}
