package crypto;

import crypto.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class GetInformationTest {

    @Test
    @DisplayName("Get Information Test")
    void getInfoTest() {
        var response = CryptoService.getInformation(SC_OK);

        assertThat(response.getBody().asString()).contains(Constants.INFO_MESSAGE);
    }
}
