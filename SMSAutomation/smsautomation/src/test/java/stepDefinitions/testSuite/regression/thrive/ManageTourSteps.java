package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.thrive.ThriveDashboardPage;
import utils.DriverFactory;

public class ManageTourSteps extends DriverFactory {

	
	public ThriveDashboardPage thrDashboardPage = PageFactory.initElements(driver, ThriveDashboardPage.class);
	
	@Given("User clicks on settings on top menu bar")
	public void user_clicks_on_settings_on_top_menu_bar() throws Exception {
		thrDashboardPage.clickSettingsTab();
	}

	@Then("the settings options are displayed")
	public void the_settings_options_are_displayed() {
	  
	}

	@Given("User clicks on Manage tour under settings")
	public void user_clicks_on_Manage_tour_under_settings() {
	   
	}

	@Then("User is redirected to Tours page")
	public void user_is_redirected_to_Tours_page() {
	 
	}


}
