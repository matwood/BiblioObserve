package biblioobserve.parsers;

/**
 * @author matwood
 * @since 12/16/11
 *        Interface that all Parse Strategies must implement.
 */
public interface ParserStrategy {
    /**
     * @param fileName {@link String} - Full path location of file to be parsed.
     */
    public void parse(String fileName);
}
