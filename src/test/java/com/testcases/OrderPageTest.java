package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.actiondriver.ActionClass;
import com.base.BaseClass;
import com.page.AddToCartPage;
import com.page.Indexpage;
import com.page.OrderPage;
import com.page.SearchPage;

import io.qameta.allure.Description;

public class OrderPageTest extends BaseClass{
	Indexpage ip;
	SearchPage sp;
	AddToCartPage addcart;
	OrderPage order;
	
	@Test(groups="Regression")
	@Description("order page validation")
	public void orderPageValidation() {
		ip=new Indexpage(driver);
		ActionClass.getUrl("http://automationpractice.pl/index.php");
		sp=ip.searchProduct("t-shirt");
		addcart=sp.clickImg();
		addcart.msgcheck();
		order=addcart.orderpagenavigation();
		double unit_price=order.getUnitPrice();
		System.out.println("unitprice:"+unit_price);
		double total_price=order.getTotalPrice();
		System.out.println("totalprice:"+total_price);
		double ship_price=order.getShippingPrice();
		int qty_no=order.getQty();
		System.out.println("no of quantity: "+qty_no);
		double totalExpectedPrice=(unit_price*qty_no)+ship_price;
		System.out.println("no of totalexpectedprice: "+totalExpectedPrice);
		Assert.assertEquals(total_price,totalExpectedPrice );
	
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

}
