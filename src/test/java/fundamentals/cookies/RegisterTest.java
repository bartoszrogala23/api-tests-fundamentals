package fundamentals.cookies;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fundamentals.FundamentalsServiceSpecification.setUser;
import static fundamentals.util.Values.PASSWORD;
import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;

class RegisterTest extends FundamentalsBase {
    String user;

    @BeforeEach
    public void setup(){
        user = faker.name().username();
    }

    @Test
    @DisplayName("register user test")
    void registerUserTest() {

        var response = FundamentalsService.registerUser(toJson(setUser(user, PASSWORD)), SC_CREATED);

        softly.assertThat(response.body().asString())
                .contains("User " + user + " registered");
        softly.assertAll();
    }

    @Test
    @DisplayName("Try create existing user test")
    void registerExistingUserTest() {

        FundamentalsService.registerUser(toJson(setUser(user, PASSWORD)), SC_CREATED);
        var response = FundamentalsService.registerUser(toJson(setUser(user, PASSWORD)), SC_BAD_REQUEST);

        softly.assertThat(response.body().asString())
                .contains("You are already registered to join the Empire!");
        softly.assertAll();
    }
}
