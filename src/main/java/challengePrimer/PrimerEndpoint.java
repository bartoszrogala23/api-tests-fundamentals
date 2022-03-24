package challengePrimer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PrimerEndpoint {
    LOCAL_HOST("http://localhost:8082"),
    GET_INFORMATION(LOCAL_HOST.endpoint + "/challenge/primer/information"),
    TRYOUT(LOCAL_HOST.endpoint + "/challenge/primer/tryout"),
    FLAG_INFO(LOCAL_HOST.endpoint + "/challenge/primer/flag"),
    FLAG_ID(LOCAL_HOST.endpoint + "/challenge/primer/flag/{flag_id}"),
    REGISTER(LOCAL_HOST.endpoint + "/challenge/primer/register"),
    LOGIN(LOCAL_HOST.endpoint + "/challenge/primer/login");
    private final String endpoint;
}
