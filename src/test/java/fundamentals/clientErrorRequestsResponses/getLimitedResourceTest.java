package fundamentals.clientErrorRequestsResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class getLimitedResourceTest {

    @Test
    @DisplayName("get limited resources using credentials")
    void getLimitedResourcesTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getLimitedResource(SC_OK);

        softly.assertThat(response.body().asString()).contains("The sausage is allowed for the Captain_snack.");
    }
}
