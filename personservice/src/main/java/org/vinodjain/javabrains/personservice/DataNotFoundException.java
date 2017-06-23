package org.vinodjain.javabrains.personservice;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527512149216716681L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
