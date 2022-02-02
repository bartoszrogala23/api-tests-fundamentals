package fundamentals.playingWithHeadersResponses;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.apache.http.HttpStatus.SC_OK;

class headerCheckTest {

    @Test
    @DisplayName("add header test")
    void getHeaderCHeckTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getHeaderCheck(SC_OK);

        softly.assertThat(response.body().asString()).contains("Probably you should ask for the auth key");
        softly.assertAll();
    }
}
