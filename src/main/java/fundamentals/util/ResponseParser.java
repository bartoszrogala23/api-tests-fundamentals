package fundamentals.util;

import com.google.gson.Gson;
import fundamentals.models.People;
import io.restassured.response.Response;


public class ResponseParser {
    private static final Gson gson = new Gson();

    public static Object parseHuman(Response response, Class<People> peopleClass) {
       return gson.fromJson(response.toString(), People.class);
    }
}
