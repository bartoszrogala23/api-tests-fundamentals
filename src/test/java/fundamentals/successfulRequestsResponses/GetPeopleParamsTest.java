package fundamentals.successfulRequestsResponses;

import com.google.gson.Gson;
import fundamentals.FundamentalsService;
import fundamentals.models.People;
import fundamentals.util.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static fundamentals.FundamentalsService.getAllPeopleSliced;
import static fundamentals.util.Util.getSingleRecordByNumberFromPeople;
import static fundamentals.util.Values.FIRST_NAME;
import static fundamentals.util.Values.LAST_NAME;
import static org.apache.http.HttpStatus.SC_OK;

class GetPeopleParamsTest {
    //    TODO: you can't hardcode it. use model.
    final String lastName = "Marach";

    @Test
    void getPeopleUsingNameOnlyTest() {
        var softly = new SoftAssertions();


        var singleRecord = getAllPeopleSliced(getSingleRecordByNumberFromPeople(), SC_OK);

        Gson gson = new Gson();
        People[] human = gson.fromJson(singleRecord.body().asString(), People[].class);

        String name =Arrays.stream(human).findFirst().get().first_name;

        Map<String, Object> params = Map.of(
                FIRST_NAME, name
        );

        var response2 = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response2.body().asString()).contains(name);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingLastNameOnlyTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Map.of(
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains(lastName);
        softly.assertAll();
    }

    @Test
    void getPeopleUsingAllParamsTest() {
        var softly = new SoftAssertions();
        Map<String, Object> params = Map.of(
//                FIRST_NAME, name,
                LAST_NAME, lastName
        );

        var response = FundamentalsService.getAllPeopleByName(params, SC_OK);

        softly.assertThat(response.body().asString()).contains("asd", lastName);
        softly.assertAll();
    }
}
