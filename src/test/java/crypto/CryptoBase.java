package crypto;

import crypto.model.User;

import static crypto.util.Util.createUniqueValue;
import static crypto.util.Util.createUser;
import static crypto.util.Util.faker;

public abstract class CryptoBase {
    String userName = faker.funnyName().name();
    String password = createUniqueValue();
    User user = createUser(userName, password);
}
