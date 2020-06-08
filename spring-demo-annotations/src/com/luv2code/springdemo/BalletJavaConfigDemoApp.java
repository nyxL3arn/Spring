package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BalletJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
				
		//get the bean from spring container
		BalletCoach theCoach = context.getBean("balletCoach", BalletCoach.class);
		
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		
		System.out.println(theCoach.getDailyFortune());
		
			
		
		//close the context
		context.close();

	}

}
