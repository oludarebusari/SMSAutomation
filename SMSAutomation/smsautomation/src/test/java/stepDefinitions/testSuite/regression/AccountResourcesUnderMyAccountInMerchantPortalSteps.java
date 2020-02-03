package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.license.MyAccountPage;
import pageObjects.license.modal.PurchaseHistoryModal;
import utils.DriverFactory;

public class AccountResourcesUnderMyAccountInMerchantPortalSteps extends DriverFactory {
	
	MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
	PurchaseHistoryModal purchaseHistory = PageFactory.initElements(driver, PurchaseHistoryModal.class);
	

	@Then("User verifies the Account Resources section options")
	public void user_verifies_the_Account_Resources_section_options() throws Exception {
		Assert.assertEquals("Prepaid Blocks", myAccountPage.getElementText(myAccountPage.lnk_Prepaid_Blocks));
		Assert.assertEquals("Prepaid Blocks", myAccountPage.getElementText(myAccountPage.lnk_Blacklist_Whitelist));
		Assert.assertEquals("Prepaid Blocks", myAccountPage.getElementText(myAccountPage.lnk_Auto_Purchase));
		Assert.assertEquals("Prepaid Blocks", myAccountPage.getElementText(myAccountPage.lnk_Purchase_History));
	}

	@When("User clicks on Purchase History option")
	public void user_clicks_on_Purchase_History_option() throws Exception {
		myAccountPage.clickPurchaseHistorylnk(); 
	}

	@Then("Purchase History window pops up and user can view all Purchase history")
	public void purchase_History_window_pops_up_and_user_can_view_all_Purchase_history() throws Exception {
		Assert.assertEquals("Purchase History", purchaseHistory.getPurchaseHistoryTitle());
	}

	@When("User clicks on the page drop down count to change the number of records per page")
	public void user_clicks_on_the_page_drop_down_count_to_change_the_number_of_records_per_page() throws Exception {
		purchaseHistory.clickPurchaseHistoryPageSizedropDown();
	}

	@Then("The list of page sizes that can be selected is displayed")
	public void the_list_of_page_sizes_that_can_be_selected_is_displayed() throws Exception {
		Assert.assertEquals("10", purchaseHistory.getPurchaseHistoryPageSize("10"));
		Assert.assertEquals("25", purchaseHistory.getPurchaseHistoryPageSize("25"));
		Assert.assertEquals("50", purchaseHistory.getPurchaseHistoryPageSize("50"));
		Assert.assertEquals("100", purchaseHistory.getPurchaseHistoryPageSize("100"));
	}

	@When("User selects a number from the list")
	public void user_selects_a_number_from_the_list() throws Exception {
		purchaseHistory.clickPurchaseHistoryPageSize("25");
	}

	@Then("the number of records displayed should correspond to the number selected")
	public void the_number_of_records_displayed_should_correspond_to_the_number_selected() throws Exception {
		Assert.assertEquals("25", purchaseHistory.getPurchaseHistoryPageInfo());
	}

	@Then("User verifies that both CSV and Copy Options are available")
	public void user_verifies_that_both_CSV_and_Copy_Options_are_available() throws Exception {
	    	Assert.assertEquals("Copy", purchaseHistory.getPurchaseHistoryPageCopyTxt());
	    	Assert.assertEquals("CSV", purchaseHistory.getPurchaseHistoryPageCSVTxt());
	}

	@When("User clicks on the CSV tab")
	public void user_clicks_on_the_CSV_tab() throws Exception {
	purchaseHistory.clickPurchaseHistoryPageCSVBtn();
	}

	@Then("CSV file is created and exported to the local machine")
	public void csv_file_is_created_and_exported_to_the_local_machine() throws InterruptedException {

	}

}
