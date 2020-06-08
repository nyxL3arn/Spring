package com.luv2code.springdemo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component

public class BadFortuneService implements FortuneService {
	
	private String fileName= "/home/nyx/eclipse-workspace/spring-demo-annotations/src/badFortunes";
	private String destructionMessage= "/home/nyx/eclipse-workspace/spring-demo-annotations/src/destroy.txt";
	
	private List <String> badStuff;
	
	//create a random number
	private Random badRandom = new Random();
		
	//create File object
	File badFile =new File(fileName);
	
	
	//create constructor

	public BadFortuneService() {
		System.out.println(">> BadFortuneService: inside default constructor");
	}
		
//	System.out.println("The options for bad fortune are: " + badFile);
	
	@PostConstruct
	private void loadtheBadLuckFiles() {
		
		System.out.println(">> BadFortuneService inside method loadTheBadLuckFiles");
		
	//initialize ArrayList
	badStuff= new ArrayList<String>();
	
	//read badFortunes from file
	try (BufferedReader br = new BufferedReader(new FileReader (badFile))){
		
		String tempLuck;
		
		while ((tempLuck= br.readLine()) !=null) {
			badStuff.add(tempLuck);
		}
		
	}catch (IOException e) {
		e.printStackTrace();
	}

	}
	
	

	@Override
	public String getFortune() {
				
		//read random bad luck from Array
		int index= badRandom.nextInt(badStuff.size());
		String badFortune = badStuff.get(index);
		
		return badFortune;
		
	}
	
	
	
		
	
	

}
