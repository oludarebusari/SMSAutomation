package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminSettingsAndLanguageStringsPage;
import pageObjects.thrive.AdminSettingsPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.AdminEditLanguageStringsModal;
import pageObjects.thrive.modal.AdminEditSettingsModal;
import utils.DriverFactory;

public class ManageSettingsAndLanguageStringsSteps extends DriverFactory {

	public AdminSettingsPage adminSettingsPage = PageFactory.initElements(driver, AdminSettingsPage.class);
	public AdminSettingsAndLanguageStringsPage adminSettingsAndLanguageStringsPage = PageFactory.initElements(driver,
			AdminSettingsAndLanguageStringsPage.class);
	public AdminEditSettingsModal adminEditSettingsModal = PageFactory.initElements(driver,
			AdminEditSettingsModal.class);
	public AdminEditLanguageStringsModal adminEditLanguageStringsModal = PageFactory.initElements(driver,
			AdminEditLanguageStringsModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);

//	@SMSM-170-Verify-manage-settings-page-options-through-settings-drop-down-in-Admin-dashboard
	@When("User clicks on Settings under Settings drop down")
	public void user_clicks_on_Settings_under_Settings_drop_down() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Settings);
	}

	@Then("User is redirected to Settings page")
	public void user_is_redirected_to_Settings_page() throws Exception {
		Assert.assertEquals("Settings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the Settings page")
	public void user_verifies_the_columns_on_the_Settings_page() {
		Assert.assertTrue(adminSettingsPage.col_Title.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Group.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_AccessLevel.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Value.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Description.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Updated.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Action.isDisplayed());
	}

//	@SMSM-170-Verify-user-is-able-to-edit-settings-details-within-the-settings-tabs
	@When("User types the Settings to edit on the search text field")
	public void user_types_the_Settings_to_edit_on_the_search_text_field() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Gateway Test Mode");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the setting is displayed on the page")
	public void the_setting_is_displayed_on_the_page() {
		Assert.assertTrue(adminSettingsPage.searchRecord("\"Gateway Test Mode\"").isDisplayed());
	}

	@When("User clicks the edit tab of the Setting to modify")
	public void user_clicks_the_edit_tab_of_the_Setting_to_modify() throws Exception {
		adminSettingsPage.waitAndClickElement(adminSettingsPage.editSettingByTitle("\"Gateway Test Mode\""));
	}

	@Then("the Edit Settings window is opened")
	public void the_Edit_Settings_window_is_opened() throws Exception {
		Assert.assertEquals("Edit Setting", adminEditSettingsModal.getElementText(adminEditSettingsModal.mod_Title));
	}

	@Then("User edits all the text fields on the Edit Setting modal")
	public void user_edits_all_the_text_fields_on_the_Edit_Setting_modal() throws Exception {
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Title, "Gateway Test Mode - edited");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Slug, "gateway.test_mode - edited");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Group, "Payment Gateway - edited");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.typeDDown, "Checkbox");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.accessLevelDDown, "Merchant");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Description,
				"This is for automation demo");
	}

	@When("User clicks on the Save Settings button")
	public void user_clicks_on_the_Save_Settings_button() throws InterruptedException {
		adminEditSettingsModal.waitAndClickElement(adminEditSettingsModal.btn_SaveSettings);
	}

	@Then("user confirms the changes were saved correctly")
	public void user_confirms_the_changes_were_saved_correctly() throws Exception {
		Thread.sleep(1000);
		Assert.assertTrue(adminSettingsPage.cellValue("\"Gateway Test Mode - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"Payment Gateway - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"Merchant\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"This is for automation demo\"").isDisplayed());

	}

//	Revert Changes to the Settings
	@Then("User revert changes made to the setting")
	public void user_revert_changes_made_to_the_setting() throws Exception {
		adminSettingsPage.waitAndClickElement(adminSettingsPage.editSettingByTitle("\"Gateway Test Mode - edited\""));
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Title, "Gateway Test Mode");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Slug, "gateway.test_mode");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Group, "Payment Gateway");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.typeDDown, "Textarea");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.accessLevelDDown, "Admin");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Description, "");
		adminEditSettingsModal.waitAndClickElement(adminEditSettingsModal.btn_SaveSettings);
	}


//	@SMSM-170-Verify-the-help-button-functionality-within-settings
	@Then("User verifies that the help button is displayed")
	public void user_verifies_that_the_help_button_is_displayed() {
		Assert.assertTrue(commonElementLocator.btn_Help.isDisplayed());
	}
	
	@Then("the Tour guide on the Settings page is opened")
	public void the_Tour_guide_on_the_Settings_page_is_opened() throws Exception {
		Assert.assertEquals("Settings Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
	@When("User clicks on Next button on Settings Management")
	public void user_clicks_on_Next_button_on_Settings_Management() throws Exception {
	commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("Tour guide should proceed to Search Settings window")
	public void tour_guide_should_proceed_to_Search_Settings_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.mod_Help_Title).contentEquals("Search Settings"));
	}

	@When("User clicks on Previous button from the Search Settings windows")
	public void user_clicks_on_Previous_button_from_the_Search_Settings_windows() throws Exception {
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("Tour guide is navigated to Settings Management window")
	public void tour_guide_is_navigated_to_Settings_Management_window() throws Exception {
		 Assert.assertEquals("Settings Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
	
//	@SMSM-170-Verify-language-strings-page-through-settings-drop-down-in-Admin-dashboard
	@When("User clicks on Language Strings under Settings drop down")
	public void user_clicks_on_Language_Strings_under_Settings_drop_down() throws Exception {
	settingsDDown.waitAndClickElement(settingsDDown.opt_Language_Strings);
	}

	@Then("User is redirected to Language String page")
	public void user_is_redirected_to_Language_String_page() throws Exception {
		Assert.assertEquals("Language Strings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the Language String page")
	public void user_verifies_the_columns_on_the_Language_String_page() {
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Title.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Group.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_AccessLevel.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Value.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Description.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Updated.isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.col_Action.isDisplayed());
	}
	
//	
	@When("User types the Language Strings to edit on the search text field")
	public void user_types_the_Language_Strings_to_edit_on_the_search_text_field() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Design Preview");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Language strings is displayed on the page")
	public void the_Language_strings_is_displayed_on_the_page() {
	 Assert.assertTrue(adminSettingsAndLanguageStringsPage.searchRecord("\"Design Preview\"").isDisplayed());
	}

	@When("User clicks the edit button of the Language String to modify")
	public void user_clicks_the_edit_button_of_the_Language_String_to_modify() throws Exception {
		adminSettingsAndLanguageStringsPage.waitAndClickElement(adminSettingsAndLanguageStringsPage.editSettingByTitle("\"Design Preview\""));
	}

	@Then("the Edit Language Strings window is opened")
	public void the_Edit_Language_Strings_window_is_opened() throws Exception {
		Assert.assertEquals("Edit Language Strings", adminEditLanguageStringsModal.getElementText(adminEditLanguageStringsModal.mod_Title));
	}

	@Then("User edits all the text fields on the Edit Language Strings modal")
	public void user_edits_all_the_text_fields_on_the_Edit_Language_Strings_modal() throws Exception {
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Title, "Design Preview - edited");
		adminEditLanguageStringsModal.clickOnTextFromDropdownList(adminEditLanguageStringsModal.typeDDown, "Textarea");
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Group, "ContactForm - edited");
		adminEditLanguageStringsModal.clickOnTextFromDropdownList(adminEditLanguageStringsModal.roleDDown, "Admin");
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Description, "Automation Testing");
	}
	
	@When("User closes the Edit Language Strings windows without saving")
	public void user_closes_the_Edit_Language_Strings_windows_without_saving() throws Exception {
		adminEditLanguageStringsModal.waitAndClickElement(adminEditLanguageStringsModal.btn_Close);
	}

	@Then("user confirms that the record is not changed")
	public void user_confirms_that_the_record_is_not_changed() {
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"Design Preview\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"ContactForm\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"Merchant\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"\"").isDisplayed());
	}

	
//	@SMSM-170-Verify-user-is-able-to-edit-details-within-the-language-strings-tab
	@When("User clicks on the Save Settings button on the Edit Language Strings")
	public void user_clicks_on_the_Save_Settings_button_on_the_Edit_Language_Strings() throws Exception {
		adminEditLanguageStringsModal.waitAndClickElement(adminEditLanguageStringsModal.btn_SaveSettings);
	}

	@Then("user confirms the changes to the Language Strings were saved correctly")
	public void user_confirms_the_changes_to_the_Language_Strings_were_saved_correctly() throws Exception {
		Thread.sleep(5000);
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"Design Preview - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"ContactForm - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"Admin\"").isDisplayed());
		Assert.assertTrue(adminSettingsAndLanguageStringsPage.cellValue("\"Automation Testing\"").isDisplayed());
	}
	
//	#Revert Changes to the Settings
	@Then("User revert changes made to the language strings")
	public void user_revert_changes_made_to_the_language_strings() throws Exception {
		adminSettingsAndLanguageStringsPage.waitAndClickElement(adminSettingsAndLanguageStringsPage.editSettingByTitle("\"Design Preview - edited\""));
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Title, "Design Preview");
		adminEditLanguageStringsModal.clickOnTextFromDropdownList(adminEditLanguageStringsModal.typeDDown, "Text");
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Group, "ContactForm");
		adminEditLanguageStringsModal.clickOnTextFromDropdownList(adminEditLanguageStringsModal.roleDDown, "Merchant");
		adminEditLanguageStringsModal.sendKeysToWebElement(adminEditLanguageStringsModal.txtF_Description, "");
		adminEditLanguageStringsModal.waitAndClickElement(adminEditLanguageStringsModal.btn_SaveSettings);
	}

//	@SMSM-170-Verify-the-help-functionality-for-Language-Strings-page
	@Then("the Tour guide on the Language Strings page is opened")
	public void the_Tour_guide_on_the_Language_Strings_page_is_opened() throws Exception {
		Assert.assertEquals("Language Strings Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
	@When("User clicks on Next button on Language Strings Management")
	public void user_clicks_on_Next_button_on_Language_Strings_Management() throws Exception {
	commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("Tour guide should proceed to Search Language Strings window")
	public void tour_guide_should_proceed_to_Search_Language_Strings_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
	Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.mod_Help_Title).contentEquals("Search Language Strings"));
	}

	@When("User clicks on Previous button from the Search Language Strings windows")
	public void user_clicks_on_Previous_button_from_the_Search_Language_Strings_windows() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("Tour guide is navigated to Language Strings Management window")
	public void tour_guide_is_navigated_to_Language_Strings_Management_window() throws Exception {
	Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.mod_Help_Title).contentEquals("Language Strings Management"));
	}
}
