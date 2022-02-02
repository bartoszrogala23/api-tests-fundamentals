package fundamentals;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static fundamentals.ServiceEndpoint.*;
import static fundamentals.util.Util.setupUsingCredentials;
import static fundamentals.util.Values.PASSWORD;
import static fundamentals.util.Values.USERNAME;
import static io.restassured.RestAssured.given;

public class FundamentalsService {

    private static final String HUMAN_ID ="human_id";
    private static final String THINGS_ID ="things_id";

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
                        .ifValidationFails()
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

    public static Response getAllPeoplePaged(Map<String,Object> params, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .queryParams(params)
                        .get(GET_PEOPLE_PAGED.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getAllPeopleByName(Map<String,Object> params, int httpStatus){
        return
                given()
                .log()
                .ifValidationFails()
                .when()
                .queryParams(params)
                .get(GET_PEOPLE_BY.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response postHuman(String body, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .post(HUMAN.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putHuman(int idParam, String body, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .pathParam(HUMAN_ID, idParam)
                        .put(HUMAN_BY_ID.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response deleteHuman(int idParam, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam(HUMAN_ID, idParam)
                        .delete(HUMAN_BY_ID.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response patchHuman(int idParam, String body, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .body(body)
                        .pathParam(HUMAN_ID, idParam)
                        .patch(HUMAN_BY_ID.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getLimitedResource(int httpStatus){

        RequestSpecification requestSpecification =
                setupUsingCredentials(USERNAME, PASSWORD);

//        popatrz po RequestSpec -> setAuth. byc moze bedziesz inaczej budowac autoryzację.
//        RequestSpecification requestSpecification2 = new RequestSpecBuilder()
//                .setAuth("Username",USERNAME )
//                .addParam("password",PASSWORD)
//                .build();

        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(requestSpecification)
                        .when()
                        .get(LIMITED.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getThingId(int idParam, int httpStatus){
        return
                given()
                        .log()
                        .all()
                        .when()
                        .pathParam(THINGS_ID, idParam)
                        .get(THINGS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putThingId(int idParam, int httpStatus){
        return
                given()
                        .log()
                        .all()
                        .when()
                        .pathParam(THINGS_ID, idParam)
                        .put(THINGS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response postThingId(int idParam, int httpStatus){
        return
                given()
                        .log()
                        .ifValidationFails()
                        .when()
                        .pathParam(THINGS_ID, idParam)
                        .post(THINGS.getEndpoint())
                        .then()
                        .log()
                        .ifValidationFails()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
