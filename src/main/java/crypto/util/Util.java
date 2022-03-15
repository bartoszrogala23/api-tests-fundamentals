package crypto.util;

import com.github.javafaker.Faker;
import crypto.model.User;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
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

    public static String getCodename(String responseText) {
        String codename = responseText.substring(0, responseText.length() - 2);
        return codename.substring(codename.lastIndexOf(" ") + 1);
    }
}
