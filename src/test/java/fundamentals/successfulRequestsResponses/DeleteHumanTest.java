package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.util.Util.getRandomId;
import static org.apache.http.HttpStatus.SC_ACCEPTED;

class DeleteHumanTest {

    @Test
    @DisplayName("delete Human Correct Request Test")
    void deleteHumanTest() {

        var softly = new SoftAssertions();
        int randomId = getRandomId();

        var response = FundamentalsService.deleteHuman(randomId, SC_ACCEPTED);

        softly.assertThat(response.body().asString()).contains
                ("Human at index " + randomId + " deleted.");
    }
}
