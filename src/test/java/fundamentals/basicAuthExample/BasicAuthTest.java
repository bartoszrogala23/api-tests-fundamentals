package fundamentals.basicAuthExample;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class BasicAuthTest {

    @Test
    @DisplayName("try to log in using credentials test")
    void getLimitedResourcesTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getCurrentUser(SC_OK);

        softly.assertThat(response.body().asString()).contains("You are logged in");
        softly.assertAll();
    }
}
