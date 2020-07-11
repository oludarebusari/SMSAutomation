package stepDefinitions.testSuite.regression.engage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class OptionsUnderSubscribersInMerchantsPortal extends DriverFactory {

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
	
	public List<WebElement> licenseLogin = driver.findElements(By.xpath(manageSitesPage.licenseLoginLocator));

//  @SMSM-131-Verify-that-user-is-able-to-check-Manage-Resellers-page-content, @RegressionTest
	@Then("User checks the page content Title, list of Resellers, search and Status")
	public void user_checks_the_page_content_Title_list_of_Resellers_search_and_Status() {
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
	
	@Then("User verifies the columns of the table of columns")
	public void user_verifies_the_columns_of_the_table_of_columns() {
	   Assert.assertTrue(manageSitesPage.colByName("Reseller").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("Login").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("Status").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("Reseller ID").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("Timezone").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("Shortcode").isDisplayed());
	   Assert.assertTrue(manageSitesPage.colByName("CC Process ").isDisplayed());
	}
	
	@Then("User verifiles the license logins are enabled")
	public void user_verifiles_the_license_logins_are_enabled() throws Exception {
		for (int i = 0; i < driver.findElements(By.xpath(manageSitesPage.licenseLoginLocator)).size(); i++) {
			Assert.assertTrue(driver.findElements(By.xpath(manageSitesPage.licenseLoginLocator)).get(i).isEnabled());
		}
		System.out.println("Loop over " + driver.findElements(By.xpath(manageSitesPage.licenseLoginLocator)).size() + " is done");
	}


//  @SMSM-131-Verify-that-user-is-able-to-review-Businesses-page-content, @RegressionTest
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
	
//	@SMSM-131-Verify-that-user-is-able-to-view-list-of-Subscribers, @RegressionTest
	@When("User clicks the Subscribers menu")
	public void user_clicks_the_Subscribers_menu() throws Exception {	
		merchantMenu.waitAndClickElement(merchantMenu.menu_Subscribers);
	}

	@Then("the Subscribers page is opened")
	public void the_Subscribers_page_is_opened() throws Exception {
		Assert.assertTrue(subscribersPage.getElementText(subscribersPage.pag_Title).contentEquals("Subscribers"));
	}
	//div[contains(@class, "option") and text()="Test 3 (Enabled) (Test03)"]
	@Then("User verifies the list of Subscribers")
	public void user_verifies_the_list_of_Subscribers() throws NumberFormatException, Exception {
		subscribersPage.waitAndClickElement(subscribersPage.campaignDDown);
		subscribersPage.waitAndClickElement(subscribersPage.campaignOpt("Test 3 (Enabled) (Test03)"));
		Assert.assertTrue(
				Integer.parseInt(subscribersPage.getElementText(subscribersPage.num_Subscribers).substring(7, 9).trim()) > 0);
	}

//	 @SMSM-131-Send-Meesage-To-Reply-Subscriber, @RegressionTest
	@When("user clicks the Reply button")
	public void user_clicks_the_Reply_button() throws Exception {
		subscribersPage.waitAndClickElement(subscribersPage.btn_Reply("555-555-5549"));
	}

	@Then("The Send Message window is displayed")
	public void the_Send_Message_window_is_displayed() throws Exception {
		Assert.assertTrue(sendMessageModal.getElementText(sendMessageModal.mod_Title).contentEquals("Send Message"));
	}

	@When("User clicks the Send as MMS toggle and fill in the required fields")
	public void user_clicks_the_Send_as_MMS_toggle_and_fill_in_the_required_fields() throws Exception {
		sendMessageModal.waitAndClickElement(sendMessageModal.tog_Send_As_MMS);
		sendMessageModal.sendKeysToWebElement(sendMessageModal.txt_Introduction, "Hello");
		sendMessageModal.sendKeysToWebElement(sendMessageModal.txt_Message, "Test");
	}

	@When("User clicks on the Send button")
	public void user_clicks_on_the_Send_button() throws Exception {
		sendMessageModal.waitAndClickElement(sendMessageModal.btn_Send);
	}

	@Then("a message sent notification is displayed.")
	public void a_message_sent_notification_is_displayed() throws Exception {
		System.out.println(subscribersPage.getElementText(subscribersPage.txt_Notification));
		Assert.assertEquals("×Message has been sent.",
				subscribersPage.getElementText(subscribersPage.txt_Notification).replaceAll("[\\n]", ""));
	}

//	@SMSM-200-Verify-the-Giftbar-Profile,, @RegressionTest
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

		
		  if (reader.getConfigValue("DriverConfig", "environment").equals("localHub"))  {
			  licAdminPage.waitAndClickElement(licAdminPage.win_Update_Status_Of_Business);
			  licAdminPage.waitForBusinessesDialogToDisappear(); 
		  
		  }
		 

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
	
//	@SMSM-200-Verify-that-user-is-able-to-Blacklist,-unsubscribe-with-text-and-without-text
	@When("User clicks the dropdown under Action column of a subscriber")
	public void user_clicks_the_dropdown_under_Action_column_of_a_subscriber() throws Exception {
	   subscribersPage.waitAndClickElement(subscribersPage.btn_Reply_Dropdown("447-744-7785"));
	}

	@Then("User verifies that Blacklist option is available")
	public void user_verifies_that_Blacklist_option_is_available() {
	   Assert.assertTrue(subscribersPage.opt_ReplyDDown("447-744-7785", "Blacklist").isDisplayed());
	}

	@Then("User verifies that Unsubscribe with text is available")
	public void user_verifies_that_Unsubscribe_with_text_is_available() {
		Assert.assertTrue(subscribersPage.opt_ReplyDDown("447-744-7785", "Unsubscribe w/ Text").isDisplayed());
	}

	@Then("User verifies that Unsubscribe without Text is available")
	public void user_verifies_that_Unsubscribe_without_Text_is_available() {
		Assert.assertTrue(subscribersPage.opt_ReplyDDown("447-744-7785", "Unsubscribe w/o Text").isDisplayed());
	}

//	@SMSM-200-Verify-that-user-is-able-to-Bulk-edit
	@Then("User selects one or more Subscribers")
	public void user_selects_one_or_more_Subscribers() throws Exception {
		subscribersPage.waitAndClickElement(subscribersPage.selectSubscriber("447-744-7785"));
		subscribersPage.waitAndClickElement(subscribersPage.selectSubscriber("555-555-5569"));
	}

	@Then("the Bulk Edit button is enabled")
	public void the_Bulk_Edit_button_is_enabled() {
	 Assert.assertTrue(subscribersPage.btn_Bulk_Edit.isEnabled());
	}

	@When("User clicks the Bulk Edit button")
	public void user_clicks_the_Bulk_Edit_button() throws Exception {
		subscribersPage.waitAndClickElement(subscribersPage.btn_Bulk_Edit);
	}

	@Then("User verifies the options Under the Bulk Edit button")
	public void user_verifies_the_options_Under_the_Bulk_Edit_button() {
		Assert.assertTrue(subscribersPage.opt_BulkEdit("Reply to Selected").isDisplayed());
		Assert.assertTrue(subscribersPage.opt_BulkEdit("Unsubscribe Selected w/ Text").isDisplayed());
		Assert.assertTrue(subscribersPage.opt_BulkEdit("Unsubscribe Selected w/o Text").isDisplayed());
		Assert.assertTrue(subscribersPage.opt_BulkEdit("Blacklist Selected").isDisplayed());
	}

	@When("User selects Reply to selected option")
	public void user_selects_Reply_to_selected_option() throws Exception {
	  subscribersPage.waitAndClickElement(subscribersPage.opt_BulkEdit("Reply to Selected"));
	}
	
	@When("User types in a message into the Message textarea")
	public void user_types_in_a_message_into_the_Message_textarea() throws Exception {
		sendMessageModal.sendKeysToWebElement(sendMessageModal.txt_Message, "This is automation text");
		sendMessageModal.waitAndClickElement(sendMessageModal.btn_Send);
	}

	@Then("a success notification message is displayed")
	public void a_success_notification_message_is_displayed() throws Exception {
		Assert.assertEquals("×Message has been sent.",
				subscribersPage.getElementText(subscribersPage.txt_Notification).replaceAll("[\\n]", ""));
	}

//	@SMSM-200-Verify-that-user-is-able-to-Search-for-any-subscriber
	@When("User enters a string into the search box")
	public void user_enters_a_string_into_the_search_box() {
	 
	}

	@Then("user confirms the record is displayed")
	public void user_confirms_the_record_is_displayed() {
	    
	}

	@Then("User confirms the Table Header")
	public void user_confirms_the_Table_Header() {
	 
	}

	@Then("User confirms the Table content")
	public void user_confirms_the_Table_content() {
	
	}

	
}
