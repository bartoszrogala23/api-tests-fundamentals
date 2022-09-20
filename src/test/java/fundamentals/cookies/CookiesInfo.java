package fundamentals.cookies;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class CookiesInfo extends FundamentalsBase {

    @Test
    @DisplayName("get cookies test")
    void getCookieInfoTest() {

        var response = FundamentalsService.getCookies(SC_OK);

        assertThat(response.body().asString())
                .contains("Come to the dark side, we have cookies! Use /register endpoint to obtain unique key");
    }
}
