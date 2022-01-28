package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;

class getResponseOkWithParamsTest {

    @Test
    @DisplayName("check if 200 received using query parameters")
    void getResponseUsingParamsTest() {
        var softly = new SoftAssertions();
        String name = "Jose";
        String middleName = "Maria";
        String lastName = "Gonzales";
        int height = 10;

        Map<String, Object> params = Maps.of(
                "first_name", name,
                "middle_name", middleName,
                "last_name", lastName,
                "height", height
        );

        var response = FundamentalsService.getResponseOkWithParams(params, SC_OK);

        softly.assertThat(response.body().asString())
                .contains(name);
        softly.assertThat(response.body().asString())
                .contains(middleName);
        softly.assertThat(response.body().asString())
                .contains(lastName);
        softly.assertAll();
    }
}
