package testbase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.pages.LoginPageObjects;
import com.selenium.SeleniumAbstractMethodImplementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtil;
import utility.TestUtil;

public class TestBase extends SeleniumAbstractMethodImplementation{	
	public void launchApplication() throws IOException {
		
		Properties prop = TestUtil.loadPropertyFile();		
		String url = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		openBrowser(browserName);
		maximizeBrowser();
		openUrl(url);
	}
	
	//Open browser and Initialice webdriver instance
	public void openBrowser(String browserName) throws MalformedURLException {
		if(browserName.equalsIgnoreCase("chrome")) {
			
			DesiredCapabilities dcap= DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			URL url = new URL("http://localhost:55001/wd/hub");
			if(driver == null) {
				driver = new RemoteWebDriver(url,dcap);
				super.setDriver(driver);
				performImplicitWait();
			}			
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(driver==null) {
				FirefoxOptions option = setFirefoxOptionsForFirefox();
				driver = new FirefoxDriver();
				super.setDriver(driver);
				performImplicitWait();
			}
		}
	}
	
	//Setup chrome options
	public ChromeOptions setChromeBrowserForChrome() {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.acceptInsecureCerts();		
		ChromeOptions option = new ChromeOptions();		
		cap.setCapability("requireWindowFocus", true);
	    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.addArguments("--disable-notifications");
	    option.merge(cap);	    
		return option;		
	}
	
	//Setup chrome options
	public FirefoxOptions setFirefoxOptionsForFirefox() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", false);		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		options.setAcceptInsecureCerts(true);
		return options;
	}
	
	public void performLoginToTheApplication() throws IOException {
		LoginPageObjects obj = new LoginPageObjects(super.getDriver());
		Properties prop = TestUtil.loadPropertyFile();
		
		ExcelUtil.setExcel("credential");		
		String userName = ExcelUtil.getDataFromExcel(0, 1);
		String password = ExcelUtil.getDataFromExcel(1, 1);
		obj.performLogin(userName, password);
	}
	
	public void closeBrowserAfterCompletionOfTestScript(ITestResult result) {	
		try{
			if(result.getStatus()== ITestResult.SUCCESS) {
				System.out.println("TestCase Passed");
				super.closeBrowser();
			}else if(result.getStatus()== ITestResult.FAILURE) {
				System.out.println("TestCase Failed");
				
				System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
				System.out.println(result.getMethod().getMethodName() + " failed!");
				
				ITestContext context = result.getTestContext();
				super.closeBrowser();
			}else if(result.getStatus()== ITestResult.SKIP) {
				System.out.println("TestCase Skipped");
				super.closeBrowser();
			}else {
				super.closeAllWindows();
			}
		}catch(Exception e) {
			super.closeAllWindows();
		}
	
	}
	
	public void performAssertTrue(boolean res) {
		Assert.assertTrue(res);
	}
	
	public void performAssertEquals(String expectedString, String actualString) {
		Assert.assertEquals(actualString, expectedString);
	}
	
	public void validateTitleOfThePage(String expectedTitle) {
		performAssertEquals(expectedTitle, super.returnTitle());
	}
	
	public void validateUrl(String expectedUrl) {
		performAssertEquals(expectedUrl, super.getCurrentUrl());
	}
	
}
