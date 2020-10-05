package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By landingLogin = By.cssSelector("a.theme-btn.register-btn");
	private By landingCoursesTitle = By.xpath("//h2[text()='Featured Courses']");
	private By landingNavBar = By.xpath("(//nav[@class='main-menu'])[1]");
	private By header = By.xpath("(//h2/span)[1]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(landingLogin).click();
		LoginPage login = new LoginPage(driver); 
		return login;
	}
	
	public WebElement getFeaturedCoursesTitle() {
		return driver.findElement(landingCoursesTitle);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(landingNavBar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
