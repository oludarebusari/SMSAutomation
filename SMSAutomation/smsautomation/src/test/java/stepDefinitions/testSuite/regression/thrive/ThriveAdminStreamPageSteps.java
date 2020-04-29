package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.Tab.ExperienceDDown;
import utils.DriverFactory;

public class ThriveAdminStreamPageSteps extends DriverFactory {
	
	
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	
//	@Verify-the-stream-page-is-opened-at-Experience-tab
	@When("User clicks on the Experience Menu option on the dashboard")
	public void user_clicks_on_the_Experience_Menu_option_on_the_dashboard() {
	
	}

	@Then("the Experience option is displayed")
	public void the_Experience_option_is_displayed() {
	 
	}

}
