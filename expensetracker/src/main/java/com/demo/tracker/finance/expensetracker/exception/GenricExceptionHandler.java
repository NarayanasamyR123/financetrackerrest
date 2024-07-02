package com.demo.tracker.finance.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenricExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExpenseErrorResponse> updateExceptionHandler(ExpenseNotFoundException ex) {
		ExpenseErrorResponse e = new ExpenseErrorResponse();
		e.setMessage(ex.getMessage());
		e.setStatus(HttpStatus.NOT_FOUND.value());
		e.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExpenseErrorResponse>(e, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ExpenseErrorResponse> genericExceptionHandler(Exception e) {
		ExpenseErrorResponse response = new ExpenseErrorResponse();

		response.setMessage(e.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ExpenseErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
