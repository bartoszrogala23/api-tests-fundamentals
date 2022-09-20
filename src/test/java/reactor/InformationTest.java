package reactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.INFORMATION_MESSAGE;

class InformationTest extends ReactorBase {
    @Test
    @DisplayName("try to get information test")
    void getInformationTest() {

        var response = ReactorService.getInformation(SC_OK);

        assertThat(response.body().asString()).contains(INFORMATION_MESSAGE);
    }
}
