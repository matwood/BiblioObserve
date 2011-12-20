package biblioobserve.parsers;

/**
 * @author matwood
 * @since 12/16/11
 *        Executes a strategy on a parameter.
 */
public class Parser {
    private final ParserStrategy strategy;

    public Parser(ParserStrategy parserStrategy) {
        strategy = parserStrategy;
    }

    public void parseFile(String fileName) {
        strategy.parse(fileName);
    }
}
