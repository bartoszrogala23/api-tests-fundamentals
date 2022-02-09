package fundamentals;

import fundamentals.models.Credentials;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FundamentalsServiceSpecification {

    public static String getSchema(String schemaName) {
        String schemaDirectory = "json/fundamentalsService/%s.json";
        return String.format(schemaDirectory, schemaName);
    }

    public static Credentials setUser(String username, String password) {
       return Credentials.builder().username(username).password(password).build();
    }
}
