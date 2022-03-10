package crypto.util;

import com.github.javafaker.Faker;
import crypto.model.User;

import java.util.UUID;

public class Util {
    static final Faker faker = new Faker();
    public static final String id = UUID.randomUUID().toString();


    public static User createUser(){
        return User.builder()
                .username(faker.funnyName().toString())
                .password(id)
                .build();
    }
}
