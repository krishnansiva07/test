package com.selenium;

import org.openqa.selenium.WebElement;

public interface SeleniumAbstractMethod {
	
	public void click(WebElement element);
	public void setText(WebElement element, String text);
	public void maximizeBrowser();
	public void openUrl(String url);
	public int getAllElementsBasedOnWebElement(String xpath);
	public void closeBrowser();
	public void closeAllWindows();
	public String returnTitle();
	public String getCurrentUrl();
	public WebElement getElementUsingXpath(String xpath);//Add Others
	public void selectUsingValue(String value, String xpath);//Add Others
	public void performMouseHoverUsingElement(WebElement element);
	public void perforMouseHoverUsingXpath(String xpath);//contextlick, doubleclick, DragAndDrop
	public void performImplicitWait();
	
	public void waitForTheElementToBeClickable(WebElement element, int durationInSec);
	public void waitForTheElementToBeClickable(String xpath, int durationInSec);
}
