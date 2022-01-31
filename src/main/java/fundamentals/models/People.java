package fundamentals.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@AllArgsConstructor(access = PRIVATE)
public class People {
    public String first_name;
    public String last_name;
}
