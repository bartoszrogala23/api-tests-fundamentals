package fundamentals;

import io.restassured.response.Response;

import java.util.Map;

import static fundamentals.ServiceEndpoint.GET_PEOPLE;
import static fundamentals.ServiceEndpoint.GET_PEOPLE_SLICED;
import static fundamentals.ServiceEndpoint.LOCAL_HOST_OK;
import static fundamentals.ServiceEndpoint.QUERY_PARAMS;
import static io.restassured.RestAssured.given;

public class FundamentalsService {

    public static Response getResponseOk(int httpStatus) {
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

    public static Response getResponseOkWithParams(Map<String,Object> params, int httpStatus){
        return
                given()
                        .log()
                        .all()
                        .when()
                        .queryParams(params)
                        .get(QUERY_PARAMS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getAllPeople(int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(GET_PEOPLE.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getAllPeopleSliced(Map<String,Object> params, int httpStatus){
        return
                given()
                        .log()
                        .all()
                        .when()
                        .queryParams(params)
                        .get(GET_PEOPLE_SLICED.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
