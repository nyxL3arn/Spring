package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//need a controller to read form data and
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName= theName.toUpperCase();
		
		//create the message
		String result = "Yo! "+ theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld"; //damit ist das jsp gemeint
}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName, Model model) {
		
		//read the request parameter from the HTML form
		//brauchen wir nicht mehr: das passiert mit @RequestParam
		
		//convert the data to all caps
		theName= theName.toUpperCase();
		
		//create the message
		String result = "Hey my friend "+ theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld"; //damit ist das jsp gemeint
}
}
