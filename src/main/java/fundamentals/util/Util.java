package fundamentals.util;

import com.github.javafaker.Faker;
import fundamentals.models.People;
import lombok.NoArgsConstructor;
import org.apache.groovy.util.Maps;

import java.util.Map;
import java.util.Random;

import static fundamentals.util.Values.FROM_NUMBER;
import static fundamentals.util.Values.UP_TO_NUMBER;
import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
public class Util {
    static final int lowerBound = 1;
    static final int upperBound = 1000;
    static final Faker faker = new Faker();
    static final Random random = new Random();

    public static int getRandomId() {
        return (random.nextInt(upperBound - lowerBound) + lowerBound);
    }

    public static Map<String, Object> getSingleRecordByNumberFromPeople() {
        int randomValue = (random.nextInt(upperBound - lowerBound) + lowerBound);
        int randomValueBound = randomValue + 1;
        String randomRecordNumber = Integer.toString(randomValue);
        String randomRecordNumberUpperBound = Integer.toString(randomValueBound);
        return Maps.of(
                FROM_NUMBER, randomRecordNumber,
                UP_TO_NUMBER, randomRecordNumberUpperBound
        );
    }

    public static People createRandomBodyForPeople() {
        return People.builder().first_name(faker.name().firstName()).last_name(faker.name().lastName()).build();
    }
}
