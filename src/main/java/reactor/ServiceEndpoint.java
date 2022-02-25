package reactor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {

    LOCAL_HOST ("http://localhost:8083"),
    INFORMATION (LOCAL_HOST.endpoint + "/challenge/reactor/information"),
    CHECK_IN (LOCAL_HOST.endpoint + "/challenge/reactor/desk"),
    CONTROL_ROOM (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/control_room"),
    CONTROL_ROD (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/control_room/control_rods/{rod_number}"),
    AZ_5 (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/control_room/az_5"),
    REACTOR_CORE (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/reactor_core"),
    ANALYSIS (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/control_room/analysis"),
    FUEL_ROD (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/control_room/fuel_rods/{rod_number}"),
    RESET_PROGRESS (LOCAL_HOST.endpoint + "/challenge/reactor/{key}/reset_progress");

    private final String endpoint;
}
