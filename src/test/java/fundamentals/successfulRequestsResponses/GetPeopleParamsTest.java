package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.Values.FIRST_NAME;
import static fundamentals.Values.LAST_NAME;
import static org.apache.http.HttpStatus.SC_OK;

public class GetPeopleParamsTest {

    @Test
    public void getPeopleUsingParamsTest() {
        var softly = new SoftAssertions();
        final String name = "Adam";
        Map<String, Object> params = Map.of(
                FIRST_NAME, name
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);
//
//        softly.assertThat(response.body().asString()).contains(name);
//        softly.assertAll();
    }
}
