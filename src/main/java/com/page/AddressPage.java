package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class AddressPage extends ActionClass{
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="address1")
	WebElement addresstx;
	
	@FindBy(id="city")
	WebElement citytx;
	
	@FindBy(id="id_state")
	WebElement statedrp;
	
	@FindBy(id="postcode")
	WebElement ziptx;
	
	@FindBy(id="id_country")
	WebElement countrydrp;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement headingaddress;
	
	@FindBy(id="submitAddress")
	WebElement savebtn;
	
	@FindBy(name="processAddress")
	WebElement processbtn;
	
	public AddressPage() {
		PageFactory.initElements(driver,this);
	}
	
	public ShippingPage fromFillUp(String fname,String lname,String address,String city,String state,String zip,String country,String mobilePh,String addresstitle) {
		writeText(firstname,fname);
		writeText(lastname,lname);
		writeText(lastname,lname);
		writeText(addresstx,address);
		writeText(citytx,city);
		selectElement(statedrp,state);
		writeText(ziptx,zip);
		selectElement(countrydrp,country);
		writeText(mobile,mobilePh);
		writeText(headingaddress,addresstitle);
		clickElement(savebtn);
		waitForExplicitwait(processbtn);
		clickElement(processbtn);
		return new ShippingPage();
	}
	public  ShippingPage forsigninperson() {
		clickElement(processbtn);
		return new ShippingPage();
	}

}
