package fundamentals;

public class FundamentalsServiceSpecification {

    public static String getSchema(String schemaName) {
        String schemaDirectory = "json/fundamentalsService/%s.json";
        return String.format(schemaDirectory, schemaName);
    }
}
