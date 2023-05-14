package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.actiondriver.ActionClass;
import com.base.BaseClass;

public class LoginPage extends ActionClass{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	By username=By.id("email");
	By password=By.id("passwd");	
	By login=By.id("SubmitLogin");
	By emailnewAcc=By.id("email_create");
	By accclick=By.xpath("//button[@id='SubmitCreate']");
	
	public void inputUser(String email) {
		writeTextlocation(username,email);
	}
	public void inputPass(String pass) {
		writeTextlocation(password,pass);
	}
	public void clickButton() {
		clickBy(login);
	}
	
	public void AccCreate(String newemail) {
		writeTextlocation(emailnewAcc,newemail);
	}
	
	public void newAcclogin() {
		clickBy(accclick);
	}
	
	

	public HomePage loginstore(String email,String password) {
	
		//getUrl("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
		inputUser(email);
		inputPass(password);
		clickButton();
		return new HomePage();
	}
	
	public AddressPage loginstore1(String email,String password) {
		
		
		inputUser(email);
		inputPass(password);
		clickButton();
		return new AddressPage();
	}
	public AccountCreationPage newCreateAcc(String newemail) {
		getUrl("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
		AccCreate(newemail);
		newAcclogin();
		return new AccountCreationPage() ;
	}

	

}
