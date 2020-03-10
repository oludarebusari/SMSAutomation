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
import pageObjects.thrive.modal.EditEmailTemplateModal;
import pageObjects.thrive.modal.EditSettingsModal;
import pageObjects.thrive.modal.EditStringModal;
import utils.DriverFactory;

public class SettingsSteps extends DriverFactory {

	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditEmailTemplateModal editEmailTemplateModal = PageFactory.initElements(driver, EditEmailTemplateModal.class);
	public EditSettingsModal editSettingsModal = PageFactory.initElements(driver, EditSettingsModal.class);
	public EditStringModal editStringModal = PageFactory.initElements(driver, EditStringModal.class);
	public LanguageStringsPage languageStringsPage = PageFactory.initElements(driver, LanguageStringsPage.class);
	public MessageTemplatesPage messageTemplatesPage = PageFactory.initElements(driver, MessageTemplatesPage.class);
	public SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);

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
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_Settings);
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
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_LanguageStrings);
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
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_MessageTemplates);
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

//	@SMSM-136 @Edit-any-Manage-Settings-option
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
		editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSetting);
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
		editSettingsModal.waitAndClickElement(editSettingsModal.btn_SaveSetting);
	}

	@When("User clicks on Language Strings option from the dropdown")
	public void user_clicks_on_Language_Strings_option_from_the_dropdown() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_LanguageStrings);
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
	public void user_changed_the_Language_String_to_it_s_original_value_and_clicks_the_Update_Setting_button() throws Exception {
		editStringModal.sendKeysToWebElement(editStringModal.txt_EditString, "Select account");
		editStringModal.waitAndClickElement(editStringModal.btn_SaveString);
	}
	
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
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Response to review"));
	}

	@Then("the Edit Message Template popup is displayed")
	public void the_Edit_Message_Template_popup_is_displayed() throws InterruptedException {
		Assert.assertEquals("Edit Message Template", editEmailTemplateModal.getElementText(editEmailTemplateModal.mod_Title));
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
	  messageTemplatesPage.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Response to review"));
	}

	@When("User changed the Message Template fields to it's original value and clicks the Save Settings button")
	public void user_changed_the_Message_Template_fields_to_it_s_original_value_and_clicks_the_Save_Settings_button() throws Exception {
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_Subject, "Response to your review");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_To, "");
		editEmailTemplateModal.sendKeysToWebElement(editEmailTemplateModal.txtF_SMSText, "");
		editEmailTemplateModal.waitAndClickElement(editEmailTemplateModal.btn_SaveSettings);
	}

}
