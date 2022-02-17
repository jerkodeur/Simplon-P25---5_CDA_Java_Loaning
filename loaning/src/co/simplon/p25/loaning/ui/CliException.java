package co.simplon.p25.loaning.ui;

import java.io.Serializable;

/**
 * An exception to be thrown when a CLI general error occurs.
 */
public final class CliException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new CliException with given message.
     *
     * @param message - a detail message
     */
    public CliException(String message) {
	super(message);
    }

    /**
     * Creates a new CliException with given message and cause.
     *
     * @param message - a detail message
     * @param cause   - the cause
     */
    public CliException(String message, Throwable cause) {
	super(message, cause);
    }

}
