package crypto;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static crypto.util.Constants.AUTHORIZED_BY;

import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class EncryptedMessageTest extends CryptoBase{

    @Test
    void encryptedMessageTest() {
        CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification = setupUsingCredentials(userName, password);

        var login = CryptoService.postLogin(requestSpecification, SC_OK);
        String authorizedBy = login.getHeader(AUTHORIZED_BY);

        var response = CryptoService.getEncryptedMessage(requestSpecification, authorizedBy, SC_OK);

        assertThat(response.statusCode())
                .isEqualTo(SC_OK);
    }
}
