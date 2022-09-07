package Exceptions;

public class SystemUserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemUserException() {

		super("You reached hhe maximum discount percentage which is 25%");
	}

}
