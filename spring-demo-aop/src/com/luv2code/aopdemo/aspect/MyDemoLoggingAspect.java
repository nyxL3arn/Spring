package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	
	//let's start with an @Before advice
	/*@Before("execution(public void addAccount())") //das ist ein match für ALLE addAccount() Methoden in ALLEN Klassen
	public void beforeAddAccountAdvice() { 
		
		System.out.println("\n====>>> Executing @Before advice on method()");
	}*/
	
	//calling the pointCutExpression for a specific class
	/*@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
public void beforeAddAccountAdvice() { 
		
		System.out.println("\n====>>> Executing @Before advice on AccountDAO.addAccount-method()");
	}*/
	
	//using wildcards
	/*@Before("execution(* add*())")
	public void beforeAddAccountAdvice() { 
			
			System.out.println("\n====>>> Executing @Before advice on any add...-method() with any return-type");
		}*/
	
	@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	public void beforeAddAccountAdvice() { 
		
		System.out.println("\n====>>> Executing @Before advice on any add...-method() with the specific Account param");
	}
	
	
}
