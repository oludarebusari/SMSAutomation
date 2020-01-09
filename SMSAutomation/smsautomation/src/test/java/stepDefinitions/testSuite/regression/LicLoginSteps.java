package stepDefinitions.testSuite.regression;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.LicLoginPage;
import pageObjects.license.LicAdminPage;
import utils.DriverFactory;

public class LicLoginSteps extends DriverFactory {
	
	public LicLoginPage licLoginPage = PageFactory.initElements(driver, LicLoginPage.class);
	public LicAdminPage licPortalPage = PageFactory.initElements(driver, LicAdminPage.class);
	
	@Given("User navigate to License url")
	public void user_navigate_to_License_url() throws IOException {
		licLoginPage.getLoginPage();
	}

	@Given("User enters valid username")
	public void user_enters_valid_username() throws Exception {
		licLoginPage.enterUserName("superadmin");
	}

	@Given("User enters valid password")
	public void user_enters_valid_password() throws Exception {
		licLoginPage.enterPassWord("d4kc77ww");
	}

	@When("User clicks on the SignIn button")
	public void user_clicks_on_the_SignIn_button() throws Exception {
		licLoginPage.clickOnSubmiButton();
	}

	@And("User clicks X icon to close the notification banner")
	public void user_clicks_X_icon_to_close_the_notification_banner() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("User clicks X icon on the new revenue streams banner")
	public void user_clicks_X_icon_on_the_new_revenue_streams_banner() {
	 
	}

	@Then("User is taken to the License homepage")
	public void user_is_taken_to_the_License_homepage() {
	 
	}
	@And("User clicks on Campaigns with Broadcasts in {int} Days")
	public void user_clicks_on_Campaigns_with_Broadcasts_in_Days(Integer int1) throws Exception {
		licPortalPage.clickOnCampaigns_WO_Broadcast_In_7_Days();
	}

	@And("User click the Username displayed on the side menu")
	public void user_click_the_Username_displayed_on_the_side_menu() {

	}
	
	@And("User clicks Sign Out option")
	public void user_clicks_Sign_Out_option() {

	}

	@Then("User is successfully signed out")
	public void user_is_successfully_signed_out() {

	}


}