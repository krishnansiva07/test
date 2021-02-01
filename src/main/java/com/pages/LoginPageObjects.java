package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumAbstractMethodImplementation;

import io.qameta.allure.Step;

public class LoginPageObjects extends SeleniumAbstractMethodImplementation{

//Page Objects
@FindBy(css= "input#user-name")
private WebElement inputUserName;

@FindBy(css = "input#password")
private WebElement inputPass;

@FindBy(css="input#login-button")
private WebElement btnSubmit;


public LoginPageObjects(WebDriver driver) {
	PageFactory.initElements(driver, this);
	super.setDriver(driver);
}

@Step("This step for getting user name and password from test script to perform login")
public void performLogin(String userName, String password) {
	setText(inputUserName, userName);
	setText(inputPass, password);
	click(btnSubmit);
}

public void performLoginMultipleUser(String userName, String password) {
	setText(inputUserName, userName);
	setText(inputPass, password);
	click(btnSubmit);
}


}
