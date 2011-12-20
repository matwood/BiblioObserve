package biblioobserve.parsers;

/**
 * @author matwood
 * @since 12/15/11
 */
public class ParserStrategyNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Unknown ParserStrategy Type Requested.";
    }
}
