package fundamentals;

import io.restassured.response.Response;
import io.restassured.RestAssured;

import static fundamentals.ServiceEndpoint.LOCAL_HOST_OK;

public class FundamentalsService {


    public static Response getResponse(int httpStatus) {
        return RestAssured
                .given()
                .log().all()
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

