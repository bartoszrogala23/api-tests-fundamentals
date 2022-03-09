package reactor;

import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

class ResetProgressTest {

    @Test
    void analysisTest() {
        var checkIn = parseCheckInResponse(toJson(createUser));
        String key = checkIn.getKey();

        var response = ReactorService.getResetProgress(key, SC_OK);

        assertThat(response.body().asString()).contains("Your reactor is good as new!");
    }

}
