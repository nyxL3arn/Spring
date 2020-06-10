package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
			private void forDaoPackage() {}
	
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {	}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut combining pointcut expression: include package ... exclude getter/setter
	@Pointcut ("forDaopackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterNoSetter() {}
	
	
	 @Before("forDaoPackageNoGetterNoSetter()") 
	
	public void beforeAddAccount() {
		
		System.out.println("\n====>>> Executing @Before adding an account: No getters and setters");
	} 
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Performing API analytics");
	}
	
	
}