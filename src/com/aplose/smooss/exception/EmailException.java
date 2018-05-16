package com.aplose.smooss.exception;


/**
 * This class is used to send a message in case of exception
 * @author Fomation
 *
 */
public class EmailException extends Exception{
	
	/**
	 * @param message
	 * @return message
	 */
	public EmailException(String message) {
		super(message);
	} 
}
