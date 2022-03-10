package crypto.util;

import com.github.javafaker.Faker;
import crypto.model.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.UUID;

import static crypto.util.Constants.PASSWORD;
import static crypto.util.Constants.USERNAME;

public class Util {
    public static final Faker faker = new Faker();
    public static final String uniqueValue = UUID.randomUUID().toString();

    public static User createUser(String username, String password){
        return User.builder()
                .username(faker.funnyName().name())
                .password(uniqueValue)
                .build();
    }

    //TODO: set requestSpec
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .addParam(USERNAME, "value1",
                    PASSWORD, "")
            .build();
}
