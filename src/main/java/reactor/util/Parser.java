package reactor.util;

import com.google.gson.Gson;
import reactor.ReactorService;
import reactor.model.CheckIn;
import reactor.model.Reactor;
import reactor.model.ReactorData;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class Parser {
    private static final Gson gson = new Gson();

    public static CheckIn parseCheckInResponse(String body) {
        var response = ReactorService.postCheckIn(body, SC_CREATED);

        return gson.fromJson(response.body().asString(), CheckIn.class);
    }

    public static Reactor parseControlRoom(String key) {
        var response = ReactorService.getControlRoom(key, SC_OK);

        return gson.fromJson(response.body().asString(), Reactor.class);
    }
}
