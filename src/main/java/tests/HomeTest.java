package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import resources.Start;

public class HomeTest extends Start {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Start.class.getName());
	
	@BeforeTest
	public void inicialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is inicialized");
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LandingPage landing = new LandingPage(driver);
		LoginPage login = landing.getLogin();
		
		
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
	}
	
	@AfterTest
	public void quitBroswer() {
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[1][2]; 
		data[0][0] = "test@automation.com";
		data[0][1] = "123*&65";
	
		return data;
	}
}
