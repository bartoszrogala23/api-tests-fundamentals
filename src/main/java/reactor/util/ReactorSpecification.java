package reactor.util;

import reactor.model.User;

import java.util.Date;
import java.util.List;

public class ReactorSpecification {

    public static User createUser() {
        return User.builder().name(generateUniqueValue()).build();
    }

    public static String generateUniqueValue() {
        return String.valueOf(new Date().getTime());
    }
}


