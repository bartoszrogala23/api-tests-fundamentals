package reactor.util;

import com.google.gson.Gson;
import reactor.ReactorService;
import reactor.model.CheckIn;

import static org.apache.http.HttpStatus.SC_CREATED;

public class Parser {
    private static final Gson gson = new Gson();

    public static CheckIn parseCheckInResponse(String body) {
        var response = ReactorService.postCheckIn(body, SC_CREATED);

        return gson.fromJson(response.body().asString(), CheckIn.class);
    }
}
