package reactor.util;

import com.github.javafaker.Faker;
import reactor.model.User;

public class ReactorSpecification {
    public static final Faker faker = new Faker();
    public static final User userName = User.builder().name(faker.name().fullName()).build();
}
