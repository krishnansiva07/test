package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumAbstractMethodImplementation implements SeleniumAbstractMethod{
	
	
	//Step 1
	protected WebDriver driver = null;
	//Step 2
	public WebDriver getDriver() {
		return driver;
	}
	//Step3
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public Actions getActionsInstance() {
		return new Actions(getDriver());
	}
	
	public void click(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}

	public void maximizeBrowser() {
		// TODO Auto-generated method stub
		getDriver().manage().window().maximize();
	}

	public void openUrl(String url) {
		// TODO Auto-generated method stub
		getDriver().get(url);
	}
	
	public void setText(WebElement element, String text) {
		// TODO Auto-generated method stub
		element.sendKeys(text);
	}	
	
	public int getAllElementsBasedOnWebElement(String xpath) {
		// TODO Auto-generated method stub		
		List<WebElement> allElement = getDriver().findElements(By.xpath(xpath));
		return allElement.size();
	}
	
	//Close Current tab or window
	public void closeBrowser() {
		// TODO Auto-generated method stub
		getDriver().close();
	}
	
	//Close All windows
	public void closeAllWindows() {
		// TODO Auto-generated method stub
		getDriver().quit();
	}
	
	//This method returns title Of the Page
	public String returnTitle() {
		// TODO Auto-generated method stub
		return getDriver().getTitle();
	}
	
	//This method returns CurrentUrl
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return getDriver().getCurrentUrl();
	}
	
	public WebElement getElementUsingXpath(String xpath) {
		// TODO Auto-generated method stub
		return getDriver().findElement(By.xpath(xpath));
	}
	
	@Override
	public void selectUsingValue(String value, String xpath) {
		// TODO Auto-generated method stub
		Select sel = new Select(getDriver().findElement(By.xpath(xpath)));
		sel.selectByValue(value);		
	}
	
	@Override
	public void performMouseHoverUsingElement(WebElement element) {
		// TODO Auto-generated method stub
		
		getActionsInstance().moveToElement(element).build().perform();
	}
	
	@Override
	public void perforMouseHoverUsingXpath(String xpath) {
		// TODO Auto-generated method stub
		getActionsInstance().moveToElement(getElementUsingXpath(xpath)).build().perform();
	}
	
	@Override
	public void performImplicitWait() {
		// TODO Auto-generated method stub
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Override
	public void waitForTheElementToBeClickable(WebElement element, int durationInSec) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(getDriver(), durationInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@Override
	public void waitForTheElementToBeClickable(String xpath, int durationInSec) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(getDriver(), durationInSec);
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(xpath))));
	}
	
}
