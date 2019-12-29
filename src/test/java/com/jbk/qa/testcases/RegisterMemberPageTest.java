package com.jbk.qa.testcases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.qa.base.TestBase;
public class RegisterMemberPageTest extends TestBase {

	@Test(priority=1,groups="Regression")
	public void verifyRegisterMemberlink() throws Exception{
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		WebElement strText = driver.findElement(By.xpath("/html/body/div/div[1]/a/b"));
		String actText = strText.getText();
		String expText = "Java By Kiran";
		logger = extend.createTest("verifyRegisterMemberlink", "This test case validate to check Register a new Membership link");
		Assert.assertEquals(actText, expText);
		System.out.println("------------------------------");
	}
	@Test(priority=2,groups="Regression")
	public void verifyHeading(){
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Registration Page";
		logger = extend.createTest("verifyHeading", "This test case validate to check Heading of Register a new Membership link");
		Assert.assertEquals(actTitle, expTitle);
		System.out.println("****************************************************");	
	}
	@Test(priority=3)
	public void verifyPlaceholderName(){
		String atuName = driver.findElement(By.xpath("//*[@id='name']")).getAttribute("placeholder");
		String expName = "Name";
		logger = extend.createTest("verifyPlaceholderName", "This test case validate to check Placeholder of Name on registeration page");
		Assert.assertEquals(atuName, expName);
	}
	@Test(priority=4)
	public void verifyPlaceholderMobile(){
		String actMobileName = driver.findElement(By.xpath("//*[@id='mobile']")).getAttribute("placeholder");
		String expMobileName = "Mobile";
		logger = extend.createTest("verifyPlaceholderMobile", "This test case validate to check Placeholder of Mobile on registeration page");
		Assert.assertEquals(actMobileName, expMobileName);
		
	}
	@Test(priority=5)
	public void verifyPlaceholderEmail(){
		String actEmailName = driver.findElement(By.xpath("//*[@id='email']")).getAttribute("placeholder");
		String expEmailName = "Email";
		logger = extend.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");
		Assert.assertEquals(actEmailName, expEmailName);
	}
	@Test(priority=6)
	public void verifyPlaceholderPassword(){
		String actPwdName = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("placeholder");
		String expPwdName = "Password";
		logger = extend.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");
		Assert.assertEquals(actPwdName, expPwdName);	
	}
	@Test(priority=7)
	public void verifyRegistermemberBlankinfo(){
		WebElement setName = driver.findElement(By.xpath("//*[@id='name']"));
		setName.sendKeys("");
		String expName = "ab";
		Assert.assertNotEquals(setName, expName);
		WebElement actMoble = driver.findElement(By.xpath("//*[@id='mobile']"));
		actMoble.sendKeys("");
		String expMobile="87678888";
		Assert.assertNotEquals(actMoble, expMobile);
		WebElement actEmail = driver.findElement(By.xpath("//*[@id='email']"));
		actEmail.sendKeys("");
		String expEmail="singale@gmail.com";
		Assert.assertNotEquals(actEmail, expEmail);
		WebElement actPwd = driver.findElement(By.xpath("//*[@id='password']"));
		actMoble.sendKeys("");
		String expPwd="singale@gmail.com";
		logger = extend.createTest("verifyRegistermemberBlankinfo", "This test case validate to check Register a new membership with blnkinfo");
		Assert.assertNotEquals(actPwd, expPwd);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		String name = driver.findElement(By.xpath("//*[@id='name_error']")).getText();
		System.out.println(name);
		String mobile = driver.findElement(By.xpath("//*[@id='mobile_error']")).getText();
		System.out.println(mobile);
		String email = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		System.out.println(email);
		String password = driver.findElement(By.xpath("//*[@id='password_error']")).getText();
		System.out.println(password);	
		System.out.println("****************************************************");
	}
	
	@Test(priority=8,groups="Regrression")
	public void verifyErrorMessageRegistermember(){
		String actname = driver.findElement(By.xpath("//*[@id='name_error']")).getText();
		String ename = "Please enter Name.";
		Assert.assertEquals(actname, ename);
		String actmobile = driver.findElement(By.xpath("//*[@id='mobile_error']")).getText();
		String actename = "Please enter Mobile.";
		Assert.assertEquals(actmobile, actename);
		String actemail = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		String expEmal = "Please enter Email.";
		Assert.assertEquals(actemail, expEmal);
		String actpwd = driver.findElement(By.xpath("//*[@id='password_error']")).getText();
		String exppwd = "Please enter Password.";
		logger = extend.createTest("verifyErrorMessageRegistermember", "This test case validate to check Error Message of Registermember");
		Assert.assertEquals(actpwd, exppwd);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		System.out.println("****************************************************");
		
	}
	@Test(priority=9,groups="Regression")
	public void verifyRegisterMemberValidinfo() throws InterruptedException{
		WebElement setName = driver.findElement(By.xpath("//*[@id='name']"));
		setName.sendKeys("subhash");
		Thread.sleep(2000);
		WebElement actMoble = driver.findElement(By.xpath("//*[@id='mobile']"));
		actMoble.sendKeys("87678888");
		Thread.sleep(2000);
		WebElement actEmail = driver.findElement(By.xpath("//*[@id='email']"));
		actEmail.sendKeys("singale@gmail.com");
		Thread.sleep(2000);
		WebElement actPwd = driver.findElement(By.xpath("//*[@id='password']"));
		Thread.sleep(2000);
		actPwd.sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		String actResult  = alt.getText();
		String expResult  = "User registered successfully.";
		logger = extend.createTest("verifyRegisterMemberValidinfo", "This test case validate to check Register Member functionality with Validinfo");
		Assert.assertEquals(actResult, expResult);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@Test(priority=10,groups="Regression")
	public void verifyAlreadyMembershipLink() throws Exception{
		System.out.println("verifyAlreadyMembershipLink===>>out");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		Thread.sleep(1000);
	    String actText=	driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
	    String expText = "JAVA | SELENIUM | PYTHON";
	    logger = extend.createTest("verifyAlreadyMembershipLink", "This test case validate to check Already Membership Link");
	    Assert.assertEquals(actText, expText);
	    
	}
	
	
}
