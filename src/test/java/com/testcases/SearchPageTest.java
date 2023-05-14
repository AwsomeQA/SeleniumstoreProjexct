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
public class SearchPageTest extends BaseClass{
	Indexpage ip;
	SearchPage sp;
	
	@Test(groups="Smoke")
	@Description("product should be displayed and navigate to addtocart page after img click and check addtocart page to order page navigation")
	public void SearchPagevalidation() {
		ip=new Indexpage(driver);
		ActionClass.getUrl("http://automationpractice.pl/index.php");
		sp=ip.searchProduct("t-shirt");
		boolean productavailability=sp.isproductAvailable();
		Assert.assertTrue(productavailability);
		AddToCartPage addcart=sp.clickImg();
		//String msgtitle=addcart.msgcheck();
		//System.out.println(msgtitle);
		//Assert.assertEquals(msgtitle,"Product successfully added to your shopping cart");
		//addcart.orderpagenavigation();**/
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

}
