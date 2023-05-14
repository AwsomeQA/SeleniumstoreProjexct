package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class OrderConfirmationPage extends ActionClass{
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement ordercmpletemsg;
	
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String clickonordersum() {
		String ordermsg=readText(ordercmpletemsg);
		return ordermsg;
	}


}
