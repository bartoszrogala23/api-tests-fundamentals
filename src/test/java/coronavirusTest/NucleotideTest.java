package coronavirusTest;

import coronavirus.CoronavirusService;
import coronavirus.model.User;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coronavirus.util.Constant.*;
import static coronavirus.util.CoronavirusSpecification.createRandomUser;
import static fundamentals.util.Util.setupUsingCredentials;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NucleotideTest {
    User user;
    RequestSpecification requestSpecification;
    final int nucleotideId = 1;
    final int invalidNucleotideId = 100;

    @BeforeEach
    public void setup() {
        user = createRandomUser();
        CoronavirusService.register(toJson(user), SC_CREATED);
        requestSpecification = setupUsingCredentials(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("GET nucleotide test")
    void getNucleotide() {
        var response = CoronavirusService.getNucleotide(requestSpecification, nucleotideId, SC_OK);

        assertThat(response.getBody().asString())
                .contains(String.format(GET_NUCLEOTIDE, nucleotideId));
    }

    @Test
    @DisplayName("GET invalid nucleotide test")
    void getInvalidNucleotide() {
        var response = CoronavirusService.getNucleotide(requestSpecification, invalidNucleotideId, SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(NUCLEOTIDE_OUT_OF_BOUND);
    }

    @Test
    @DisplayName("DELETE invalid nucleotide test")
    void deleteInvalidNucleotide() {
        var response = CoronavirusService.deleteNucleotide(requestSpecification, invalidNucleotideId, SC_UNPROCESSABLE_ENTITY);

        assertThat(response.getBody().asString())
                .contains(NUCLEOTIDE_OUT_OF_BOUND);
    }

    @Test
    @DisplayName("PUT nucleotide test")
    void putNucleotide() {
        var response = CoronavirusService.putNucleotide(requestSpecification, "A", SC_OK);

        assertThat(response.getBody().asString())
                .contains(PUT_NUCLEOTIDE);
    }

    @Test
    @DisplayName("POST nucleotide test")
    void postNucleotide() {
        var response = CoronavirusService.postNucleotide(requestSpecification, "A", SC_CREATED);

        assertThat(response.getBody().asString())
                .contains(POST_NUCLEOTIDE);
    }

    @Test
    @DisplayName("DELETE nucleotide test")
    void deleteNucleotide() {
        var response = CoronavirusService.postNucleotide(requestSpecification, "A", SC_CREATED);

        assertThat(response.getBody().asString())
                .contains(POST_NUCLEOTIDE);
    }
}
