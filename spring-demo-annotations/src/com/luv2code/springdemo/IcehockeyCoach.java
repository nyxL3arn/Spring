package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IcehockeyCoach implements Coach {
	
	@Value("${email}") 
	private String email;

	@Value("${team}")
	private String team;
	
	@Override
	public String getDailyWorkout() {
	
		return "Faster, faster, hit it!!!";
	}
	
	public String contact() {
		return "Talk to the coach of team "+team+ " via Email: "+email;
	}

	@Override
	public String getDailyFortune() {
		return "Better go home and chill out";
	}

	

}
