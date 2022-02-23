package fundamentals.basicAuthExample;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class BasicAuthTest extends FundamentalsBase {

    @Test
    @DisplayName("try to log in using credentials test")
    void getLimitedResourcesTest() {

        var response = FundamentalsService.getCurrentUser(SC_OK);

        softly.assertThat(response.body().asString()).contains("You are logged in");
        softly.assertAll();
    }
}
