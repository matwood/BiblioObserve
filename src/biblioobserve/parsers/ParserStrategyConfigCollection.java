package biblioobserve.parsers;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author matwood
 * @since 12/15/11
 * Manages the loading and access of the parser.xml config.  Should call {@link #configure()}
 * before first use.
 */
public enum ParserStrategyConfigCollection {
    INSTANCE;
    private final static Logger logger = Logger.getLogger(ParserStrategyConfigCollection.class);

    private final HashMap<String,String> loadedParsers = new HashMap<String,String>();

    /**
     * Singleton access.
     * @return {@link ParserStrategyConfigCollection}
     */
    public static ParserStrategyConfigCollection getInstance() {
        return INSTANCE;
    }

    private ParserStrategyConfigCollection() {}

    /**
     * Loads the parser.xml config file.  Should be called before first use.  Can be called again
     * in order to reload the file if changes were made while the programming was running.
     */
    public void configure(){
        loadedParsers.clear();

        try{
            XMLConfiguration config = new XMLConfiguration("parsers.xml");

            @SuppressWarnings("unchecked") //suppressed b/c of the configurationsAt List doesn't use generics<>
            List<HierarchicalConfiguration> parsers = config.configurationsAt("parsers.strategy");

            for(HierarchicalConfiguration parser : parsers){
                loadedParsers.put(parser.getProperty("type").toString()
                        ,parser.getProperty("classpath").toString());
            }

        }catch(ConfigurationException e){
            logger.debug("Exception: " + e.getMessage());
        }

        logger.debug("ParserStrategy Configurations Loaded.");
    }

    /**
     * 
     * @param type {@link String} - ParserStrategy type.  Used to search the hashmap of parsers.
     * @return {@link String} - Class name as defined in the parser.xml that
     * is associated with the parser type.
     */
    public String getParserClassForType(String type){
        return loadedParsers.get(type);
    }

    /**
     * 
     * @return {@link ArrayList} - List of all available parser types.
     */
    public ArrayList<String> getTypes(){
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(loadedParsers.keySet());
        return list;
    }
}
