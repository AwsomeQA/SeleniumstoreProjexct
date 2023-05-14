package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class OrderSummPage extends ActionClass {
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement processOrderbtn;
	
	
	
	public OrderSummPage() {
		PageFactory.initElements(driver,this);
	}
	
	public OrderConfirmationPage clickonordersum() {
		clickElement(processOrderbtn);
		return new OrderConfirmationPage();
	}

}
