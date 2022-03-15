package crypto;

import org.junit.jupiter.api.Test;

import static crypto.util.Constants.REGISTER_MESSAGE;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegisterTest extends CryptoBase{

    @Test
    void postRegisterTest() {

        var response = CryptoService.postRegister(toJson(user), SC_CREATED);

        assertThat(response.getBody().asString()).contains(REGISTER_MESSAGE);
    }
}
