package fundamentals.basicAuthExample;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BasicAuthTest extends FundamentalsBase {

    @Test
    @DisplayName("try to log in using credentials test")
    void getLimitedResourcesTest() {

        var response = FundamentalsService.getCurrentUser(SC_OK);

        assertThat(response.body().asString())
                .contains("You are logged in");
    }
}
