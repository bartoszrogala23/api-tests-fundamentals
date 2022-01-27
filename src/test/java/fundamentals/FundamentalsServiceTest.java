package fundamentals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class FundamentalsServiceTest {


    @Tag("First test ever")

    @Test
    @DisplayName("check if 200 recieved")
    void Response() {
        var response = FundamentalsService.getResponse(SC_OK);

//        response
//                .then()
//                .body(matchesJsonSchemaInClasspath(getSchema("lpSuppliersSchema")));
    }
}


