package com.ibm.complaint.exception;

public class NoComplaintsFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoComplaintsFoundException(String message) {
        super(message);
    }
}
