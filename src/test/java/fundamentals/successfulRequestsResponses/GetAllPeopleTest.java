package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class GetAllPeopleTest {

//TODO: investigate why schema does not match.

    @Test
    @DisplayName("list of all people test")
    void getResponseOkTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getAllPeople(SC_OK);

        softly.assertThat(response.body().asString()).contains("first_name", "last_name");
        softly.assertAll();
    }
}
