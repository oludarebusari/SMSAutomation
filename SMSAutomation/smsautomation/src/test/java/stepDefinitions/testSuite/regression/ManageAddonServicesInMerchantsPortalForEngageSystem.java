package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.engage.EngageDashboardPage;
import pageObjects.engage.ManageSitesPage;
import pageObjects.license.AddOnGiftbarPage;
import pageObjects.license.AdvertisersPage;
import pageObjects.license.LicAdminPage;
import pageObjects.license.SubscriberViewPage;
import pageObjects.license.SubscribersPage;
import pageObjects.license.menu.AddOnServicesSubMenu;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.modal.SendMessageModal;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ManageAddonServicesInMerchantsPortalForEngageSystem extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();

	AddOnServicesSubMenu addOnServicesSubMenu = PageFactory.initElements(driver, AddOnServicesSubMenu.class);
	AddOnGiftbarPage addOnGiftbarPage = PageFactory.initElements(driver, AddOnGiftbarPage.class);
	AdvertisersPage advertisersPage = PageFactory.initElements(driver, AdvertisersPage.class);
	EngageDashboardPage engDashboard = PageFactory.initElements(driver, EngageDashboardPage.class);
	LicAdminPage licAdminPage = PageFactory.initElements(driver, LicAdminPage.class);
	ManageSitesPage manageSitesPage = PageFactory.initElements(driver, ManageSitesPage.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	SubscribersPage subscribersPage = PageFactory.initElements(driver, SubscribersPage.class);
	SubscriberViewPage subscriberViewPage = PageFactory.initElements(driver, SubscriberViewPage.class);
	SendMessageModal sendMessageModal = PageFactory.initElements(driver, SendMessageModal.class);

	// @SMSM-131-Check-Manage-Page-Content, @RegressionTest
	@Then("User checks the page content \\(Title, list of Resellers, search and Status)")
	public void user_checks_the_page_content_Title_list_of_Resellers_search_and_Status() throws Exception {
		Assert.assertTrue(driver.getTitle().contentEquals("Engage Dashboard"));
		Assert.assertTrue(engDashboard.txtF_Search.isDisplayed());
		Assert.assertTrue(engDashboard.table_Reseller.isDisplayed());
	}

	@Then("User confirms the possibility to Copy to clipboard and export to csv")
	public void user_confirms_the_possibility_to_Copy_to_clipboard_and_export_to_csv() {
		Assert.assertTrue(engDashboard.btn_Copy.isDisplayed());
		Assert.assertTrue(engDashboard.btn_CSV.isDisplayed());
	}

	@Then("user is redirected to the manage site page")
	public void user_is_redirected_to_the_manage_site_page() throws Exception {
		Assert.assertTrue(manageSitesPage.getElementText(manageSitesPage.pag_Title).contentEquals("Manage Resellers"));
		Assert.assertTrue(manageSitesPage.SearchTxtF.isDisplayed());
		Assert.assertTrue(manageSitesPage.table_Reseller.isDisplayed());
		Assert.assertTrue(manageSitesPage.btn_Copy.isDisplayed());
		Assert.assertTrue(manageSitesPage.btn_CSV.isDisplayed());
	}

	// @SMSM-131-Review-Bussiness-Page-Content, @RegressionTest
	@Then("User verify the contents - Search textbox, New button, Show Terminated button and table grid")
	public void user_verify_the_contents_Search_textbox_New_button_Show_Terminated_button_and_table_grid() {
		Assert.assertTrue(advertisersPage.txt_SearchTxtF.isDisplayed());
		Assert.assertTrue(advertisersPage.btn_New.isDisplayed());
		Assert.assertTrue(advertisersPage.btn_Show_Terminated.isDisplayed());
		Assert.assertTrue(advertisersPage.table_Businesses.isDisplayed());
	}

	@Then("User confirms the Table Grid elements")
	public void user_confirms_the_Table_Grid_elements() {
		Assert.assertTrue(advertisersPage.btn_Copy.isDisplayed());
		Assert.assertTrue(advertisersPage.btn_CSV.isDisplayed());
		Assert.assertTrue(advertisersPage.con_Pagination.isDisplayed());
	}

	@Then("User confirms the Table columns")
	public void user_confirms_the_Table_columns() throws InterruptedException {
		Assert.assertEquals("ID", advertisersPage.getElementText(advertisersPage.col_ID));
		Assert.assertEquals("Business Contact", advertisersPage.getElementText(advertisersPage.col_Business_Contact));
		Assert.assertEquals("Business Name", advertisersPage.getElementText(advertisersPage.col_Business_Name));
		Assert.assertEquals("City, State", advertisersPage.getElementText(advertisersPage.col_City_Sate));
		Assert.assertEquals("Phone", advertisersPage.getElementText(advertisersPage.col_Phone));
		Assert.assertEquals("Plan", advertisersPage.getElementText(advertisersPage.col_Plan));
		Assert.assertEquals("Billing Type", advertisersPage.getElementText(advertisersPage.col_Billing_Type));
		Assert.assertEquals("Status", advertisersPage.getElementText(advertisersPage.col_Status));
		Assert.assertEquals("Text Number", advertisersPage.getElementText(advertisersPage.col_Text_Number));
		Assert.assertEquals("Action", advertisersPage.getElementText(advertisersPage.col_Action));
	}

//	@SMSM-131-Opening-Subscribers-Page, @RegressionTest

	@Then("User verifies that the Subscribers menu is present")
	public void user_verifies_that_the_Subscribers_menu_is_present() {
		Assert.assertTrue(merchantMenu.menu_Subscribers.isDisplayed());
	}

	@When("User clicks the Subscribers menu")
	public void user_clicks_the_Subscribers_menu() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Subscribers);
	}

	@Then("the Subscribers page is opened")
	public void the_Subscribers_page_is_opened() throws Exception {
		Assert.assertTrue(subscribersPage.getElementText(subscribersPage.pag_Title).contentEquals("Subscribers"));
	}

	@Then("User verifies the list of Subscribers")
	public void user_verifies_the_list_of_Subscribers() throws NumberFormatException, Exception {
		Assert.assertTrue(Integer.parseInt(subscribersPage.getElementText(subscribersPage.num_Subscribers).substring(7, 8)) > 0);
	}

//	 @SMSM-131-Send-Meesage-To-Reply-Subscriber, @RegressionTest
	@When("user types in a subscriber's name in the textbox and click Get Result button")
	public void user_types_in_a_subscriber_s_name_in_the_textbox_and_click_Get_Result_button() {

	}

	@Then("the Subscriber is displayed")
	public void the_Subscriber_is_displayed() {

	}

	@When("user clicks the view button for the Subcriber")
	public void user_clicks_the_view_button_for_the_Subcriber() {

	}

	@Then("the Subscriber View page is opened")
	public void the_Subscriber_View_page_is_opened() {

	}

	@When("user clicks the Send Message button")
	public void user_clicks_the_Send_Message_button() {

	}

	@Then("the Send message window is opened")
	public void the_Send_message_window_is_opened() {

	}

	@When("user enters a message and click Send button")
	public void user_enters_a_message_and_click_Send_button() {

	}

	@Then("Message sent notification is displayed on the Subscriber View page")
	public void message_sent_notification_is_displayed_on_the_Subscriber_View_page() {

	}

//	 @SMSM-200-Verify-the-Giftbar-Profile,, @RegressionTest
	@When("User clicks the Manage Resellers menubar option")
	public void user_clicks_the_Manage_Resellers_menubar_option() throws Exception {

		if (reader.getConfigValue("DriverConfig", "environment").equals("remoteHub")) {
			manageSitesPage.waitAndClickElement(manageSitesPage.tog_Navbar);
		}

		manageSitesPage.waitAndClickElement(manageSitesPage.menu_Manage_Resellers);
	}

	@When("User logs in to a reseller")
	public void user_logs_in_to_a_reseller() throws Exception {
		manageSitesPage.sendKeysToWebElement(manageSitesPage.SearchTxtF, "test");
		manageSitesPage.waitAndClickElement(manageSitesPage.loginAS("smsmmtest ", "SUPER"));
	}

	@And("User is redirected to the Engaged Admin Dashboard page")
	public void user_is_redirected_to_the_Engaged_Admin_Dashboard_page() throws Exception {
		manageSitesPage.switchWindow();
		Assert.assertEquals(manageSitesPage.getCurrentURL(), reader.getConfigValue("GeneralSettings", "licBaseURL"));
	}

	@Then("User clicks Business tabs at the left side")
	public void user_clicks_Business_tabs_at_the_left_side() throws Exception {
		/*
		 * if (reader.getConfigValue("DriverConfig", "environment").equals("localHub"))
		 * { licAdminPage.clickCloseUpdateStatusOfBusinesses();
		 * licAdminPage.waitForBusinessesDialogToDisappear(); }
		 */
		licAdminPage.waitAndClickElement(licAdminPage.menu_Businesses);
	}

	@Then("the Businesses page is opened")
	public void the_Businesses_page_is_opened() throws Exception {
		Assert.assertTrue(advertisersPage.getElementText(advertisersPage.page_Heading).contentEquals("Businesses"));
	}

	@Then("Users click Login tab for a merchant")
	public void users_click_Login_tab_for_a_merchant() throws Exception {
		advertisersPage.waitAndClickElement(advertisersPage.getLoginBtnByBusinessContact("QA, Aclate"));
	}

	@Then("the user is redirected to a new window of Merchant's Dashboard")
	public void the_user_is_redirected_to_a_new_window_of_Merchant_s_Dashboard() {
		merchantMenu.switchWindow();
		Assert.assertEquals(manageSitesPage.getCurrentURL(), "https://www.smsmmtest.com/advertisercpanel/");
	}

	@Then("User verifies that Add-On Services menu is available")
	public void user_verifies_that_Add_On_Services_menu_is_available() throws Exception {
		Assert.assertTrue(
				merchantMenu.getElementText(merchantMenu.menu_Add_On_Services).contentEquals("Add-On Services"));
	}

	@Then("User clicks the Add-On Services menu option")
	public void user_clicks_the_Add_On_Services_menu_option() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Add_On_Services);
	}

	@Then("the Giftbar menu option is displayed")
	public void the_Giftbar_menu_option_is_displayed() throws Exception {
		Assert.assertTrue(
				addOnServicesSubMenu.getElementText(addOnServicesSubMenu.menu_Giftbar).contentEquals("Giftbar"));
	}

	@When("User clicks the Giftbar menu option")
	public void user_clicks_the_Giftbar_menu_option() throws Exception {
		addOnServicesSubMenu.waitAndClickElement(addOnServicesSubMenu.menu_Giftbar);
	}

	@Then("the giftbar page is opened")
	public void the_giftbar_page_is_opened() throws Exception {
		Assert.assertTrue(addOnGiftbarPage.getElementText(addOnGiftbarPage.page_Title).contentEquals("Giftbar"));
	}

	@Then("User clicks the Interested button")
	public void user_clicks_the_Interested_button() throws Exception {
		addOnGiftbarPage.waitAndClickElement(addOnGiftbarPage.btn_Giftbar_Interested);
	}

	@Then("an interest notification is sent message is displayed")
	public void an_interest_notification_is_sent_message_is_displayed() throws Exception {
		Assert.assertTrue(addOnGiftbarPage.getElementText(addOnGiftbarPage.msg_Giftbar_Notification)
				.contentEquals("Thanks — a notification was sent about your interest!"));
	}

}
