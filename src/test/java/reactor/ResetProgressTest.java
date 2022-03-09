package reactor;

import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class ResetProgressTest extends ReactorBase{

    @Test
    void analysisTest() {

        var response = ReactorService.getResetProgress(key, SC_OK);

        assertThat(response.body().asString()).contains("Your reactor is good as new!");
    }
}
