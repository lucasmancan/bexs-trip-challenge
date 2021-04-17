package exceptions;

public class InvalidConfigurationException extends RuntimeException {
    public InvalidConfigurationException(String s) {
        super(s);
    }
}
