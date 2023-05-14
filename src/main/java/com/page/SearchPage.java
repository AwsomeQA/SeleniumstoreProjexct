package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class SearchPage extends ActionClass {
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement clickimg;
	public SearchPage() {
		PageFactory.initElements(driver,this);
	}
	public boolean isproductAvailable() {
		return isDisplayed(clickimg);
	}
	public AddToCartPage clickImg() {
		clickElement(clickimg);
		return new AddToCartPage();
	}

}
