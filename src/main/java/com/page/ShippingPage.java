package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class ShippingPage extends ActionClass{
	
	@FindBy(id="cgv")
	WebElement checkbx;
	
	@FindBy(name="processCarrier")
	WebElement prbtnclick;
	
	public ShippingPage() {
		PageFactory.initElements(driver,this);
	}
	public PaymentPage navigateTopayment() {
		clickElement(checkbx);
		clickElement(prbtnclick);
		return new PaymentPage();
		
	}

}
