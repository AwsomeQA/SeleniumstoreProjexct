package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.actiondriver.ActionClass;
import com.base.BaseClass;
import com.page.Indexpage;
import com.page.LoginPage;
import com.utils.Log;

import io.qameta.allure.Description;

public class IndexTest extends BaseClass {
	@Test(groups="Smoke")
	@Description("validation with logo and title and check Intregation between Index and loginpage")
	public void indexValidation() {
		Log.startTestCase("IndexPageTest");
		Indexpage indexpage=new Indexpage(driver);
		String actualtitle=indexpage.mystoretitle();
		Assert.assertEquals(actualtitle,"My Store");
		boolean logo=indexpage.logovalidation();
		Assert.assertTrue(logo);
		indexpage.clickIn();
		Log.endTestCase("IndexPageTest");
		
		
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

}
