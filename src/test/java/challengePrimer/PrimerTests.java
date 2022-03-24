package challengePrimer;

import challengePrimer.model.User;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static challengePrimer.util.Util.FLAG_MESSAGE;
import static challengePrimer.util.Util.GET_INFORMATION_MESSAGE;
import static challengePrimer.util.Util.TRYOUT_MESSAGE;
import static groovy.json.JsonOutput.toJson;
import static java.lang.String.valueOf;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class PrimerTests {

    @Test
    @DisplayName("GET challenge/primer/information")
    void getInformationTest() {
        var response = PrimerService.getInformation(SC_OK);

        assertThat(response.getBody().asString()).contains(GET_INFORMATION_MESSAGE);
    }

    @Test
    @DisplayName("GET challenge/primer/tryout")
    void getTryoutTest() {
        var response = PrimerService.getTryout(SC_OK);

        assertThat(response.getBody().asString()).contains(TRYOUT_MESSAGE);
    }

    @Test
    @DisplayName("GET challenge/primer/flag")
    void getFlagTest() {
        var response = PrimerService.getFlagInfo(SC_OK);

        assertThat(response.getBody().asString()).contains(FLAG_MESSAGE);
    }

    @Test
    @DisplayName("GET challenge/primer/flag/{flag_id}")
    void getFlagIdTest() {
        String status = "200";
        List<Integer> flagsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var response = PrimerService.getFlagIdInfo(valueOf(i));
            if (response.statusCode() == SC_OK) {
                flagsList.add(i);
                assertThat(response.getBody().asString()).contains(status);
            }
        }
        System.out.println("Correct flags IDs are: " + flagsList);
    }

    @Test
    @DisplayName("POST challenge/primer/register")
    void postRegisterTest() {
        Faker faker = new Faker();

        User user = User.builder()
                .username(faker.funnyName().name())
                .password(faker.animal().name())
                .build();

        var response = PrimerService.postRegister(toJson(user), SC_CREATED);

        assertThat(response.getBody().asString()).contains("User " + user.getUsername() + " registered");
    }
}
