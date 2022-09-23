package coronavirus;

import io.restassured.response.Response;

import static coronavirus.ServiceEndpoint.GET_INFORMATION;
import static coronavirus.ServiceEndpoint.REGISTER;
import static io.restassured.RestAssured.given;

public class CoronavirusService {

    public static Response getInformation(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(GET_INFORMATION.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response register(String body, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .body(body)
                        .when()
                        .post(REGISTER.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
