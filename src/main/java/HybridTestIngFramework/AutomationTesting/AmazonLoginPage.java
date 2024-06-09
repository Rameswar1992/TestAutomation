package HybridTestIngFramework.AutomationTesting;

import Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class AmazonLoginPage {

	WebDriver driver;

	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Hello, sign in']")
	private WebElement signInText;

	@FindBy(css = "input[type='email']")
	private WebElement userNameTxtBox;

	@FindBy(css = "input[type='password']")
	private WebElement passwordtxtBox;

	@FindBy(css = "input#continue")
	private WebElement continueBtn;

	@FindBy(id = "signInSubmit")
	private WebElement submitBtn;

	public WebElement getSignInText() {
		return signInText;
	}

	public WebElement getUserNameTxtBox() {
		return userNameTxtBox;
	}

	public WebElement getPasswordtxtBox() {
		return passwordtxtBox;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public AmazonHomePage loginToAmazon() throws IOException {
		getSignInText().click();
		getUserNameTxtBox().sendKeys(PropertiesReader.getProperty("amazon.username"));
		getContinueBtn().click();
		getPasswordtxtBox().sendKeys(PropertiesReader.getProperty("amazon.password"));
		getSubmitBtn().click();
		return new AmazonHomePage(driver);
	}
	public void loginToAmazonWithInvalidCredentials(String username) throws IOException, InterruptedException {
		getSignInText().click();
		getUserNameTxtBox().sendKeys(username);
		getContinueBtn().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'We cannot find an account with that email address')]")).isDisplayed(),"Test failed");
		getUserNameTxtBox().clear();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(4000);
	}
	public boolean verifyUserNotInHomePage() {
		try {
			if(!driver.findElement(By.xpath("//span[contains(text(),'Hello, Rameswar')]")).isDisplayed()){
			  return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}
