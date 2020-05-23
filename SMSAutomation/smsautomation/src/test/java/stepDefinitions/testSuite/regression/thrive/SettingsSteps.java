package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.LanguageStringsPage;
import pageObjects.thrive.MessageTemplatesPage;
import pageObjects.thrive.SettingsPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.EditMessageTemplateModal;
import pageObjects.thrive.modal.EditSettingsModal;
import pageObjects.thrive.modal.EditStringModal;
import pageObjects.thrive.modal.LanguagePageHelpModal;
import pageObjects.thrive.modal.MessageTemplatesPageHelpModal;
import pageObjects.thrive.modal.SettingsPageHelpModal;
import utils.DriverFactory;

public class SettingsSteps extends DriverFactory {

	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditMessageTemplateModal editEmailTemplateModal = PageFactory.initElements(driver,
			EditMessageTemplateModal.class);
	public EditSettingsModal editSettingsModal = PageFactory.initElements(driver, EditSettingsModal.class);
	public EditStringModal editStringModal = PageFactory.initElements(driver, EditStringModal.class);
	public LanguageStringsPage languageStringsPage = PageFactory.initElements(driver, LanguageStringsPage.class);
	public LanguagePageHelpModal languagePageHelpModal = PageFactory.initElements(driver, LanguagePageHelpModal.class);
	public MessageTemplatesPage messageTemplatesPage = PageFactory.initElements(driver, MessageTemplatesPage.class);
	public MessageTemplatesPageHelpModal messageTemplatesPageHelpModal = PageFactory.initElements(driver, MessageTemplatesPageHelpModal.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
	public SettingsPageHelpModal settingsPageHelpModal = PageFactory.initElements(driver, SettingsPageHelpModal.class);

	
//   @SMSM-136 @View-Settings-Under-Settings-option @RegressionTest
	@When("User clicks the Settings menu item")
	public void user_clicks_the_Settings_menu_item() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Settings);
	}

	@Then("a dropdown apears with the Settings options")
	public void a_dropdown_apears_with_the_Settings_options() {
		Assert.assertTrue(commonElementLocator.menu_dropdown.isDisplayed());
	}

	@When("User clicks on Settings option from the dropdown")
	public void user_clicks_on_Settings_option_from_the_dropdown() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Settings);
	}

	@Then("the Settings page is opened")
	public void the_Settings_page_is_opened() throws Exception {
		Assert.assertEquals("Settings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User confirms the columns on the Settings page")
	public void user_confirms_the_columns_on_the_Settings_page() throws Exception {
		Assert.assertTrue(settingsPage.col_Title.isDisplayed());
		Assert.assertTrue(settingsPage.col_Group.isDisplayed());
		Assert.assertTrue(settingsPage.col_Value.isDisplayed());
		Assert.assertTrue(settingsPage.col_Description.isDisplayed());
		Assert.assertTrue(settingsPage.col_Updated.isDisplayed());
	}

//	 @SMSM-136 @View-Language-String-Under-Settings-option
	@When("User clicks on Language Strings from the dropdown")
	public void user_clicks_on_Language_Strings_from_the_dropdown() throws InterruptedException {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Language_Strings);
	}

	@Then("the Language Strings page is opened")
	public void the_Language_Strings_page_is_opened() throws Exception {
		Assert.assertEquals("Language Strings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User confirms the columns on the Language Strings page")
	public void user_confirms_the_columns_on_the_Language_Strings_page() throws Exception {
		Assert.assertTrue(languageStringsPage.col_Title.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_Group.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_AccessLevel.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_Value.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_Description.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_Updated.isDisplayed());
		Assert.assertTrue(languageStringsPage.col_Action.isDisplayed());
	}

//	 @SMSM-136 @View-Email-Templates-Under-Settings-option
	@When("User clicks on Message Templates from the dropdown")
	public void user_clicks_on_Message_Templates_from_the_dropdown() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Message_Templates);
	}

	@Then("the Message Templates page is opened")
	public void the_Message_Templates_page_is_opened() throws Exception {
		Assert.assertEquals("Message Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User confirms the columns on the Message Templates page")
	public void user_confirms_the_columns_on_the_Message_Templates_page() {
		Assert.assertTrue(messageTemplatesPage.col_Title.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Subject.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Description.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Updated.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Action.isDisplayed());
	}

//	@SMSM-136 @Search-and-Edit-any-Manage-Settings-option
	@When("User types the Settings title in the Search box and click Search button")
	public void user_types_the_Settings_title_in_the_Search_box_and_click_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Initial");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Settings record is displayed")
	public void the_Settings_record_is_displayed() {
		Assert.assertTrue(settingsPage.searchRecord("Initial Post Status").isDisplayed());
	}

	@When("User clicks the Edit button for the Settings")
	public void user_clicks_the_Edit_button_for_the_Settings() throws Exception {
		settingsPage.waitAndClickElement(settingsPage.editSettingByTitle("Initial Post Status"));
	}

	@Then("the Edit Setting popup is displayed")
	public void the_Edit_Setting_popup_is_displayed() throws Exception {
		Assert.assertEquals("Edit Setting", editSettingsModal.getElementText(editSettingsModal.mod_Title));
	}

	@When("User clicks the dropdown textbox on the Edit Setting modal")
	public void user_clicks_the_dropdown_textbox_on_the_Edit_Setting_modal() throws Exception {
		editSettingsModal.waitAndClickElement(editSettingsModal.lov_EditSetting);
	}

	@And("User clicks a Setting option and clicks the Update Setting button")
	public void user_clicks_a_Setting_option_and_clicks_the_Update_Setting_button() throws Exception {
		editSettingsModal.waitAndClickElement(editSettingsModal.editSettingOption("Approved"));
		editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSettings);
	}

	@Then("User confirms that the changes is reflected on the settings page")
	public void user_confirms_that_the_changes_is_reflected_on_the_settings_page() throws Exception {
		driver.navigate().refresh();
		Assert.assertTrue(settingsPage.colValueOption("Approved").isDisplayed());
	}

	@When("User changes Settings option to it's original value and clicks the Update Setting button")
	public void user_changes_Settings_option_to_it_s_original_value_and_clicks_the_Update_Setting_button()
			throws Exception {
		editSettingsModal.waitAndClickElement(editSettingsModal.editSettingOption("Suppressed"));
		editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSettings);
	}

//	@SMSM-136 @Search-and-Edit-any-Language-String-option
	@When("User clicks on Language Strings option from the dropdown")
	public void user_clicks_on_Language_Strings_option_from_the_dropdown() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Language_Strings);
	}

	@When("User types the Language String title in the Search box and click Search button")
	public void user_types_the_Language_String_title_in_the_Search_box_and_click_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Select account");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Language String record is displayed")
	public void the_Language_String_record_is_displayed() {
		Assert.assertTrue(settingsPage.searchRecord("Select account").isDisplayed());
	}

	@When("User clicks the Edit button for the Language Strings")
	public void user_clicks_the_Edit_button_for_the_Language_Strings() throws Exception {
		languageStringsPage.waitAndClickElement(languageStringsPage.editLanguageStringsByTitle("Select account"));
	}

	@Then("the Edit String popup is displayed")
	public void the_Edit_String_popup_is_displayed() throws Exception {
		Assert.assertEquals("Edit String", editStringModal.getElementText(editStringModal.mod_Title));
	}

	@Then("User enters the required information into the text field")
	public void user_enters_the_required_information_into_the_text_field() throws Exception {
		editStringModal.sendKeysToWebElement(editStringModal.txt_EditString, "Select account1");
	}

	@Then("User clicks the Update Setting button")
	public void user_clicks_the_Update_Setting_button() throws Exception {
		editStringModal.waitAndClickElement(editStringModal.btn_SaveString);
	}

	@Then("User confirms the change is reflected on the settings page")
	public void user_confirms_the_change_is_reflected_on_the_settings_page() {
		driver.navigate().refresh();
		Assert.assertTrue(settingsPage.colValueOption("Select account1").isDisplayed());
	}

	@Then("User clicks the Edit button for Language Strings")
	public void user_clicks_the_Edit_button_for_Language_Strings() throws Exception {
		languageStringsPage.waitAndClickElement(languageStringsPage.editLanguageStringsByTitle("Select account"));
	}

	@When("User changed the Language String to it's original value and clicks the Update Setting button")
	public void user_changed_the_Language_String_to_it_s_original_value_and_clicks_the_Update_Setting_button()
			throws Exception {
		editStringModal.sendKeysToWebElement(editStringModal.txt_EditString, "Select account");
		editStringModal.waitAndClickElement(editStringModal.btn_SaveString);
	}

//	@SMSM-136 @Search-and-Edit-any-Email-Template
	@When("User types a Message Templates title in the Search box and click Search button")
	public void user_types_a_Message_Templates_title_in_the_Search_box_and_click_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Response to review");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Message Templates record is displayed")
	public void the_Message_Templates_record_is_displayed() throws Exception {
		Assert.assertTrue(messageTemplatesPage.searchRecord("Response to review").isDisplayed());
	}

	@When("User clicks the Edit button for the Message Templates")
	public void user_clicks_the_Edit_button_for_the_Message_Templates() throws Exception {
		messageTemplatesPage
				.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Response to review"));
	}

	@Then("the Edit Message Template popup is displayed")
	public void the_Edit_Message_Template_popup_is_displayed() throws InterruptedException {
		Assert.assertEquals("Edit Message Template",
				editEmailTemplateModal.getElementText(editEmailTemplateModal.mod_Title));
	}

	@Then("User enters the required information into the text field on the popup")
	public void user_enters_the_required_information_into_the_text_field_on_the_popup() throws Exception {
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_Subject, "Response to Automation");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_To, "test@aclate.com");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_SMSText, "Automation text");
	}

	@Then("User clicks the Save Settings button")
	public void user_clicks_the_Save_Settings_button() throws Exception {
		editEmailTemplateModal.waitAndClickElement(editEmailTemplateModal.btn_SaveSettings);
	}

	@Then("User confirms the change is reflected on the Message Templates page")
	public void user_confirms_the_change_is_reflected_on_the_Message_Templates_page() {
		driver.navigate().refresh();
		Assert.assertTrue(messageTemplatesPage.colValueOption("Response to Automation").isDisplayed());

	}

	@Then("User clicks the Edit button for the Message Template")
	public void user_clicks_the_Edit_button_for_the_Message_Template() throws Exception {
		messageTemplatesPage
				.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Response to review"));
	}

	@When("User changed the Message Template fields to it's original value and clicks the Save Settings button")
	public void user_changed_the_Message_Template_fields_to_it_s_original_value_and_clicks_the_Save_Settings_button()
			throws Exception {
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_Subject, "Response to your review");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_To, "");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_SMSText, "");
		editEmailTemplateModal.waitAndClickElement(editEmailTemplateModal.btn_SaveSettings);
	}

//	@SMSM-136 @Help-Guide-for-Manage-Settings-page
	@When("User clicks the Help button on the Setting")
	public void user_clicks_the_Help_button_on_the_Setting() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Settings Management pop up is opened")
	public void the_Settings_Management_pop_up_is_opened() throws Exception {
		Assert.assertEquals("Settings Management",settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getSettingsManagementContent(), settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Settings Management pop up window")
	public void user_clicks_the_Next_button_on_the_Settings_Management_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search Setting pop up is displayed")
	public void the_Search_Setting_pop_up_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search Settings", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getSearchSettings(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on Search Settings pop up window")
	public void user_clicks_the_Next_button_on_Search_Settings_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Title pop up dialog is displayed")
	public void the_Title_pop_up_dialog_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Title", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getTITLE(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Tile pop up window")
	public void user_clicks_the_Next_button_on_the_Tile_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Group pop up dialog is displayed")
	public void the_Group_pop_up_dialog_is_displayed() throws InterruptedException {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Group", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getGROUP(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Group pop up window")
	public void user_clicks_the_Next_button_on_the_Group_pop_up_window() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Value pop up dialog is displayed")
	public void the_Value_pop_up_dialog_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Value", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getVALUE(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Value pop up window")
	public void user_clicks_the_Next_button_on_the_Value_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Description pop up dialog is displayed")
	public void the_Description_pop_up_dialog_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Description", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getDESCRIPTION(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Description pop up window")
	public void user_clicks_the_Next_button_on_the_Description_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Updated pop up dialog is displayed")
	public void the_Updated_pop_up_dialog_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Updated", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getUPDATED(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Updated pop up window")
	public void user_clicks_the_Next_button_on_the_Updated_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Action pop up dialog is displayed")
	public void the_Action_pop_up_dialog_is_displayed() throws Exception {
		settingsPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Action", settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(settingsPageHelpModal.getACTION(),
				settingsPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the End Tour button on the Action pop up window")
	public void user_clicks_the_End_Tour_button_on_the_Action_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_EndTour);
	}

	@Then("the pop up window is closed")
	public void the_pop_up_window_is_closed() {
		settingsPageHelpModal.waitUntilElementDissapears(commonElementLocator.mod_Help_Title);
	}

	
//	@SMSM-136 @Help-Guide-for-Language-String-page
	@Then("the Language String Management pop up is opened")
	public void the_Language_String_Management_pop_up_is_opened() throws InterruptedException {
		Assert.assertEquals("Language Strings Management",languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getLANGUAGE_STRINGS_MANAGEMENT(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Language String Management pop up window")
	public void user_clicks_the_Next_button_on_the_Language_String_Management_pop_up_window() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search Language Strings pop up is displayed")
	public void the_Search_Language_Strings_pop_up_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search Language Strings", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getSEARCH_LANGUAGE_STRING(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on Search Language Strings pop up window")
	public void user_clicks_the_Next_button_on_Search_Language_Strings_pop_up_window() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Title pop up dialog for Language String is displayed")
	public void the_Title_pop_up_dialog_for_Language_String_is_displayed() throws InterruptedException {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Title", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getTITLE(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Tile pop up window for Language Strings")
	public void user_clicks_the_Next_button_on_the_Tile_pop_up_window_for_Language_Strings() throws Exception {
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Group pop up dialog for Language String is displayed")
	public void the_Group_pop_up_dialog_for_Language_String_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Group", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getGROUP(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Group pop up window for Language Strings")
	public void user_clicks_the_Next_button_on_the_Group_pop_up_window_for_Language_Strings() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Value pop up dialog for Language String is displayed")
	public void the_Value_pop_up_dialog_for_Language_String_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Value", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getVALUE(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Value pop up window for Language Strings")
	public void user_clicks_the_Next_button_on_the_Value_pop_up_window_for_Language_Strings() throws Exception {
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Description pop up dialog for Language String is displayed")
	public void the_Description_pop_up_dialog_for_Language_String_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Description", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getDESCRIPTION(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Description pop up window for Language String")
	public void user_clicks_the_Next_button_on_the_Description_pop_up_window_for_Language_String() throws Exception {
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Updated pop up dialog for Language String is displayed")
	public void the_Updated_pop_up_dialog_for_Language_String_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Updated", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getUPDATED(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Updated pop up window for Language String")
	public void user_clicks_the_Next_button_on_the_Updated_pop_up_window_for_Language_String() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Action pop up dialog for Language String is displayed")
	public void the_Action_pop_up_dialog_for_Language_String_is_displayed() throws Exception {
		languagePageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Actions", languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(languagePageHelpModal.getACTION(), languagePageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

//	 @SMSM-136 @Help-Guide-for-Email-Templates-page
	@Then("the Message Template Management pop up is opened")
	public void the_Message_Template_Management_pop_up_is_opened() throws Exception {
		Assert.assertEquals("Message Template Management",messageTemplatesPage.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getMESSAGE_TEMPLATES_MANAGEMENT(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Message Template Management pop up window")
	public void user_clicks_the_Next_button_on_the_Message_Template_Management_pop_up_window() throws Exception {
	   commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search Message Templates pop up is displayed")
	public void the_Search_Message_Templates_pop_up_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search Message Templates", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getSEARCH_MESSAGE_TEMPLATES(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on Search Message Templates pop up window")
	public void user_clicks_the_Next_button_on_Search_Message_Templates_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Title pop up dialog for Message Templates String is displayed")
	public void the_Title_pop_up_dialog_for_Message_Templates_String_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Title", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getTITLE(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Tile pop up window for Message Templates")
	public void user_clicks_the_Next_button_on_the_Tile_pop_up_window_for_Message_Templates() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Subject pop up dialog is displayed")
	public void the_Subject_pop_up_dialog_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Subject", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getSUBJECT(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Subject pop up window")
	public void user_clicks_the_Next_button_on_the_Subject_pop_up_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Description pop up dialog for Message Templates is displayed")
	public void the_Description_pop_up_dialog_for_Message_Templates_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Description", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getDESCRIPTION(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Description pop up window for Message Templates")
	public void user_clicks_the_Next_button_on_the_Description_pop_up_window_for_Message_Templates() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Updated pop up dialog for Message Templates is displayed")
	public void the_Updated_pop_up_dialog_for_Message_Templates_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Updated", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getUPDATED(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}

	@When("User clicks the Next button on the Updated pop up window for Message Templates")
	public void user_clicks_the_Next_button_on_the_Updated_pop_up_window_for_Message_Templates() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Action pop up dialog for Message Templates is displayed")
	public void the_Action_pop_up_dialog_for_Message_Templates_is_displayed() throws Exception {
		messageTemplatesPageHelpModal.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Action", messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Title));
		Assert.assertEquals(messageTemplatesPageHelpModal.getACTION(), messageTemplatesPageHelpModal.getElementText(commonElementLocator.mod_Help_Content));
	}
	
	
//	@SMSM-136 @Apply-Sort-in-Manage-Settings-page
	@When("User clicks the Title column name")
	public void user_clicks_the_Title_column_name() throws InterruptedException {
		//Verify the current value of the title cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("SMTP Host"));
		settingsPage.waitAndClickElement(settingsPage.col_Title);
	}

	@Then("the Settings records are sorted by Tilte column")
	public void the_Settings_records_are_sorted_by_Tilte_column() throws Exception {
		//Verify the value of the title cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("Allowed Domains"));
	}
	
	@When("User clicks the Group column name")
	public void user_clicks_the_Group_column_name() throws Exception {
		//Reverse sorting on Title
		settingsPage.waitAndClickElement(settingsPage.col_Title);
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("Social Streams"));
		settingsPage.waitAndClickElement(settingsPage.col_Group);
	}

	@Then("the Settings records are sorted by Group column")
	public void the_Settings_records_are_sorted_by_Group_column() throws Exception {
		//Verify the value of the Group cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("Email Settings"));
	}

	@When("User clicks the Value column name")
	public void user_clicks_the_Value_column_name() throws InterruptedException {
		//Verify the current value of the Value cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("smtp.sendgrid.net"));	
		settingsPage.waitAndClickElement(settingsPage.col_Value);
	}

	@Then("the Settings records are sorted by Value column")
	public void the_Settings_records_are_sorted_by_Value_column() throws Exception {
		//Verify the value of the Value cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("Unread"));
	}

	@When("User clicks the Description column name")
	public void user_clicks_the_Description_column_name() throws Exception {
		//Verify the current value of the Description cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals("Set as default Streams Read/Unread"));
		settingsPage.waitAndClickElement(settingsPage.col_Description);
	}

	@Then("the Settings record are sorted by Description column.")
	public void the_Settings_record_are_sorted_by_Description_column() throws InterruptedException {
		//Verify the value of the Description cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals(""));
	}

	@When("User clicks the Updated column name")
	public void user_clicks_the_Updated_column_name() throws Exception {
		//Verify the current value of the Updated cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "5")).contentEquals("08/25/2015"));
		settingsPage.waitAndClickElement(settingsPage.col_Updated);
	}

	@Then("the Settings records are sorted by Updated colum")
	public void the_Settings_records_are_sorted_by_Updated_colum() throws InterruptedException {
		//Verify the value of the Updated cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "5")).contains("2020"));
	}

//	@SMSM-136 @Apply-Sort-in-Language-String-page
	@When("User clicks the Title column name on Language Strings page")
	public void user_clicks_the_Title_column_name_on_Language_Strings_page() throws InterruptedException {
		//Verify the current value of the title cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("Save"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_Title);
	}

	@Then("the Language Strings records are sorted by Tilte column")
	public void the_Language_Strings_records_are_sorted_by_Tilte_column() throws Exception {
		//Verify the current value of the title cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("Filters"));
	}

	@When("User clicks the Group column name on Language Strings page")
	public void user_clicks_the_Group_column_name_on_Language_Strings_page() throws InterruptedException {
		//Verify the current value of the Group cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("Controls"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_Group);
	}

	@Then("the Language Strings records are sorted by Group column")
	public void the_Language_Strings_records_are_sorted_by_Group_column() throws Exception {
		//Verify the current value of the Group cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("Streams"));
	}

	@When("User clicks the Access Level column name")
	public void user_clicks_the_Access_Level_column_name() throws InterruptedException {
		//Verify the current value of the Access Level cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("Merchant"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_AccessLevel);
	}

	@Then("the Language Strings records are sorted by Access Level column")
	public void the_Language_Strings_records_are_sorted_by_Access_Level_column() throws InterruptedException {
		//Verify the current value of the Access Level cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("Merchant"));
	}

	@When("User clicks the Value column name on Language Strings page")
	public void user_clicks_the_Value_column_name_on_Language_Strings_page() throws InterruptedException {
		//Verify the current value of the Value cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals("Save"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_Value);
	}

	@Then("the Language Strings records are sorted by Value column")
	public void the_Language_Strings_records_are_sorted_by_Value_column() throws InterruptedException {
		//Verify the current value of the Value cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals("Your Review"));
	}

	@When("User clicks the Description column name on Language Strings page")
	public void user_clicks_the_Description_column_name_on_Language_Strings_page() throws InterruptedException {
		//Verify the current value of the Description cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "5")).contentEquals("Heading on the write a review page"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_Description);
	}

	@Then("the Language Strings record are sorted by Description column.")
	public void the_Language_Strings_record_are_sorted_by_Description_column() throws Exception {
		//Verify the current value of the Description cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "5")).contentEquals(""));
	}

	@When("User clicks the Updated column name on Language String page")
	public void user_clicks_the_Updated_column_name_on_Language_String_page() throws InterruptedException {
		//Verify the current value of the Updated cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "6")).contentEquals("03/08/2016"));
		languageStringsPage.waitAndClickElement(languageStringsPage.col_Updated);
	}

	@Then("the Language Strings records are sorted by Updated column")
	public void the_Language_Strings_records_are_sorted_by_Updated_column() throws Exception {
		//Verify the current value of the Updated cell after sorting
//		Thread.sleep(30000);
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "6")).contentEquals("01/16/2018"));
	}

//	@SMSM-136 @Apply-Sort-in-Email-Template-page
	@When("User clicks the Title column name on Message Template page")
	public void user_clicks_the_Title_column_name_on_Message_Template_page() throws InterruptedException {
		//Verify the current value of the Title cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("Contact form Submission"));
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.col_Title);
	}

	@Then("the Message Templates records are sorted by Tilte column")
	public void the_Message_Templates_records_are_sorted_by_Tilte_column() throws Exception {
		//Verify the current value of the Title cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "1")).contentEquals("Contact form Submission"));
	}

	@When("User clicks the Subject column name on Message Templates page")
	public void user_clicks_the_Subject_column_name_on_Message_Templates_page() throws Exception {
		//Verify the current value of the Subject cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("EasyConnect Submission"));
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.col_Subject);
	}

	@Then("the Message Templates records are sorted by Subject column")
	public void the_Message_Templates_records_are_sorted_by_Subject_column() throws Exception {
		//Verify the current value of the Subject cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "2")).contentEquals("Thrive reply to your review"));
	}

	@When("User clicks the Description column name on Message Templates page")
	public void user_clicks_the_Description_column_name_on_Message_Templates_page() throws InterruptedException {
		//Verify the current value of the Description cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("This email is set to the user immedatly when admin, licensee or merchant replied to the users thrive review"));
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.col_Description);
	}

	@Then("the Message Templates record are sorted by Description column.")
	public void the_Message_Templates_record_are_sorted_by_Description_column() throws InterruptedException {
		//Verify the current value of the Description cell after sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "3")).contentEquals("This email is sent to a merchant when a user submits a contact form"));
	}

	@When("User clicks the Updated column name on Message Templates page")
	public void user_clicks_the_Updated_column_name_on_Message_Templates_page() throws Exception {
		//Verify the current value of the Updated cell before sorting
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals("02/18/2015"));
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.col_Updated);
	}

	@Then("the Message Templates records are sorted by Updated column")
	public void the_Message_Templates_records_are_sorted_by_Updated_column() throws InterruptedException {
		//Verify the current value of the Updated cell after sorting;
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.recordCellValue("1", "4")).contentEquals(commonElementLocator.getGMTDate()));
	}

}
