package fundamentals;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.assertj.core.api.SoftAssertions;

public abstract class FundamentalsBase  {
    public static Gson gson = new Gson();
    public static SoftAssertions softly = new SoftAssertions();
    public static Faker faker = new Faker();
}
