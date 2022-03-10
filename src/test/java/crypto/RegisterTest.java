package crypto;

import crypto.model.User;
import org.junit.jupiter.api.Test;

import static crypto.util.Constants.REGISTER_MESSAGE;
import static crypto.util.Util.createUser;
import static crypto.util.Util.faker;
import static crypto.util.Util.uniqueValue;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegisterTest {

    @Test
    void postRegisterTest(){
        User user = createUser(faker.funnyName().name(),uniqueValue);

        var response = CryptoService.postRegister(toJson(user),SC_CREATED);

        String responseText = response.getBody().asString();

        assertThat(responseText).contains(REGISTER_MESSAGE);

        // User's unique identification number starts from character no 78
        String id = responseText.substring(78);
    }
}
