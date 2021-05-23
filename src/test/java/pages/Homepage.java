package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {
	WebDriver driver;
	WebDriverWait wait;

	String url = "https://www.contorion.de/";
	String searchText = "hammer";

	By loginButton = By.xpath("//*[@id=\"page-home-index\"]/div[1]/header/div[2]/div/div[4]/a");
	By searchField = By.id("search-input");
	By searchButton = By.xpath("//*[@id=\"search-button\"]/div");
	By searchResultsHeader = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[2]/h2");
	By searchResultsContainer = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[2]/div[2]/div[4]");

	By acceptCookieButton = By.id("popin_tc_privacy_button");

	public Homepage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void openHomepage() {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void acceptCookie() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookieButton));
	}

	public void clickOnLogInButton() {
		driver.findElement(loginButton).click();
	}

	public void searchForHammer() {
		driver.findElement(searchField).sendKeys(searchText);
		driver.findElement(searchButton).click();
	}

	public void areHammersDisplayed() {
		String actualText = driver.findElement(searchResultsHeader).getText();

		String expectedText = "Suchergebnisse für hammer";
		Assert.assertEquals(actualText, expectedText);

		Assert.assertTrue(driver.findElement(searchResultsContainer).isDisplayed());
	}

}
