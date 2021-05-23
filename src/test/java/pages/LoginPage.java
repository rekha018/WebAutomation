package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	String email = "xyz@gmail.com";
	String password = "Test1234";

	By loginEmail = By.id("login_email");
	By loginPassword = By.id("login_password");
	By login = By.xpath("//*[@id=\"login-register\"]/div[1]/div/div[2]/div[1]/form/div[1]/div[3]/button/span/span");
	By loginSucessMessage = By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/div[1]/div[2]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailAddress() {
		driver.findElement(loginEmail).sendKeys(email);
	}

	public void enterPassword() {
		driver.findElement(loginPassword).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(login).click();
	}

	public void isUserLoggedIn() {
		String expectedText = "Du bist nun bei Contorion angemeldet.";
		String actualText = driver.findElement(loginSucessMessage).getText();
		Assert.assertEquals(actualText, expectedText);
	}

}
