package com.jbk.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.qa.base.TestBase;

public class AddUserPageTest extends TestBase {
	@Test(priority=24)
	public void verifyUserlink() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a/span")).click();
		Thread.sleep(2000);
		String actResult =driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/h3")).getText();
		String expResult = "User List";
		logger = extend.createTest("verifyUserlink", "This test case validate to check user link form leftnavigation");
		Assert.assertEquals(actResult, expResult);	
	}	
	@Test(priority=25)
	public void verifyTitle() throws Exception{
		driver.findElement(By.xpath("//div[1]/a/button")).click();
		Thread.sleep(2000);
		String actResult =driver.findElement(By.xpath("//section[1]/h1")).getText();
		String expResult = "Add User";
		logger = extend.createTest("verifyTitle", "This test case validate to check title of user page");
		Assert.assertEquals(actResult, expResult);
		
	}
	@Test(priority=26)
	public void verifyAdduserBlankinfo() throws Exception{
		logger = extend.createTest("verifyAdduserBlankinfo", "This test case validate to check add user functionality with blnk info");
		Thread.sleep(2000);
		WebElement actUsername= driver.findElement(By.xpath("//*[@id='username']"));
		actUsername.sendKeys("");
	    String expResult = "abc";
	    Assert.assertNotEquals(actUsername, expResult);	
	    Thread.sleep(2000);
	    WebElement actMobile= driver.findElement(By.xpath("//*[@id='mobile']"));
	    actMobile.sendKeys("");
	    String expMobile = "abc";
	    Assert.assertNotEquals(actMobile, expMobile);	
	    Thread.sleep(2000);
	    WebElement actEmail= driver.findElement(By.xpath("//*[@id='email']"));
	    actEmail.sendKeys("");
	    String expEmail = "abc";
	    Assert.assertNotEquals(actEmail, expEmail);	
	    Thread.sleep(2000);
	    WebElement actCourse= driver.findElement(By.xpath("//*[@id='course']"));
	    actCourse.sendKeys("");
		String expCourse = "abc";
		Assert.assertNotEquals(actEmail, expCourse);
	}

	}
