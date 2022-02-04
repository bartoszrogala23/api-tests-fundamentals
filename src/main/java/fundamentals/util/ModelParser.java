package fundamentals.util;

import fundamentals.models.People;

import static fundamentals.FundamentalsService.getAllPeopleSliced;
import static fundamentals.util.Util.getSingleRecordByNumberFromPeople;
import static org.apache.http.HttpStatus.SC_OK;

public class ModelParser {

    public static Object parse() {
        var response = getAllPeopleSliced(getSingleRecordByNumberFromPeople(), SC_OK);

        return ResponseParser.parseHuman(response, People.class);
    }
}
