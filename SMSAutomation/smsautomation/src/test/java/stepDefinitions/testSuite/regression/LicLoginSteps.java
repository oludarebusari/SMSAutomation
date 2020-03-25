package stepDefinitions.testSuite.regression;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommomPageLocators;
import pageObjects.license.LicAdminPage;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class LicLoginSteps extends DriverFactory {
	
	JsonConfigReader reader = new JsonConfigReader();

	public CommomPageLocators commonPageLocators =  PageFactory.initElements(driver, CommomPageLocators.class);
	public LicAdminPage licPortalPage = PageFactory.initElements(driver, LicAdminPage.class);
	
	@Given("User navigate to License url")
	public void user_navigate_to_License_url() throws IOException {
		driver.get(reader.getConfigValue("GeneralSettings", "licBaseURL"));
	}

	@Given("User enters valid username")
	public void user_enters_valid_username() throws Exception {
		commonPageLocators.sendKeysToWebElement(commonPageLocators.txtF_UserName, reader.getConfigValue("license", "username"));
	}

	@Given("User enters valid password")
	public void user_enters_valid_password() throws Exception {
		commonPageLocators.sendKeysToWebElement(commonPageLocators.txtF_PassWord, reader.getConfigValue("license", "password"));
	}

	@When("User clicks on the SignIn button")
	public void user_clicks_on_the_SignIn_button() throws Exception {
		commonPageLocators.waitAndClickElement(commonPageLocators.btn_signIn);
	}

}
