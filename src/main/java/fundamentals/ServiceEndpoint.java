package fundamentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {

    LOCAL_HOST("http://localhost:8080"),
    LOCAL_HOST_OK(LOCAL_HOST.endpoint + "/ok"),
    QUERY_PARAMS(LOCAL_HOST.endpoint + "/query_params"),
    GET_PEOPLE(LOCAL_HOST.endpoint + "/get_all_people"),
    GET_PEOPLE_SLICED(LOCAL_HOST.endpoint + "/get_all_people_sliced"),
    GET_PEOPLE_PAGED(LOCAL_HOST.endpoint + "/get_all_people_paged"),
    GET_PEOPLE_BY(LOCAL_HOST.endpoint + "/get_people_by"),
    HUMAN(LOCAL_HOST.endpoint + "/human/"),
    HUMAN_BY_ID(HUMAN.endpoint + "{human_id}"),

    LIMITED(LOCAL_HOST.endpoint + "/limited"),
    THINGS(LOCAL_HOST.endpoint + "/things/{things_id}"),
    SERVER_OPERATION(LOCAL_HOST.endpoint + "/server_operation/{operation_name}"),

    HEADER_CHECK(LOCAL_HOST.endpoint + "/header_check"),

    READ_CURRENT_USER(LOCAL_HOST.endpoint + "/users/me"),

    IMAGES(LOCAL_HOST.endpoint + "/images"),
    IMAGES_BY_TEXT(LOCAL_HOST.endpoint + "/images_by_text");

    private final String endpoint;
}
