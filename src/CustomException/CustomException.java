package CustomException;

/**
 * 
 * 
 */
public class CustomException extends Exception {
	
	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message, null);
	}

	public CustomException(Throwable cause) {
		super("", cause);
	}
	
}
