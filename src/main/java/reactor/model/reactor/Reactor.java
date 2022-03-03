package reactor.model.reactor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Value
@AllArgsConstructor(access = PRIVATE)
public class Reactor {
    String message;
    ReactorData reactorData;

    @Value
    @AllArgsConstructor(access = PRIVATE)
    public class ReactorData{
        String _ReactorCore__uuid;
        int _ReactorCore__power;
        List<String> _ReactorCore__fuel_rods;
        List<String> _ReactorCore__control_rods;
        String _ReactorCore__state;
        String _ReactorCore__description;
    }
}
