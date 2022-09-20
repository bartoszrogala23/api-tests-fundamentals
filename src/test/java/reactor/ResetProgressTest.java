package reactor;

import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.GOOD_AS_NEW;

class ResetProgressTest extends ReactorBase{

    @Test
    void analysisTest() {

        var response = ReactorService.getResetProgress(key, SC_OK);

        assertThat(response.body().asString())
                .contains(GOOD_AS_NEW);
    }
}
