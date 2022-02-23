package fundamentals.clientErrorRequestsResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class getLimitedResourceTest extends FundamentalsBase {

    @Test
    @DisplayName("get limited resources using credentials")
    void getLimitedResourcesTest() {

        var response = FundamentalsService.getLimitedResource(SC_OK);

        softly.assertThat(response.body().asString()).contains("The sausage is allowed for the Captain_snack.");
    }
}
