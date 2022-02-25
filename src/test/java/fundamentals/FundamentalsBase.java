package fundamentals;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.assertj.core.api.SoftAssertions;

import static fundamentals.FundamentalsServiceSpecification.getSchema;

public abstract class FundamentalsBase  {
    public static Gson gson = new Gson();
    public static SoftAssertions softly = new SoftAssertions();
    public static Faker faker = new Faker();

    protected String putHuman = getSchema("putHumanCorrectSchema");
    protected String getPeople = getSchema("getPeopleSchema");
    protected String postPeople = getSchema("postPeopleSchema");
    protected String fundamentalsServerUnprocessableEntity = getSchema("ServerOperationUnprocessableEntitySchema");
    protected String fundamentalsIdUnprocessableEntity = getSchema("ThingIdUnprocessableEntitySchema");
    protected String queryParams = getSchema("queryParamsValidationErrorSchema");
    protected String getResponse = getSchema("getResponseOkSchema");
    protected String putHumanId = getSchema("putHumanIdValidationErrorSchema");
    protected String humanInvalidResult = getSchema("humanInvalidResultSchema");

}
