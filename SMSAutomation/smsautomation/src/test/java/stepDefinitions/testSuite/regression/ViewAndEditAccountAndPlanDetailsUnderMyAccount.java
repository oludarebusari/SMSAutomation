package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.MyAccountPage;
import pageObjects.license.menu.MerchantMenu;
import utils.Constant;
import utils.DriverFactory;

public class ViewAndEditAccountAndPlanDetailsUnderMyAccount extends DriverFactory{

	
	MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	
	
	
	@When("User clicks on My Accounts from the left hand side menu")
	public void user_clicks_on_My_Accounts_from_the_left_hand_side_menu() throws Exception {
	   merchantMenu.clickMyAccount();
	}

	@Then("User is redirected to my account page")
	public void user_is_redirected_to_my_account_page() throws Exception {
		Assert.assertEquals("My Account", myAccountPage.getPageTitle());
	}
	
	@And("User verifies the sections on my account page")
	public void user_verifies_the_sections_on_my_account_page() throws Exception {
		Assert.assertEquals("Account Details", myAccountPage.getAccountDetailsTxt());
		Assert.assertEquals("Account Resources", myAccountPage.getAccountResourcesTxt());
	}
	
	@And("User verifies My Plan section on my account page")
	public void user_verifies_the_My_Plan_section_on_my_account_page() throws Exception {
		Assert.assertEquals("My Plan", myAccountPage.getMyPlanTxt());
	}

	@When("User clicks on the Plan Details link")
	public void user_clicks_on_the_Plan_Details_link() throws Exception {
	    myAccountPage.clickPlanDetailsLink();
	}

	@Then("details of the plan is displayed within the Plan Details popup window")
	public void details_of_the_plan_is_displayed_within_the_Plan_Details_popup_window() throws Exception {
		Assert.assertEquals(Constant.PLAN_DETAILS, myAccountPage.getPlanDetailsTxt());
	}

	@And("User clicks on the Change Plan button")
	public void user_clicks_on_the_Change_Plan_button() throws Exception {
		myAccountPage.clickChangePlanBtn();
	}
	
	@Then("User confirms a new window popup to select a plan")
	public void user_confirms_a_new_window_popu_to_select_a_plan() throws Exception {
		Assert.assertEquals("Select a New Plan", myAccountPage.getNewPlanWindowTitle());
	}

	@And("User selects another plan")
	public void user_selects_another_plan() throws Exception {
		myAccountPage.selectPlan(Constant.NEW_PLAN_DETAILS);
	}

	@Then("User verifies that the plan is selected")
	public void user_verifies_that_the_plan_is_selected() throws Exception {
		Assert.assertTrue(myAccountPage.rBtn_Plan_Name_Opt(Constant.NEW_PLAN_DETAILS).getAttribute("class").contains("active"));
	}

	@And("User clicks Change Plan button")
	public void user_clicks_Change_Plan_button() throws Exception {
		myAccountPage.clickNewPlanChangePlanBtn();
	}
	
	@Then("Success message is displayed and the plan is changed to the new plan")
	public void success_message_is_displayed_and_the_plan_is_changed_to_the_new_plan() throws Exception {
		Assert.assertEquals("Success! Your plan is updated!", myAccountPage.getPlanUpdateMessageTxt());
	}
	
	@And("User clicks the edit button under Contact Details")
	public void user_clicks_the_edit_button_under_Contact_Details() throws Exception {
	    myAccountPage.clickAccountContactEditBtn();
	}

	@Then("the Account Contact details screen appears")
	public void the_Account_Contact_details_screen_appears() throws Exception {
		myAccountPage.getAccountContactEditTitle();
	}

	@And("User made some changes and click Save Changes")
	public void user_made_some_changes_and_click_Save_Changes() throws Exception {
		myAccountPage.setFirstName("Aclate2"); 
		myAccountPage.setLastName("QA2");
		myAccountPage.setStreetAddress("ABC Testing RD");
		myAccountPage.clickAccountContactEditSaveChanges();
	}

	@Then("A successful message indicating that the changes were saved is displayed")
	public void a_suucessful_message_indicating_that_the_changes_were_saved_is_displayed() throws Exception {
		Assert.assertEquals("Account Details successfully saved", myAccountPage.getAccountDetailsSavedMessageTxt());
	}
	
	@Then("User clicks edit button again and revert the changes made to Account Details")
	public void user_clicks_edit_button_again_and_revert_the_changes_made_to_Account_Details() throws Exception {
		Thread.sleep(500);
		myAccountPage.getAccountContactEditTitle();
		myAccountPage.setFirstName("Aclate"); 
		myAccountPage.setLastName("QA");
		myAccountPage.setStreetAddress("123 Testing Street");
		myAccountPage.clickAccountContactEditSaveChanges();
	}
	
	@And("User clicks edit button under Billing contact")
	public void user_clicks_edit_button_under_Billing_contact() throws Exception {
		myAccountPage.clickBillingContactEditBtn();
	}

	@Then("the Billing Contact details screen appears")
	public void the_Billing_Contact_details_screen_appears() throws Exception {
		myAccountPage.getBillingContactEditTitle();
	}

	@Then("User made some changes and click save button")
	public void user_made_some_changes_and_click_save_button() {
	   
	}

	@Then("A successful message indicating that the details were saved is displayed")
	public void a_suucessful_message_indicating_that_the_details_were_saved_is_displayed() {
	    
	}

	
}
