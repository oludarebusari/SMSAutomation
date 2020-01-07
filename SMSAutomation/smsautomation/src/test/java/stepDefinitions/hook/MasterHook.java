package stepDefinitions.hook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class MasterHook extends DriverFactory {

	JsonConfigReader jsonConfigReader = new JsonConfigReader();

	@Before
	public void setup() {

		driver = getDriver(jsonConfigReader.getConfigValue("DriverConfig", "browser"),
				jsonConfigReader.getConfigValue("DriverConfig", "environment"));

	}

	@SuppressWarnings("deprecation")
	@After
	@Attachment("Screenshot on failure")
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;

			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;

			}

		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	}
}
