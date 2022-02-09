package fundamentals.cookies;

import com.github.javafaker.Faker;
import fundamentals.FundamentalsService;
import fundamentals.models.Credentials;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static fundamentals.FundamentalsServiceSpecification.setUser;
import static fundamentals.util.Values.PASSWORD;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

class ForLoggedUsersTest {
    SoftAssertions softly = new SoftAssertions();
    Faker faker = new Faker();

    @Test
    @DisplayName("get info for logged users test")
    void getCookieInfoTest() {
        String userName = faker.name().username();
        Credentials user = setUser(userName, PASSWORD);

        FundamentalsService.registerUser(toJson(user), SC_CREATED);
        Map<String,String> cookies = FundamentalsService.logUser(toJson(user), SC_ACCEPTED).getCookies();

        var response = FundamentalsService.getInfoForLoggedUser(cookies, SC_OK);

        softly.assertThat(response.body().asString())
                .contains("Observe this fully operational battle station, young " + userName);
        softly.assertAll();
    }
}
