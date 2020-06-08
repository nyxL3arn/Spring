package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp2 {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
				
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		
		System.out.println(theCoach.getDailyFortune());
		
		//call our new swim coach methods .. has the props value injected
		System.out.println("email: "+ theCoach.getEmail());
		System.out.println("team: "+ theCoach.getTeam());
		
		
		//close the context
		context.close();

	}

}
