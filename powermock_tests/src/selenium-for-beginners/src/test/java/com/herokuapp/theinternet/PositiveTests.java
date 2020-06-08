package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	
	
	@Test
	public void loginTest() {
		
		System.out.println("Starting loginTest");
				
		//setting driver executable
				
		System.setProperty("webdriver.chrome.driver", "/home/nyx/eclipse-workspace/powermock_tests/src/selenium-for-beginners/src/main/resources/chromedriver");
				                  //drivername                 //path to driver
		
		
		//initiating chrome driver
		
		WebDriver driver = new ChromeDriver();  //neues Driver-Objekt erzeugen
		//maximize browser window
				driver.manage().window().maximize();
		
				
		//open test page
		
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);  //zweite Möglichkeit (tut genau dasselbe): driver.navigate().to(url)
		System.out.println("The page is opened.");
		
			
		//enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith"); //sendKeys ist eine selenium-methode, 
		           //die mir bei der texteingabe hilft
		
		//enter passwrd 
		WebElement passwrd = driver.findElement(By.name("password"));
		passwrd.sendKeys("SuperSecretPassword!");
		
		//click login button
		WebElement logInButton = driver.findElement(By.tagName("button break"));
		logInButton.click();
		
		//verifications: 
		//	-new url
		String expectedURL= "http://the-internet.herokuapp.com/secure";
		// für die "actual URL benutzen wir den Webdriver, sie zu identifizieren:
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL,"Actual page url is not the same as expected");
		
		//-logout button visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Logout-button is not visible!");
		
		//-successful login message
		WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
		String expectedMessage="You logged into a secure area!";
		String actualMessage= successMessage.getText();
		
		//mit AssertEquals wird der Test fehlschlagen, weil es AUCH SUBSTRINGS berücksichtigt und da ist was komisches hinten dran
		//Assert.assertEquals(actualMessage, expectedMessage,"Actual message is not the same as expected");
		
		//deshalb mit AssertTrue:
		
		Assert.assertTrue(actualMessage.contains(expectedMessage),"actual message doesn't contain expected message");
		
		//close browser
		driver.quit();
		
	
	}

}
