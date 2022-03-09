package reactor;

import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class ReactorCoreTest extends ReactorBase{

    @Test
    void LookIntoReactorCoreTest() {

        var response = ReactorService.getAnalysis(key,SC_OK);

        assertThat(response.body().asString()).contains("the reactor is in state Operational!");
    }
}
