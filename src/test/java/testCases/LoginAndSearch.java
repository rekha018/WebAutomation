package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;

public class LoginAndSearch {

	WebDriver driver;
	String webDriverPath = "E:\\QA\\chromedriver_win32\\chromedriver.exe";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", webDriverPath);
		driver = new ChromeDriver();
	}

	@Test
	public void main() {
		Homepage homePage = new Homepage(driver);
		LoginPage loginPage = new LoginPage(driver);

		homePage.openHomepage();
		homePage.acceptCookie();
		homePage.clickOnLogInButton();

		loginPage.enterEmailAddress();
		loginPage.enterPassword();
		loginPage.clickOnLogin();
		loginPage.isUserLoggedIn();
		homePage.searchForHammer();
		homePage.areHammersDisplayed();
	}

	@AfterTest
	public void tearDown34() {
		driver.quit();
	}

}
