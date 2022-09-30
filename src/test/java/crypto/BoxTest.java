package crypto;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static crypto.util.Constants.AUTHORIZED_BY;
import static crypto.util.Constants.USER_UUID;
import static crypto.util.Util.getCodename;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class BoxTest extends CryptoBase{

    @Test
    void boxTest() {

        var register = CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification = setupUsingCredentials(userName, password);

        var login = CryptoService.postLogin(requestSpecification, SC_OK);
        String authorizedBy = login.getHeader(AUTHORIZED_BY);

        CryptoService.getEncryptedMessage(requestSpecification, authorizedBy, SC_OK);

        String codename = getCodename(register.getBody().asString());

        Map<String, Object> queryParams = Map.of(
                USER_UUID, codename,
                "message_type", "secret");

        var response = CryptoService.getBox(requestSpecification, queryParams, authorizedBy,SC_OK);

        assertThat(response.statusCode()).isEqualTo(SC_OK);
    }
}
