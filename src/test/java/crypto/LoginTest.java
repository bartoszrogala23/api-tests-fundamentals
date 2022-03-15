package crypto;

import crypto.model.User;
import fundamentals.util.Util;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static crypto.util.Util.createUniqueValue;
import static crypto.util.Util.createUser;
import static crypto.util.Util.faker;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class LoginTest extends CryptoBase{

    @Test
    void loginUserTest() {
        CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification =
                Util.setupUsingCredentials(userName, password);

        var response = CryptoService.postLogin(requestSpecification,SC_OK);

        assertThat(response.getBody().asString())
                .contains("Welcome, " + userName);
    }
}
