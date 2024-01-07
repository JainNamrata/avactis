package com.avactis;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FrameAssignment {
	WebDriverWait wait;
	WebDriver driver;
	@Test
	public void handleFrames() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Frames")));
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("Nested Frames")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement leftMsg = driver.findElement(By.xpath("//body"));
		assertEquals(leftMsg.getText(),"LEFT", "Message validation fail");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame-middle");
		WebElement middleMsg = driver.findElement(By.tagName("div"));
		assertEquals(middleMsg.getText(),"MIDDLE", "Message validation fail");
		
		driver.switchTo().parentFrame();
		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightFrame);
		//driver.switchTo().frame("");
		WebElement rightMsg = driver.findElement(By.tagName("body"));
		assertEquals(rightMsg.getText(),"RIGHT", "Message validation fail");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement bottomMsg = driver.findElement(By.tagName("body"));
		assertEquals(bottomMsg.getText(),"BOTTOM", "Message validation fail");
		driver.close();
	}

}

//
//goto http://the-internet.herokuapp.com/frames and select the frames link and navigate between frames
//	   Navigate in nested frames. 
//	   Also navigate to iFrame link and type "This is a frame assignment" inside the WYSIWYG