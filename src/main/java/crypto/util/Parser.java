package crypto.util;

import com.google.gson.Gson;
import crypto.CryptoService;
import crypto.model.Box;
import crypto.model.EncryptedMessage;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static org.apache.http.HttpStatus.SC_OK;

@AllArgsConstructor(access = PRIVATE)
public class Parser {
    private static final Gson gson = new Gson();

    public static EncryptedMessage getEncryptedMessage(RequestSpecification spec, String authorizedBy) {
        Response response = CryptoService.getEncryptedMessage(spec, authorizedBy, SC_OK);

        return gson.fromJson(response.body().asString(), EncryptedMessage.class);
    }

    public static Box getBoxMessage(RequestSpecification spec, Map<String, Object> queryParams, String authorizedBy) {
        Response response = CryptoService.getBox(spec, queryParams, authorizedBy, SC_OK);

        return gson.fromJson(response.getBody().asString(), Box.class);
    }
}
