package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.BlackListPage;
import pageObjects.license.MyAccountPage;
import pageObjects.license.modal.AutoPurchaseModal;
import pageObjects.license.modal.PurchaseHistoryModal;
import utils.DriverFactory;

public class AccountResourcesUnderMyAccountInMerchantPortalSteps extends DriverFactory {

	MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
	PurchaseHistoryModal purchaseHistoryModal = PageFactory.initElements(driver, PurchaseHistoryModal.class);
	AutoPurchaseModal autoPurchaseModal = PageFactory.initElements(driver, AutoPurchaseModal.class);
	BlackListPage blackListPage = PageFactory.initElements(driver, BlackListPage.class);
	

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
		Assert.assertEquals("Success! Your plan is updated!",myAccountPage.getElementText(myAccountPage.txt_Update_Message));
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
	public void user_clicks_the_Private_Campaign_mode_toggle_Off() {

	}

	@Then("the blacklist options appears")
	public void the_blacklist_options_appears() {

	}

	@When("User clicks the New button under Blacklist section")
	public void user_clicks_the_New_button_under_Blacklist_section() {

	}

	@Then("the Add to blacklist window is opened")
	public void the_Add_to_blacklist_window_is_opened() {

	}

	@When("user adds the number to blacklist and cliks Add Number button")
	public void user_adds_the_number_to_blacklist_and_cliks_Add_Number_button() {

	}

	@Then("the number is added to the blacklist")
	public void the_number_is_added_to_the_blacklist() {

	}

}
