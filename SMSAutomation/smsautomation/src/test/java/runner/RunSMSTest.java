package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
 	 features = {"src/test/resources/features/"},
 		 glue = {"stepDefinitions"},
 		 monochrome = true,
 		 tags = {"@OnlyMe"},
 		 plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "html:target/selenium-reports"}
 		
)

public class RunSMSTest extends AbstractTestNGCucumberTests {
	 
}
