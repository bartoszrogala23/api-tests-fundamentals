package fundamentals.cookies;

import com.github.javafaker.Faker;
import fundamentals.FundamentalsService;
import fundamentals.models.Credentials;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.setUser;
import static fundamentals.util.Values.PASSWORD;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_CREATED;


class LoginTest {
    Faker faker = new Faker();
    SoftAssertions softly = new SoftAssertions();

    @Test
    @DisplayName("Try to log user test")
    void loginTest() {
        String userName = faker.name().username();
        Credentials user = setUser(userName, PASSWORD);

        FundamentalsService.registerUser(toJson(user), SC_CREATED);

        var response = FundamentalsService.logUser(toJson(user),SC_ACCEPTED);

        softly.assertThat(response.body().asString())
                .contains("Goooooood " + userName + ", everything is proceeding just as I have foreseen it.");
    }
}
