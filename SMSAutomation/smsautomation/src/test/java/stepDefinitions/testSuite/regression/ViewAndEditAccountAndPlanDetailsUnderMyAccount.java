package stepDefinitions.testSuite.regression;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.MyAccountPage;
import pageObjects.license.menu.MerchantMenu;
import utils.Constant;
import utils.DriverFactory;

public class ViewAndEditAccountAndPlanDetailsUnderMyAccount extends DriverFactory {
	
	Actions action = new Actions(driver);
	

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
		Assert.assertTrue(
				myAccountPage.rBtn_Plan_Name_Opt(Constant.NEW_PLAN_DETAILS).getAttribute("class").contains("active"));
	}

	@And("User clicks Change Plan button")
	public void user_clicks_Change_Plan_button() throws Exception {
		myAccountPage.clickNewPlanChangePlanBtn();
	}

	@Then("Success message is displayed and the plan is changed to the new plan")
	public void success_message_is_displayed_and_the_plan_is_changed_to_the_new_plan() throws Exception {
		Assert.assertEquals("Success! Your plan is updated!", myAccountPage.getPlanUpdateMessageTxt());
	}
	
	@Then("User clicks on the Change Plan button agaian")
	public void user_clicks_on_the_Change_Plan_button_agaian() throws Exception {
		myAccountPage.clickChangePlanBtn();
	}

	@Then("User selects a different plan and clicks and clicks the Change plan button")
	public void user_selects_a_different_plan_and_clicks_and_clicks_the_Change_plan_button() throws Exception {
		myAccountPage.selectPlan(Constant.CURRENT_PLAN_NAME);
		myAccountPage.clickNewPlanChangePlanBtn();;
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
		myAccountPage.setAccountContactCity("Grove");
		myAccountPage.setAccountContactPostalCode("123456");
		myAccountPage.clickAccountContactEditSaveChanges();
	}

	@Then("A successful message indicating that the changes were saved is displayed")
	public void a_suucessful_message_indicating_that_the_changes_were_saved_is_displayed() throws Exception {
		Assert.assertEquals("Account Details successfully saved", myAccountPage.getAccountDetailsSavedMessageTxt());
	}

	@Then("User clicks edit button again and revert the changes made to Account Details")
	public void user_clicks_edit_button_again_and_revert_the_changes_made_to_Account_Details() throws Exception {
//		Thread.sleep(500);
		myAccountPage.clickAccountContactEditBtn();
		myAccountPage.setFirstName("Aclate");
		myAccountPage.setLastName("QA");
		myAccountPage.setStreetAddress("123 Testing Street");
		myAccountPage.setAccountContactCity("Denver");
		myAccountPage.setAccountContactPostalCode("1234567");
		myAccountPage.clickAccountContactEditSaveChanges();
	}

	@And("User clicks edit button under Billing contact")
	public void user_clicks_edit_button_under_Billing_contact() throws Exception {
		Thread.sleep(500);
		myAccountPage.clickBillingContactEditBtn();
	}

	@Then("the Billing Contact details screen appears")
	public void the_Billing_Contact_details_screen_appears() throws Exception {
		Assert.assertEquals("Billing Contact", myAccountPage.getBillingContactEditTitle());
	}

	@Then("User made some changes and click save button")
	public void user_made_some_changes_and_click_save_button() throws Exception {
		myAccountPage.setBillingCity("Grove");
		myAccountPage.setBillingPostalCode("654321");
		myAccountPage.clickBillingContactEditSaveChanges();
	}

	@Then("A successful message indicating that the details were saved is displayed")
	public void a_suucessful_message_indicating_that_the_details_were_saved_is_displayed() throws Exception {
		Assert.assertEquals("Account Details successfully saved", myAccountPage.getAccountDetailsSavedMessageTxt());
	}
	
	@Then("User verifies the changes made to billing contacts")
	public void user_verifies_the_changes_made_to_billing_contacts() throws Exception {
		Assert.assertEquals("654321", myAccountPage.getBillingContactPostalCode());
	}
	
	@And("User clicks the change password button")
	public void user_clicks_the_change_password_button() throws Exception {
		myAccountPage.clickAccountContactChangePasswordBtn();
	}

	@Then("the change password window is opened")
	public void the_change_password_window_is_opened() throws Exception {
		Assert.assertEquals("Change Password", myAccountPage.getChangePasswordWindowTitle());
	}

	@Then("User verifies the fields, icon and button on the Change password window")
	public void user_verifies_the_fields_and_button_on_the_Change_password_window() {
		Assert.assertTrue(myAccountPage.txtF_Account_Contact_ChangePassword_CurrPass.isDisplayed());
		Assert.assertTrue(myAccountPage.txtF_Account_Contact_ChangePassword_NewPass.isDisplayed());
		Assert.assertTrue(myAccountPage.icon_New_PasswordTooltip.isDisplayed());
		Assert.assertTrue(myAccountPage.btn_Account_Contact_ChangePassword_ChangePass.isDisplayed());
	}
	
	@And("User clicks on the new password tooltip icon")
	public void user_clicks_on_the_new_password_tooltip_icon() throws Exception {
		myAccountPage.clickNewPasswordTooltipIcon();
	}

	@Then("the minimum password requirement window is displayed")
	public void the_minimum_password_requirement_window_is_displayed() throws Exception {
		Assert.assertEquals(Constant.PASSWORD_REQUIREMENTS, myAccountPage.getPasswordRequirementsTxt());
	}

	@Then("User leaves current and new password fields blank and clicks on the Change password button")
	public void user_leaves_current_and_new_password_fields_blank_and_clicks_on_the_Change_password_button()
			throws Exception {
		myAccountPage.clickChangePasswordBtn();
	}

	@Then("validation message is displayed")
	public void validation_message_is_displayed() throws Exception {
		Assert.assertEquals(Constant.PASSWORD_ERROR_MSG, myAccountPage.getCurrentPasswordErrorMsg());
		Assert.assertEquals(Constant.PASSWORD_ERROR_MSG, myAccountPage.getNewPasswordErrorMsg());
	}

	@And("User enters invalid current password and valid new password and clicks Change Password")
	public void user_enters_invalid_current_password_and_valid_new_password_and_clicks_Change_Password() throws Exception {
		myAccountPage.setCurrentPassword("Invalid");
		myAccountPage.setNewPassword(Constant.PLAN_PASSWORD);
		myAccountPage.clickChangePasswordBtn();
	}

	@Then("Invalid Current password error message is displayed")
	public void invalid_Current_password_error_message_is_displayed() throws Exception {
		Assert.assertEquals("Invalid Current Password", myAccountPage.getInvalidCurrentPasswordErrorMsg());
	}

	@And("User enters a weak new password")
	public void user_enters_a_weak_new_password() throws Exception {
		myAccountPage.setCurrentPassword(Constant.PLAN_PASSWORD);
		myAccountPage.setNewPassword("1234");
		myAccountPage.clickChangePasswordBtn();
	}

	@Then("Weak password warning message is displayed")
	public void weak_password_warning_message_is_displayed() throws Exception {
		Assert.assertEquals("Too weak. Refer to help icon.", myAccountPage.getWeakNewPasswordWarningMsg());
	}

	@Then("User enters the correct password for current password and new password and clicks on Change Password button")
	public void user_enters_the_correct_password_for_current_password_and_new_password_and_clicks_on_Change_Password_button()
			throws Exception {
		Robot robot = new Robot();
		myAccountPage.setCurrentPassword(Constant.PLAN_PASSWORD);
		action.contextClick(myAccountPage.txtF_Account_Contact_ChangePassword_CurrPass).perform();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		myAccountPage.setNewPassword(Constant.PLAN_PASSWORD);
		myAccountPage.clickChangePasswordBtn();
	}

	@Then("Success message is displayed")
	public void success_message_is_displayed() throws Exception {
		Assert.assertEquals("Account Details successfully saved", myAccountPage.getAccountDetailsSavedMessageTxt());
	}
	
	@And("User clicks the Edit button under Credit Card")
	public void user_clicks_the_Edit_button_under_Credit_Card() throws Exception {
	  myAccountPage.clickCreditCardEditBtn(); 
	}

	@Then("Credit card details windows is opened")
	public void credit_card_details_windows_is_opened() throws Exception {
		Assert.assertEquals("Credit Card Details", myAccountPage.getCreditCardEditTitle());
	}

	@And("User enter valid details on credit card window and click on Update Credit Card button")
	public void user_enter_valid_details_on_credit_card_window_and_click_on_button() throws Exception  {
		myAccountPage.setNameOnCard(Constant.CREDIT_CARD_NAME);
		myAccountPage.setCreditCardNumber(Constant.CREDIT_CARD_NUMBER);
		myAccountPage.setCreditCardZipCode(Constant.CREDIT_CARD_ZIPCODE);
		myAccountPage.setCreditCardExpMonth(Constant.CREDIT_CARD_EXP_MONTH);
		myAccountPage.setCreditCardExpYear(Constant.CREDIT_CARD_EXP_YEAR);
		myAccountPage.setCreditCardCVV(Constant.CREDIT_CARD_CCV);
		myAccountPage.clickUpdateCreditCardBtn();
	}

	@Then("the details is saved successfully and a successful message is displayed")
	public void the_details_is_saved_successfully_and_a_successful_message_is_displayed() throws Exception {
		Assert.assertEquals("CC processing is not configured in the site table!", myAccountPage.getCreditCardEditTitle());
	}

}
