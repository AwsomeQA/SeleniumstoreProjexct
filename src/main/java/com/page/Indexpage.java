package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actiondriver.ActionClass;
import com.base.BaseClass;

public class Indexpage extends ActionClass{
	
	WebDriver driver;
	By signin=By.xpath("//a[contains(text(),'Sign in')]");
	By storelogo=By.xpath("//img[@class='logo img-responsive']");
	By searchproductbox=By.id("search_query_top");
	By searchbtn=By.xpath("//button[@name='submit_search']");
	
	public Indexpage(WebDriver driver) {
		this.driver=driver;
	}
	public LoginPage clickIn() {
		
		ActionClass.clickBy(signin);
		waitForExplicitwaitlo(signin);
		return new LoginPage(driver);
		
	}
	public String mystoretitle() {
		getUrl("http://automationpractice.pl/index.php");
	
		//waitForUrl("http://automationpractice.pl/index.php?controller=order");
		String storetitle1=driver.getTitle();
	
		return storetitle1;
	}
	public boolean logovalidation() {
		return displayed(storelogo);
	}
	public SearchPage searchProduct(String productname) {
		writeTextlocation(searchproductbox,productname);
		clickBy(searchbtn);
		return new SearchPage();
	}
	

}
