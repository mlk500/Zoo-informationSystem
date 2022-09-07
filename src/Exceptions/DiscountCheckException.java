package Exceptions;

public class DiscountCheckException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DiscountCheckException() {

		super("You reached the maximum discount percentage which is 25%");
	}
}
