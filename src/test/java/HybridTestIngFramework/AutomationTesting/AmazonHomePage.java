package HybridTestIngFramework.AutomationTesting;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	WebDriver driver;

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
}
