package Exceptions;

public class MaximumCapcityException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MaximumCapcityException() {
		super("The section has reached to less than 50% of its capacity, you can't move to another section");
		
	}

}
