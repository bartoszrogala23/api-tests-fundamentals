package crypto;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;

import java.util.Map;

import static crypto.ServiceEndpoint.*;
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

    public static Response postFinalMessage(RequestSpecification spec, String pathParam, String authorizedBy,
                                            String body) {
        return given()
                .log()
                .ifValidationFails()
                .when()
                .spec(spec)
                .pathParam("user_uuid", pathParam)
                .header(AUTHORIZED_BY, authorizedBy)
                .body(body)
                .post(FINAL_MESSAGE.getEndpoint())
                .then()
                .extract()
                .response();
    }
}
