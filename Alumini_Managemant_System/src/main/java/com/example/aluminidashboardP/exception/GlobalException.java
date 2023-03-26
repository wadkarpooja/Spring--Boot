package com.example.aluminidashboardP.exception;

//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalException {
//@ExceptionHandler(MethodArgumentNotValidException.class)
//public ResponseEntity<Map<String,List<String>>> handleValidationErrors(Method)
//}

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(getAllErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleNotFoundErrors(UserNotFoundException ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());

		return new ResponseEntity<>(getAllErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Map<String, List<String>>> handleGeneralErrors(Exception ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());

		return new ResponseEntity<>(getAllErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	Map<String, List<String>> getAllErrorsMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

}
