package crypto;

import crypto.model.User;
import crypto.util.Parser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static crypto.util.Constants.AUTHORIZED_BY;
import static crypto.util.Util.createUniqueValue;
import static crypto.util.Util.createUser;
import static crypto.util.Util.faker;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

class EncryptedMessageTest {

    @Test
    void encryptedMessageTest() {
        String userName = faker.funnyName().name();
        String password = createUniqueValue();

        User user = createUser(userName, password);

        CryptoService.postRegister(toJson(user), SC_CREATED);

        RequestSpecification requestSpecification = setupUsingCredentials(userName, password);

        var login = CryptoService.postLogin(requestSpecification, SC_OK);
        String authorizedBy = login.getHeader(AUTHORIZED_BY);

       var response =  Parser.getEncryptedMessage(requestSpecification, authorizedBy);

        System.out.println(response.getMessage());
    }
}
