package reactor;

import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static reactor.Constants.CORE_LOOKS_FINE;

class ControlRoomAnalysisTest extends ReactorBase{
    @Test
    void analysisTest() {

        var response = ReactorService.getReactorCore(key,SC_OK);

        assertThat(response.body().asString())
                .contains(CORE_LOOKS_FINE);
    }
}
