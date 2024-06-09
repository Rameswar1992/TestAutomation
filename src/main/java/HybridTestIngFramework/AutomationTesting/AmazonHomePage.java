package HybridTestIngFramework.AutomationTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utils.Utilities.highlight;

public class AmazonHomePage {

	WebDriver driver;



	@FindBy(css="input#twotabsearchtextbox")
    WebElement searchTxtbox;

	@FindBy(xpath = "//div[contains(@class,'s-main-slot')]//a//span[contains(@class,'a-size-medium')]")
	List<WebElement> listOfProduct;


	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUserInHomePage() {

		try {
			if (!driver.findElement(By.xpath("//span[text()='Hello, sign in']")).isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			//System.out.println(e.getMessage());
			return true;
		}

	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public boolean verifyPageTitle(String pageTitle) {
		return getTitleOfPage().contains(pageTitle);

	}
	public WebElement getSearchTxtbox() {
		return searchTxtbox;
	}
	public List<WebElement> getListOfProduct() {
		return listOfProduct;
	}
	public void searchProduct(String productName){
		getSearchTxtbox().sendKeys(productName + Keys.ENTER);
	}

	public boolean verifySearchedProductDisplayed(String productName) throws InterruptedException {
		Actions action = new Actions(driver);
		for (WebElement e : getListOfProduct()) {
			action.moveToElement(e).perform();
			highlight(driver,e);
			//Thread.sleep(2000);
			if (e.getText().contains(productName)) {
				System.out.println(e.getText());
				return true;
			}
		}
		return false;
	}

}
