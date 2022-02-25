package reactor;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;

public abstract class ReactorBase {
    public static SoftAssertions softly = new SoftAssertions();
    public static Faker faker = new Faker();

}
