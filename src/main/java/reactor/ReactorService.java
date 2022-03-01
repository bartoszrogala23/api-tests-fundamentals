package reactor;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static reactor.ServiceEndpoint.CHECK_IN;
import static reactor.ServiceEndpoint.CONTROL_ROOM;
import static reactor.ServiceEndpoint.INFORMATION;

public class ReactorService {

    public static Response getInformation(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(INFORMATION.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response postCheckIn(String body, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .post(CHECK_IN.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getControlRoom(String key, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam("key",key)
                        .get(CONTROL_ROOM.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
