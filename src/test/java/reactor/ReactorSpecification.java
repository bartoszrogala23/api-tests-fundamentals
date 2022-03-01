package reactor;

import com.github.javafaker.Faker;
import reactor.model.User;

import java.util.Date;

import static groovy.json.JsonOutput.toJson;

public class ReactorSpecification {
    public static final Faker faker = new Faker();

    public static String generateUniqueValue() {
        return String.valueOf(new Date().getTime());
    }

    public static String createUser = toJson(User.builder().name(generateUniqueValue()).build());
}
