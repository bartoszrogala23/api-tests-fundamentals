package crypto;

import crypto.model.User;
import crypto.util.Util;
import org.junit.jupiter.api.Test;

import static crypto.util.Constants.REGISTER_MESSAGE;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegisterTest {

    @Test
    void postRegisterTest(){
        User user = Util.createUser();

        var response = CryptoService.postRegister(toJson(user),SC_CREATED);

        assertThat(response.getBody().asString()).contains(REGISTER_MESSAGE);

//        todo: crop id from response
    }
}
