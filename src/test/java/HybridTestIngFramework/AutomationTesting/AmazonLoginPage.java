package HybridTestIngFramework.AutomationTesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PropertiesReader;

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

}
