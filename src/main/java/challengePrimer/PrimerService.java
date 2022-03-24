package challengePrimer;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static challengePrimer.PrimerEndpoint.FLAG_ID;
import static challengePrimer.PrimerEndpoint.FLAG_INFO;
import static challengePrimer.PrimerEndpoint.GET_INFORMATION;
import static challengePrimer.PrimerEndpoint.LOGIN;
import static challengePrimer.PrimerEndpoint.REGISTER;
import static challengePrimer.PrimerEndpoint.TRYOUT;
import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrimerService {

    public static Response getInformation(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(GET_INFORMATION.getEndpoint())
                        .then()
                        .statusCode(httpStatus)
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }

    public static Response getTryout(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(TRYOUT.getEndpoint())
                        .then()
                        .statusCode(httpStatus)
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }

    public static Response getFlagInfo(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(FLAG_INFO.getEndpoint())
                        .then()
                        .statusCode(httpStatus)
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }

    public static Response getFlagIdInfo(String flagId) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam("flag_id", flagId)
                        .get(FLAG_ID.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }

    public static Response postRegister(String body, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .post(REGISTER.getEndpoint())
                        .then()
                        .statusCode(httpStatus)
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }

    public static Response postLogin (String body, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .post(LOGIN.getEndpoint())
                        .then()
                        .statusCode(httpStatus)
                        .log()
                        .ifValidationFails()
                        .extract()
                        .response();
    }
}
