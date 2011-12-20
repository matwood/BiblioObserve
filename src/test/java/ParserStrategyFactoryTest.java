import biblioobserve.parsers.*;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

/**
 * @author matwood
 * @since 12/16/11
 */
public class ParserStrategyFactoryTest {
    public ParserStrategyFactoryTest() {
        BasicConfigurator.configure();
        ParserStrategyConfigCollection.INSTANCE.configure();
    }

    @Test
    public void testGetParser() throws Exception {
        ParserStrategy p = ParserStrategyFactory.getParser("XML");
        assert (p instanceof ParserStrategyXML);

        p = ParserStrategyFactory.getParser("JSON");
        assert (p instanceof ParserStrategyJSON);

        p = ParserStrategyFactory.getParser("CSV");
        assert (p instanceof ParserStrategyCSV);
    }

    @Test(expected = ParserStrategyNotFoundException.class)
    public void testParserNotFoundException() throws Exception {
        ParserStrategy p = ParserStrategyFactory.getParser("JUNK");
    }
}
