package reactor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class ReactorData{
    private String _ReactorCore__uuid;
    private int _ReactorCore__power;
    private List<String> _ReactorCore__fuel_rods;
    private List<String> _ReactorCore__control_rods;
    private String _ReactorCore__state;
    private String _ReactorCore__description;
}

