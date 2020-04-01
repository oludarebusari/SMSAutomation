package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.BroadcastHistoryPage;
import pageObjects.license.menu.BroadCastSubMenu;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.modal.BroadcastAnalyticsModal;
import utils.DriverFactory;

public class BroadcastHistoryInMerchantSteps extends DriverFactory {

	
	BroadcastAnalyticsModal broadcastAnalyticsModal = PageFactory.initElements(driver, BroadcastAnalyticsModal.class);
	BroadcastHistoryPage broadcastHistoryPage = PageFactory.initElements(driver, BroadcastHistoryPage.class);
	BroadCastSubMenu broadCastSubMenu = PageFactory.initElements(driver, BroadCastSubMenu.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	

	String downloadpath = System.getProperty("user.home") + "//Downloads//";
	String fileName = "Engage Admin Dashboard.csv";

//	 @SMSM-125-Verify-that-user-is-redirected-to-new-windows-of-merchant's-dashboard-and-locate-the-Broadcast-menu
	@When("User clicks the broadcast option tab")
	public void user_clicks_the_broadcast_option_tab() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Broadcasts);
	}

	@Then("the Broadcast menu is opened")
	public void the_Broadcast_menu_is_opened() throws InterruptedException {
		Assert.assertEquals("Broadcasts", broadCastSubMenu.getElementText(broadCastSubMenu.menu_Title));
	}

	@Then("User verifies the available option on the KHS of the page")
	public void user_verifies_the_available_option_on_the_KHS_of_the_page() {
		Assert.assertTrue(broadCastSubMenu.menu_CreateBroadcast.isDisplayed());
		Assert.assertTrue(broadCastSubMenu.menu_ManageBroadcasts.isDisplayed());
		Assert.assertTrue(broadCastSubMenu.menu_BroadcastHistory.isDisplayed());
	}

//	@SMSM-125-Verify-that-user-is-able-to-see-all-existing-broadcast-messages-(send-or-scheduled)-according-to-Date-Selected-in-Broadcast-History
	@When("User clicks on Broadcast History option")
	public void user_clicks_on_Broadcast_History_option() throws Exception {
		broadCastSubMenu.waitAndClickElement(broadCastSubMenu.menu_BroadcastHistory);
	}

	@Then("the User is redirected to the Broadcast History page")
	public void the_User_is_redirected_to_the_Broadcast_History_page() throws Exception {
		Assert.assertEquals("Broadcast History", broadcastHistoryPage.getElementText(broadcastHistoryPage.pag_Title));
	}

	@When("User clicks on Dates")
	public void user_clicks_on_Dates() throws InterruptedException {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.lov_DatesDDown);
	}

	@Then("a list of Date options is displayed and verified by the user")
	public void a_list_of_Date_options_is_displayed_and_verified_by_the_user() {
		Assert.assertTrue(broadcastHistoryPage.dateOption("Today").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Yesterday").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last 7 Days").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last 30 Days").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("This Month").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last Month").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("All data").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Custom Range").isDisplayed());
	}

	@When("User clicks on Date and Selects All Data and clicks apply button")
	public void user_clicks_on_Date_and_Selects_All_Data_and_clicks_apply_button() throws Exception {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.dateOption("All data"));
	}

	@Then("all existing broadcast messages were displayed")
	public void all_existing_broadcast_messages_were_displayed() throws Exception, Exception {
		Assert.assertTrue(Integer.parseInt(
				broadcastHistoryPage.getElementText(broadcastHistoryPage.dataTableInfo).substring(8, 10)) > 0);
	}

//	 @SMSM-125-Verify-that-user-is-able-to-sort-and-move-across-pages-for-broadcast-History-table
	@Then("User verifies the pagination options at the bottom of the page")
	public void user_verifies_the_pagination_options_at_the_bottom_of_the_page() {
		Assert.assertTrue(broadcastHistoryPage.paginationOptions.isDisplayed());
	}

	@Then("User verifies that both Copy and CSV buttons are present")
	public void user_verifies_that_both_Copy_and_CSV_buttons_are_present() {
		Assert.assertTrue(broadcastHistoryPage.btn_Copy.isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.btn_CSV.isDisplayed());
	}

	@Then("User verifies the Page Count options")
	public void user_verifies_the_Page_Count_options() {
		Assert.assertTrue(broadcastHistoryPage.pageCountOptions("10").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.pageCountOptions("25").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.pageCountOptions("50").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.pageCountOptions("100").isDisplayed());
	}

	@Then("User verifies the records can be sorted through the column heading")
	public void user_verifies_the_records_can_be_sorted_through_the_column_heading() throws Exception {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.col_Message);
		Assert.assertTrue(broadcastHistoryPage.getElementText(broadcastHistoryPage.txt_FirstMessage).startsWith("a"));
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.col_Message);
		Assert.assertTrue(broadcastHistoryPage.getElementText(broadcastHistoryPage.txt_FirstMessage).startsWith("T"));
	}

//   @SMSM-125-Verify-that-user-is-able-to-Copy-and-Export-to-CSV-the-List-of-broadcast-messages
	@Then("user confirms data rows on the broadcast page are copied")
	public void user_confirms_data_rows_on_the_broadcast_page_are_copied() throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.txt_Copied_To_Clipboard)
				.contentEquals("Copied "
						+ broadcastHistoryPage.getElementText(broadcastHistoryPage.copyToClipboard).substring(7, 9)
						+ " rows to clipboard"));
	}

	@Then("User confirms that the CSV file for Broadcast is exported to the local machine")
	public void user_confirms_that_the_CSV_file_for_Broadcast_is_exported_to_the_local_machine() throws Exception {
		Assert.assertTrue(broadcastHistoryPage.isFileDownloaded(downloadpath, fileName));
	}

//	 @SMSM-125-Verify-that-user-is-able-to-view-details-for-the-broadcasts-message
	@Then("User verifies that for every record, there is  Details under Action column")
	public void user_verifies_that_for_every_record_there_is_Details_under_Action_column()
			throws Exception, InterruptedException {
		Assert.assertEquals(
				Integer.parseInt(
						broadcastHistoryPage.getElementText(broadcastHistoryPage.broadcast_Info).substring(2, 4)),
				broadcastHistoryPage.btn_DetailsSize().size());
	}

	@Then("User verifies the list of actions for a record")
	public void user_verifies_the_list_of_actions_for_a_record() throws Exception {
		broadcastHistoryPage
				.waitAndClickElement(broadcastHistoryPage.btn_ActionDDownByCampaignName("\"Test 3 (Enabled)\""));
		Assert.assertTrue(broadcastHistoryPage.actionDDownOption("\"Test 3 (Enabled)\"", "Resend").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.actionDDownOption("\"Test 3 (Enabled)\"", "Expire Offer").isDisplayed());
	}

	@When("User clicks the Details button for a record")
	public void user_clicks_the_Details_button_for_a_record() throws Exception {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.btn_Details("\"Test 3 (Enabled)\""));
	}

	@Then("the Broadcast Analytics window opens and shows the details of the selected record")
	public void the_Broadcast_Analytics_window_opens_and_shows_the_details_of_the_selected_record() throws Exception {
		Assert.assertEquals("Broadcast Analytics", broadcastAnalyticsModal.getElementText(broadcastAnalyticsModal.mod_Title));
	}
}
