package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.modal.ResellerLoggedInSettingsModal;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.EditResellerPage;
import pageObjects.thrive.ManageResellerPage;
import pageObjects.thrive.ResellerPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.modal.CancelServicesModal;
import pageObjects.thrive.modal.EnableServicesModal;
import utils.DriverFactory;

public class AdminDashboardSteps extends DriverFactory {

	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	public CancelServicesModal cancelServicesModal = PageFactory.initElements(driver, CancelServicesModal.class);
	public CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	public EditResellerPage editResellerPage = PageFactory.initElements(driver, EditResellerPage.class);
	public EnableServicesModal enableServicesModal = PageFactory.initElements(driver, EnableServicesModal.class);
	public ManageResellerPage manageResellerPage = PageFactory.initElements(driver, ManageResellerPage.class);
	public ResellerPage resellerPage = PageFactory.initElements(driver, ResellerPage.class);
	public ResellerLoggedInSettingsModal resellerLoggedInModal = PageFactory.initElements(driver,
			ResellerLoggedInSettingsModal.class);

//  @SMSM-203 @Verify-User-is-landed-on-AdminDashboard-page @RegressionTest
	@Then("User verifies the Dashboard title is available")
	public void user_verifies_the_Dashboard_title_is_available() {
		Assert.assertTrue(thrDashboardPage.pag_Title.isDisplayed());
	}

	@Then("user verifies the Reseller list is available")
	public void user_verifies_the_Reseller_list_is_available() throws NumberFormatException, InterruptedException {
		Assert.assertTrue(thrDashboardPage.list_Reseller.isDisplayed());
		Assert.assertTrue(Integer.parseInt(thrDashboardPage.getElementText(thrDashboardPage.num_Reseller)) > 0);
	}

	@Then("User verifies the Resellers tab is available")
	public void user_verifies_the_Resellers_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.reseller_Summary.isDisplayed());
	}

	@Then("user verifies the Business tab is available")
	public void user_verifies_the_Business_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.business_Summary.isDisplayed());
	}

	@Then("User verifies the Social Post is available")
	public void user_verifies_the_Social_Post_is_available() {
		Assert.assertTrue(thrDashboardPage.socialPost_Summary.isDisplayed());
	}

	@Then("User verifies the Revenue tab is available")
	public void user_verifies_the_Revenue_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.revenue_Summary.isDisplayed());
	}

	@Then("User verifies the Help button is available")
	public void user_verifies_the_Help_button_is_available() {
		Assert.assertTrue(thrDashboardPage.btn_Help.isDisplayed());
	}

//	@SMSM-203 @Verify-all-reseller-data @RegressionTest
	@Then("User verifies company column is available")
	public void user_verifies_company_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Company.isDisplayed());
	}

	@Then("user verifies Location column is available")
	public void user_verifies_Location_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Locaton.isDisplayed());
	}

	@Then("User verifies Phone column is available")
	public void user_verifies_Phone_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Phone.isDisplayed());
	}

	@Then("user verifies Support email column is available")
	public void user_verifies_Support_email_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_SupportEmail.isDisplayed());
	}

	@Then("User verifies Created date column is available")
	public void user_verifies_Created_date_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Created.isDisplayed());
	}

	@Then("User verifies Action column is available")
	public void user_verifies_Action_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Action.isDisplayed());
	}

//	@SMSM-203 @Verify-the-user-is-on-Licensee-Dashboard @RegressionTest
	@When("User clicks the SignIn button on a Reseller")
	public void user_clicks_the_SignIn_button_on_a_Reseller() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn("AutomationQA"));
	}

	@Then("the Reseller page is opened")
	public void the_Reseller_page_is_opened() throws Exception {
		Assert.assertEquals("New Businesses", resellerPage.getElementText(resellerPage.pag_Title));
	}

	@Then("User verifies the Merchant list")
	public void user_verifies_the_Merchant_list() {
		Assert.assertTrue(resellerPage.panel_Business.isDisplayed());
	}

	@Then("User verifies the late payment tab")
	public void user_verifies_the_late_payment_tab() {
		Assert.assertTrue(resellerPage.tab_Late_Payments.isDisplayed());
	}

	@Then("User verifies the Pending Payments tab")
	public void user_verifies_the_Pending_Payments_tab() {
		Assert.assertTrue(resellerPage.tab_Late_Pending_Payments.isDisplayed());
	}

	@Then("User verifies the Payment Received tab")
	public void user_verifies_the_Payment_Received_tab() {
		Assert.assertTrue(resellerPage.tab_Late_Payments_Received.isDisplayed());
	}

	@Then("User verifies the Revenue tab")
	public void user_verifies_the_Revenue_tab() {
		Assert.assertTrue(resellerPage.tab_Late_Payments_Received_Revenue.isDisplayed());
	}

//	 @SMSM-203 @Verify-the-user-is-able-to-log-out-from-Resellee @RegressionTest @OnlyMe
	@Then("user verifies the login user link is available")
	public void user_verifies_the_login_user_link_is_available() {
		Assert.assertTrue(resellerPage.drpD_LoggedInUser.isDisplayed());
	}

	@When("User clicks on the logged In user dropdown link")
	public void user_clicks_on_the_logged_In_user_dropdown_link() throws InterruptedException {
		resellerPage.waitAndClickElement(resellerPage.drpD_LoggedInUser);
	}

	@Then("the dropdown is opened")
	public void the_dropdown_is_opened() {
		Assert.assertTrue(resellerPage.menu_LoggedInUser.isDisplayed());
	}

	@Then("User verifies that Sign Out option is available")
	public void user_verifies_that_Sign_Out_option_is_available() {
		Assert.assertTrue(resellerLoggedInModal.mod_SignOut.isDisplayed());
	}

	@When("User clicks on the Sign Out option")
	public void user_clicks_on_the_Sign_Out_option() throws Exception {
		resellerLoggedInModal.waitAndClickElement(resellerLoggedInModal.mod_SignOut);
	}

	@Then("user is redirected to the Admin Dashboard page")
	public void user_is_redirected_to_the_Admin_Dashboard_page() throws Exception {
		Assert.assertEquals("New Resellers", thrDashboardPage.getElementText(thrDashboardPage.panel_Reseller_Title));
	}

//	 @SMSM-203 @Verify-the-options-and-link-from-the-Action-dropdown @RegressionTest
	@When("User clicks a Reseller action dropdown")
	public void user_clicks_a_Reseller_action_dropdown() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("AutomationQA"));
	}

	@Then("User verifies two Action options are displayed")
	public void user_verifies_two_Action_options_are_displayed() {
		Assert.assertTrue(thrDashboardPage.btn_Edit_Reseller_Company("AutomationQA").isDisplayed());
		Assert.assertTrue(thrDashboardPage.btn_Cancel_Services("AutomationQA").isDisplayed());
	}

	@When("user clicks the Edit Reseller Company option")
	public void user_clicks_the_Edit_Reseller_Company_option() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Edit_Reseller_Company("AutomationQA"));
	}

	@Then("user is redirected to the Edit Reseller page")
	public void user_is_redirected_to_the_Edit_Reseller_page() throws Exception {
		Assert.assertTrue(editResellerPage.pag_Title.isDisplayed());
	}

	@When("User clicks the Dashboard menu option")
	public void user_clicks_the_Dashboard_menu_option() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.tab_Dashboard);
	}

	@Then("the Admin Dashboard page is displayed")
	public void the_Admin_Dashboard_page_is_displayed() throws InterruptedException {
		Assert.assertEquals("New Resellers", thrDashboardPage.getElementText(thrDashboardPage.panel_Reseller_Title));
	}

	@When("User clicks on Cancel Services options")
	public void user_clicks_on_Cancel_Services_options() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("AutomationQA"));
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Cancel_Services("AutomationQA"));
	}

	@Then("the Cancel services window is displayed")
	public void the_Cancel_services_window_is_displayed() throws Exception {
		Assert.assertEquals("Cancel Services", cancelServicesModal.getElementText(cancelServicesModal.mod_Title));
	}

//	 @SMSM-203 @Verify-the-user-can-edit-the-Reseller-details @RegressionTest
	@When("Edits some of the Resellers details")
	public void edits_some_of_the_Resellers_details() throws Exception {
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessName, "AutomationTesting");
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessPhone, "555-444-1827");
	}

	@When("User clicks the Save Reseller's button")
	public void user_clicks_the_Save_Reseller_s_button() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.btn_Save_Reseller);
	}

	@Then("a message indicating the Reseller has been updated is displayed")
	public void a_message_indicating_the_Reseller_has_been_updated_is_displayed() throws Exception {
		Assert.assertEquals("This company has been successfully updated.",
				editResellerPage.getElementText(editResellerPage.alert_SuccessNotification).replace("Close", "")
						.replaceAll("[×\\n]", ""));
	}

	@When("User clicks the Dashboard menu")
	public void user_clicks_the_Dashboard_menu() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.tab_Dashboard);
	}

	@Then("User is redirected to the Dashboard and and confirms changes to Reseller")
	public void user_is_redirected_to_the_Dashboard_and_and_confirms_changes_to_Reseller() throws Exception {
		Assert.assertTrue(thrDashboardPage.getElementText(thrDashboardPage.txt_CompanyName("AutomationTesting"))
				.contentEquals("AutomationTesting"));
		Assert.assertTrue(thrDashboardPage.getElementText(thrDashboardPage.txt_PhoneNumber("555-444-1827"))
				.contentEquals("555-444-1827"));
	}

	@Then("User revert changes")
	public void user_revert_changes() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("AutomationTesting"));
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Edit_Reseller_Company("AutomationTesting"));
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessName, "AutomationQA");
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessPhone, "555-555-1827");
		editResellerPage.waitAndClickElement(editResellerPage.btn_Save_Reseller);
		thrDashboardPage.waitAndClickElement(thrDashboardPage.tab_Dashboard);
	}

//	 @SMSM-203 @Verify-the-admin-can-cancel-service @RegressionTest
	@When("User selects a reseller to cancel and clicks the action dropdown button")
	public void user_selects_a_reseller_to_cancel_and_clicks_the_action_dropdown_button() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("Automation1"));
	}

	@When("user clicks the Cancel services option")
	public void user_clicks_the_Cancel_services_option() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Cancel_Services("Automation1"));
	}

	@When("User clicks the Cancel Services button")
	public void user_clicks_the_Cancel_Services_button() throws Exception {
		cancelServicesModal.waitAndClickElement(cancelServicesModal.btn_Cancel_Services);
	}

	@Then("the Manage Resellers page is displayed")
	public void the_Manage_Resellers_page_is_displayed() throws Exception {
		Assert.assertTrue(
				manageResellerPage.getElementText(manageResellerPage.pag_Title).contentEquals("Manage Resellers"));
	}

	@When("User types the Resellers name on the search textfield and click Search button")
	public void user_types_the_Resellers_name_on_the_search_textfield_and_click_Search_button() throws Exception {
		manageResellerPage.sendKeysToWebElement(manageResellerPage.txtF_Search, "Automation1");
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Search);
	}

	@Then("the reseller is displayed")
	public void the_reseller_is_displayed() {
		Assert.assertTrue(manageResellerPage.opt_Reseller("Automation1").isDisplayed());
	}

	@Then("User verifies the new status of the Reseller")
	public void user_verifies_the_new_status_of_the_Reseller() throws Exception {
		Assert.assertTrue(manageResellerPage.getElementText(manageResellerPage.txt_Status("Automation1"))
				.contentEquals("Disabled"));
	}

	@When("User Clicks the Dashboard menu")
	public void user_Clicks_the_Dashboard_menu() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.tab_Dashboard);
	}

	@Then("User verifies that the cancelled reseller services is not displayed")
	public void user_verifies_that_the_cancelled_reseller_services_is_not_displayed() {
		boolean result = true;
		try {
			thrDashboardPage.opt_Reseller("Automation1");
		} catch (NoSuchElementException NSE) {
			result = false;
		}
		Assert.assertFalse(result);
	}

	@Then("Revert Changes")
	public void revert_Changes() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.tab_Companies);
		companiesDDown.waitAndClickElement(companiesDDown.opt_Resellers);
		manageResellerPage.sendKeysToWebElement(manageResellerPage.txtF_Search, "Automation1");
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Search);
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Edit_Dropdown("Automation1"));
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Enable_Services("Automation1"));
		enableServicesModal.waitAndClickElement(enableServicesModal.btn_Enable_Services);
		
	}

}
