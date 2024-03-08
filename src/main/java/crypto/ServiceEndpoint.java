package crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static crypto.httpAddress.ACRONYM_AGENCY;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {
    LOCAL_HOST("http://localhost:8084"),
    GET_INFO(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/information"),
    REGISTER(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/register"),
    LOGIN(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/login"),
    ENCRYPTED_MESSAGE(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/encrypted_message"),
    GET_INFO_FROM_BOX(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/box"),
    FINAL_MESSAGE(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/{user_uuid}/headquarters"),
    CRYPTO_ENGINE(LOCAL_HOST.endpoint + ACRONYM_AGENCY + "/{user_uuid}/crypto_engine");

    private final String endpoint;
}

class httpAddress {
    protected static final String ACRONYM_AGENCY = "/challenge/acronym_agency/";
}
