package fundamentals.successfulRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.util.Util.getRandomId;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.assertj.core.api.Assertions.assertThat;

class DeleteHumanTest extends FundamentalsBase {

    @Test
    @DisplayName("delete Human Correct Request Test")
    void deleteHumanTest() {

        int randomId = getRandomId();

        var response = FundamentalsService.deleteHuman(randomId, SC_ACCEPTED);

        assertThat(response.body().asString()).contains
                ("Human at index " + randomId + " deleted.");
    }
}
