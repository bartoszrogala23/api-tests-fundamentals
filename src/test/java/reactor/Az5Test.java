package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static reactor.Constans.AZ5_CORRECT;
import static reactor.Constans.AZ5_FORBIDDEN;
import static reactor.Constans.incorrectValue;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

class Az5Test extends ReactorBase {

    @Test
    @DisplayName("Az5 using true value test")
    void Az5Test() {

        var checkIn = parseCheckInResponse(toJson(createUser));

        String key = checkIn.getKey();
        String body = "{\"pressed\": true}";

        var response = ReactorService.putAz5(key, body, SC_OK);

        softly.assertThat(response.getBody().asString().contains(AZ5_CORRECT)).isTrue();
        softly.assertAll();
    }

    @Test
    @DisplayName("Az5 using false value test")
    void Az5NegativeTest() {

        var checkIn = parseCheckInResponse(toJson(createUser));

        String key = checkIn.getKey();
        String body = "{\"pressed\": false}";

        var response = ReactorService.putAz5(key, body, SC_FORBIDDEN);

        assertThat(response.getBody().asString()).contains(AZ5_FORBIDDEN);
    }

    @Test
    @DisplayName("Az5 using incorrect body test")
    void Az5IncorrectBodyTest() {

        var checkIn = parseCheckInResponse(toJson(createUser));

        String key = checkIn.getKey();

        var response = ReactorService.putAz5(key, toJson(incorrectValue), SC_UNPROCESSABLE_ENTITY);


    }
}
