package fundamentals;

import io.restassured.response.Response;

import static fundamentals.ServiceEndpoint.LOCAL_HOST_OK;
import static io.restassured.RestAssured.given;

public class FundamentalsService {


    public static Response getResponse(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(LOCAL_HOST_OK.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}

