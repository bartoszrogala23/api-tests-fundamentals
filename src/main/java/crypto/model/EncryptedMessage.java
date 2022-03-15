package crypto.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

@Value
@AllArgsConstructor(access = PRIVATE)
public class EncryptedMessage {
    String message;
    String securityInformation;
    String secret;
}
