package fundamentals.servingImages;

import fundamentals.FundamentalsBase;
import fundamentals.FundamentalsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class ImageTest extends FundamentalsBase {

    @Test
    @DisplayName("image by text test")
    void getImageTest() {

        var response = FundamentalsService.getImage(SC_OK);

     //TODO: assertion
    }
}
