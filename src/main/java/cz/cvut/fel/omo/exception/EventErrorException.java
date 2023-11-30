package cz.cvut.fel.omo.exception;

/**
 * Exception that is thrown when there is a problem with creation of an object
 */
public class EventErrorException extends RuntimeException {

    /**
     * Constructor for CreationException
     *
     * @param message message of the exception
     */
    public EventErrorException(String message) {
        super(message);
    }
}
