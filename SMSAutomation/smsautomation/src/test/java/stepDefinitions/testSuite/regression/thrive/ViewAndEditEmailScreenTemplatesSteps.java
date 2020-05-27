package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.MessageTemplatesPage;
import pageObjects.thrive.ScreenTemplatesPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.ActivatePageModal;
import pageObjects.thrive.modal.ActivateScreenTemplateModal;
import pageObjects.thrive.modal.DeactivateScreenTemplateModal;
import pageObjects.thrive.modal.EditMessageTemplateModal;
import utils.DriverFactory;

public class ViewAndEditEmailScreenTemplatesSteps extends DriverFactory {
	
	
	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public ActivateScreenTemplateModal activateScreenTemplateModal = PageFactory.initElements(driver, ActivateScreenTemplateModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public DeactivateScreenTemplateModal deactivateScreenTemplateModal = PageFactory.initElements(driver, DeactivateScreenTemplateModal.class);
	public EditMessageTemplateModal editMessageTemplateModal = PageFactory.initElements(driver, EditMessageTemplateModal.class);
	public MessageTemplatesPage messageTemplatesPage = PageFactory.initElements(driver, MessageTemplatesPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public ScreenTemplatesPage screenTemplatesPage = PageFactory.initElements(driver, ScreenTemplatesPage.class);
	

//	@Verify-Email-Templates-option-under-Settings-in-admin-dashboard
	@When("User clicks the Message Templates")
	public void user_clicks_the_Message_Templates() throws Exception {
	  settingsDDown.waitAndClickElement(settingsDDown.opt_Message_Templates);
	}

	@Then("User is redirected to Email Templates page")
	public void user_is_redirected_to_Email_Templates_page() throws InterruptedException {
		Assert.assertEquals("Message Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	@Then("User validates the message templates fields and that records are present")
	public void user_validates_the_message_templates_fields_and_that_records_are_present() throws Exception, InterruptedException {
		Assert.assertTrue(messageTemplatesPage.col_Title.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Subject.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Description.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Updated.isDisplayed());
		Assert.assertTrue(messageTemplatesPage.col_Action.isDisplayed());
	    Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)) > 0);
	}
	
//	@Verify-user-is-able-to-modify-email-templates-within-templates-list 
	@Then("User verifies that the edit button is displayed against each message template lit")
	public void user_verifies_that_the_edit_button_is_displayed_against_each_message_template_lit() throws Exception {
		Assert.assertEquals(10, messageTemplatesPage.getNumberOfElements(messageTemplatesPage.getEDITBTN()));
	}

	@When("User clicks the edit button for a message template")
	public void user_clicks_the_edit_button_for_a_message_template() throws Exception {
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Invoice Created test"));
	}

	@Then("the Message template window is opened")
	public void the_Message_template_window_is_opened() throws Exception {
		Assert.assertEquals("Edit Message Template", editMessageTemplateModal.getElementText(editMessageTemplateModal.mod_Title));
	}

	@Then("User enters value for all the fields")
	public void user_enters_value_for_all_the_fields() throws Exception {
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MSubject, "Your Yearly Invoice - edited");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MTo, "testTo@QA.com");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_FROM, "testAuto@auto.com");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MCC, "testing@guess.com");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MBCC, "rufu@yes.com");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Header, "This is the header");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_EmailBody, "This is the body");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_SMSText, "This is sms text");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Footer, "This is the footer");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Title, "Invoice Created test");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Slug, "invoice.created.testauto");
		editMessageTemplateModal.clickOnTextFromDropdownList(editMessageTemplateModal.txtF_Role, "Merchant");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Description, "Testing automation");
	}

	@When("User clicks the Update tab")
	public void user_clicks_the_Update_tab() throws Exception {
	   editMessageTemplateModal.waitAndClickElement(editMessageTemplateModal.btn_MSaveSettings);
	}

	@Then("changes are saved correctly")
	public void changes_are_saved_correctly() {
	 Assert.assertTrue(messageTemplatesPage.cellValue("\"Invoice Created test\"").isDisplayed());
	 Assert.assertTrue(messageTemplatesPage.cellValue("\"Your Yearly Invoice - edited\"").isDisplayed());
	 Assert.assertTrue(messageTemplatesPage.cellValue("\"Testing automation\"").isDisplayed());
	}

	
	@Then("User revert changes made to the Message Template")
	public void user_revert_changes_made_to_the_Message_Template() throws Exception {
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Invoice Created test"));
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MSubject, "Your Monthly Invoice");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MTo, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_FROM, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MCC, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MBCC, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Header, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_EmailBody, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_SMSText, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Footer, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Title, "Invoice Created");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Slug, "invoice.created");
		editMessageTemplateModal.clickOnTextFromDropdownList(editMessageTemplateModal.txtF_Role, "License");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Description, "");
	}
	
// Screen Templates
	
//	@Verfiy-that-on-clicking-(X)-button-user-is-navigated-back-to-email-templates-page
	@When("User clicks the X button on the right corner of the edit template window")
	public void user_clicks_the_X_button_on_the_right_corner_of_the_edit_template_window() throws Exception {
	  editMessageTemplateModal.waitAndClickElement(editMessageTemplateModal.btn_Close);
	}

	@Then("User is navigated back to email templates window")
	public void user_is_navigated_back_to_email_templates_window() {
		Assert.assertFalse(editMessageTemplateModal.btn_SaveSettings.isDisplayed());
	}

//	@Verify-that-user-is-not-able-to-update-settings-on-entering-invalid-data-in-different-fields
	@When("User enters an Invalid email address in To field")
	public void user_enters_an_Invalid_email_address_in_To_field() throws Exception {
	   editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MTo, "abc");
	   Assert.assertTrue(editMessageTemplateModal.error_To.isDisplayed());
	}

	@When("User enters invalid email address in From field")
	public void user_enters_invalid_email_address_in_From_field() throws Exception {
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_FROM, "dgf");
		Assert.assertTrue(editMessageTemplateModal.error_From.isDisplayed());
	}
	
	@When("User verifies that the Save Settings button is disabled")
	public void user_verifies_that_the_Save_Settings_button_is_disabled() {
		Assert.assertTrue(editMessageTemplateModal.btn_MSaveSettings.getAttribute("class").contains("disabled"));
	}
	
	
//	@Verify-that-mandatory-fields-are-marked-red-on-clicking-update-settings-without-entering-any-data
	@When("User clicks the edit button for a message template edit")
	public void user_clicks_the_edit_button_for_a_message_template_edit() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Invoice Past Due");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		messageTemplatesPage.waitAndClickElement(messageTemplatesPage.editMessageTemplatesByTitle("Invoice Past Due"));
	}

	@Then("the Message template window to edit is opened")
	public void the_Message_template_window_to_edit_is_opened() throws Exception {
		Assert.assertEquals("Edit Message Template", editMessageTemplateModal.getElementText(editMessageTemplateModal.mod_Title));
	}
	
	@When("User removes all the default values on the fields on the Edit Message tamplate window and clicks Save Settings button")
	public void user_removes_all_the_default_values_on_the_fields_on_the_Edit_Message_tamplate_window_and_clicks_Save_Settings_button() throws Exception {
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_MSubject, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_EmailBody, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Title, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtF_Slug, "");
		editMessageTemplateModal.sendKeysToWebElement(editMessageTemplateModal.txtA_Description, "");
		editMessageTemplateModal.waitAndClickElement(editMessageTemplateModal.btn_MSaveSettings);
	}

	@Then("vaidation messages are displayed for those fields")
	public void vaidation_messages_are_displayed_for_those_fields() throws Exception {
		Assert.assertTrue(editMessageTemplateModal.error_Subject.isDisplayed());
		Assert.assertTrue(editMessageTemplateModal.error_EmailBody.isDisplayed());
		Assert.assertTrue(editMessageTemplateModal.error_Title.isDisplayed());
		Assert.assertTrue(editMessageTemplateModal.error_Slug.isDisplayed());
		Assert.assertTrue(editMessageTemplateModal.error_Description.isDisplayed());
	}
	
//	Verify-that-user-is-navigated-to-screen-templates-page
	@When("User clicks the Screen Templates")
	public void user_clicks_the_Screen_Templates() throws Exception {
	 settingsDDown.waitAndClickElement(settingsDDown.opt_Screen_Templates); 
	}

	@Then("User should be navigated to Screen Templates page")
	public void user_should_be_navigated_to_Screen_Templates_page() throws Exception {
	  Assert.assertEquals("Screen Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));  
	}
	
//	@Verify-that-user-is-able-to-Deactivate-a-screen-template
	@Then("User verifies the columns on the Screen templates page")
	public void user_verifies_the_columns_on_the_Screen_templates_page() {
	   Assert.assertTrue(screenTemplatesPage.col_Name.isDisplayed());
	   Assert.assertTrue(screenTemplatesPage.col_Template.isDisplayed());
	   Assert.assertTrue(screenTemplatesPage.col_Verticals.isDisplayed());
	   Assert.assertTrue(screenTemplatesPage.col_Status.isDisplayed());
	   Assert.assertTrue(screenTemplatesPage.col_Action.isDisplayed());
	}

	@Then("user verifies that Deactivate button is present for all the rows under the Action column")
	public void user_verifies_that_Deactivate_button_is_present_for_all_the_rows_under_the_Action_column() throws Exception {
		Assert.assertEquals(10, screenTemplatesPage.getNumberOfElements(screenTemplatesPage.getDEACTIVATEBTN()));
	}

	@When("User clicks on deactivate button for a particular record")
	public void user_clicks_on_deactivate_button_for_a_particular_record() throws Exception {
		screenTemplatesPage.waitAndClickElement(screenTemplatesPage.btn_DeactivateByName("Offer"));
	}

	@Then("the Deactivate Screen Template window is opened")
	public void the_Deactivate_Screen_Template_window_is_opened() throws Exception {
		Assert.assertEquals("Deactivate Screen Template", deactivateScreenTemplateModal.getElementText(deactivateScreenTemplateModal.mod_Title));
	}

	@When("User clicks on the deactivate button on the pop-up window")
	public void user_clicks_on_the_deactivate_button_on_the_pop_up_window() throws Exception {
		deactivateScreenTemplateModal.waitAndClickElement(deactivateScreenTemplateModal.btn_Deactivate);
	}

	@Then("User confirms the status of the screen template is updated")
	public void user_confirms_the_status_of_the_screen_template_is_updated() {
		Assert.assertTrue(screenTemplatesPage.CellValueByName("Offer", "Inactive, Hidden").isDisplayed());
	}
	
	
//	@Verify-that-user-is-able-to-Reactivate-a-deactivated-template
	@When("User clicks on Activate button of the deactivated screen templates")
	public void user_clicks_on_Activate_button_of_the_deactivated_screen_templates() throws Exception {
		screenTemplatesPage.waitAndClickElement(screenTemplatesPage.btn_ActivateByName("Offer"));
	}

	@Then("the Activate Screen Template window is opened")
	public void the_Activate_Screen_Template_window_is_opened() throws Exception {
		Assert.assertEquals("Activate Screen Template", activateScreenTemplateModal.getElementText(activateScreenTemplateModal.mod_Title));
	}

	@When("User clicks on the Activate button on the modal")
	public void user_clicks_on_the_Activate_button_on_the_modal() throws Exception {
		activateScreenTemplateModal.waitAndClickElement(activateScreenTemplateModal.btn_Activate);
	}

	@Then("User confirms the status of the screen template that is activated")
	public void user_confirms_the_status_of_the_screen_template_that_is_activated() {
		Assert.assertTrue(screenTemplatesPage.CellValueByName("Offer", "Active").isDisplayed());
	}

	
//	@erify-that-user-is-able-to-filter-the-records-on-the-basis-of-verticals
	@When("User clicks on the Verticals dropdown box")
	public void user_clicks_on_the_Verticals_dropdown_box() throws Exception {
	 screenTemplatesPage.waitAndClickElement(screenTemplatesPage.txtF_Verticals);
	}

	@Then("the drop down option is displayed")
	public void the_drop_down_option_is_displayed() {
		Assert.assertTrue(screenTemplatesPage.VerticalOptions.isDisplayed());
	}

	@When("User selects a vertical option")
	public void user_selects_a_vertical_option() throws Exception {
	  screenTemplatesPage.waitAndClickElement(screenTemplatesPage.verticalsOpt("Fast Food"));
	  commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("records are displayed as per vertical selected")
	public void records_are_displayed_as_per_vertical_selected() throws NumberFormatException, InterruptedException {
		Assert.assertEquals(8, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}

	@When("User selects Multiple verticals")
	public void user_selects_Multiple_verticals() {
//	 TODO : There is no enough data to complete this.
	}

	@Then("records are displayed as per verticals selected")
	public void records_are_displayed_as_per_verticals_selected() {
//		 TODO : There is no enough data to complete this.
	}
	
	
//	@Verfiy-that-user-is-able-to-search-the-records
	@Then("User verifies that the search textbox is displayed on the page")
	public void user_verifies_that_the_search_textbox_is_displayed_on_the_page() {
		Assert.assertTrue(commonElementLocator.txtF_Search.isDisplayed());
	}

	@When("User enters a search keyword in the search textbox and click on Search button")
	public void user_enters_a_search_keyword_in_the_search_textbox_and_click_on_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Upsell");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the search result is displayed as per the search criterion")
	public void the_search_result_is_displayed_as_per_the_search_criterion() {
	Assert.assertTrue(screenTemplatesPage.CellValue("Upsell").isDisplayed());
	}

	@Then("User verifies that the Show n entries works correctly")
	public void user_verifies_that_the_Show_n_entries_works_correctly() throws Exception {
	 commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "");
	 commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	 commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	 commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("25"));
	 Assert.assertEquals(25, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
	}

	@Then("User verifies that paginator works correctly")
	public void user_verifies_that_paginator_works_correctly() throws Exception {
	   commonElementLocator.waitAndClickElement(commonElementLocator.btn_PaginationNext);
	   Assert.assertEquals(2, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).substring(0, 1)));
	}

//	@Verify-the-help-button-functionality-within-email-templates-page
	@Then("User is redirected to Message Templates page")
	public void user_is_redirected_to_Message_Templates_page() throws Exception {
	Assert.assertEquals("Message Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks the Help button on the Message Template page")
	public void user_clicks_the_Help_button_on_the_Message_Template_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Message Templates Management help tour window appears")
	public void the_Message_Templates_Management_help_tour_window_appears() throws Exception {
		Assert.assertEquals("Message Template Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Message Templates Management help window")
	public void user_clicks_the_Next_button_on_the_Message_Templates_Management_help_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search Message Templates is displayed")
	public void the_Search_Message_Templates_is_displayed() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search Message Templates",  commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on the Search Message Templates window")
	public void user_clicks_the_previous_button_on_the_Search_Message_Templates_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}
	
	@Then("User is navigated to the Message Templates Management window")
	public void user_is_navigated_to_the_Message_Templates_Management_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Message Template Management", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
		
//	@Verifiy-that-user-is-no-records-are-searched-when-keywords-entered-in-search-box-does-not-exist
	@Then("User verifies that a search text box is displayed")
	public void user_verifies_that_a_search_text_box_is_displayed() {
		Assert.assertTrue(commonElementLocator.txtF_Search.isDisplayed());
	}

	@When("User enters an invalid keyword in the search box")
	public void user_enters_an_invalid_keyword_in_the_search_box() throws Exception {
	  commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "vvvv");
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("user verifies that zero result is displayed")
	public void user_verifies_that_zero_result_is_displayed() throws Exception {
		Assert.assertEquals(0, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
	}
}
