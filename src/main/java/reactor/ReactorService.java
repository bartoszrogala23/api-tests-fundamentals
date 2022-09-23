package reactor;

import io.restassured.response.Response;

import java.util.Map;

import static fundamentals.util.Values.KEY;
import static io.restassured.RestAssured.given;
import static reactor.ServiceEndpoint.*;

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
                        .pathParam(KEY, key)
                        .get(CONTROL_ROOM.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putAz5(String key, String body, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .pathParam(KEY, key)
                        .put(AZ_5.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getReactorCore(String key, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam(KEY, key)
                        .get(REACTOR_CORE.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getAnalysis(String key, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam(KEY, key)
                        .get(ANALYSIS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getResetProgress(String key, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam(KEY, key)
                        .get(RESET_PROGRESS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putFuelRod(Map<String, String> pathParams, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParams(pathParams)
                        .put(FUEL_ROD.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response deleteFuelRod(Map<String, String> pathParams, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParams(pathParams)
                        .delete(FUEL_ROD.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putControlRod(Map<String, String> pathParams, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParams(pathParams)
                        .put(CONTROL_ROD.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response deleteControlRod(Map<String, String> pathParams, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParams(pathParams)
                        .delete(CONTROL_ROD.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
