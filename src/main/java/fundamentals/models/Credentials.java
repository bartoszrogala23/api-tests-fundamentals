package fundamentals.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@AllArgsConstructor(access = PRIVATE)
public class Credentials {
    String username;
    String password;
}
