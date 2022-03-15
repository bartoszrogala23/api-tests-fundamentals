package crypto;

import crypto.model.EncryptedMessage;
import crypto.util.Parser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static crypto.util.Constants.AUTHORIZED_BY;
import static crypto.util.Util.getCodename;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class FinalMessageTest extends CryptoBase {

    @Test
    void finalMessageTest() {
        var register = CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification = setupUsingCredentials(userName, password);

        var login = CryptoService.postLogin(requestSpecification, SC_OK);
        String authorizedBy = login.getHeader(AUTHORIZED_BY);

        var encryptedMessage = Parser.getEncryptedMessage(requestSpecification, authorizedBy);

        String codename = getCodename(register.getBody().asString());
        String messageValue = encryptedMessage.getMessage();
        EncryptedMessage message = EncryptedMessage.builder().message(messageValue).build();

        var response = CryptoService.postFinalMessage(requestSpecification, codename, authorizedBy, toJson(message));

        assertThat(response.getBody().asString()).contains("From Russia, With Love");
    }
}
