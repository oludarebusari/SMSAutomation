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
	public void user_selects_a_value_from_the_dropdown_for_CheckIn_Review_Request() {
		streamSettingsModal.selectDropDownOptions(streamSettingsModal.txtF_CheckInReviewRequestDDown, "Hours");
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
	public void user_selects_a_value_from_the_dropdown_for_Review_Submissions_Automatic_Response() {
	 streamSettingsModal.selectDropDownOptions(streamSettingsModal.txtF_ReviewSubmissionsAutoResponseMethodDDown, "Email Only Response");
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


}
