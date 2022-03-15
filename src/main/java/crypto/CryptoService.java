package crypto;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;

import java.util.Map;

import static crypto.ServiceEndpoint.ENCRYPTED_MESSAGE;
import static crypto.ServiceEndpoint.FINAL_MESSAGE;
import static crypto.ServiceEndpoint.GET_INFO;
import static crypto.ServiceEndpoint.GET_INFO_FROM_BOX;
import static crypto.ServiceEndpoint.LOGIN;
import static crypto.ServiceEndpoint.REGISTER;
import static crypto.util.Constants.AUTHORIZED_BY;
import static io.restassured.RestAssured.given;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CryptoService {

    public static Response getInformation(int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .get(GET_INFO.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response postRegister(String body, int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .body(body)
                .post(REGISTER.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response postLogin(RequestSpecification spec, int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .spec(spec)
                .post(LOGIN.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response getEncryptedMessage(RequestSpecification spec, String authorizedBy, int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .header(AUTHORIZED_BY, authorizedBy)
                .spec(spec)
                .get(ENCRYPTED_MESSAGE.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response getBox(RequestSpecification spec, Map<String, Object> queryParams,String authorizedBy,
                                  int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .spec(spec)
                .queryParams(queryParams)
                .header(AUTHORIZED_BY, authorizedBy)
                .get(GET_INFO_FROM_BOX.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response postFinalMessage(RequestSpecification spec, String user_uuid, String authorizedBy,
                                            String body) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .spec(spec)
                .pathParam("user_uuid", user_uuid)
                .header(AUTHORIZED_BY, authorizedBy)
                .body(body)
                .post(FINAL_MESSAGE.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .extract()
                .response();
    }
}
