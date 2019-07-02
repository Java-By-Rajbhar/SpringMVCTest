package com.rajbhar.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExcetionHandler {
	
	   @ExceptionHandler(AgeNotValidException.class)
	    public ModelAndView handleCustomException(AgeNotValidException ex)
	    {
	    	System.out.println("from handling exception");
	    	ModelAndView model  = new ModelAndView("Error");
	    	model.addObject("excep", ex.getMessage());
	    	return model;
	    }

}
