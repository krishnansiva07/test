package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumAbstractMethodImplementation;

public class AddToCartPageObjects extends SeleniumAbstractMethodImplementation{

	public AddToCartPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickAddToCart() {
		WebElement element = getElementUsingXpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
		click(element);
	}

}
