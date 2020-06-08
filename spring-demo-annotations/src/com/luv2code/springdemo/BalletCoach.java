package com.luv2code.springdemo;

public class BalletCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BalletCoach(FortuneService theFortuneService) {
		fortuneService= theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Go round and round... and round";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	@Override
	public String contact() {
		// TODO Auto-generated method stub
		return null;
	}

}
