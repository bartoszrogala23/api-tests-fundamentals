package challengePrimer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static challengePrimer.util.Constants.FLAG_MESSAGE;
import static challengePrimer.util.Constants.GET_INFORMATION_MESSAGE;
import static challengePrimer.util.Constants.TRYOUT_MESSAGE;
import static java.lang.String.valueOf;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class PrimerTests {

    @Test
    void getInformationTest() {
        var response = PrimerService.getInformation(SC_OK);

        assertThat(response.getBody().asString()).contains(GET_INFORMATION_MESSAGE);
    }

    @Test
    void getTryout() {
        var response = PrimerService.getTryout(SC_OK);

        assertThat(response.getBody().asString()).contains(TRYOUT_MESSAGE);
    }

    @Test
    void getFlag() {
        var response = PrimerService.getFlagInfo(SC_OK);

        assertThat(response.getBody().asString()).contains(FLAG_MESSAGE);
    }

    @Test
    void getFlagId() {
        String status = "200";
        List<Integer>  flagsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var response = PrimerService.getFlagIdInfo(valueOf(i));
           if (response.statusCode() == SC_OK) {
               flagsList.add(i);
               assertThat(response.getBody().asString()).contains(status);
           }
        }
        System.out.println("Correct flags IDs are: " + flagsList);
    }
}
