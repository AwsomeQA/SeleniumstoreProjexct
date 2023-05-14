package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.actiondriver.ActionClass;
import com.base.BaseClass;
import com.page.AddToCartPage;
import com.page.AddressPage;
import com.page.Indexpage;
import com.page.LoginPage;
import com.page.OrderConfirmationPage;
import com.page.OrderPage;
import com.page.OrderSummPage;
import com.page.PaymentPage;
import com.page.SearchPage;
import com.page.ShippingPage;
import com.utils.Log;
import com.utils.ReadConfig;

public class EndToEndTest extends BaseClass{
	ReadConfig read=new ReadConfig();
	public String username=read.getApplicationUsername();
	public String pass=read.getApplicationpassword();
	Indexpage ip;
	SearchPage sp;
	AddToCartPage addcart;
	OrderPage order;
	LoginPage login;
	AddressPage address;
	ShippingPage shipping;
	PaymentPage pay;
	OrderSummPage ordersum;
	OrderConfirmationPage orderconfirm;
	
	@Test(groups="Regression")
public void endToEndValidation() {
	ip=new Indexpage(driver);
	Log.startTestCase("endtoendTestCase");
	ActionClass.getUrl("http://automationpractice.pl/index.php");
	sp=ip.searchProduct("t-shirt");
	addcart=sp.clickImg();
	addcart.msgcheck();
	order=addcart.orderpagenavigation();
	login=order.navigateLogin();
	address=login.loginstore1(username, pass);
	shipping=address.forsigninperson();
	pay=shipping.navigateTopayment();
	ordersum=pay.clickonPaymentMethod();
	orderconfirm=ordersum.clickonordersum();
	String orderconfirmmsg=orderconfirm.clickonordersum();
	Assert.assertEquals(orderconfirmmsg,"Your order on My Store is complete.");
	Log.endTestCase("endtoendtestcase");
	}
	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}


}
