package com.avactis;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookVerify {
	
	@Test
	public void verifyTitlet() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("My page title is --> "+title);
		driver.close();
	}
	
	@Test
	public void verifylogin() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("namrata.jain@gmal.com");				
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("1234");
		WebElement btnlogin = driver.findElement(By.xpath("//button[@name='login']"));
		btnlogin.click();
		System.out.println("Login failed");
		driver.close();
		
	}
	
}
