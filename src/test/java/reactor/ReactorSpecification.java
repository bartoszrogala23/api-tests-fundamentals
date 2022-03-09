package reactor;

import reactor.model.User;
import reactor.util.Parser;

import java.util.Date;
import java.util.List;

public class ReactorSpecification {

    public static User createUser = User.builder().name(generateUniqueValue()).build();

    public static String generateUniqueValue() {
        return String.valueOf(new Date().getTime());
    }

    public static void setupReactorPower(String key) {
        var reactor = Parser.parseControlRoom(key);
        System.out.println(reactor.getReactorData().get_ReactorCore__fuel_rods());
        List fuelRods =  reactor.getReactorData().get_ReactorCore__fuel_rods();
        System.out.println(fuelRods);
        }
}


