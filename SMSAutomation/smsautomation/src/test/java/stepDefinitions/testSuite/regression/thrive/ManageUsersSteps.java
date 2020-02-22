package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.BusinessDashboardPage;
import pageObjects.thrive.ManageBusinessPage;
import pageObjects.thrive.UserManagementPage;

public class ManageUsersSteps extends BasePage {

	public ManageUsersSteps() throws IOException {
		super();
	}

	public BusinessDashboardPage businessDashboardPage = PageFactory.initElements(driver, BusinessDashboardPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ManageBusinessPage manageBusinessPage = PageFactory.initElements(driver, ManageBusinessPage.class);
	public UserManagementPage userManagementPage = PageFactory.initElements(driver, UserManagementPage.class);

//	 @SMSM-134 @View-User--On-user-Management-page,-Confirm-all-existing-Users-are-visible
	@When("User navigates to the actions column of a Business and clicks Sign In button")
	public void user_navigates_to_the_actions_column_of_a_Business_and_clicks_Sign_In_button() throws Exception {
		manageBusinessPage.sendKeysToWebElement(manageBusinessPage.txtF_Search, "AclateQA");
		manageBusinessPage.waitAndClickElement(manageBusinessPage.btn_Search);
		manageBusinessPage.waitAndClickElement(manageBusinessPage.btn_SignIn("AclateQA"));
	}

	@Then("User is logged into the Business and the business dashboard is opened")
	public void user_is_logged_into_the_Business_and_the_business_dashboard_is_opened() throws Exception {
		Assert.assertEquals("Dashboard", businessDashboardPage.getElementText(businessDashboardPage.pag_Title));
	}

	@When("User clicks the Users menu option")
	public void user_clicks_the_Users_menu_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Users);
	}

	@Then("User is redirected to User Management page")
	public void user_is_redirected_to_User_Management_page() throws Exception {
		Assert.assertEquals("User Management", manageBusinessPage.getElementText(manageBusinessPage.pag_Title));
	}

	@Then("User verifies that existing users are displayed on the page")
	public void user_verifies_that_existing_users_are_displayed_on_the_page()
			throws NumberFormatException, InterruptedException {
		Assert.assertTrue(
				Integer.parseInt(userManagementPage.getElementText(userManagementPage.lbl_PaginationTotal)) > 0);
		Assert.assertTrue(userManagementPage.col_FirstName.isDisplayed());
		Assert.assertTrue(userManagementPage.col_LastName.isDisplayed());
		Assert.assertTrue(userManagementPage.col_Status.isDisplayed());
		Assert.assertTrue(userManagementPage.col_Updated.isDisplayed());
		Assert.assertTrue(userManagementPage.col_Action.isDisplayed());
	}

//	@SMSM-134 @verify-user-should-be-able-to-view-all-entries-on-user-management-page
	@When("User clicks the Show entries dropdown")
	public void user_clicks_the_Show_entries_dropdown() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	}

	@Then("the dropdown should open successfully")
	public void the_dropdown_should_open_successfully() {
		Assert.assertTrue(commonElementLocator.showEntriesOption("All").isDisplayed());
	}

	@When("User selects All option from the drop down")
	public void user_selects_All_option_from_the_drop_down() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("All"));
	}

	@Then("All option was selected successfully")
	public void all_option_was_selected_successfully() throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.btn_PaginationEnd)
				.equals(commonElementLocator.getElementText(commonElementLocator.btn_PaginationTotal)));
	}

	@Then("User verifies that all the records are displayed")
	public void user_verifies_that_all_the_records_are_displayed() {
		Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.getAttribute("class").contains("disabled"));
		Assert.assertTrue(
				commonElementLocator.btn_PaginationPreviousDisabled.getAttribute("class").contains("disabled"));
	}

//	@SMSM-134 @verify-the-user-record-by-sorting-first-name-column
	@When("User clicks the first name column")
	public void user_clicks_the_first_name_column() throws Exception {
	userManagementPage.waitAndClickElement(userManagementPage.col_FirstName);
	}
	
	@Then("the user records should be sorted in ascending order by firstname column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_firstnamecolumn() throws Exception {
		Assert.assertTrue(userManagementPage.col_FirstName.getAttribute("class").contains("asc"));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.sort_FirstName).contentEquals("Automation"));
	}

	@When("User clicks the first name column again")
	public void user_clicks_the_first_name_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_FirstName);
	}

	@Then("the user records should be sorted in descending order by firstname column")
	public void the_user_records_should_be_sorted_in_descending_order_by_firstname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_FirstName.getAttribute("class").contains("desc"));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.sort_FirstName).contentEquals("Zella"));
	}
	
//	@SMSM-134 @verify-the-user-record-by-sorting-last-name-column 
	@When("User clicks the last name column")
	public void user_clicks_the_last_name_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_LastName);
	}
	
	@Then("the user records should be sorted in ascending order by lastname column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_lastname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_LastName.getAttribute("class").contains("asc"));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.sort_LastName).contentEquals("Auto"));
	}

	@When("User clicks the last name column again")
	public void user_clicks_the_last_name_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_LastName);
	}
	
	@Then("the user records should be sorted in descending order by lastname column")
	public void the_user_records_should_be_sorted_in_descending_order_by_lastname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_LastName.getAttribute("class").contains("desc"));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.sort_LastName).contentEquals("Zazzi"));
	}

//	 @SMSM-134 @verify-the-user-record-by-sorting-status-column 
	@When("User clicks the status column")
	public void user_clicks_the_status_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Status);
	}
	
	@Then("the user records should be sorted in ascending order by status column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_status_column() {
		Assert.assertTrue(userManagementPage.col_Status.getAttribute("class").contains("asc"));
	}

	@When("User clicks the status column again")
	public void user_clicks_the_status_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Status);
	}
	
	@Then("the user records should be sorted in descending order by status column")
	public void the_user_records_should_be_sorted_in_descending_order_by_status_column() {
		Assert.assertTrue(userManagementPage.col_Status.getAttribute("class").contains("desc"));
	}

//	@SMSM-134 @verify-the-user-record-by-sorting-updated-column
	@When("User clicks the updated column")
	public void user_clicks_the_updated_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Updated);
	}
	
	@Then("the user records should be sorted in ascending order by updated column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_updated_column() {
		Assert.assertTrue(userManagementPage.col_Updated.getAttribute("class").contains("asc"));
	}

	@When("User clicks the updated column again")
	public void user_clicks_the_updated_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Updated);
	}
	
	@Then("the user records should be sorted in descending order by updated column")
	public void the_user_records_should_be_sorted_in_descending_order_by_updated_column() {
		Assert.assertTrue(userManagementPage.col_Updated.getAttribute("class").contains("desc"));
	}

}
