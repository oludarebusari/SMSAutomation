package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.MessageTemplatesPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.ActivatePageModal;
import pageObjects.thrive.modal.EditMessageTemplateModal;
import utils.DriverFactory;

public class ViewAndEditEmailScreenTemplatesSteps extends DriverFactory {
	
	
	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditMessageTemplateModal editMessageTemplateModal = PageFactory.initElements(driver, EditMessageTemplateModal.class);
	public MessageTemplatesPage messageTemplatesPage = PageFactory.initElements(driver, MessageTemplatesPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	

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
//		editMessageTemplateModal.WaitUntilWebElementIsVisible(editMessageTemplateModal.btn_MSaveSettings);
		Assert.assertTrue(editMessageTemplateModal.btn_MSaveSettings.getAttribute("class").contains("disabled"));
	}
	
}
