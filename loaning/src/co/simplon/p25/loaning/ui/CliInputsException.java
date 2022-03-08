/**
 *
 */
package co.simplon.p25.loaning.ui;

import java.io.Serializable;

/**
 * An exception to be thrown when a conversion or validation error occurs.
 */
public final class CliInputsException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new CliInputsException.
     */
    public CliInputsException() {
	super();
    }

}
