package co.simplon.p25.loaning.ui;

import java.io.Serializable;

public final class CliException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public CliException(String message) {
	super(message);
    }

    public CliException(String message, Throwable cause) {
	super(message, cause);
    }

}
