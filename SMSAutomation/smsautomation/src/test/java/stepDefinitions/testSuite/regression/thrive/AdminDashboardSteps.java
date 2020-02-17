package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.modal.ResellerLoggedInSettingsModal;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.EditResellerPage;
import pageObjects.thrive.ResellerPage;
import pageObjects.thrive.modal.CancelServicesModal;
import utils.DriverFactory;

public class AdminDashboardSteps extends DriverFactory {

	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	public CancelServicesModal cancelServicesModal = PageFactory.initElements(driver, CancelServicesModal.class);
	public EditResellerPage editResellerPage = PageFactory.initElements(driver, EditResellerPage.class);
	public ResellerPage resellerPage = PageFactory.initElements(driver, ResellerPage.class);
	public ResellerLoggedInSettingsModal resellerLoggedInModal = PageFactory.initElements(driver, ResellerLoggedInSettingsModal.class);
	

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
	thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn("Business"));
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

	@When("User clicks on the Sing Out option")
	public void user_clicks_on_the_Sing_Out_option() throws Exception {
	resellerLoggedInModal.waitAndClickElement(resellerLoggedInModal.mod_SignOut);
	}

	@Then("user is redirected to the Admin Dashboard page")
	public void user_is_redirected_to_the_Admin_Dashboard_page() throws Exception {
	Assert.assertEquals("New Resellers", thrDashboardPage.getElementText(thrDashboardPage.panel_Reseller_Title));
	}
	
//	 @SMSM-203 @Verify-the-options-and-link-from-the-Action-dropdown @RegressionTest
	@When("User clicks a Reseller action dropdown")
	public void user_clicks_a_Reseller_action_dropdown() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("Business"));
	}

	@Then("User verifies the two Action options displayed")
	public void user_verifies_the_two_Action_options_displayed() {
	 Assert.assertTrue(thrDashboardPage.btn_Edit_Reseller_Company("Business").isDisplayed());
	 Assert.assertTrue(thrDashboardPage.btn_Cancel_Services("Business").isDisplayed());
	}
	
	@When("user clicks the Edit Reseller Company option")
	public void user_clicks_the_Edit_Reseller_Company_option() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Edit_Reseller_Company("Business"));
	}

	@Then("user is redirected to the Edit Reseller page")
	public void user_is_redirected_to_the_Edit_Reseller_page() throws Exception {
	  Assert.assertTrue(editResellerPage.pag_Title.isDisplayed());
	  driver.navigate().back();
	}

	@When("User clicks on Cancel Services options")
	public void user_clicks_on_Cancel_Services_options() throws Exception {
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_SignIn_Dropdown("Business"));
		thrDashboardPage.waitAndClickElement(thrDashboardPage.btn_Cancel_Services("Business"));
	}

	@Then("the Cancel services window is displayed")
	public void the_Cancel_services_window_is_displayed() throws Exception {
		Assert.assertEquals("Cancel Services", cancelServicesModal.getElementText(cancelServicesModal.mod_Title));
	}
}
