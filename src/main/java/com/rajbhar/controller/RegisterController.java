package com.rajbhar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rajbhar.exceptionhandler.AgeNotValidException;
import com.rajbhar.model.User;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        User userForm = new User();    
        model.addAttribute("userForm", userForm); // the Category object is used as a template to generate the form
         
        List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.addAttribute("professionList", professionList);
         
        return "Registration";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("birth date: " + user.getBirthDate());
        System.out.println("profession: " + user.getProfession());
         
        return "RegistrationSuccess";
    }
    @RequestMapping(value="/{age}",method=RequestMethod.GET)
    public ModelAndView goForVoting(@PathVariable("age") int age) throws AgeNotValidException
    {
    	ModelAndView model=null;
    	if(age>=18)
    	{
    		System.out.println("Your are eligible for vote,Happy voting");
        	 model  = new ModelAndView("Votingsuccess");
        	String response= "You are eligible for voting,voting has done !!!!";
        	model.addObject("res", response);
    	}
    	else
    	{
    		throw new AgeNotValidException("Your age "+age+" is less than 18,so not eligible for vote");
    	}
    	return model;
    }
}
