package com.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeClass;

import com.utils.Log;
import com.utils.ReadConfig;

public class BaseClass {
	ReadConfig rd= new ReadConfig();
	public String url=rd.getApplicationUrl();
	
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver> ();
	//public static Logger logger;
	public static ChromeOptions option;
	@BeforeClass(groups={"Smoke","Sanity","Regression"})
	public WebDriver setup() {
		DOMConfigurator.configure("log4j.xml");
		 Log.info("This is setup method");
		//logger = Logger.getLogger("--selenium project start---");
		
		option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Log.info("browser started");
		driver=new ChromeDriver(option);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	
		}
	/**@AfterMethod
	public void tearDown() {
		driver.close();
	}**/
	public static synchronized WebDriver getDriver() {
		return driver;
		
	}
	public String randomstring()
	{
		String randomalpha=RandomStringUtils.randomAlphabetic(8);
		return randomalpha;
	}
	
	public static void getUrl1(String url) {
		driver.get(url);
	}


}
