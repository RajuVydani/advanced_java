package com.home.exceptions;

public class HallTicketException extends Exception {
	
	private String htNo;
	
	public HallTicketException(String message, String htNo) {
		super(message + htNo);
		this.htNo = htNo;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	

}
