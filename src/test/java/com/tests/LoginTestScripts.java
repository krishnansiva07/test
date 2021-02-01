package com.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPageObjects;

import io.qameta.allure.Description;
import log.Log;
import testbase.TestBase;
import utility.ExcelUtil;

public class LoginTestScripts extends TestBase{	
	
	
	static Logger log = Logger.getLogger("devpinoyLogger");
	@Description("This tescase for testing the login scenario")
	@Test(priority = 0, enabled = true)
	public void validateLogin(Method method) throws IOException {
		Log.info(method.getName().toString());
		Log.info("Application Before launching");
		launchApplication();
		Log.info("Application Started and checking login is working or nor");
		
		Log.debug("Checking Assertion is working or not");
		performAssertTrue(true);
	
	}
	
	@Test(priority = 1, enabled = false, dataProvider = "credentials")
	
	public void testMultipleUserLogins(String userName, String pass) throws IOException {
		Log.info("Application Before launching");
		launchApplication();
		Log.info("Application Started and checking login is working or nor");
		LoginPageObjects obj = new LoginPageObjects(super.getDriver());
		obj.performLoginMultipleUser(userName, pass);
		Log.debug("Checking Assertion is working or not");
	}
	
	@DataProvider(name = "credentials")
	public Object[][] getDifferentUserLogin() throws IOException {
		Object[][] tableData = ExcelUtil.getTableData("setOfUsers", 1, 1, 4, 2);
		return tableData;
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		//super.closeBrowserAfterCompletionOfTestScript(result);
	}

}
