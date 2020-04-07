package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.BroadcastConfirmationPage;
import pageObjects.engage.CreateEditBroadcastPage;
import pageObjects.engage.ManageBroadcastsPage;
import pageObjects.engage.modal.BroadcastPreviewModal;
import pageObjects.license.menu.BroadCastSubMenu;
import utils.DriverFactory;

public class ManageExistingBroadcastSteps extends DriverFactory {

	BroadcastConfirmationPage broadcastConfirmationPage = PageFactory.initElements(driver, BroadcastConfirmationPage.class);
	BroadCastSubMenu broadCastSubMenu = PageFactory.initElements(driver, BroadCastSubMenu.class);
	BroadcastPreviewModal broadcastPreviewModal = PageFactory.initElements(driver, BroadcastPreviewModal.class);
	CreateEditBroadcastPage createEditBroadcastPage = PageFactory.initElements(driver, CreateEditBroadcastPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	ManageBroadcastsPage manageBroadcastsPage = PageFactory.initElements(driver, ManageBroadcastsPage.class);

//	 @SMSM-124-User-can-see-all-existing-broadcast-messages 
	@When("User clicks on Manage Broadcasts option")
	public void user_clicks_on_Manage_Broadcasts_option() throws Exception {
		broadCastSubMenu.waitAndClickElement(broadCastSubMenu.menu_ManageBroadcasts);
	}

	@Then("User is redirected to the Manage Broadcasts page")
	public void user_is_redirected_to_the_Manage_Broadcasts_page() throws Exception {
		Assert.assertEquals("Manage Broadcasts", manageBroadcastsPage.getElementText(manageBroadcastsPage.pag_Heading));
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.tableRecordsCount)
				.substring(7, 9).trim()) > 0);
	}

//	@SMSM-124-User-can-change-number-of-broadcast-messages-per-page
	@Then("User verifies that the pagination count dropdown is available")
	public void user_verifies_that_the_pagination_count_dropdown_is_available() {
		Assert.assertTrue(commonElementLocator.lov_PaginationTableLength.isDisplayed());
	}

	@When("User clicks the pagination drop down")
	public void user_clicks_the_pagination_drop_down() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_PaginationTableLength);
	}

	@Then("the drop down is opened and user verifies the number of records per page")
	public void the_drop_down_is_opened_and_user_verifies_the_number_of_records_per_page() {
		Assert.assertTrue(commonElementLocator.tableLengthOpt("10").isDisplayed());
		Assert.assertTrue(commonElementLocator.tableLengthOpt("25").isDisplayed());
		Assert.assertTrue(commonElementLocator.tableLengthOpt("50").isDisplayed());
		Assert.assertTrue(commonElementLocator.tableLengthOpt("100").isDisplayed());
	}

	@When("User selects a value from the drop down")
	public void user_selects_a_value_from_the_drop_down() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.tableLengthOpt("25"));
	}

	@Then("User confirms the value was selected successfully.")
	public void user_confirms_the_value_was_selected_successfully() throws Exception {
		Assert.assertTrue(commonElementLocator.tableLengthOpt("25").isSelected());
	}

//	@SMSM-124-User-can-search-the-broadcast-message
	@Then("User verifies that Search textfield is available on Manage Broadcast page")
	public void user_verifies_that_Search_textfield_is_available_on_Manage_Broadcast_page() {
		Assert.assertTrue(manageBroadcastsPage.txtF_Search.isDisplayed());
	}

	@When("User enters some search string into the Search text box")
	public void user_enters_some_search_string_into_the_Search_text_box() throws Exception {
		manageBroadcastsPage.sendKeysToWebElement(manageBroadcastsPage.txtF_Search, "SearchTest");
	}

	@Then("User verifies the search results is displayed based on search string")
	public void user_verifies_the_search_results_is_displayed_based_on_search_string() {
		Assert.assertTrue(manageBroadcastsPage.rowByMessage("\"SearchTest\"").isDisplayed());
	}

	@When("User enters some invalid search string")
	public void user_enters_some_invalid_search_string() throws Exception {
		manageBroadcastsPage.sendKeysToWebElement(manageBroadcastsPage.txtF_Search, "invalidtext");
	}

	@Then("a message indicating no matching records found is displayed")
	public void a_message_indicating_no_matching_records_found_is_displayed() throws Exception {
		Assert.assertTrue(manageBroadcastsPage.rowByMessage("\"No matching records found\"").isDisplayed());
	}

//	@SMSM-124-User-can-export-broadcast-messages-in-csv-file
	@Then("User verifies that CSV button is available on the page")
	public void user_verifies_that_CSV_button_is_available_on_the_page() {
		Assert.assertTrue(commonElementLocator.btn_CSV.isDisplayed());
	}

	@When("user clicks the CSV button")
	public void user_clicks_the_CSV_button() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_CSV);
	}

	@Then("the Broadcast messages are exported to a CSV file")
	public void the_Broadcast_messages_are_exported_to_a_CSV_file() throws Exception {
		Assert.assertTrue(commonElementLocator.isFileDownloaded(commonElementLocator.downloadpath,
				commonElementLocator.fileName));
	}

//	@SMSM-124-User-can-sort-the-broadcast-messages-wrt-respective-column-header 
	@Then("User verifies the sort icon along column header")
	public void user_verifies_the_sort_icon_along_column_header() {
		Assert.assertTrue(manageBroadcastsPage.col_CampaignIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_KeywordIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_MessageIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_TypeIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_FrequencyIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_StartDateIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_NextDateIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_EndDateIcon.isDisplayed());
		Assert.assertTrue(manageBroadcastsPage.col_ActionIcon.isDisplayed());
	}

	@When("User clicks the sort icon for a column ie Message")
	public void user_clicks_the_sort_icon_for_a_column_ie_Message() throws Exception {
	manageBroadcastsPage.waitAndClickElement(manageBroadcastsPage.col_MessageIcon);
	}

	@Then("the records are sorted in ascending order by message column")
	public void the_records_are_sorted_in_ascending_order_by_message_column() throws Exception {
		Assert.assertTrue(manageBroadcastsPage.getElementText(manageBroadcastsPage.txt_FirstMessage).startsWith("a") || manageBroadcastsPage.getElementText(manageBroadcastsPage.txt_FirstMessage).startsWith("A"));
	}

	@When("User clicks the sort icon for message column again")
	public void user_clicks_the_sort_icon_for_message_column_again() throws Exception {
		manageBroadcastsPage.waitAndClickElement(manageBroadcastsPage.col_MessageIcon);
	}

	@Then("the records sorted in descending order by messages")
	public void the_records_sorted_in_descending_order_by_messages() throws Exception {
		Assert.assertTrue(manageBroadcastsPage.getElementText(manageBroadcastsPage.txt_FirstMessage).startsWith("S") || manageBroadcastsPage.getElementText(manageBroadcastsPage.txt_FirstMessage).startsWith("s"));
	}

//	 @SMSM-124-User-can-edit-existing-broadcast-message
	@When("User clicks the Edit button corresponding to the broadcast to edit")
	public void user_clicks_the_Edit_button_corresponding_to_the_broadcast_to_edit() throws Exception {
		manageBroadcastsPage.waitAndClickElement(manageBroadcastsPage.EditRecord("\"Automation testing\""));
	}

	@Then("User is redirected to the Edit broadcast page")
	public void user_is_redirected_to_the_Edit_broadcast_page() throws Exception {
		Assert.assertEquals("Edit Broadcast", createEditBroadcastPage.getElementText(createEditBroadcastPage.pag_Title));
	}

	@Then("User edits a field from the page displayed")
	public void user_edits_a_field_from_the_page_displayed() throws Exception {
		createEditBroadcastPage.sendKeysToWebElement(createEditBroadcastPage.txtF_Message, "Automation testing edited");
	}

	@Then("User clicks the Schedule broadcast button")
	public void user_clicks_the_Schedule_broadcast_button() throws Exception {
		createEditBroadcastPage.waitAndClickElement(createEditBroadcastPage.btn_ScheduleBroadcast);
	}

	@Then("User clicks the Schedule Broadcast button on Preview popup")
	public void user_clicks_the_Schedule_Broadcast_button_on_Preview_popup() throws Exception {
		broadcastPreviewModal.waitAndClickElement(broadcastPreviewModal.btn_ScheduleBroadcast);
	}

	@Then("the editted message should be broadcasted successfully")
	public void the_editted_message_should_be_broadcasted_successfully() throws Exception {
		Assert.assertEquals("Broadcast Scheduled!", broadcastConfirmationPage.getElementText(broadcastConfirmationPage.lbl_ConfirmationMessage));
	}
	
//  #Revert changes to changes to Message
	@When("User clicks the Edit button corresponding to the changed broadcast")
	public void user_clicks_the_Edit_button_corresponding_to_the_changed_broadcast() throws Exception {
		manageBroadcastsPage.waitAndClickElement(manageBroadcastsPage.EditRecord("\"Automation testing edited\""));
	}
	
	@Then("User revert changes made to broadcast")
	public void user_revert_changes_made_to_broadcast() throws Exception {
		createEditBroadcastPage.sendKeysToWebElement(createEditBroadcastPage.txtF_Message, "Automation testing");
		createEditBroadcastPage.waitAndClickElement(createEditBroadcastPage.btn_ScheduleBroadcast);
		broadcastPreviewModal.waitAndClickElement(broadcastPreviewModal.btn_ScheduleBroadcast);
	}
	
//	@SMSM-124-User-can-preview-broadcast-message-before-sending
	@Then("User verifies that Preview Broadcast button")
	public void user_verifies_that_Preview_Broadcast_button() {
	 Assert.assertTrue(createEditBroadcastPage.btn_PreviewBroadcast.isDisplayed());
	}

	@When("user clicks the Preview Broadcast button")
	public void user_clicks_the_Preview_Broadcast_button() throws Exception {
		createEditBroadcastPage.waitAndClickElement(createEditBroadcastPage.btn_PreviewBroadcast);
	}

	@Then("the Broadcast Preview window is opened")
	public void the_Broadcast_Preview_window_is_opened() throws Exception {
		Assert.assertEquals("Broadcast Preview", broadcastPreviewModal.getElementText(broadcastPreviewModal.mod_Title));
	}

	
	
}
