package crypto;

import crypto.model.User;
import org.junit.jupiter.api.Test;

import static crypto.util.Constants.REGISTER_MESSAGE;
import static crypto.util.Util.*;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegisterTest extends CryptoBase{

    @Test
    void postRegisterTest() {
        User user = createUser(faker.funnyName().name(), uniqueValue);

        var response = CryptoService.postRegister(toJson(user), SC_CREATED);

        String responseText = response.getBody().asString();

        assertThat(responseText).contains(REGISTER_MESSAGE);

        String id = responseText.substring(responseText.lastIndexOf(" ") + 1, responseText.length() - 2);
    }
}
