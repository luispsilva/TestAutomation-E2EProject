package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import resources.Start;

public class ValidateNavigationBarTest extends Start {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Start.class.getName());
	
	@BeforeTest
	public void inicialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is inicialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	
	@Test
	public void navigationBar() throws IOException {

		LandingPage landingNavBar = new LandingPage(driver);
		Assert.assertTrue(landingNavBar.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void quitBrowser() {
		
		driver.quit();
	}
}
