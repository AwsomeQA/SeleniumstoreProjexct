package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.AccountCreationPage;
import com.page.Indexpage;
import com.page.LoginPage;

import io.qameta.allure.Description;

public class AccountCreateTest extends BaseClass{
	Indexpage in;
	LoginPage loginpage;
	AccountCreationPage accpage;
	@Test(groups="Sanity")
	@Description("verify accountpage title")
	public void AccountPageValidation() {
		getUrl1("http://automationpractice.pl/index.php");
		in=new Indexpage(driver);
		loginpage=in.clickIn();
		accpage=loginpage.newCreateAcc(randomstring()+"@mail.com");
		Boolean titlevalidation=accpage.titleValidation();
		Assert.assertTrue(titlevalidation);
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}


}
