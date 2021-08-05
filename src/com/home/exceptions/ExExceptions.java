package com.home.exceptions;

import java.io.File;
import java.io.IOException;

public class ExExceptions {
	
	public int getHallTicket(String hallTicket) throws HallTicketException {
		
		int results = 0;
		
		try {
			
			results = Integer.parseInt(hallTicket);
			
			
		} catch (RuntimeException e) {
			
			throw new HallTicketException("Hall Ticket number is wrong, Please check :: ", hallTicket);
			
		} finally {
			System.out.println("connection closing logic");
		}
		
		return results;
	
	}


	public static void main(String[] args) {
		
		System.out.println("Exception Handling");
		
		ExExceptions exExceptions = new ExExceptions();
		
		int examResults = 0;
		
		try {
			
			examResults = exExceptions.getHallTicket(args[0]);
			
		} catch (HallTicketException e) {
			
			e.printStackTrace();
			
		}		
		
		System.out.println("Results :: " + examResults);
	}

}
