package coronavirus;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static coronavirus.ServiceEndpoint.*;
import static coronavirus.util.Constant.*;
import static coronavirus.util.Constant.NUCLEOTIDE_ID;
import static coronavirus.util.Constant.TRIPLET_ID;
import static io.restassured.RestAssured.given;

@AllArgsConstructor
@Getter
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

    public static Response checkFlags(RequestSpecification specification, int httpStatus) {
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

    public static Response getPrimarySequence(RequestSpecification specification, int httpStatus) {
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

    public static Response getSampleSequence(RequestSpecification specification, int httpStatus) {
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

    public static Response getCopy(RequestSpecification specification, int httpStatus) {
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

    public static Response getTriplet(RequestSpecification specification, int tripletId, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .pathParam(TRIPLET_ID, tripletId)
                        .when()
                        .get(ServiceEndpoint.TRIPLET_ID.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response deleteTriplet(RequestSpecification specification, int tripletId, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .pathParam(TRIPLET_ID, tripletId)
                        .when()
                        .delete(ServiceEndpoint.TRIPLET_ID.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response patchTriplet(RequestSpecification specification, int tripletId, String tripletToAdd, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .pathParams(TRIPLET_ID, tripletId)
                        .queryParam(TRIPLET_TO_ADD, tripletToAdd)
                        .when()
                        .patch(ServiceEndpoint.TRIPLET_ID.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putTriplet(RequestSpecification specification, String tripletToAdd, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .queryParam(TRIPLET_TO_ADD, tripletToAdd)
                        .when()
                        .put(TRIPLETS.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response addTriplet(RequestSpecification specification, String tripletToAdd, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .queryParam(TRIPLET_TO_ADD, tripletToAdd)
                        .when()
                        .post(TRIPLETS.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getNucleotide(RequestSpecification specification, int nucleotideId, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .pathParam(NUCLEOTIDE_ID, nucleotideId)
                        .when()
                        .get(ServiceEndpoint.NUCLEOTIDE_ID.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response deleteNucleotide(RequestSpecification specification, int nucleotideId, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .pathParam(NUCLEOTIDE_ID, nucleotideId)
                        .when()
                        .delete(ServiceEndpoint.NUCLEOTIDE_ID.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response putNucleotide(RequestSpecification specification, String nucleotideToAdd, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .queryParam(NUCLEOTIDE_TO_ADD, nucleotideToAdd)
                        .when()
                        .put(NUCLEOTIDES.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response postNucleotide(RequestSpecification specification, String nucleotideToAdd, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .queryParam(NUCLEOTIDE_TO_ADD, nucleotideToAdd)
                        .when()
                        .post(NUCLEOTIDES.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }

    public static Response getTranslation(RequestSpecification specification, int httpStatus) {
        return
                given()
                        .log()
                        .ifValidationFails()
                        .spec(specification)
                        .when()
                        .get(TRANSLATION.getEndpoint())
                        .then()
                        .log()
                        .all()
                        .statusCode(httpStatus)
                        .extract()
                        .response();
    }
}
