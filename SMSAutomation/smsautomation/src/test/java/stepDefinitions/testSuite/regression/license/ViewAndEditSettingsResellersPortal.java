package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.BasePage;
import pageObjects.thrive.ManageResellerPage;
import pageObjects.thrive.ResellerDashboardPage;
import pageObjects.thrive.SettingsPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.EditSettingsModal;

public class ViewAndEditSettingsResellersPortal extends BasePage {

	public ViewAndEditSettingsResellersPortal() throws IOException {
		super();
	}

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	EditSettingsModal editSettingsModal = PageFactory.initElements(driver, EditSettingsModal.class);
	ManageResellerPage manageResellerPage = PageFactory.initElements(driver, ManageResellerPage.class);
	ResellerDashboardPage resellerDashboardPage = PageFactory.initElements(driver, ResellerDashboardPage.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
	
	@When("User clicks on Companies")
	public void user_clicks_on_Companies() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Companies);
	}

	@Then("the Companies options are displayed")
	public void the_Companies_options_are_displayed() {
		Assert.assertTrue(companiesDDown.opt_Resellers.isDisplayed());
		Assert.assertTrue(companiesDDown.opt_Businesses.isDisplayed());
	}

	@When("User clicks on Resellers")
	public void user_clicks_on_Resellers() throws Exception {
		companiesDDown.waitAndClickElement(companiesDDown.opt_Resellers);
	}

	@Then("the Resellers Page is opened")
	public void the_Resellers_Page_is_opened() throws Exception {
		Assert.assertEquals("Manage Resellers", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User selects a Reseller and Clicks Sign In button")
	public void user_selects_a_Reseller_and_Clicks_Sign_In_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "805 Loyal");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_SignIn("805 Loyal"));
	}

	@Then("the Resellers dashboard is opened")
	public void the_Resellers_dashboard_is_opened() throws Exception {
		Assert.assertEquals("New Businesses", resellerDashboardPage.getElementText(resellerDashboardPage.page_Title));
	}

//	@Verify-the-Help-on-"Manage-Settings"-page-by-clicking-the-Help-button
	@When("User clicks on the settings Menu and clicks the Setting option")
	public void user_clicks_on_the_settings_Menu_and_clicks_the_Setting_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Settings);
		commonElementLocator.waitAndClickElement(settingsDDown.opt_Settings);
	}

	@Then("User is redirected to the Settings page")
	public void user_is_redirected_to_the_Settings_page() throws Exception {
		Assert.assertEquals("Settings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	@When("User clicks the Help button on the Settings page")
	public void user_clicks_the_Help_button_on_the_Settings_page() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Settings Management help tour window appears")
	public void the_Settings_Management_help_tour_window_appears() throws Exception {
		Assert.assertEquals("Settings Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Settings Management help window")
	public void user_clicks_the_Next_button_on_the_Settings_Management_help_window() throws Exception {
	   commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search Settings window is displayed")
	public void the_Search_Settings_window_is_displayed() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search Settings", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on the Search Settings Templates window")
	public void user_clicks_the_previous_button_on_the_Search_Settings_Templates_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("User is navigated to the Settings Management window")
	public void user_is_navigated_to_the_Settings_Management_window() throws Exception {
		Assert.assertEquals("Settings Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
//	@Verify-the-Help-on-"Manage-Settings"-page-by-clicking-the-Help-button
	@Then("User verifies that the Search text box is displayed")
	public void user_verifies_that_the_Search_text_box_is_displayed() {
	   Assert.assertTrue(commonElementLocator.txtF_Search.isDisplayed());
	}

	@Then("User verifies that the Search button is displayed")
	public void user_verifies_that_the_Search_button_is_displayed() {
	 Assert.assertTrue(commonElementLocator.btn_Search.isDisplayed());
	}

	@When("User types in a group name into the Search box and clicks Search button")
	public void user_types_in_a_group_name_into_the_Search_box_and_clicks_Search_button() throws Exception {
	 commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Email Settings");
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Settings records are displayed")
	public void the_Settings_records_are_displayed() throws NumberFormatException, InterruptedException {
	  Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) > 0);
	}
	
//	
	@Then("User verifies the arrows icon on the Column heading")
	public void user_verifies_the_arrows_icon_on_the_Column_heading() {
		Assert.assertTrue(settingsPage.col_Title.isDisplayed());
		Assert.assertTrue(settingsPage.col_Group.isDisplayed());
		Assert.assertTrue(settingsPage.col_Value.isDisplayed());
		Assert.assertTrue(settingsPage.col_Description.isDisplayed());		
	}

	@When("User clicks the Title column header")
	public void user_clicks_the_Title_column_header() throws Exception {
	 Assert.assertTrue(settingsPage.firstSortedRecord("Gateway API Username").isDisplayed());	
	  settingsPage.waitAndClickElement(settingsPage.col_Title);
	}

	@Then("data is sorted in ascending order")
	public void data_is_sorted_in_ascending_order() {
	    Assert.assertTrue(settingsPage.firstSortedRecord("Allowed Domains").isDisplayed());	
	}

	@When("User clicks on the Title column header again")
	public void user_clicks_on_the_Title_column_header_again() throws Exception {
		settingsPage.waitAndClickElement(settingsPage.col_Title);
	}

	@Then("data is sorted in descending order")
	public void data_is_sorted_in_descending_order() {
		Assert.assertTrue(settingsPage.firstSortedRecord("Yelp Username").isDisplayed());	
	}

	@Then("User verifies the Show Entries section is displayed")
	public void user_verifies_the_Show_Entries_section_is_displayed() {
	 Assert.assertTrue(commonElementLocator.lbl_ShowEntries.isDisplayed());
	}

	@Then("User verifies that button two is selected")
	public void user_verifies_that_button_two_is_selected() throws NumberFormatException, InterruptedException {
	  Assert.assertEquals(2, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).substring(0, 1)));
	}

	@When("User selects All from Show entries drop down")
	public void user_selects_All_from_Show_entries_drop_down() throws InterruptedException {
	commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("All"));
	}

	@Then("User verfies that all the records are displayed on one page")
	public void user_verfies_that_all_the_records_are_displayed_on_one_page() throws NumberFormatException, InterruptedException {
	Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
	Assert.assertEquals(1, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).substring(0, 1)));
	Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
	}
	
//	
	@Then("User verifies the edit button for each setting")
	public void user_verifies_the_edit_button_for_each_setting() throws Exception {
	   Assert.assertEquals(10, settingsPage.getNumberOfElements(settingsPage.getEDITBTN()));
	}

	@When("User clicks on the Edit button for a Setting")
	public void user_clicks_on_the_Edit_button_for_a_Setting() throws Exception {
	  settingsPage.waitAndClickElement(settingsPage.editSettingByTitle("Gateway API Username"));
	}

	@Then("the Edit Setting pop up window is opened")
	public void the_Edit_Setting_pop_up_window_is_opened() throws Exception {
	  Assert.assertEquals("Edit Setting", editSettingsModal.getElementText(editSettingsModal.mod_Title));
	}

	@When("User enters a value and click the close button")
	public void user_enters_a_value_and_click_the_close_button() throws Exception {
		editSettingsModal.sendKeysToWebElement(editSettingsModal.txtF_EditSetting, "testing");
		editSettingsModal.waitAndClickElement(editSettingsModal.btn_Close);
	}

	@Then("User verifies that the selected settings is not updated")
	public void user_verifies_that_the_selected_settings_is_not_updated() {
		Assert.assertTrue(settingsPage.colValueOption("******name").isDisplayed());
	}

	@When("User enters a value and click the Update Settings button")
	public void user_enters_a_value_and_click_the_Update_Settings_button() throws Exception {
	 editSettingsModal.sendKeysToWebElement(editSettingsModal.txtF_EditSetting, "Gateway API User");
	 editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSettings);
	}

	@Then("User verifies the value field is updated")
	public void user_verifies_the_value_field_is_updated() throws Exception {
		Thread.sleep(1000);
		Assert.assertTrue(settingsPage.colValueOption("******User").isDisplayed());
	}

//	#Revert Changes
	@Then("User revert the changes to the Setting record")
	public void user_revert_the_changes_to_the_Setting_record() throws Exception {
		 settingsPage.waitAndClickElement(settingsPage.editSettingByTitle("Gateway API Username"));
		 editSettingsModal.sendKeysToWebElement(editSettingsModal.txtF_EditSetting, "Gateway API Username");
		 editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSettings);	 
	}

//	@Verify-Admin-can-edit-Email-Templates-from-the-available-list-from-Companies-menu-for-Licensees
	@When("User clicks the settings Menu and clicks the Message Templates")
	public void user_clicks_the_settings_Menu_and_clicks_the_Message_Templates() {
	 
	}

	@Then("User is redirected to the Message Templates")
	public void user_is_redirected_to_the_Message_Templates() {
	  
	}

	@Then("User verifies the Edit button for the Message Templates")
	public void user_verifies_the_Edit_button_for_the_Message_Templates() {
	 
	}

	@When("User selects a Message Template and clicks on Edit button")
	public void user_selects_a_Message_Template_and_clicks_on_Edit_button() {
	 
	}

	@Then("the Message Templates opens in edit mode")
	public void the_Message_Templates_opens_in_edit_mode() {
	 
	}

	@When("User edits some fields and clicks on the close button")
	public void user_edits_some_fields_and_clicks_on_the_close_button() {
	 
	}

	@Then("User verifies that the fields were not updated")
	public void user_verifies_that_the_fields_were_not_updated() {
	
	}

	@Then("all updated fields were updated successfully")
	public void all_updated_fields_were_updated_successfully() {
	  
	}
}
