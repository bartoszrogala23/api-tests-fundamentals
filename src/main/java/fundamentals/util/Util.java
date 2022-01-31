package fundamentals.util;

import lombok.Getter;
import org.apache.groovy.util.Maps;

import java.util.Map;
import java.util.Random;

import static fundamentals.util.Values.FROM_NUMBER;
import static fundamentals.util.Values.UP_TO_NUMBER;

public class Util {
    static final int lowerBound = 1;
    static final int upperBound = 1000;

    public static Map<String, Object> getSingleRecordFromPeople() {
        Random random = new Random();
        int randomValue = (random.nextInt(upperBound - lowerBound) + lowerBound);
        int randomValueBound = randomValue + 1;
        String randomRecordNumber = Integer.toString(randomValue);
        String randomRecordNumberUpperBound = Integer.toString(randomValueBound);
        return Maps.of(
                FROM_NUMBER, randomRecordNumber,
                UP_TO_NUMBER, randomRecordNumberUpperBound
        );
    }
}
