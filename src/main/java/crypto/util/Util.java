package crypto.util;

import com.github.javafaker.Faker;
import crypto.model.User;

import java.util.UUID;

public class Util {
    public static final Faker faker = new Faker();
    public static final String uniqueValue = UUID.randomUUID().toString();


    public static String createUniqueValue() {
        return UUID.randomUUID().toString();
    }

    public static User createUser(String username, String password){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

}
