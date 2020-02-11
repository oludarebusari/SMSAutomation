package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.BlackListPage;
import pageObjects.license.MyAccountPage;
import pageObjects.license.modal.AddToBlacklistWhitelistModal;
import pageObjects.license.modal.AutoPurchaseModal;
import pageObjects.license.modal.PurchaseHistoryModal;
import pageObjects.license.modal.PurchaseMessageCreditsModal;
import utils.DriverFactory;

public class AccountResourcesUnderMyAccountInMerchantPortalSteps extends DriverFactory {

	MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
	PurchaseHistoryModal purchaseHistoryModal = PageFactory.initElements(driver, PurchaseHistoryModal.class);
	AutoPurchaseModal autoPurchaseModal = PageFactory.initElements(driver, AutoPurchaseModal.class);
	PurchaseMessageCreditsModal purchaseMessageCreditsModal = PageFactory.initElements(driver,
			PurchaseMessageCreditsModal.class);
	BlackListPage blackListPage = PageFactory.initElements(driver, BlackListPage.class);
	AddToBlacklistWhitelistModal addToBlackWhitelistModal = PageFactory.initElements(driver,
			AddToBlacklistWhitelistModal.class);

	//@SMSM-138-Purchase-History @RegressionTest
	@Then("User verifies the Account Resources section options")
	public void user_verifies_the_Account_Resources_section_options() throws Exception {
		Assert.assertEquals("Prepaid Blocks", myAccountPage.getElementText(myAccountPage.lnk_Prepaid_Blocks));
		Assert.assertEquals("Blacklist/Whitelist", myAccountPage.getElementText(myAccountPage.lnk_Blacklist_Whitelist));
		Assert.assertEquals("Auto Purchase", myAccountPage.getElementText(myAccountPage.lnk_Auto_Purchase));
		Assert.assertEquals("Purchase History", myAccountPage.getElementText(myAccountPage.lnk_Purchase_History));
	}

	@When("User clicks on Purchase History option")
	public void user_clicks_on_Purchase_History_option() throws Exception {
		myAccountPage.waitAndClickElement(myAccountPage.lnk_Purchase_History);
	}

	@Then("Purchase History window pops up and user can view all Purchase history")
	public void purchase_History_window_pops_up_and_user_can_view_all_Purchase_history() throws Exception {
		Assert.assertEquals("Purchase History",
				purchaseHistoryModal.getElementText(purchaseHistoryModal.mod_Purchase_History_Title));
	}

	@When("User clicks on the page drop down count to change the number of records per page")
	public void user_clicks_on_the_page_drop_down_count_to_change_the_number_of_records_per_page() throws Exception {
		purchaseHistoryModal.waitAndClickElement(purchaseHistoryModal.dropdown_Page_Size);
	}

	@Then("The list of page sizes that can be selected is displayed")
	public void the_list_of_page_sizes_that_can_be_selected_is_displayed() throws Exception {
		Assert.assertEquals("10", purchaseHistoryModal.getElementText(purchaseHistoryModal.num_PageSize("10")));
		Assert.assertEquals("25", purchaseHistoryModal.getElementText(purchaseHistoryModal.num_PageSize("25")));
		Assert.assertEquals("50", purchaseHistoryModal.getElementText(purchaseHistoryModal.num_PageSize("50")));
		Assert.assertEquals("100", purchaseHistoryModal.getElementText(purchaseHistoryModal.num_PageSize("100")));
	}

	@When("User selects a number from the list")
	public void user_selects_a_number_from_the_list() throws Exception {
		purchaseHistoryModal.waitAndClickElement(purchaseHistoryModal.num_PageSize("25"));
	}

	@Then("the number of records displayed should correspond to the number selected")
	public void the_number_of_records_displayed_should_correspond_to_the_number_selected() throws Exception {
		Assert.assertEquals("25",
				purchaseHistoryModal.getElementText(purchaseHistoryModal.txt_Purchase_History_Info).substring(2, 4));
	}

	@Then("User verifies that both CSV and Copy Options are available")
	public void user_verifies_that_both_CSV_and_Copy_Options_are_available() throws Exception {
		Assert.assertEquals("Copy", purchaseHistoryModal.getElementText(purchaseHistoryModal.btn_Copy));
		Assert.assertEquals("CSV", purchaseHistoryModal.getElementText(purchaseHistoryModal.btn_CSV));
	}

	@When("User clicks on the CSV tab")
	public void user_clicks_on_the_CSV_tab() throws Exception {
		purchaseHistoryModal.waitAndClickElement(purchaseHistoryModal.btn_CSV);
	}

	@Then("CSV file is created and exported to the local machine")
	public void csv_file_is_created_and_exported_to_the_local_machine() throws InterruptedException {

	}

    //@SMSM-138-Auto-Purchase @RegressionTest
	@When("User clicks the Auto Purchase option")
	public void user_clicks_the_Auto_Purchase_option() throws Exception {
		myAccountPage.waitAndClickElement(myAccountPage.lnk_Auto_Purchase);
	}

	@Then("Auto Purchase window pops")
	public void auto_Purchase_window_pops() throws Exception {
		Assert.assertEquals("Auto Purchase Plans",
				autoPurchaseModal.getElementText(autoPurchaseModal.mod_Auto_Purchase_Title));
	}

	@Then("User selects an auto purchase plan")
	public void user_selected_an_auto_purchase_plan() throws Exception {
		autoPurchaseModal.waitAndClickElement(autoPurchaseModal.selectAutoPurchasePlan("BASIC ENGAGEMENT BULK 10000"));
	}

	@Then("User clicks the Change Plan butto")
	public void user_clicks_the_Change_Plan_butto() throws Exception {
		autoPurchaseModal.waitAndClickElement(autoPurchaseModal.btn_Change_Plan);
	}

	@Then("a message indicating that your plan is updated is displayed")
	public void a_message_indicating_that_your_plan_is_updated_is_displayed() throws Exception {
		Assert.assertEquals("Success! Your plan is updated!",
				myAccountPage.getElementText(myAccountPage.txt_Auto_Purchase_Update_Message));
	}

	//  @SMSM-138-Prepaid-Block @RegressionTest
	@When("User clicks the prepaid block option")
	public void user_clicks_the_prepaid_block_option() throws Exception {
		myAccountPage.waitAndClickElement(myAccountPage.lnk_Prepaid_Blocks);
	}

	@Then("the Purchase Message Credits pop up screen appears")
	public void the_Purchase_Message_Credits_pop_up_screen_appears() throws Exception {
		Assert.assertEquals("Purchase Message Credits",
				purchaseHistoryModal.getElementText(purchaseMessageCreditsModal.mod_Purchase_Message_Credits));
	}

	@When("User selects a plan from the given option")
	public void user_selects_a_plan_from_the_given_option() throws Exception {
		purchaseMessageCreditsModal.waitAndClickElement(
				purchaseMessageCreditsModal.selectPurchaseMessageCredit("BASIC ENGAGEMENT BULK 100 "));
	}

	@Then("the option is selected successfully")
	public void the_option_is_selected_successfully() {
		Assert.assertTrue(purchaseMessageCreditsModal.selectPurchaseMessageCredit("BASIC ENGAGEMENT BULK 100 ")
				.getAttribute("class").contains("active"));
	}

	@Then("User verifies the value of the due Amount")
	public void user_verifies_the_value_of_the_due_Amount() throws Exception {
		String messageCost = purchaseMessageCreditsModal
				.getElementText(purchaseMessageCreditsModal.lab_CostOfMessages("BASIC ENGAGEMENT BULK 100 "))
				.substring(0, 3);
		Assert.assertTrue(messageCost
				.equals(purchaseMessageCreditsModal.getElementText(purchaseMessageCreditsModal.lab_Amount_Due_Today)));
	}

	@When("user clicks the Purchase Now button")
	public void user_clicks_the_Purchase_Now_button() throws Exception {
		purchaseMessageCreditsModal.waitAndClickElement(purchaseMessageCreditsModal.btn_Purchase_Now);
	}

	@Then("the plan is selected and messages are creadit to the account")
	public void the_plan_is_selected_and_messages_are_creadit_to_the_account() throws Exception {
		Assert.assertEquals("Success! Your plan is updated!",
				myAccountPage.getElementText(myAccountPage.txt_Purchase_Message_Credit_Update_Message));
	}

	//@SMSM-138-Blacklist-Whitelist-1 @RegressionTest
	@When("User clicks the Blacklist-whitelist option")
	public void user_clicks_the_Blacklist_whitelist_option() throws Exception {
		myAccountPage.waitAndClickElement(myAccountPage.lnk_Blacklist_Whitelist);
	}

	@Then("the Blacklist-Whitelist page is opened")
	public void the_Blacklist_Whitelist_pop_up_screen_appears() throws Exception {
		Assert.assertEquals("Blacklist/Whitelist", blackListPage.getElementText(blackListPage.pag_Blacklist_Whitelist));
	}

	@When("User clicks the Private Campaign mode toggle \\(Off)")
	public void user_clicks_the_Private_Campaign_mode_toggle_Off() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.tog_Off);
	}

	@Then("the whitelist option appears on the screen")
	public void the_whitelist_option_appears_on_the_screen() throws Exception {
		Assert.assertEquals("Whitelist", blackListPage.getElementText(blackListPage.txt_Whitelist_Subtitle));
	}

	@When("User clicks the New button under Whitelist section")
	public void user_clicks_the_New_button_under_Whitelist_section() throws InterruptedException {
		blackListPage.waitAndClickElement(blackListPage.btn_Whitelist_New);
	}

	@Then("the Add to whitelist window is opened")
	public void the_Add_to_whitelist_window_is_opened() throws InterruptedException {
		Assert.assertEquals("Add to Whitelist",
				addToBlackWhitelistModal.getElementText(addToBlackWhitelistModal.mod_Add_To_Whitelist_Title));
	}

	@When("user adds the number to whitelist and cliks Add Number button")
	public void user_adds_the_number_to_whitelist_and_cliks_Add_Number_button() throws Exception {
		addToBlackWhitelistModal.sendKeysToWebElement(addToBlackWhitelistModal.txt_Phone_Number, "5551112424");
		addToBlackWhitelistModal.waitAndClickElement(addToBlackWhitelistModal.btn_Add_Number);
	}

	@Then("the number is added to the whiteklist")
	public void the_number_is_added_to_the_whiteklist() throws Exception {
		Thread.sleep(500);
		Assert.assertEquals("555-111-2424",
				blackListPage.getElementText(blackListPage.txt_WhiteList_Number("555-111-2424")));
	}

	@Then("user confirms that both Copy and CSV buttons are present")
	public void user_confirms_that_both_Copy_and_CSV_buttons_are_present() {
		Assert.assertTrue(blackListPage.btn_Copy.isDisplayed());
		Assert.assertTrue(blackListPage.btn_CSV.isDisplayed());
	}

	@When("user clicks the copy button")
	public void user_clicks_the_copy_button() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.btn_Copy);
	}

	@Then("user confirms row data is copied")
	public void user_confirms_row_data_is_copied() throws Exception {
		Assert.assertTrue(blackListPage.getElementText(blackListPage.txt_Copied_To_Clipboard)
				.contentEquals("Copied one row to clipboard"));
	}

	@When("User clicks the CSV tab")
	public void user_clicks_the_CSV_tab() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.btn_CSV);
	}

	@Then("User confirms that the CSV file is exported to the local machine")
	public void user_confirms_that_the_CSV_file_is_exported_to_the_local_machine() {

	}

	@When("User enters an incorrect number in the search box")
	public void user_enters_an_incorrect_number_in_the_search_box() throws Exception {
		blackListPage.sendKeysToWebElement(blackListPage.txt_Whitelist_SearchField, "77");
	}

	@Then("a text indicating no matching records is displayed")
	public void a_text_indicating_no_matching_records_is_displayed() throws Exception {
		Assert.assertTrue(blackListPage.getElementText(blackListPage.txt_No_Match_Message)
				.contentEquals("No matching records found"));
		blackListPage.waitAndClickElement(blackListPage.tog_On);
	}

	//@SMSM-138-Whitelist-2 @RegressionTest
	@When("user clicks on the X button user the Actions column")
	public void user_clicks_on_the_X_button_user_the_Actions_column() throws Exception {
//		To be completed when https://jira.devfactory.com/browse/PLSMS-986 is fixed

	}

	@Then("the number is deleted from the whitelist table")
	public void the_number_is_deleted_from_the_whitelist_table() throws Exception {
//		To be completed when https://jira.devfactory.com/browse/PLSMS-986 is fixed
	}

    //@SMSM-138-Blacklist @RegressionTest
	@When("User leaves the Private Campaign mode toggle as Off")
	public void user_leaves_the_Private_Campaign_mode_toggle_as_Off() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.tog_Off);
		Assert.assertTrue(blackListPage.getElementText(blackListPage.tog_Off).contentEquals("Off"));
	}

	@Then("User clicks the Blacklist New button")
	public void user_clicks_the_Blacklist_New_button() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.btn_Blacklist_New);
	}

	@Then("the blacklist options appears")
	public void the_blacklist_options_appears() throws Exception {
		Assert.assertEquals("Blacklist", blackListPage.getElementText(blackListPage.txt_Blacklist_Subtitle));
	}

	@Then("the Add to blacklist window is opened")
	public void the_Add_to_blacklist_window_is_opened() throws Exception {
		Assert.assertEquals("Add to Blacklist",
				addToBlackWhitelistModal.getElementText(addToBlackWhitelistModal.mod_Add_To_Blacklist_Title));
	}

	@When("user adds the number to blacklist and cliks Add Number button")
	public void user_adds_the_number_to_blacklist_and_cliks_Add_Number_button() throws Exception {
		addToBlackWhitelistModal.sendKeysToWebElement(addToBlackWhitelistModal.txt_Phone_Number, "5211112424");
		addToBlackWhitelistModal.waitAndClickElement(addToBlackWhitelistModal.btn_Add_Number);
	}

	@Then("the number is added to the blacklist")
	public void the_number_is_added_to_the_blacklist() {

	}

}
