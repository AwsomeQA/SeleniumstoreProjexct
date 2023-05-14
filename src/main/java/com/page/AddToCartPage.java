package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class AddToCartPage extends ActionClass{
	
	@FindBy(id="group_1")
	WebElement selectsize;
	
	@FindBy(id="color_14")
	WebElement colourselect;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//i[@class='icon-check']")
	WebElement addcartmsgcheck;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']")
	WebElement quantity;
	
	//@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']")
	//WebElement qty;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver,this);
	}
	public boolean msgcheck() {
		selectElement(selectsize,"M");
		clickElement(colourselect);
		waitForExplicitwait(quantity);
		clickElement(quantity);
		clickElement(addtocartbtn);
		waitForExplicitwait(addcartmsgcheck);
		return isDisplayed(addcartmsgcheck);
	}
	
	
	public OrderPage orderpagenavigation() {
		clickElement(proceedtocheckout);
		return new OrderPage();
	}

}
