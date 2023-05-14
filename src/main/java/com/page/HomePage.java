/**
 * 
 */
package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

/**
 *
 *
 */
public class HomePage extends ActionClass {
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement clickorderlist;
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean orderlistValidation() {
		return isDisplayed(clickorderlist);
	}
	public String getCureentUrlcheck() {
		String homeurl=getCurrentUrls();
		return homeurl;
	}

}
