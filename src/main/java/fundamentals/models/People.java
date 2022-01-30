package fundamentals.models;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class People {
    public String first_name;
    public String last_name;
}
