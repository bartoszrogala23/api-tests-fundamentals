package reactor;

import org.junit.jupiter.api.BeforeEach;
import reactor.model.CheckIn;

import static groovy.json.JsonOutput.toJson;
import static reactor.ReactorSpecification.createUser;
import static reactor.util.Parser.parseCheckInResponse;

public abstract class ReactorBase {
    public CheckIn checkIn;
    public String key;

    @BeforeEach
    public void setup(){
        checkIn = parseCheckInResponse(toJson(createUser));
        key = checkIn.getKey();
    }
}
