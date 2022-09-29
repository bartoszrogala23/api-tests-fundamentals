package coronavirus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {
    LOCAL_HOST("http://localhost:8085"),
    GET_INFORMATION(LOCAL_HOST.endpoint + "/challenge/genetics/information"),
    REGISTER(LOCAL_HOST.endpoint + "/challenge/genetics/register_as_technician"),
    CHECK_FLAGS(LOCAL_HOST.endpoint + "/challenge/genetics/check_flags"),
    GET_SEQUENCE(LOCAL_HOST.endpoint + "/challenge/genetics/primary_sequence"),
    SAMPLE_SEQUENCE(LOCAL_HOST.endpoint + "/challenge/genetics/sample_sequence"),
    GET_COPY(LOCAL_HOST.endpoint + "/challenge/genetics/copy"),
    TRIPLET_ID(LOCAL_HOST.endpoint + "/challenge/genetics/triplets/{triplet_id}"),
    TRIPLETS(LOCAL_HOST.endpoint + "/challenge/genetics/triplets/"),
    NUCLEOTIDE_ID(LOCAL_HOST.endpoint + "/challenge/genetics/nucleotides/{nucleotide_id}"),
    NUCLEOTIDES(LOCAL_HOST.endpoint + "/challenge/genetics/nucleotides/"),
    TRANSLATION(LOCAL_HOST.endpoint + "/challenge/genetics/translation");

    private final String endpoint;
}
