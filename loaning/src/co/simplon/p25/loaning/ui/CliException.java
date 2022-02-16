package co.simplon.p25.loaning.ui;

@SuppressWarnings("serial")
public final class CliException extends Exception{

	private String message;
	private Throwable cause;
	
	public CliException(String message) {
		this.message = message;
	}
	
	public CliException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}
	
	
	public String getMessage() {
		return message;
	}

	public Throwable getCause() {
		return cause;
	}
	
}
