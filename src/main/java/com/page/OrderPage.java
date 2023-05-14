package com.page;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class OrderPage extends ActionClass{
	
	@FindBy(xpath="//td[@class='cart_unit']//ul//li[@class='price']")
	WebElement unitpricee;
	
	@FindBy(id="total_price")
	WebElement totalpricee;
	

	@FindBy(xpath="//td[@class='cart_quantity text-center']/input[1]")
	WebElement qty;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement procedcheckbtn;
	
	@FindBy(xpath="//tr[@class='cart_total_delivery']//td[@id='total_shipping']")
	WebElement shippingpricee;
	public OrderPage() {
		PageFactory.initElements(driver,this);
	}
	public double getUnitPrice() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String unitprice=readText(unitpricee);
		String unit= unitprice.replaceAll("[^a-zA-Z0-9]","");
		
		double finalunitprice=Double.parseDouble(unit);
	
		return finalunitprice/100;
		
		
		
	}
	public double getTotalPrice() {
		//double finaltotalprice=0;
		String totalprice=readText(totalpricee);
		String tot= totalprice.replaceAll("[^a-zA-Z0-9]","");
		
		double finaltotalprice=Double.parseDouble(tot);
		//System.out.println("final price:"+finaltotalprice/100);
		return finaltotalprice/100;
		}
		
		
	
	public double getShippingPrice() {
		String shippingprice=readText(shippingpricee);
		String shipping= shippingprice.replaceAll("[^a-zA-Z0-9]","");
		
			double finalshippingprice=Double.parseDouble(shipping);
			return finalshippingprice/100;
		}
		
		
	
	public int getQty() {
		String s=qty.getAttribute("value");
		
		try {
		return Integer.parseInt(s);
		}
		
		catch (NumberFormatException e) {
           // System.out.println("NumberFormatException is handled");
            return 0;
        }
		
		
		
	}
	
	
	
	
	public LoginPage navigateLogin() {
		clickElement(procedcheckbtn);
		return new LoginPage(driver);
	}

}
