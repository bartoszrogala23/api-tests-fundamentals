package fundamentals.playingWithHeadersResponses;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.apache.http.HttpStatus.SC_OK;

class headerCheckTest extends FundamentalsBase {

    @Test
    @DisplayName("add header test")
    void getHeaderCHeckTest() {

        var response = FundamentalsService.getHeaderCheck(SC_OK);

        softly.assertThat(response.body().asString()).contains("Probably you should ask for the auth key");
        softly.assertAll();
    }
}
