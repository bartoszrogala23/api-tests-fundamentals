package reactor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Value
@AllArgsConstructor(access = PRIVATE)
public class CheckIn {
    String message;
    String key;
}
