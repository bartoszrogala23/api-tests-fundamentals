package crypto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class EncryptedMessage {
    String message;
    String securityInformation;
    String secret;
}
