package stepDefinitions.testSuite.regression.engage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommomPageLocators;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class EngLoginSteps extends DriverFactory {
	
	JsonConfigReader reader = new JsonConfigReader();
	
	public CommomPageLocators commonPageLocators =  PageFactory.initElements(driver, CommomPageLocators.class);

	@Given("User navigate to Engage url")
	public void user_navigate_to_Engage_url() throws IOException {
		driver.get(reader.getConfigValue("GeneralSettings", "engBaseURL"));
	}

	@And("User enters a valid username")
	public void user_enters_a_valid_username() throws Exception {
		commonPageLocators.sendKeysToWebElement(commonPageLocators.txtF_UserName, reader.getConfigValue("engage", "username"));
	}

	@And("User enters a valid password")
	public void user_enters_a_valid_password() throws Exception {
		commonPageLocators.sendKeysToWebElement(commonPageLocators.txtF_PassWord, reader.getConfigValue("engage", "password"));
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() throws Exception {
		commonPageLocators.waitAndClickElement(commonPageLocators.btn_signIn);
	}

	@Then("User should be taken to Engage SMS home page")
	public void user_should_be_taken_to_Engage_SMS_home_page() throws InterruptedException {
		
	}

}
