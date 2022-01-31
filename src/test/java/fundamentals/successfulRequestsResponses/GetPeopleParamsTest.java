package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.util.Values.FIRST_NAME;
import static fundamentals.util.Values.LAST_NAME;
import static org.apache.http.HttpStatus.SC_OK;

class GetPeopleParamsTest {
    final String name = "Adam";
    final String lastName = "Marach";

    @Test
    void getPeopleUsingNameOnlyTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Map.of(
                FIRST_NAME, name
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(name);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingLastNameOnlyTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Map.of(
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(lastName);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingAllParamsTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Map.of(
                FIRST_NAME, name,
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(name, lastName);
        softly.assertAll();
    }
}
