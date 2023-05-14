package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.actiondriver.ActionClass;
import com.base.BaseClass;
import com.page.AddToCartPage;
import com.page.Indexpage;
import com.page.SearchPage;

import io.qameta.allure.Description;

public class AddCartTest extends BaseClass {
	Indexpage ip;
	SearchPage sp;
	AddToCartPage addcart;
	
	
	@Test(groups={"Sanity","Regression"})
	@Description("addcart page validation")
	public void addToCartValidation() {
		ip=new Indexpage(driver);
		ActionClass.getUrl("http://automationpractice.pl/index.php");
		sp=ip.searchProduct("t-shirt");
		addcart=sp.clickImg();
		boolean msgcheckboxpresent=addcart.msgcheck();
		Assert.assertTrue(msgcheckboxpresent);
		addcart.orderpagenavigation();
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}


}
