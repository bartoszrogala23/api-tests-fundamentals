package fundamentals.successfulRequestsResponses;

import com.google.gson.Gson;
import fundamentals.FundamentalsService;
import fundamentals.models.People;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.FundamentalsService.getAllPeopleSliced;
import static fundamentals.util.Util.getSingleRecordByNumberFromPeople;
import static fundamentals.util.Values.FIRST_NAME;
import static fundamentals.util.Values.LAST_NAME;
import static java.util.Arrays.stream;
import static org.apache.http.HttpStatus.SC_OK;

class GetPeopleParamsTest {

    Gson gson = new Gson();
    SoftAssertions softly = new SoftAssertions();
    Response singleRecord;
    People[] human;

    @BeforeEach
    public void setup(){
        singleRecord = getAllPeopleSliced(getSingleRecordByNumberFromPeople(), SC_OK);
        human =  gson.fromJson(singleRecord.body().asString(), People[].class);
    }

    @Test
    void getPeopleUsingNameOnlyTest() {
        String name = stream(human).iterator().next().getFirst_name();
        Map<String, Object> params = Map.of(
                FIRST_NAME, name
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(name);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingLastNameOnlyTest() {
        String lastName = stream(human).iterator().next().getLast_name();
        Map<String, Object> params = Map.of(
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(lastName);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingAllParamsTest() {
        String name = stream(human).iterator().next().first_name;
        String lastName = stream(human).iterator().next().last_name;
         Map<String, Object> params = Map.of(
                FIRST_NAME, name,
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(name, lastName);
        softly.assertAll();
    }
}
