package biblioobserve;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import biblioobserve.parsers.ParserStrategyConfigCollection;
import org.apache.log4j.Logger;

/**
 * @author matwood
 * @since 12/16/11
 *
 * Class that emulates a directory and alerts its observers when a file arrives.  When the class
 * notifies the observers it sends along information required to process the file.
 */
public class ObservableDirectory extends Observable{
    static Logger logger = Logger.getLogger(ObservableDirectory.class);

    public void run() {
        logger.debug("Pretend a file shows up...");

        ObservedFile ofile = new ObservedFile();
        ofile.setName("path/name/type");

        //grab set of parser types to pull one from random
        ArrayList<String> parserTypes = ParserStrategyConfigCollection.getInstance().getTypes();

        Random r = new Random();
        int numParsers = parserTypes.size();
        int parserIdx = Math.abs(r.nextInt())% (numParsers + 1); //add 1 for the JUNK parser

        if(parserIdx == numParsers){ //0 based arrays ftw
            ofile.setType("JUNK");
        } else{
            ofile.setType(parserTypes.get(parserIdx));
        }
        
        logger.debug("File is type: " + ofile.getType());
        
        setChanged();
        notifyObservers(ofile);
    }
}
