package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.ThriveDashboardPage;
import pageObjects.thrive.ThriveLoginPage;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ThriveLoginSteps  extends DriverFactory {
	
	JsonConfigReader reader = new JsonConfigReader();
	public ThriveLoginPage thrLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);
	public ThriveDashboardPage thrDashboardPage = PageFactory.initElements(driver, ThriveDashboardPage.class);
	
	@Given("User Navigates to Thrive URL")
	public void user_Navigates_to_Thrive_URL() throws IOException {
		thrLoginPage.getLoginPage();
	}

	@Then("Thrive login page is displayed")
	public void thrive_login_page_is_displayed() {
		 Assert.assertTrue(driver.getTitle().contains("Sign In"));
	}

	@When("User enters a valid username for thrive")
	public void user_enters_a_valid_username_for_thrive() throws Exception {
		thrLoginPage.enterUserName(reader.getConfigValue("thrive", "username"));
	}

	@When("User enters a valid password for thrive")
	public void user_enters_a_valid_password_for() throws Exception {
		thrLoginPage.enterPassWord(reader.getConfigValue("thrive", "password"));
	}
	
	@When("User clicks the sign in button for thrve")
	public void user_clicks_the_sign_in_button_for_thrve() throws Exception {
		thrLoginPage.clickOnSubmiButton();
	}

	@Then("Thrive Dashboard page is displayed")
	public void thrive_Dashboard_page_is_displayed() throws Exception {
	 Assert.assertEquals(thrDashboardPage.getThrivePageTitle(), "Dashboard");
	}




}
