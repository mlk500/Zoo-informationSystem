package Exceptions;

public class DuplicatedValues extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicatedValues() {
		super("Duplicated values are not allowed, a visitor and an employee cannot be the same person");
	}
	

}
