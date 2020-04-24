package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BusinessDashboardPage;
import pageObjects.thrive.StreamsPage;
import utils.DriverFactory;

public class ManageReviewSettingsInThriveSteps  extends DriverFactory {
	
	public BusinessDashboardPage businessDashboardPage = PageFactory.initElements(driver, BusinessDashboardPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public StreamsPage streamsPage = PageFactory.initElements(driver, StreamsPage.class);
	
	
	@When("User types the business name in the search field and clicks Search")
	public void user_types_the_business_name_in_the_search_field_and_clicks_Search() {
	  
	}

	@Then("the Business is displayed")
	public void the_Business_is_displayed() {
	
	}

	@When("User navigates to the actions column of the Business for stream testing and clicks Sign In button")
	public void user_navigates_to_the_actions_column_of_the_Business_for_stream_testing_and_clicks_Sign_In_button() {
	 
	}
	
//	
	@When("User clicks the Streams option")
	public void user_clicks_the_Streams_option() {

	}

	@Then("the Stream page is opened")
	public void the_Stream_page_is_opened() {
	 
	}
	
	
//	@SMSM-136 @Verify-that-user-is-able-to-navigate-to-streams-page
	@Then("User verifies that Settings button is displayed")
	public void user_verifies_that_Settings_button_is_displayed() {
	  
	}

	@When("User clicks the Settings button")
	public void user_clicks_the_Settings_button() {
	  
	}

	@Then("a Settings configuration pop is opened")
	public void a_Settings_configuration_pop_is_opened() {
	
	}
}
