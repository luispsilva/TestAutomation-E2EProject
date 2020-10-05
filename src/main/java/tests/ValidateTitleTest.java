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

public class ValidateTitleTest extends Start {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Start.class.getName());
	
	LandingPage landingTitles;
	
	@BeforeTest
	public void inicialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is inicialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	
	@Test
	public void checkTitle() throws IOException {
	
		landingTitles = new LandingPage(driver);
		Assert.assertEquals(landingTitles.getFeaturedCoursesTitle().getText(), "Featured Courses");
		log.info("Successfully validated text message");
	}
	
	@Test
	public void checkHeader() throws IOException {
	
		landingTitles = new LandingPage(driver);
		Assert.assertEquals(landingTitles.getHeader().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void quitBrowser() {
		
		driver.quit();
	}
}
