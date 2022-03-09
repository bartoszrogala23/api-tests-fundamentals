package reactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.model.CheckIn;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static reactor.Constants.AZ5_CORRECT;
import static reactor.Constants.AZ5_FORBIDDEN;
import static reactor.Constants.AZ5_INVALID;
import static reactor.Constants.incorrectValue;

class Az5Test extends ReactorBase {

    @Test
    @DisplayName("Az5 using true value test")
    void Az5Test() {
        String body = "{\"pressed\": true}";

        var response = ReactorService.putAz5(key, body, SC_OK);

        softly.assertThat(response.getBody().asString().contains(AZ5_CORRECT)).isTrue();
        softly.assertAll();
    }

    @Test
    @DisplayName("Az5 using false value test")
    void Az5NegativeTest() {
        String body = "{\"pressed\": false}";

        var response = ReactorService.putAz5(key, body, SC_FORBIDDEN);

        assertThat(response.getBody().asString()).contains(AZ5_FORBIDDEN);
    }

    @Test
    @DisplayName("Az5 using incorrect body test")
    void Az5IncorrectBodyTest() {

        var response = ReactorService.putAz5(key, toJson(incorrectValue), SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString()).contains(AZ5_INVALID);

    }
}
