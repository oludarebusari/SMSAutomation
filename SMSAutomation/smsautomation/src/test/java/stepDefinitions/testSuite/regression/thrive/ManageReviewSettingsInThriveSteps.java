package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BusinessDashboardPage;
import pageObjects.thrive.ManageBusinessPage;
import pageObjects.thrive.StreamsPage;
import pageObjects.thrive.Tab.ExperienceDDown;
import pageObjects.thrive.modal.StreamSettingsModal;
import utils.DriverFactory;

public class ManageReviewSettingsInThriveSteps  extends DriverFactory {
	
	public BusinessDashboardPage businessDashboardPage = PageFactory.initElements(driver, BusinessDashboardPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	public ManageBusinessPage manageBusinessPage = PageFactory.initElements(driver, ManageBusinessPage.class);
	public StreamsPage streamsPage = PageFactory.initElements(driver, StreamsPage.class);
	public StreamSettingsModal streamSettingsModal = PageFactory.initElements(driver, StreamSettingsModal.class);
	
	
//	@SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-page
	@When("User types the business name in the search field and clicks Search")
	public void user_types_the_business_name_in_the_search_field_and_clicks_Search() throws Exception {
	  commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Johnson & Fanger Painting");
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Business is displayed")
	public void the_Business_is_displayed() {
	Assert.assertTrue(manageBusinessPage.selectRecordByCompanyName("Johnson & Fanger Painting").isDisplayed());
	}

	@When("User navigates to the actions column of the Business for stream testing and clicks Sign In button")
	public void user_navigates_to_the_actions_column_of_the_Business_for_stream_testing_and_clicks_Sign_In_button() throws Exception {
	 manageBusinessPage.waitAndClickElement(manageBusinessPage.btn_SignIn("Johnson & Fanger Painting"));
	}
	
	@When("User clicks the Streams option")
	public void user_clicks_the_Streams_option() throws Exception {
		experienceDDown.waitAndClickElement(experienceDDown.opt_Streams);
	}

	@Then("the Stream page is opened")
	public void the_Stream_page_is_opened() throws Exception {
	 Assert.assertEquals("Streams", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	
//	 @SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-configuration-windows-pop-up
	@Then("User verifies that Settings button is displayed")
	public void user_verifies_that_Settings_button_is_displayed() throws Exception {
	  Assert.assertTrue(streamsPage.btn_Settings.isDisplayed());
	}

	@When("User clicks the Settings button")
	public void user_clicks_the_Settings_button() throws Exception {
	  streamsPage.waitAndClickElement(streamsPage.btn_Settings);
	}

	@Then("a Settings configuration pop is opened")
	public void a_Settings_configuration_pop_is_opened() throws Exception {
	Assert.assertEquals("Settings", streamSettingsModal.getElementText(streamSettingsModal.mod_Title));
	}
	
	@Then("User verifies the three tabs on the settings window")
	public void user_verifies_the_three_tabs_on_the_settings_window() {
	 Assert.assertTrue(streamSettingsModal.tab_StreamSettings.isDisplayed());
	 Assert.assertTrue(streamSettingsModal.tab_ReviewSettings.isDisplayed());
	 Assert.assertTrue(streamSettingsModal.tab_ReviewTemplates.isDisplayed());
	}


//  @SMSM-240 @Verify-that-user-is-able-to-set-Reviews-System-value-under-Review-Settings-tab
	@When("User Clicks the Reviews Settings tab")
	public void user_Clicks_the_Reviews_Settings_tab() throws Exception {
		streamSettingsModal.waitAndClickElement(streamSettingsModal.tab_ReviewSettings);
	}

	@Then("the Review Settings tab is opened")
	public void the_Review_Settings_tab_is_opened() {
		streamSettingsModal.WaitUntilWebElementIsVisible(streamSettingsModal.btn_ReviewsEnabled);
		Assert.assertTrue(streamSettingsModal.btn_ReviewsEnabled.isDisplayed());
	}

	@When("User hovers on Review System")
	public void user_hovers_on_Review_System() {
		Actions actions = new Actions(driver);
		actions.moveToElement(streamSettingsModal.title_ReviewsSystem).perform();
	}

	@Then("the help description of Review System is displayed")
	public void the_help_description_of_Review_System_is_displayed() throws Exception {
		Assert.assertEquals(streamSettingsModal.getREVIEWS_SYETEM_TOOLTIP_TEXT(), streamSettingsModal.getElementText(streamSettingsModal.title_ReviewSSYSTooltip));
	}

	@Then("User verifies the two button available for Review System")
	public void user_verifies_the_two_button_available_for_Review_System() {
	   Assert.assertTrue(streamSettingsModal.btn_ReviewsEnabled.isDisplayed());
	   Assert.assertTrue(streamSettingsModal.btn_ReviewsDisabled.isDisplayed());
	}

	@When("User clicks on the Reviews Disabled button")
	public void user_clicks_on_the_Reviews_Disabled_button() throws Exception {
	streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_ReviewsDisabled);
	}

	@Then("the Review is Disabled")
	public void the_Review_is_Disabled() {
	 Assert.assertTrue(streamSettingsModal.btn_ReviewsDisabled.getAttribute("class").contains("active"));
	}

	@When("User clicks the Review Enabled button")
	public void user_clicks_the_Review_Enabled_button() throws Exception {
	   streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_ReviewsEnabled);
	}

	@Then("the Review is Enabled")
	public void the_Review_is_Enabled() {
	   Assert.assertTrue(streamSettingsModal.btn_ReviewsEnabled.getAttribute("class").contains("active"));
	}	
	
//	@SMSM-240 @Verify-that-user-is-able-to-set-send-review-request-after-x-checkins	
	@Then("User verifies that Send Review Requestafter x checkins textbox is available")
	public void user_verifies_that_Send_Review_Requestafter_x_checkins_textbox_is_available() {
	Assert.assertTrue(streamSettingsModal.txtF_SendReviewRequestAfterXCheckIns.isDisplayed());
	}
	
	@Then("User enters a value into the Send Review Requestafter x checkins textbox")
	public void user_enters_a_value_into_the_Send_Review_Requestafter_x_checkins_textbox() throws Exception {
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtF_SendReviewRequestAfterXCheckIns, "2");
	}

	@When("User hovers over the Send Review Requestafter x checkins title")
	public void user_hovers_over_the_Send_Review_Requestafter_x_checkins_title() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(streamSettingsModal.title_SendReviewRequestAfterXCheckIns).perform();
	}
	
	@Then("the help description for Send Review Requestafter x checkins is displayed")
	public void the_help_description_for_Send_Review_Requestafter_x_checkins_is_displayed() throws Exception {
		Assert.assertEquals(streamSettingsModal.getSendReviewsRequestAfterXCheckins(), streamSettingsModal.getElementText(streamSettingsModal.title_ReviewSSYSTooltip));
	}
	
	
//	@SMSM-240 @Verify-that-user-is-able-to-set-checkin-review-request-value-under-Review-settings-tab
	@Then("User verifies that the CheckIn Review Request dropdown is available")
	public void user_verifies_that_the_CheckIn_Review_Request_dropdown_is_available() {
		Assert.assertTrue(streamSettingsModal.txtF_CheckInReviewRequestDDown.isDisplayed());
	}

	@Then("User selects a value from the dropdown for CheckIn Review Request")
	public void user_selects_a_value_from_the_dropdown_for_CheckIn_Review_Request() throws Exception {
		streamSettingsModal.waitAndClickElement(streamSettingsModal.CheckInReviewRequestOptions("Hours"));
	}

	@When("User hovers over the Checkin Review Request title")
	public void user_hovers_over_the_Checkin_Review_Request_title() {
		Actions actions = new Actions(driver);
		actions.moveToElement(streamSettingsModal.title_CheckInReviewRequest).perform();
	}

	@Then("the help description for Checkin Review Request is displayed")
	public void the_help_description_for_Checkin_Review_Request_is_displayed() throws Exception {
		Assert.assertEquals(streamSettingsModal.getCHECKIN_REVIEW_REQUEST(), streamSettingsModal.getElementText(streamSettingsModal.title_ReviewSSYSTooltip));
	}

//	 @SMSM-240 @Verify-that-user-is-able-to-set-review-submissions-automatic-response-method-value-under-Review-settings-tab
	@Then("User verifies that the Review Submissions Automatic Response Method dropdown is available")
	public void user_verifies_that_the_Review_Submissions_Automatic_Response_Method_dropdown_is_available() {
	   Assert.assertTrue(streamSettingsModal.txtF_ReviewSubmissionsAutoResponseMethodDDown.isDisplayed());
	}

	@Then("User selects a value from the dropdown for Review Submissions Automatic Response")
	public void user_selects_a_value_from_the_dropdown_for_Review_Submissions_Automatic_Response() throws Exception {
		streamSettingsModal.waitAndClickElement(streamSettingsModal.ReviewSubmissionsAutoResponseMethod("Email Only Response"));
	}

	@When("User hovers over the Review Submissions Automatic Response Method dropdown title")
	public void user_hovers_over_the_Review_Submissions_Automatic_Response_Method_dropdown_title() {
		Actions actions = new Actions(driver);
		actions.moveToElement(streamSettingsModal.title_ReviewSubmissionsAutoResponseMethod).perform();
	}

	@Then("the help description for Review Submissions Automatic Response Method dropdown is displayed")
	public void the_help_description_for_Review_Submissions_Automatic_Response_Method_dropdown_is_displayed() throws Exception {
		Assert.assertEquals(streamSettingsModal.getREVIEW_SUBMISSIONS_AUTOMATIC_RESPONSE_METHOD(), streamSettingsModal.getElementText(streamSettingsModal.title_ReviewSSYSTooltip));
	}

//	 @SMSM-240 @Verify-that-user-is-able-to-set-social-share-automatic-response-value-under-Review-settings-tab
	@Then("User verifies the two button available for Social Share Automatic Response")
	public void user_verifies_the_two_button_available_for_Social_Share_Automatic_Response() {
		Assert.assertTrue(streamSettingsModal.btn_SocialShareAutoResponseEnabled.isDisplayed());
		Assert.assertTrue(streamSettingsModal.btn_SocialShareAutoResponseDisabled.isDisplayed());
	}

	@When("User clicks on the Social Share Auto Response Disabled button")
	public void user_clicks_on_the_Social_Share_Auto_Response_Disabled_button() throws Exception {
		streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_SocialShareAutoResponseDisabled);
	}

	@Then("the Social Share Auto Response is Disabled")
	public void the_Social_Share_Auto_Response_is_Disabled() {
		 Assert.assertTrue(streamSettingsModal.btn_SocialShareAutoResponseDisabled.getAttribute("class").contains("active"));
	}

	@When("User clicks the Social Share Auto Response Enabled button")
	public void user_clicks_the_Social_Share_Auto_Response_Enabled_button() throws Exception {
	streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_SocialShareAutoResponseEnabled);
	}

	@Then("the Social Share Auto Response is Enabled")
	public void the_Social_Share_Auto_Response_is_Enabled() {
		Assert.assertTrue(streamSettingsModal.btn_SocialShareAutoResponseEnabled.getAttribute("class").contains("active"));
	}

	@When("User hovers over the Social Share Automatic Response title")
	public void user_hovers_over_the_Social_Share_Automatic_Response_title() {
		Actions actions = new Actions(driver);
		actions.moveToElement(streamSettingsModal.title_SocialShareAutoRespons).perform();
	}

	@Then("the help description for Social Share Automatic Response is displayed")
	public void the_help_description_for_Social_Share_Automatic_Response_is_displayed() throws Exception {
		Assert.assertEquals(streamSettingsModal.getSOCIAL_SHARE_AUTOMATIC_RESPONSE(), streamSettingsModal.getElementText(streamSettingsModal.title_ReviewSSYSTooltip));
	}

//	 @SMSM-240 @Verify-that-user-is-able-to-set-social-share-automatic-response-delay-value-under-Review-Settings-tab-and-save-the-stream-setting
	@Then("User verifies that the Social Share Automatic Response Delay dropdown is available")
	public void user_verifies_that_the_Social_Share_Automatic_Response_Delay_dropdown_is_available() {
		Assert.assertTrue(streamSettingsModal.txtF_SocialShareAutoResponseDelayDDown.isDisplayed());
	}
	
	@Then("User selects a value for Social Share Automatic Response Delay from the dropdown values")
	public void user_selects_a_value_for_Social_Share_Automatic_Response_Delay_from_the_dropdown_values() throws Exception {
	  streamSettingsModal.waitAndClickElement(streamSettingsModal.txtF_SocialShareAutoResponseDelayDDown);
	  streamSettingsModal.WaitUntilWebElementIsVisible(streamSettingsModal.SocialShareAutoResponseDelay("Immediately"));
	  streamSettingsModal.waitAndClickElement(streamSettingsModal.SocialShareAutoResponseDelay("Immediately"));
	}
	
	@When("User clicks the Save Settings button on the Stream Configuration modal")
	public void user_clicks_the_Save_Settings_button_on_the_Stream_Configuration_modal() throws Exception {
	 streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_SaveSetting);
	}

	@Then("User confirms the selected value for Social Share Auto Resp Delay was saved correctly")
	public void user_confirms_the_selected_value_for_Social_Share_Auto_Resp_Delay_was_saved_correctly() throws Exception {
		streamsPage.waitAndClickElement(streamsPage.btn_Settings);
		Assert.assertTrue(streamSettingsModal.txtF_SocialShareAutoResponseDelayDDown.getAttribute("value").contains("Immediately"));
	}

//  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Request-Template-for-Review-Templates-tab 
	@When("User clicks on the Review Templates tab")
	public void user_clicks_on_the_Review_Templates_tab() throws Exception {
	  streamSettingsModal.waitAndClickElement(streamSettingsModal.tab_ReviewTemplates);
	}
	
	@Then("the Review Template section is opened")
	public void the_Review_Template_section_is_opened() throws Exception {
		Assert.assertEquals("Templates", streamSettingsModal.getElementText(streamSettingsModal.title_ReviewTemplate));
	}
	
	@Then("User verifies there are SMS and Email sections for each Review Templates subsection")
	public void user_verifies_there_are_SMS_and_Email_sections_for_each_Review_Templates_subsection() throws Exception {
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestSMS.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestEmail.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionSMS.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionEmail.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestToShareTemplateSMS.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestToShareTemplateEmail.isDisplayed());
	}
	
	@Then("User is able to send text to all the SMS and Email textboxes")
	public void user_is_able_to_send_text_to_all_the_SMS_and_Email_textboxes() throws Exception {
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestSMS, "RRSMS Test"); 
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestEmail, "RREmail Test"); 
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS, "RPFSSMS Test");
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail, "RPFSEMAIL Test");
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionSMS, "RNFSSMS Test");
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionEmail, "RNFSEMAIL Test");
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestToShareTemplateSMS, "RRSTSMS Test");
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestToShareTemplateEmail, "RRSTEMAIL Test");
	}
	
//	@SMSM-240 @Verify-that-user-is-able-to-edit-Review-Positive-form-submission-templates-for-Review-Templates-tab
	@Then("User verifies SMS and Email textboxes for Review Positive Form Submission")
	public void user_verifies_SMS_and_Email_textboxes_for_Review_Positive_Form_Submission() {
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS.isDisplayed());
		Assert.assertTrue(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail.isDisplayed());
	}
	
	@Then("User edits the text in SMS textbox for Review Positive Form Submission")
	public void user_edits_the_text_in_SMS_textbox_for_Review_Positive_Form_Submission() throws Exception {
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS, "Edit Review Positive form Submission sms");	
	}

   @Then("User edits the text in the Email textbox for Review Positive Form Submission")
    public void user_edits_the_text_in_the_Email_textbox_for_Review_Positive_Form_Submission() throws Exception {
    	streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail, "Edit Review Positive form Submiission email");
    }
   
//  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Negative-form-submission-templates-for-Review-Templates-tab
   	@Then("User verifies SMS and Email textboxes for Review Negative Form Submission")
	public void user_verifies_SMS_and_Email_textboxes_for_Review_Negative_Form_Submission() {
   		Assert.assertTrue(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionSMS.isDisplayed());
   		Assert.assertTrue(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionEmail.isDisplayed());
	}

	@Then("User edits the text in SMS textbox for Review Negative Form Submission")
	public void user_edits_the_text_in_SMS_textbox_for_Review_Negative_Form_Submission() throws Exception {
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionSMS, "Edit Review Negative form Submission sms");
	}

	@Then("User edits the text in the Email textbox for Review Negative Form Submission")
	public void user_edits_the_text_in_the_Email_textbox_for_Review_Negative_Form_Submission() throws Exception {
	    streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewNegativeFormSubmissionEmail, "Edit Review Negative form Submission email");
	}

//  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Request-to-share-template-for-Review-Templates-tab
	@Then("User verifies SMS and Email textboxes Review Request to Share Template section")
	public void user_verifies_SMS_and_Email_textboxes_Review_Request_to_Share_Template_section() {
	 Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestToShareTemplateSMS.isDisplayed());
	 Assert.assertTrue(streamSettingsModal.txtArea_ReviewRequestToShareTemplateEmail.isDisplayed());
	}

	@Then("User edits the text in SMS textbox Review Request to Share Template section")
	public void user_edits_the_text_in_SMS_textbox_Review_Request_to_Share_Template_section() throws Exception {
	 streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestToShareTemplateSMS, "Edit Review Request to Share Template sms");
	}

	@Then("User edits the text in the Email textbox Review Request to Share Template section")
	public void user_edits_the_text_in_the_Email_textbox_Review_Request_to_Share_Template_section() throws Exception {
	   streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewRequestToShareTemplateEmail, "Edit Review Request to Share Template email");
	}
	
//	@SMSM-240 @Verify-that-user-is-able-to-save-stream-configuration-for-Review-Settings-tab
	@Then("User edits SMS and Email for Review Positive Form Submission")
	public void user_edits_SMS_and_Email_for_Review_Positive_Form_Submission() throws Exception {
	 streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS, "Edit Review Positive Form sms");
	 streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail, "Edit Review Positive email");
	}

	@When("User clicks the Review Settings tab")
	public void user_clicks_the_Review_Settings_tab() throws Exception {
		streamSettingsModal.waitAndClickElement(streamSettingsModal.tab_ReviewSettings);
	}

	@Then("the Review Settings section is opened")
	public void the_Review_Settings_section_is_opened() {
		streamSettingsModal.WaitUntilWebElementIsVisible(streamSettingsModal.title_ReviewsSystem);
		Assert.assertTrue(streamSettingsModal.title_ReviewsSystem.isDisplayed());
	}

	@When("User clicks the Stream Settings tab")
	public void user_clicks_the_Stream_Settings_tab() throws Exception {
	 streamSettingsModal.waitAndClickElement(streamSettingsModal.tab_StreamSettings);
	}

	@Then("the Stream Setting section is opened")
	public void the_Stream_Setting_section_is_opened() throws Exception {
		streamSettingsModal.WaitUntilWebElementIsVisible(streamSettingsModal.txtF_StreamPostQuantity);
		Assert.assertTrue(streamSettingsModal.txtF_StreamPostQuantity.isDisplayed());
	}
	
	@Then("User edits the streams post quantity")
	public void user_edits_the_streams_post_quantity() throws Exception {
	 streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtF_StreamPostQuantity, "10");
	}

	@Then("User clicks the Save Settings")
	public void user_clicks_the_Save_Settings() throws Exception {
	  streamSettingsModal.waitAndClickElement(streamSettingsModal.btn_SaveSetting);
	}

	@Then("User verifies that the changes were saved correctly")
	public void user_verifies_that_the_changes_were_saved_correctly() throws InterruptedException {
	   streamsPage.waitAndClickElement(streamsPage.btn_Settings);
	   Assert.assertTrue(streamSettingsModal.txtF_StreamPostQuantity.getAttribute("value").contentEquals("10"));
	   streamSettingsModal.waitAndClickElement(streamSettingsModal.tab_ReviewTemplates);
	   Assert.assertEquals("Edit Review Positive Form sms", streamSettingsModal.getElementText(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionSMS));
	   Assert.assertEquals("Edit Review Positive email", streamSettingsModal.getElementText(streamSettingsModal.txtArea_ReviewPositiveFormSubmissionEmail));
	}
	
	
//	 @SMSM-240 @Verify-that-user-is-able-to-edit-data-under-verify-Review-Language-Strings-for-Review-Templates-tab
	@Then("User verifies Review Positive Message and Review Negative Messages textbox is available")
	public void user_verifies_Review_Positive_Message_and_Review_Negative_Messages_textbox_is_available() {
	  Assert.assertTrue(streamSettingsModal.txtF_ReviewPositiveMessage.isDisplayed());
	  Assert.assertTrue(streamSettingsModal.txtF_ReviewNegativeMessage.isDisplayed());
	}

	@Then("User edits the text in Reviews Positive Message textbox")
	public void user_edits_the_text_in_Reviews_Positive_Message_textbox() throws Exception {
	  streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtF_ReviewPositiveMessage, "Positive Message");
	}

	@Then("User edits the text in Reviews Negatuive Message textbox")
	public void user_edits_the_text_in_Reviews_Negatuive_Message_textbox() throws Exception {
		streamSettingsModal.sendKeysToWebElement(streamSettingsModal.txtF_ReviewNegativeMessage, "Negative Message");	  
	}

}
