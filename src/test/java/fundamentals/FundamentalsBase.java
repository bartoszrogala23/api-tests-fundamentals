package fundamentals;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.assertj.core.api.SoftAssertions;

import static fundamentals.FundamentalsServiceSpecification.getSchema;

public abstract class FundamentalsBase  {
    public static Faker faker = new Faker();
    public static Gson gson = new Gson();

    protected String fundamentalsPutHuman = getSchema("putHumanCorrectSchema");
    protected String fundamentalsGetPeople = getSchema("getPeopleSchema");
    protected String fundamentalsPostPeople = getSchema("postPeopleSchema");
    protected String fundamentalsServerUnprocessableEntity = getSchema("ServerOperationUnprocessableEntitySchema");
    protected String fundamentalsIdUnprocessableEntity = getSchema("ThingIdUnprocessableEntitySchema");
    protected String fundamentalsQueryParams = getSchema("queryParamsValidationErrorSchema");
    protected String fundamentalsGetResponse = getSchema("getResponseOkSchema");
    protected String fundamentalsPutHumanId = getSchema("putHumanIdValidationErrorSchema");
    protected String fundamentalsHumanInvalidResult = getSchema("humanInvalidResultSchema");

}
