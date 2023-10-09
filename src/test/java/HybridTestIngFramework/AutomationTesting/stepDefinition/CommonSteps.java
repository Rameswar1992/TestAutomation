package HybridTestIngFramework.AutomationTesting.stepDefinition;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import HybridTestIngFramework.AutomationTesting.AmazonHomePage;
import HybridTestIngFramework.AutomationTesting.AmazonLoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.Duration;

public class CommonSteps {

	static WebDriver driver = new ChromeDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	AmazonLoginPage loginPage;
	AmazonHomePage homePage;

	@Before
	public void beforeTest() {
		loginPage = new AmazonLoginPage(driver);
		homePage = new AmazonHomePage(driver);
	}

	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() throws IOException {
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@When("I submit username and password")
	public void i_submit_username_and_password() throws IOException {
		loginPage.loginToAmazon();
	}

//	@Then("I should be logged in")
//	public void i_should_be_logged_in() {
//		AmazonHomePage homePage = new AmazonHomePage(driver);
//		assertTrue(homePage.verifyUserInHomePage());
//	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		assertTrue(homePage.verifyUserInHomePage());
	}

//	@When("user gets the title of the page")
//	public String user_gets_the_title_of_the_page() {
//		return driver.getTitle();
//
//	}

	@Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
		assertTrue(homePage.verifyPageTitle(pageTitle));

	}

	@AfterAll
	public static void before_or_after_all() {
		driver.close();
	}

}
