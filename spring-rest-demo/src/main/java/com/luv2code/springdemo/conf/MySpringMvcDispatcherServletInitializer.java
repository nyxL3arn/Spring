package com.luv2code.springdemo.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //we don't need it here, so leave it as is
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { DemoAppConfig.class };
		
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/" };  //mapping it to the root path
		
	}

}
