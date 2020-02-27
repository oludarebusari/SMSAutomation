package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.BusinessDashboardPage;
import pageObjects.thrive.CreateUserPage;
import pageObjects.thrive.EditUserPage;
import pageObjects.thrive.ManageBusinessPage;
import pageObjects.thrive.UserManagementPage;
import pageObjects.thrive.modal.DeleteUserModal;

public class ManageUsersSteps extends BasePage {

	public ManageUsersSteps() throws IOException {
		super();
	}

	public BusinessDashboardPage businessDashboardPage = PageFactory.initElements(driver, BusinessDashboardPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
	public DeleteUserModal deleteUserModal = PageFactory.initElements(driver, DeleteUserModal.class);
	public EditUserPage editUserPage = PageFactory.initElements(driver, EditUserPage.class);
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
		Assert.assertEquals(userManagementPage.all_Users().size(), Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.btn_PaginationTotal)));
		System.out.println("All Users Count: " + userManagementPage.all_Users().size());
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
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_FirstName).contentEquals("AutoAsc"));
	}

	@When("User clicks the first name column again")
	public void user_clicks_the_first_name_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_FirstName);
	}

	@Then("the user records should be sorted in descending order by firstname column")
	public void the_user_records_should_be_sorted_in_descending_order_by_firstname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_FirstName.getAttribute("class").contains("desc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_FirstName).contentEquals("Zella"));
	}

//	@SMSM-134 @verify-the-user-record-by-sorting-last-name-column 
	@When("User clicks the last name column")
	public void user_clicks_the_last_name_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_LastName);
	}

	@Then("the user records should be sorted in ascending order by lastname column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_lastname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_LastName.getAttribute("class").contains("asc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_LastName).contentEquals("AutoLAsc"));
	}

	@When("User clicks the last name column again")
	public void user_clicks_the_last_name_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_LastName);
	}

	@Then("the user records should be sorted in descending order by lastname column")
	public void the_user_records_should_be_sorted_in_descending_order_by_lastname_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_LastName.getAttribute("class").contains("desc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_LastName).contentEquals("Zazzi"));
	}

//	 @SMSM-134 @verify-the-user-record-by-sorting-status-column 
	@When("User clicks the status column")
	public void user_clicks_the_status_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Status);
	}

	@Then("the user records should be sorted in ascending order by status column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_status_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_Status.getAttribute("class").contains("asc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_Status).contentEquals("Disabled"));
	}

	@When("User clicks the status column again")
	public void user_clicks_the_status_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Status);
	}

	@Then("the user records should be sorted in descending order by status column")
	public void the_user_records_should_be_sorted_in_descending_order_by_status_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_Status.getAttribute("class").contains("desc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_Status).contentEquals("Active"));
	}

//	@SMSM-134 @verify-the-user-record-by-sorting-updated-column
	@When("User clicks the updated column")
	public void user_clicks_the_updated_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Updated);
	}

	@Then("the user records should be sorted in ascending order by updated column")
	public void the_user_records_should_be_sorted_in_ascending_order_by_updated_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_Updated.getAttribute("class").contains("asc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_Updated).contentEquals("02/20/2020"));
	}

	@When("User clicks the updated column again")
	public void user_clicks_the_updated_column_again() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.col_Updated);
	}

	@Then("the user records should be sorted in descending order by updated column")
	public void the_user_records_should_be_sorted_in_descending_order_by_updated_column() throws Exception {
		Assert.assertTrue(userManagementPage.col_Updated.getAttribute("class").contains("desc"));
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.sort_Updated).contentEquals("02/27/2020"));
	}

//	@SMSM-134 @Edit-a-user-from-user-management
	@When("user clicks on a User's Edit button under the Action column")
	public void user_clicks_on_a_User_s_Edit_button_under_the_Action_column() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.btn_UserEdit("AutoEdit"));
	}

	@Then("the Edit User page is displayed")
	public void the_Edit_User_page_is_displayed() throws Exception {
		Assert.assertEquals("Edit User", editUserPage.getElementText(editUserPage.pag_Title));
	}

	@When("user enters the information on the fields to be edited")
	public void user_enters_the_information_on_the_fields_to_be_edited() throws Exception {
		editUserPage.sendKeysToWebElement(editUserPage.txtF_LastName, "fonade");
		editUserPage.sendKeysToWebElement(editUserPage.txtF_PrimaryEmail, "jane@fonade.com");
		editUserPage.waitAndClickElement(editUserPage.btn_Status_Inactive);
	}

	@And("user toggles on some settings on the Edit User page")
	public void user_toggles_on_some_settings_on_the_Edit_User_page() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_Company);
		editUserPage.waitAndClickElement(editUserPage.tog_Plans);
	}

	@When("user clicks the Save User button")
	public void user_clicks_the_Save_User_button() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

	@Then("a notification that the details were saved successfully is displayed")
	public void a_notification_that_the_details_were_saved_successfully_is_displayed() throws Exception {
		Assert.assertTrue(editUserPage.getElementText(editUserPage.txt_Save_Alert_Notification)
				.contentEquals("Item has been successfully updated."));
	}

//	@SMSM-134 @Edit-a-user-from-user-management
	@When("User clicks the Dashborad menu")
	public void user_clicks_the_Dashborad_menu() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Dashboard);
	}

	@When("User clicks the Users menu")
	public void user_clicks_the_Users_menu() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Users);
	}

	@When("User searched for the editted record")
	public void user_searched_for_the_editted_record() throws Exception {
		manageBusinessPage.sendKeysToWebElement(manageBusinessPage.txtF_Search, "AutoEdit");
		manageBusinessPage.waitAndClickElement(manageBusinessPage.btn_Search);
	}

	@Then("User confirms the changes were saved correctly.")
	public void user_confirms_the_changes_were_saved_correctly() throws Exception {
		Assert.assertEquals("fonade",
				userManagementPage.getElementText(userManagementPage.selectColumnByName("fonade")));
		Assert.assertEquals("Disabled",
				userManagementPage.getElementText(userManagementPage.selectColumnByName("Disabled")));
	}

//	@Revert-changes-to-User-record
	@Then("User revert the changes")
	public void user_revert_the_changes() throws Exception {
		editUserPage.sendKeysToWebElement(editUserPage.txtF_LastName, "fona");
		editUserPage.sendKeysToWebElement(editUserPage.txtF_PrimaryEmail, "jane@fona.com");
		editUserPage.waitAndClickElement(editUserPage.btn_Status_Active);
		editUserPage.waitAndClickElement(editUserPage.tog_Company);
		editUserPage.waitAndClickElement(editUserPage.tog_Plans);
	}

//	@Create-a-test-user
	@When("User clicks the New button")
	public void user_clicks_the_New_button() throws InterruptedException {
		userManagementPage.waitAndClickElement(userManagementPage.btn_New);
	}

	@Then("the Create User page is opened")
	public void the_Create_User_page_is_opened() throws InterruptedException {
		Assert.assertEquals("Create User", createUserPage.getElementText(createUserPage.pag_Title));
	}

	@When("user types in the information for a test user and clicks the Save User button")
	public void user_types_in_the_information_for_a_test_user_and_clicks_the_Save_User_button() throws Exception {
		//Create instance of Random class
		Random rand = new Random();
		
		//Generate random integers within 0 t0 999
		int randNum = rand.nextInt(1000);
		
		createUserPage.sendKeysToWebElement(createUserPage.txtF_FirstName, "AutoDelete");
		createUserPage.sendKeysToWebElement(createUserPage.txtF_LastName, "Test");
		createUserPage.sendKeysToWebElement(createUserPage.txtF_PrimaryEmail, "test@Aclate" + randNum + ".com");
		createUserPage.sendKeysToWebElement(createUserPage.txtF_Password, "QA@vnet1");
		createUserPage.sendKeysToWebElement(createUserPage.txtF_CellPhone, "555-101-2020");
		createUserPage.waitAndClickElement(createUserPage.btn_Status_Active);
		createUserPage.waitAndClickElement(createUserPage.btn_SaveUser);
	}

	@Then("a notification that the user has been created is displayed")
	public void a_notification_that_the_user_has_been_created_is_displayed() throws InterruptedException {
		Assert.assertTrue(createUserPage.getElementText(createUserPage.txt_Action_Notification)
				.contentEquals("Item has been successfully created."));
	}

//	@SMSM-134 @Clicking-on-cancel-on-delete-user-popup-should-not-delete-the-user
	@When("user clicks on a User's dropdown button under the Action column")
	public void user_clicks_on_a_User_s_dropdown_button_under_the_Action_column() throws Exception {
		userManagementPage.sendKeysToWebElement(userManagementPage.txtF_Search, "AutoDelete");
		userManagementPage.waitAndClickElement(userManagementPage.btn_Search);
		userManagementPage.waitAndClickElement(userManagementPage.btn_ActionDropdown("AutoDelete"));
	}

	@Then("the Actions option is displayed")
	public void the_Actions_option_is_displayed() {
		Assert.assertTrue(userManagementPage.btn_DropdownDeleteOpt("AutoDelete").isDisplayed());
	}

	@When("User clicks the Delete option")
	public void user_clicks_the_Delete_option() throws Exception {
		userManagementPage.waitAndClickElement(userManagementPage.btn_DropdownDeleteOpt("AutoDelete"));
	}

	@Then("the Delete User modal is displayed")
	public void the_Delete_User_modal_is_displayed() throws Exception {
		Assert.assertEquals("Delete User", deleteUserModal.getElementText(deleteUserModal.mod_Title));
	}

	@When("user clicks the Cancel button on the Delete User modal")
	public void user_clicks_the_Cancel_button_on_the_Delete_User_modal() throws Exception {
		deleteUserModal.waitAndClickElement(deleteUserModal.btn_Cancel);
	}

	@Then("confirms that the user is not deleted")
	public void confirms_that_the_user_is_not_deleted() throws Exception {
		userManagementPage.sendKeysToWebElement(userManagementPage.txtF_Search, "AutoDelete");
		userManagementPage.waitAndClickElement(userManagementPage.btn_Search);
		Assert.assertTrue(userManagementPage.selectColumnByName("AutoDelete").isDisplayed());
	}

//	@SMSM-134 @User-can-be-deleted-from-user-management-page
	@When("user clicks the Delete button on the Delete User modal")
	public void user_clicks_the_Delete_button_on_the_Delete_User_modal() throws Exception {
		deleteUserModal.waitAndClickElement(deleteUserModal.btn_Delete);
	}

	@Then("a notification confirming successfully deletion is displayed.")
	public void a_notification_confirming_successfully_deletion_is_displayed() throws Exception {
		Assert.assertTrue(userManagementPage.getElementText(userManagementPage.txt_Action_Notification).contentEquals("Item has been successfully deleted."));
	}

//	@SMSM-134 @Verfy-that-deleted-user-is-not-displayed-on-user-management-page
	@When("the deleted username is typed into the search field and the search button is clicked")
	public void the_deleted_username_is_typed_into_the_search_field_and_the_search_button_is_clicked() throws Exception {
		userManagementPage.sendKeysToWebElement(userManagementPage.txtF_Search, "AutoDelete");
		userManagementPage.waitAndClickElement(userManagementPage.btn_Search);
	}

	@Then("no result should be displayed.")
	public void no_result_should_be_displayed() throws Exception {
		boolean result = true;
		try {
			Assert.assertTrue(userManagementPage.selectColumnByName("AutoDelete").isDisplayed());
		} catch (NoSuchElementException NSE) {
			result = false;
			Assert.assertFalse(result);
		}
	}

}
