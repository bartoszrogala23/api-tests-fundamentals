package fundamentals;

public class FundamentalsServiceSpecification {

//    spróbuj resources ogarnąć w testach


    public static String getSchema(String schemaName) {
        String schemaDirectory = "json/fundamentalsService/%s.json";
        return String.format(schemaDirectory, schemaName);
    }
}
