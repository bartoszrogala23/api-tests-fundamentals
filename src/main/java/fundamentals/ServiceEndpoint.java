package fundamentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {

    LOCAL_HOST("http://localhost:8080"),
    LOCAL_HOST_OK(LOCAL_HOST.endpoint + "/ok");

    private final String endpoint;
}
