package crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {
    LOCAL_HOST("http://localhost:8084"),
    GET_INFO(LOCAL_HOST.endpoint + "/challenge/acronym_agency/information"),
    REGISTER(LOCAL_HOST.endpoint + "/challenge/acronym_agency/register"),
    LOGIN(LOCAL_HOST.endpoint + "/challenge/acronym_agency/login"),
    ENCRYPTED_MESSAGE(LOCAL_HOST.endpoint + "/challenge/acronym_agency/encrypted_message"),
    GET_INFO_FROM_BOX(LOCAL_HOST.endpoint + "/challenge/acronym_agency/box"),
    FINAL_MESSAGE(LOCAL_HOST.endpoint + "/challenge/acronym_agency/{user_uuid}/headquarters"),
    CRYPTO_ENGINE(LOCAL_HOST.endpoint + "/challenge/acronym_agency/{user_uuid}/crypto_engine");

    private final String endpoint;
}
