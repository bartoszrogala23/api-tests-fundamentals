package crypto;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static crypto.ServiceEndpoint.GET_INFO;
import static crypto.ServiceEndpoint.LOGIN;
import static crypto.ServiceEndpoint.REGISTER;
import static io.restassured.RestAssured.given;

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
}
