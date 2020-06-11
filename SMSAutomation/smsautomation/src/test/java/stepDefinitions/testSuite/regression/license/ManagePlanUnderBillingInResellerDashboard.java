package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.And;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AddAndEditPlansPage;
import pageObjects.thrive.ManagePlansPage;
import pageObjects.thrive.ThriveLoginPage;
import pageObjects.thrive.Tab.BillingDDown;
import pageObjects.thrive.modal.DeletePlanModal;

public class ManagePlanUnderBillingInResellerDashboard extends BasePage {

	public ManagePlanUnderBillingInResellerDashboard() throws IOException {
		super();
	}

	AddAndEditPlansPage addAndEditPlansPage = PageFactory.initElements(driver, AddAndEditPlansPage.class);
	BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	DeletePlanModal deletePlanModal = PageFactory.initElements(driver, DeletePlanModal.class);
	ManagePlansPage managePlansPage = PageFactory.initElements(driver, ManagePlansPage.class);
	public ThriveLoginPage thriveLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);

	private String URLAddress = "";

//	@Navigate-to-"Manage-Plans"-under-Licensees's-dashboard-in-Thrive-system,-and-verify-admin-is-able-to-see-all-existing-Plans
	@When("User clicks on Plan option from the Billing drop down options")
	public void user_clicks_on_Plan_option_from_the_Billing_drop_down_options() throws Exception {
		billingDDown.waitAndClickElement(billingDDown.opt_Plans);
	}

	@Then("User is redirected to the Plan page")
	public void user_is_redirected_to_the_Plan_page() throws Exception {
		Assert.assertEquals("Manage Plans", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-Admin-is-able-to-edit-an-existing-plan-under-Resellers-dashboard-in-Thrive-System
	@When("User clicks the edit button besides a plan")
	public void user_clicks_the_edit_button_besides_a_plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan"));
	}

	@Then("the Edit plan page is opened")
	public void the_Edit_plan_page_is_opened() throws Exception {
		Assert.assertEquals("Edit %entity%", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User edits the Plan name text value")
	public void user_edits_the_Plan_name_text_value() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_PlanName, "AutoPlan - Edited");
	}

	@Then("User edits the Plan description text value")
	public void user_edits_the_Plan_description_text_value() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtA_PlanDescription, "AutoDescription - Edited");
	}

	@Then("User edits Status value")
	public void user_edits_Status_value() throws Exception {
		addAndEditPlansPage.clickOnTextFromDropdownList(addAndEditPlansPage.statusDDown, "Inactive");
	}

	@When("User clicks on the Save Plan button")
	public void user_clicks_on_the_Save_Plan_button() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

	@Then("the update notification alert is displayed")
	public void the_update_notification_alert_is_displayed() throws Exception {
		Assert.assertEquals("×\nClose\nItem has been successfully updated.",
				managePlansPage.getElementText(managePlansPage.txt_NotificationAlert));
	}

	@Then("User verifies the changes made.")
	public void user_verifies_the_changes_made() throws InterruptedException {
		Assert.assertTrue(managePlansPage.getCellValue("AutoPlan - Edited").isDisplayed());
		Assert.assertTrue(managePlansPage.getCellValue("AutoDescription - Edited").isDisplayed());
		Assert.assertTrue(managePlansPage.getCellValue("Inactive").isDisplayed());
	}

//	#Revert Changes made to Plans details
	@Then("User reverted changes made to plans details")
	public void user_reverted_changes_made_to_plans_details() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan - Edited"));
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_PlanName, "AutoPlan");
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtA_PlanDescription, "AutoDescription");
		addAndEditPlansPage.clickOnTextFromDropdownList(addAndEditPlansPage.statusDDown, "Active");
		;
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

//  @Verify-Admin-is-able-to-edit-an-existing-Plan-and-Add-a-Feature-Under-Reseller's-dashboard-in-Thrive-System
	@Then("User clicks the add icon under feature to add a feature")
	public void user_clicks_the_add_icon_under_feature_to_add_a_feature() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.addFeatureTopBtn);
	}

	@Then("User enters feature, One-Time Price, Recurring Price and Start Date")
	public void user_enters_feature_One_Time_Price_Recurring_Price_and_Start_Date() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.featureDDown);
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.selectFeature("Package Discount"));
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_OneTimePrice("1"), "120.00");
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_RecurringPrice("1"), "10.00");
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.txtF_Date("1"));
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.activeDate2);
	}

	@When("User clicks the Save Plan button")
	public void user_clicks_the_Save_Plan_button() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

	@Then("User verifies the added feature")
	public void user_verifies_the_added_feature() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan"));
		Assert.assertTrue(addAndEditPlansPage.feature("Package Discount").isDisplayed());
		Assert.assertTrue(addAndEditPlansPage.txtF_OneTimePrice("1").getAttribute("value").contentEquals("120.00"));
		Assert.assertTrue(addAndEditPlansPage.txtF_RecurringPrice("1").getAttribute("value").contentEquals("10.00"));
		Assert.assertTrue(addAndEditPlansPage.txtF_Date("1").getAttribute("value")
				.contentEquals(addAndEditPlansPage.getCURRENTDate()));
	}

	@Then("User removes the added feature")
	public void user_removes_the_added_feature() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.removeFeature("Package Discount"));
		Thread.sleep(500);
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

//	@Verify-Admin-is-able-to-create-a-plan
	@When("User clicks on the New button on the Manage Plans page")
	public void user_clicks_on_the_New_button_on_the_Manage_Plans_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("User is redirected to the Create Plan page")
	public void user_is_redirected_to_the_Create_Plan_page() throws Exception {
		Assert.assertEquals("Create %entity%", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User provides value for Plan Name")
	public void user_provides_value_for_Plan_Name() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_PlanName, "AutoTest");
		;
	}

	@Then("User provides value for Plan Description")
	public void user_provides_value_for_Plan_Description() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtA_PlanDescription,
				"This plan is used for Automation testing");
	}

	@Then("User adds a Feature to the Plan")
	public void user_adds_a_Feature_to_the_Plan() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.addFeatureTopBtn);
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.featureDDown);
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.selectFeature("Web Essentials Ongoing"));
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_OneTimePrice, "150.00");
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_RecurringPrice, "15.00");
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.txtF_Date);
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.activeDate1);
	}

	@Then("User clicks thd Save Plan button")
	public void user_clicks_thd_Save_Plan_button() throws Exception {
		addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

	@Then("User verifies that the plan is created")
	public void user_verifies_that_the_plan_is_created() throws Exception {
		Assert.assertTrue(managePlansPage.getCellValue("AutoTest").isDisplayed());
	}

//	@Verify-that-a-Plan-cannot-be-deleted-if-the-"x"-is-clicked-on-"Delete-Plan"-confirmation-popup-for-"Delete-Plan"-action-when-navigated-from-Reseller-Dashboard
	@When("User clicks the drop down action button")
	public void user_clicks_the_drop_down_action_button() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.planActionDDown("AutoTest"));
	}

	@Then("User verifies the actions options available")
	public void user_verifies_that_the_actions_options_available() {
		managePlansPage.ActionDDownOption("AutoTest", "Deactivate");
		managePlansPage.ActionDDownOption("AutoTest", "Delete");
	}

	@When("User clicks the Delete option for the Manage Plan")
	public void user_clicks_the_Delete_option_for_the_Manage_Plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("AutoTest", "Delete"));
	}

	@Then("the Delete plan confirmation popup appears")
	public void the_Delete_plan_confirmation_popup_appears() throws Exception {
		Assert.assertEquals("Delete Plan", deletePlanModal.getElementText(deletePlanModal.mod_Title));
	}

	@When("User clicks on the close button")
	public void user_clicks_on_the_close_button() throws Exception {
		deletePlanModal.waitAndClickElement(deletePlanModal.btn_Close);
	}

	@Then("the Delete Plan popup is closed and the plan is not deleted")
	public void the_Delete_Plan_popup_is_closed_and_the_plan_is_not_deleted() {
		Assert.assertFalse(deletePlanModal.isElementVisible(deletePlanModal.btn_Delete.toString()));
		Assert.assertTrue(managePlansPage.getCellValue("AutoTest").isDisplayed());
	}

//	@Verify-that-an-Active-plan-can-be-deactivated-by-clicking-on-Deactivate-in-the-Edit-drop-down-on-Manage-Plans-Reseller's-dashboard
	@Then("User verifies the actions options available for an Active Plan")
	public void user_verifies_the_actions_options_available_for_an_Active_Plan() {
		managePlansPage.ActionDDownOption("AutoTest", "Deactivate");
		managePlansPage.ActionDDownOption("AutoTest", "Delete");
	}

	@When("User clicks the Deactivate option for the Manage Plan")
	public void user_clicks_the_Deactivate_option_for_the_Manage_Plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("AutoTest", "Deactivate"));
	}

	@Then("the plan status changes to Inactive")
	public void the_plan_status_changes_to_Inactive() throws Exception {
		Assert.assertEquals("×\nClose\nItem has been successfully updated.",
				managePlansPage.getElementText(managePlansPage.txt_NotificationAlert));
	}

//	@Verify-that-an-Inactive-plan-can-be-activated-by-clicking-on-Activate-in-the-Edit-drop-down-on-Manage-Plans-Reseller's-dashboard
	@Then("User verifies the actions options available for an Inactive Plan")
	public void user_verifies_the_actions_options_available_for_an_Inactive_Plan() {
		managePlansPage.ActionDDownOption("AutoTest", "Activate");
		managePlansPage.ActionDDownOption("AutoTest", "Delete");
	}

	@When("User clicks the Activate option for the Manage Plan")
	public void user_clicks_the_Activate_option_for_the_Manage_Plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("AutoTest", "Activate"));
	}

	@Then("the plan status changes to Active")
	public void the_plan_status_changes_to_Active() throws Exception {
		Assert.assertEquals("×\nClose\nItem has been successfully updated.",
				managePlansPage.getElementText(managePlansPage.txt_NotificationAlert));
	}

//	@Verify-that-a-Plan-is-deleted-if-Delete"-is-clicked-on-"Delete-Plan"-confirmation-popup-for-"Delete"-action-from-Manage-Plans-page
	@When("User clicks the Delete button on the confirmation page")
	public void user_clicks_the_Delete_button_on_the_confirmation_page() throws Exception {
		deletePlanModal.waitAndClickElement(deletePlanModal.btn_Delete);
	}

	@Then("User confirms that the plan is deleted")
	public void user_confirms_that_the_plan_is_deleted() throws Exception {
		Assert.assertFalse(managePlansPage.isElementVisible(managePlansPage.getCellValueLocator("AutoTest")));
	}

//	@Verify-Admin-is-able-to-search-the-Plans-by-entering-a-search-criteria-in-Search-box-and-clicking-Search-on-Manage-Plans-page
	@When("User enters a valid search criteria in the search box at the top right of the page and clicks Search button")
	public void user_enters_a_valid_search_criteria_in_the_search_box_at_the_top_right_of_the_page_and_clicks_Search_button()
			throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoPlan");
		;
	}

	@Then("The result of the search is displayed correctly")
	public void the_result_of_the_search_is_displayed_correctly() {
		Assert.assertTrue(managePlansPage.isElementVisible(managePlansPage.getCellValueLocator("AutoPlan")));
	}

	@When("User enters an invalid search criteria and clicks Search button")
	public void user_enters_an_invalid_search_criteria_and_clicks_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "invalid");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("zero record is displayed")
	public void zero_record_is_displayed() throws Exception {
		Assert.assertEquals(0,
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
	}

//	@Verify-the-help-on-Manage-Plans-under-Reseller-dashboard-page-by-clicking-the-Help-button
	@When("User clicks the Help button on the Manage Plans page")
	public void user_clicks_the_Help_button_on_the_Manage_Plans_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Plan Overview window is opened")
	public void the_Plan_Overview_window_is_opened() throws Exception {
		Assert.assertEquals("Plans Overview", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Plans Overview window")
	public void user_clicks_the_Next_button_on_the_Plans_Overview_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Create A Plan window is opened")
	public void the_Create_A_Plan_window_is_opened() throws Exception {
		Assert.assertEquals("Create A Plan", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Previous button on the Crate A Plan window")
	public void user_clicks_the_Previous_button_on_the_Crate_A_Plan_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("User is navigated back to the Plan Overview window")
	public void user_is_navigated_back_to_the_Plan_Overview_window() throws Exception {
		Assert.assertEquals("Plans Overview", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	@Verify-functionality-of-sorting-and-show-entries-drop-down-on-Manage-Plans-page-for-Resellers-dashboard
	@When("User clicks the Plan column")
	public void user_clicks_the_Plan_column() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.col_Plan);
	}

	@Then("User verifies that the records are sorted by Plan column in ascending order")
	public void user_verifies_that_the_records_are_sorted_by_Plan_column_in_ascending_order() throws Exception {
		Assert.assertEquals("AutoPlan", managePlansPage.getElementText(managePlansPage.firstRowCellValue("AutoPlan")));
	}

	@When("User clicks on the Plan column again")
	public void user_clicks_on_the_Plan_column_again() throws InterruptedException {
		managePlansPage.waitAndClickElement(managePlansPage.col_Plan);
	}

	@Then("User verifies that the records are sorted by Plan column in descending order")
	public void user_verifies_that_the_records_are_sorted_by_Plan_column_in_descending_order() throws Exception {
		Assert.assertEquals("Web Essentials",
				managePlansPage.getElementText(managePlansPage.firstRowCellValue("Web Essentials")));
	}

//	@Verify-a-non-admin-user-cannot-access-the-Manage-Plans-page-both-through-UI-and-direct-URL-access-from-Billing-menu-for-Resellers-dashboard
	@Then("User copies the current url from the Manage Plans page and sign out")
	public void user_copies_the_current_url_from_the_Manage_Plans_page_and_sign_out() throws InterruptedException {
		URLAddress = driver.getCurrentUrl();
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
	}

	@When("User signs in with a user without admin access")
	public void user_signs_in_with_a_user_without_admin_access() throws Exception {
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_UserName, "test@automation.com");
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_PassWord, "QA@vnet1");
		thriveLoginPage.waitAndClickElement(thriveLoginPage.button_signIn);
	}

	@When("User is redirected to the dashboard for the sign in user")
	public void user_is_redirected_to_the_dashboard_for_the_sign_in_user() throws Exception {
			Assert.assertTrue(commonElementLocator.menu_Settings.isDisplayed());
	}

	@When("User navigates to the URL copied earlier")
	public void user_navigates_to_the_URL_copied_earlier() {
		  driver.navigate().to(URLAddress);
	}
	
	@Then("an error403 page is displayed instead of the Manage Plans page")
	public void an_error403_page_is_displayed_instead_of_the_Manage_Plans_page() {
		Assert.assertTrue(commonElementLocator.lbl_Error403.isDisplayed());
	}

}
