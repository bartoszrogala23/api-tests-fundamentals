package crypto;

import crypto.model.Box;
import crypto.util.Parser;
import fundamentals.util.Util;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static crypto.util.Constants.AUTHORIZED_BY;
import static crypto.util.Util.getCodename;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class FinalMessageTest extends CryptoBase {

//TODO: napraw
    @Test
    void finalMessageTest() {
        var register = CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification = setupUsingCredentials(userName, password);

        var login = CryptoService.postLogin(requestSpecification, SC_OK);
        String authorizedBy = login.getHeader(AUTHORIZED_BY);

        CryptoService.getEncryptedMessage(requestSpecification, authorizedBy, SC_OK);

        String codename = getCodename(register.getBody().asString());

        Map<String, Object> queryParams = Map.of(
                "user_uuid", codename,
                "message_type", "secret");

        var box = Parser.getBoxMessage(requestSpecification, queryParams, authorizedBy);
        String message = box.getEnvelope();

            Box msg = Box.builder().envelope(message).build();

        var response = CryptoService.postFinalMessage(requestSpecification,codename,authorizedBy,toJson(msg));

        assertThat(response.getStatusCode()).isEqualTo(SC_OK);

    }
}
