package fundamentals.cookies;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class CookiesInfo {

    @Test
    @DisplayName("get cookies test")
    void getCookieInfoTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getCookies(SC_OK);

        softly.assertThat(response.body().asString())
                .contains("Come to the dark side, we have cookies! Use /register endpoint to obtain unique key");
        softly.assertAll();
    }
}
