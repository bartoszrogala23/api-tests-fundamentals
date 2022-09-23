package coronavirus.util;

import coronavirus.model.User;
import lombok.Getter;

@Getter
public class CoronavirusSpecification extends Util {

    public static User createRandomUser() {
        return User.builder()
                .username(faker.name().username())
                .password(faker.internet().password())
                .build();
    }
}
