package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseClass;

import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;

public class AllureListner implements ITestListener{
	
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
		
	}
	
	

	@Attachment
	public byte[] saveFalureScreenshot(WebDriver driver) {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment
	public static String saveTextLog(String message) {
	    return message;
	}


	

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am on start method "+getTestMethodName(iTestResult)+"start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am on Sucess method "+getTestMethodName(iTestResult)+"success");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am on testfaliure method "+getTestMethodName(iTestResult)+"failed");
		Object testClass=iTestResult.getInstance();
		WebDriver driver=BaseClass.getDriver();
		if(driver instanceof WebDriver) {
			System.out.println("screenshot capture for testcases "+getTestMethodName(iTestResult));
			saveFalureScreenshot(driver);
		}
		saveTextLog(getTestMethodName(iTestResult)+"failed screenshot failed");
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("I am on start method "+iTestContext.getName());
		iTestContext.setAttribute("WebDriver",BaseClass.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am on start method "+iTestContext.getName());
	}

}
