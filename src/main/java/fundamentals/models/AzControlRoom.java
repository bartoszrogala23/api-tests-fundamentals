package fundamentals.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
public class AzControlRoom {
        public boolean pressed;
    }

