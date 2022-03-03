package reactor;

import reactor.model.User;
import reactor.util.Parser;

import java.util.Date;
import java.util.List;

import static groovy.json.JsonOutput.toJson;

public class ReactorSpecification {

    public static String generateUniqueValue() {
        return String.valueOf(new Date().getTime());
    }

    public static String createUser = toJson(User.builder().name(generateUniqueValue()).build());


    public static void setupReactorPower(String key) {
        var reactor = Parser.parseControlRoom(key);
        List<String> fuelRods = reactor.
        System.out.println(fuelRods);
//        for (String fuelRod : fuelRods) {
//            if (fuelRod.isEmpty()) {
//                System.out.println("empty rod: " + fuelRod);
//            }
        }
    }


