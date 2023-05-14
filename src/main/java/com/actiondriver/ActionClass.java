package com.actiondriver;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class ActionClass extends BaseClass{
	public ActionClass(){
		
	}
	public static void scrollBy() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	public static void clickElement(WebElement ele) {
		ele.click();
	}
	public static void clickBy(By elementlocation) {
		driver.findElement(elementlocation).click();
	}
	public static void writeText(WebElement ele,String text)
	{
		ele.clear();
		ele.sendKeys(text);
	}
	public static void writeTextlocation(By elelocation,String text)
	{
		driver.findElement(elelocation).clear();
		driver.findElement(elelocation).sendKeys(text);
	}
	public static void selectElement(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	public static String readText(WebElement ele) {
		return ele.getText();
	}
	
	public static void mouseHover(WebElement ele) {
		new Actions(driver).moveToElement(ele).build().perform();
	}
	public static void waitForExplicitwait(WebElement element) {
		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForExplicitwaitlo(By elementlocation) {
		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementlocation));
	}
	public static boolean displayed(By elelocation) {
		 boolean flag =false;
		 WebElement ele=driver.findElement(elelocation);
		 if(ele.isDisplayed()) {
			 return flag=true;
		 }
		 else 
		 {
		return flag;
		 }

	}
	
	public static boolean isDisplayed(WebElement ele) {
		 boolean flag =false;
		 
		 if(ele.isDisplayed()) {
			 return flag=true;
		 }
		 else 
		 {
		return flag;
		 }

	}
	public static void getUrl(String url) {
		driver.get(url);
	}
	public void waitForUrl(String url) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.urlContains(url));
	}
	public static String getCurrentUrls() {
		return driver.getCurrentUrl();
	}
	

}
