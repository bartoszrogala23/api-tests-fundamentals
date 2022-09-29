package coronavirus.util;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import coronavirus.CoronavirusService;
import io.restassured.specification.RequestSpecification;

import static org.apache.http.HttpStatus.SC_OK;

public class Util {
    static final Faker faker = new Faker();
    public static Gson gson = new Gson();

    public static String fetchTriplet(RequestSpecification requestSpecification) {
        var sampleSequence = CoronavirusService.getSampleSequence(requestSpecification, SC_OK).body().asString();
        return sampleSequence.substring(0,2);
    }
}
