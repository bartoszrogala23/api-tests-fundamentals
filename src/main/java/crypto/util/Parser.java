package crypto.util;

import com.google.gson.Gson;
import crypto.CryptoService;
import crypto.model.EncryptedMessage;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static org.apache.http.HttpStatus.SC_OK;

@AllArgsConstructor(access = PRIVATE)
public class Parser {
    private static final Gson gson = new Gson();

    public static EncryptedMessage getEncryptedMessage(RequestSpecification spec, String authorizedBy) {
        Response response = CryptoService.getEncryptedMessage(spec, authorizedBy, SC_OK);

        return gson.fromJson(response.body().asString(), EncryptedMessage.class);
    }


    public <K> Object fetchResponse(Response response) {

        return gson.fromJson(response.body().asString(), Object.class);
    }
}
