package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class PaymentPage extends ActionClass{
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement paybybank;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement paybycheck;
	
	public PaymentPage() {
		PageFactory.initElements(driver,this);
	}
	public OrderSummPage clickonPaymentMethod() {
		clickElement(paybybank);
		return new OrderSummPage();
	}

}
