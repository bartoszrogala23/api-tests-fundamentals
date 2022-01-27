package fundamentals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FundamentalsServiceTest {


    @Tag("First test ever")

    @Test
    @DisplayName("check if 200 recieved")
    void Response() {
        var response = FundamentalsService.getResponse(200);

//        response
//                .then()
//                .body(matchesJsonSchemaInClasspath(getSchema("lpSuppliersSchema")));
    }
}


