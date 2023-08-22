package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@AmazonTest", 
		features = "src/test/resources", 
		glue = {"HybridTestIngFramework/AutomationTesting/stepDefinition" }, 
		plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				monochrome = true)

public class MyTestRunner {

}
