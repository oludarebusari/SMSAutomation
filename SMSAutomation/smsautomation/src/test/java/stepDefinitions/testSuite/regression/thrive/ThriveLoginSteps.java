package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.ThriveLoginPage;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ThriveLoginSteps  extends DriverFactory {
	
	JsonConfigReader reader = new JsonConfigReader();
	public ThriveLoginPage thrLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);
	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	
	@Given("User Navigates to Thrive URL")
	public void user_Navigates_to_Thrive_URL() throws IOException {
		driver.get(reader.getConfigValue("GeneralSettings", "thrBaseURL"));
	}

	@Then("Thrive login page is displayed")
	public void thrive_login_page_is_displayed() {
		 Assert.assertTrue(driver.getTitle().contains("Sign In"));
	}

	@When("User enters a valid username for thrive")
	public void user_enters_a_valid_username_for_thrive() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_UserName, reader.getConfigValue("thrive", "username"));
	}

	@When("User enters a valid password for thrive")
	public void user_enters_a_valid_password_for() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_PassWord, reader.getConfigValue("thrive", "password"));
	}
	
	@When("User clicks the sign in button for thrve")
	public void user_clicks_the_sign_in_button_for_thrve() throws Exception {
		thrLoginPage.waitAndClickElement(thrLoginPage.button_signIn);
	}

	@Then("Thrive Dashboard page is displayed")
	public void thrive_Dashboard_page_is_displayed() throws Exception {
	 Assert.assertEquals(thrDashboardPage.getElementText(thrDashboardPage.pag_Title), "Dashboard");
	}

}
