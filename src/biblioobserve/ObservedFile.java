package biblioobserve;

/**
 * @author matwood
 * @since 12/15/11
 *
 * Wrapper class around the information needed to process a file.  This class
 * provides the data connection between the observed and the observers.
 *
 */
public class ObservedFile {
    private String name;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
