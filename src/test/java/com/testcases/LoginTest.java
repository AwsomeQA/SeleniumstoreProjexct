package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.HomePage;
import com.page.Indexpage;
import com.page.LoginPage;
import com.utils.ReadConfig;

import io.qameta.allure.Description;

public class LoginTest extends BaseClass{
	ReadConfig read=new ReadConfig();
	public String username=read.getApplicationUsername();
	public String pass=read.getApplicationpassword();
	Indexpage in;
	LoginPage loginpage;
	//@BeforeTest
	/*public void seturl() {
		getUrl1("http://automationpractice.pl/index.php");
	}*/
	@Test(groups= {"Sanity","Smoke"})
	@Description("validation indexpage to homapage navigation and homepage title and check able to login or not and navigate to hompage")
	public void loginValidation() {
		
		getUrl1("http://automationpractice.pl/index.php");
		in=new Indexpage(driver);
		loginpage=in.clickIn();
		//loginpage=new LoginPage(driver);
		loginpage.loginstore(username, pass);
		String actualurl=HomePage.getCurrentUrls();
		Assert.assertEquals(actualurl,"http://automationpractice.pl/index.php?controller=my-account");
		                                                                                                                                                                      
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

}
