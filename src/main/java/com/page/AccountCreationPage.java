package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class AccountCreationPage extends ActionClass {
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement texttitle;
	
	@FindBy(id="id_gender1")
	WebElement radiobtn;
	
	@FindBy(id="customer_firstname")
	WebElement fname;
	@FindBy(id="customer_lastname")
	WebElement lname;
	
	@FindBy(id="customer_lastname")
	WebElement pass;
	
	@FindBy(id="days")
	WebElement sday;
	@FindBy(id="months")
	WebElement smnth;
	@FindBy(id="years")
	WebElement syear;
	
	@FindBy(id="submitAccount")
	WebElement btncreate;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver,this);
	}
	public boolean titleValidation() {
		return isDisplayed(texttitle);
	}
	public SearchPage accCreate(String Fname,String Lname,String Pass,String day,String month,String year) {
		clickElement(radiobtn);
		writeText(fname,Fname);
		writeText(lname,Lname);
		writeText(pass,Pass);
		selectElement(sday,day);
		selectElement(smnth,month);
		selectElement(syear,year);
		clickElement(btncreate);
		return new SearchPage();
	}


}
