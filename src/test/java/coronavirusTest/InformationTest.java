package coronavirusTest;

import coronavirus.CoronavirusService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.MESSAGE_INFO;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class InformationTest {

    @Test
    @DisplayName("GET information test")
    void getInformationTest() {
        var response = CoronavirusService.getInformation(SC_OK);

        assertThat(response.getBody().asString())
                .contains(MESSAGE_INFO);
    }
}
