package coronavirus;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static coronavirus.ServiceEndpoint.*;
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

    public static Response checkFlags (RequestSpecification specification, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .when()
                        .get(CHECK_FLAGS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getPrimarySequence (RequestSpecification specification, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .when()
                        .get(GET_SEQUENCE.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getSampleSequence (RequestSpecification specification, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .when()
                        .get(SAMPLE_SEQUENCE.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getCopy (RequestSpecification specification, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .when()
                        .get(GET_COPY.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
