package biblioobserve.parsers;

/**
 * @author matwood
 * @since 12/15/11
 */
public class ParserStrategyFactory {

    /**
     * Creates a parser from the given type based on the parser.xml configuration.  Any error will cause it
     * to throw a {@link ParserStrategyNotFoundException}.
     * @param parseType {@link String}
     * @return {@link ParserStrategy}
     * @throws ParserStrategyNotFoundException when no matching parse type is found.
     */
    public static ParserStrategy getParser(String parseType) throws
            ParserStrategyNotFoundException {
        ClassLoader classLoader = ParserStrategyFactory.class.getClassLoader();

        try{
            String parserClassPath = ParserStrategyConfigCollection.INSTANCE.getParserClassForType(parseType);
            return (ParserStrategy)classLoader.loadClass(parserClassPath).newInstance();
        } catch (Exception e){
            //for current purposes *any* exception means the parser was not found
            throw new ParserStrategyNotFoundException();
        }
    }
}
