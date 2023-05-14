package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.HomePage;
import com.page.Indexpage;
import com.page.LoginPage;
import com.utils.ReadConfig;

import io.qameta.allure.Description;

public class HomePageTest extends BaseClass {
	ReadConfig read=new ReadConfig();
	public String username=read.getApplicationUsername();
	public String pass=read.getApplicationpassword();
	Indexpage in;
	LoginPage loginpage;
	HomePage home;
	
	@Test(groups="Smoke")
	@Description("Homepage orderlist visible or not validation")
	public void orderDetailsvalidation() {
		
		getUrl1("http://automationpractice.pl/index.php");
		in=new Indexpage(driver);
		loginpage=in.clickIn();
		home=loginpage.loginstore(username, pass);
		boolean orderlistdisplay=home.orderlistValidation();
		Assert.assertTrue(orderlistdisplay);
		
		                                                                                                                                         
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

}



