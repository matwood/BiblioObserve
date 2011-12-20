package biblioobserve;

import biblioobserve.parsers.ParserStrategyConfigCollection;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author matwood
 * @since 12/16/11
 *
 * Basic application created to demonstrate a few different topics:
 *
 * 1) Observer Pattern.  This is a basic GoF pattern where objects (observers)
 * register themselves with another object (observable) in order be alerted when
 * events occur.
 *
 * 2) Factory Method Pattern. Another GoF pattern where the exact class used to create
 * the object is unknown to the requester.   The exact class used is typically
 * determined by some parameters passed to the factory method.
 *
 * 3) Strategy Pattern.  The Parser class acts as the context or strategy executor.  In
 * following with the spirit of the pattern of being able to select a new strategy at
 * runtime the system is setup in way to make it easy to create new strategies
 * and load them.
 *
 */
public class Application {
    static Logger logger = Logger.getLogger(Application.class);
    
    public static void main(String[] args){
        //setup log4j
        BasicConfigurator.configure();

        //setup parser collection
        ParserStrategyConfigCollection.INSTANCE.configure();

        //create the app objects
        final ObservableDirectory obd = new ObservableDirectory();
        DirectoryObserver dirobs = new DirectoryObserver();

        //add observer
        obd.addObserver(dirobs);
        logger.debug("Observer added");

        //quick hack timer to trigger a notify every 5 seconds
        Timer t = new Timer();
        t.schedule(new TimerTask(){
            public void run(){
                obd.run();
            }
        }, 0, 5000);
    }
}
