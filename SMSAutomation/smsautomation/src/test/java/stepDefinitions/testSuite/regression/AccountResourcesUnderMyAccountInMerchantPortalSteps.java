package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.BlackListPage;
import pageObjects.license.MyAccountPage;
import pageObjects.license.modal.AddToWhitelistModal;
import pageObjects.license.modal.AutoPurchaseModal;
import pageObjects.license.modal.PurchaseHistoryModal;
import pageObjects.license.modal.PurchaseMessageCreditsModal;
import utils.DriverFactory;

public class AccountResourcesUnderMyAccountInMerchantPortalSteps extends DriverFactory {

	MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
	PurchaseHistoryModal purchaseHistoryModal = PageFactory.initElements(driver, PurchaseHistoryModal.class);
	AutoPurchaseModal autoPurchaseModal = PageFactory.initElements(driver, AutoPurchaseModal.class);
	PurchaseMessageCreditsModal purchaseMessageCreditsModal = PageFactory.initElements(driver, PurchaseMessageCreditsModal.class);
	BlackListPage blackListPage = PageFactory.initElements(driver, BlackListPage.class);
	AddToWhitelistModal addToWhitelistModal = PageFactory.initElements(driver, AddToWhitelistModal.class);
	

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
		Assert.assertEquals("25", purchaseHistoryModal.getElementText(purchaseHistoryModal.txt_Purchase_History_Info).substring(2,4));
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

	@When("User clicks the Auto Purchase option")
	public void user_clicks_the_Auto_Purchase_option() throws Exception {
		myAccountPage.waitAndClickElement(myAccountPage.lnk_Auto_Purchase);
	}

	@Then("Auto Purchase window pops")
	public void auto_Purchase_window_pops() throws Exception {
		Assert.assertEquals("Auto Purchase Plans", autoPurchaseModal.getElementText(autoPurchaseModal.mod_Auto_Purchase_Title));
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
		Assert.assertEquals("Success! Your plan is updated!",myAccountPage.getElementText(myAccountPage.txt_Auto_Purchase_Update_Message));
	}
	
	@When("User clicks the prepaid block option")
	public void user_clicks_the_prepaid_block_option() throws Exception {
	   myAccountPage.waitAndClickElement(myAccountPage.lnk_Prepaid_Blocks);
	}

	@Then("the Purchase Message Credits pop up screen appears")
	public void the_Purchase_Message_Credits_pop_up_screen_appears() throws Exception {
	  Assert.assertEquals("Purchase Message Credits", purchaseHistoryModal.getElementText(purchaseMessageCreditsModal.mod_Purchase_Message_Credits));
	}

	@When("User selects a plan from the given option")
	public void user_selects_a_plan_from_the_given_option() throws Exception {
	 purchaseMessageCreditsModal.waitAndClickElement(purchaseMessageCreditsModal.selectPurchaseMessageCredit("BASIC ENGAGEMENT BULK 100 "));
	}

	@Then("the option is selected successfully")
	public void the_option_is_selected_successfully() {
		Assert.assertTrue(purchaseMessageCreditsModal.selectPurchaseMessageCredit("BASIC ENGAGEMENT BULK 100 ").getAttribute("class").contains("active"));
	}

	@Then("User verifies the value of the due Amount")
	public void user_verifies_the_value_of_the_due_Amount() throws Exception {
		String messageCost = purchaseMessageCreditsModal.getElementText(purchaseMessageCreditsModal.lab_CostOfMessages("BASIC ENGAGEMENT BULK 100 ")).substring(0, 3);
		Assert.assertTrue(messageCost.equals(purchaseMessageCreditsModal.getElementText(purchaseMessageCreditsModal.lab_Amount_Due_Today)));
	}

	@When("user clicks the Purchase Now button")
	public void user_clicks_the_Purchase_Now_button() throws Exception {
	   purchaseMessageCreditsModal.waitAndClickElement(purchaseMessageCreditsModal.btn_Purchase_Now);
	}

	@Then("the plan is selected and messages are creadit to the account")
	public void the_plan_is_selected_and_messages_are_creadit_to_the_account() throws Exception {
		Assert.assertEquals("Success! Your plan is updated!", myAccountPage.getElementText(myAccountPage.txt_Purchase_Message_Credit_Update_Message));
	}

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
	
	@When("User clicks the New button under Blacklist section")
	public void user_clicks_the_New_button_under_Blacklist_section() throws Exception {
		blackListPage.waitAndClickElement(blackListPage.btn_Whitelist_New);
	}

	@Then("the Add to whitelist window is opened")
	public void the_Add_to_whitelist_window_is_opened() throws InterruptedException {
		Assert.assertEquals("Add to Whitelist", addToWhitelistModal.getElementText(addToWhitelistModal.mod_Add_To_Whitelist_Title));
	}
		
	@When("user adds the number to whitelist and cliks Add Number button")
	public void user_adds_the_number_to_whitelist_and_cliks_Add_Number_button() throws Exception {
	  addToWhitelistModal.sendKeysToWebElement(addToWhitelistModal.txt_Phone_Number, "5551112424");
	  addToWhitelistModal.waitAndClickElement(addToWhitelistModal.btn_Add_Number);
	}

	@Then("the number is added to the blacklist")
	public void the_number_is_added_to_the_blacklist() {

	}

}
