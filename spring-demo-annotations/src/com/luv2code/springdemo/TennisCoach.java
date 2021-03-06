package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component //uses default bean id, Classname mit anfangsbuchstabe klein
//@Scope("prototype") default: singleton
public class TennisCoach implements Coach{
	
	/*@Autowired // example for field injection. */
	//@Qualifier("badFortuneService")
	//@Inject ist der java-standard für spring's @Autowire
	private FortuneService fortuneService;
		
	
	
	 //Spring will find a bean that implements FortuneService
	public TennisCoach(@Qualifier("badFortuneService")FortuneService theFortuneService) {
		
		fortuneService = theFortuneService;
	}
	
	
	
	//define a default constructor
	//public TennisCoach() {
	//	System.out.println(">>TennisCoach: inside default constructor");
		
	//}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">>TennisCoach: inside of MyStartupStaff()");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">>TennisCoach: inside of doMyCleanupStuff()");
	}
	
	
	//define a setter method: setter injection with Autowired
	/*@Autowired //brauche ich, weil fortuneService injected werden muss
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach: inside setFortuneService() method");
		fortuneService = theFortuneService;*/
	//}
	
	
	/*@Autowired //egal welche Methode
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach: inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
				return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


	@Override
	public String contact() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
