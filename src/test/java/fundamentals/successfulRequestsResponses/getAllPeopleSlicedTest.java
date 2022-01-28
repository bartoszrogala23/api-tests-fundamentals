package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.apache.groovy.util.Maps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;

class getAllPeopleSlicedTest {
    int fromNumber = 10;
    int upToNumber = 15;

    @Test
    @DisplayName("check if 422 received using incomplete query parameters")
    void getResponseUsingParamsValidationErrorTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Maps.of(
                "from_number", fromNumber,
                "up_to_number", upToNumber
        );

        var response = FundamentalsService.getAllPeopleSliced(params, SC_OK);

        softly.assertThat(response.body().asString()).contains("first_name", "last_name");
        softly.assertAll();
    }
}
