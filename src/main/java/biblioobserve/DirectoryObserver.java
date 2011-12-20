package biblioobserve;

import biblioobserve.parsers.Parser;
import biblioobserve.parsers.ParserStrategy;
import biblioobserve.parsers.ParserStrategyFactory;
import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * @author matwood
 * @since 12/15/11
 *        Simple observer class to monitor an {@link ObservableDirectory} for new files.
 */
public class DirectoryObserver implements Observer {
    private final static Logger logger = Logger.getLogger(ObservableDirectory.class);

    @Override
    public void update(Observable o, Object arg) {
        try {
            ObservedFile ofile = (ObservedFile) arg;
            logger.debug("Notification Received:" + ofile.getType());

            ParserStrategy parserStrategy = ParserStrategyFactory.getParser(ofile.getType());
            Parser parser = new Parser(parserStrategy);
            parser.parseFile(ofile.getName());

        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }
}
