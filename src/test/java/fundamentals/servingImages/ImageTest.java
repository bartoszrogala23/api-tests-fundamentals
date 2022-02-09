package fundamentals.servingImages;

import fundamentals.FundamentalsService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

class ImageTest {

    @Test
    @DisplayName("image by text test")
    void getImageTest() {
        var softly = new SoftAssertions();

        var response = FundamentalsService.getImage(SC_OK);

       //asercja?
    }
}
