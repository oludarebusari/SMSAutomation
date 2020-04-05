package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.ManageBroadcastsPage;
import pageObjects.license.menu.BroadCastSubMenu;
import utils.DriverFactory;

public class ManageExistingBroadcastSteps extends DriverFactory {
	
	BroadCastSubMenu broadCastSubMenu = PageFactory.initElements(driver, BroadCastSubMenu.class);
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
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.tableRecordsCount).substring(7, 9).trim()) > 0 );
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


}
