package biblioobserve.parsers;

import org.apache.log4j.Logger;

/**
 * @author matwood
 * @since 12/15/11
 */
public class ParserStrategyJSON implements ParserStrategy {
    static Logger logger = Logger.getLogger(ParserStrategyJSON.class);

    @Override
    public void parse(String fileName) {
        logger.debug("Parsing JSON file: " + fileName);
    }
}
