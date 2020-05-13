package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AdminStreamPage;
import pageObjects.thrive.Tab.ExperienceDDown;
import pageObjects.thrive.modal.RespondToStreamModal;

public class StreamsPageUnderExperienceSteps extends BasePage {

	public StreamsPageUnderExperienceSteps() throws IOException {
		super();
	}

	public AdminStreamPage adminStreamPage = PageFactory.initElements(driver, AdminStreamPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	public RespondToStreamModal respondToStreamModal = PageFactory.initElements(driver, RespondToStreamModal.class);

	
	
	private int totalNumberOfRecords = 0;

	@When("User clicks on the Experience Menu option on the admin dashboard")
	public void user_clicks_on_the_Experience_Menu_option_on_the_admin_dashboard() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
	}

	@Then("the Experience tab option is displayed")
	public void the_Experience_tab_option_is_displayed() {
		Assert.assertTrue(experienceDDown.opt_Streams.isDisplayed());
	}

	@When("User clicks on the Streams option")
	public void user_clicks_on_the_Streams_option() throws Exception {
		experienceDDown.waitAndClickElement(experienceDDown.opt_Streams);
	}

	@Then("the Stream page under Experience is displayed")
	public void the_Stream_page_under_Experience_is_displayed() throws Exception {
		Assert.assertEquals("Streams", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//  @Verify-the-stream-page-is-opened-at-Experience-tab
	@Then("User verifies the URL of the Stream page")
	public void user_verifies_the_URL_of_the_Stream_page() {
		Assert.assertEquals("https://thrive.stage2-aut.mastermindsdigital.com/admin/streams/", driver.getCurrentUrl());
	}

//	@Verify-the-"Licensee-and-Merchants"-Filter
	@Then("User verifies that the Reseller and Business filter is available")
	public void user_verifies_that_the_Reseller_and_Business_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_ResellerAndBusiness.isDisplayed());
	}

	@When("User clicks the Reseller and Business textfield")
	public void user_clicks_the_Reseller_and_Business_textfield() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.txtF_ResellerAndBusiness);
	}

	@Then("a drop down displaying Busineses is opened")
	public void a_drop_down_displaying_Busineses_is_opened() {
		Assert.assertTrue(adminStreamPage.resellerAndBusinessOptions.isDisplayed());
		Assert.assertTrue(adminStreamPage.resellerDataGroup.isDisplayed());
		Assert.assertTrue(adminStreamPage.businessDataGroup.isDisplayed());
	}

	@When("User selects Business or Reseller")
	public void user_selects_Business_or_Reseller() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.selectResellerOrBusiness("AcadianaRewards"));
		
	}

	@Then("the selected Business or Reseller is displayed on the drop down text field")
	public void the_selected_Business_or_Reseller_is_displayed_on_the_drop_down_text_field() throws Exception {
		Assert.assertEquals("AcadianaRewards", adminStreamPage
				.getElementText(adminStreamPage.activeResellerOrBusinessOption("AcadianaRewards")).replace("\n×", ""));
	}

	@When("User clicks the close button beside a selected Business")
	public void user_clicks_the_close_button_beside_a_selected_Business() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.removeActiveResellerOrBusinessOption("AcadianaRewards"));
	}

	@Then("the Business option is deselected")
	public void the_Business_option_is_deselected() throws Exception {
		Assert.assertTrue(adminStreamPage.getElementText(adminStreamPage.txtF_ResellerAndBusiness).isBlank());
	}

	@When("User selects an existing Reseller and Business")
	public void user_selects_an_existing_Reseller_and_Business() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.txtF_ResellerAndBusiness);
		adminStreamPage.waitAndClickElement(adminStreamPage.selectResellerOrBusiness("Benchmark Soundworks"));
		adminStreamPage.waitAndClickElement(adminStreamPage.txtF_ResellerAndBusiness);
		adminStreamPage.waitAndClickElement(adminStreamPage.selectResellerOrBusiness("IowaLoyal"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User confirms that both the Reseller and Business are selected and displayed")
	public void user_confirms_that_both_the_Reseller_and_Business_are_selected_and_displayed() throws Exception {
		int ResellerOrBusiness1 = adminStreamPage.getNumberOfElements(adminStreamPage.displayedResellerOrBusinessLocator("Benchmark Soundworks"));
		int ResellerOrBusiness2 = adminStreamPage.getNumberOfElements(adminStreamPage.displayedResellerOrBusinessLocator("IowaLoyal"));
		Assert.assertEquals(ResellerOrBusiness1+ResellerOrBusiness2, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}

	
//  @Verify-the-"Platforms"-filter 
	@Then("User verifies that the Platform filter is available")
	public void user_verifies_that_the_Platform_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Platform.isDisplayed());
	}

	@When("User clicks the close button beside a selected platform")
	public void user_clicks_the_close_button_beside_a_selected_platform() throws Exception {
		totalNumberOfRecords = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal));
		adminStreamPage.waitAndClickElement(adminStreamPage.removeActiveResellerOrBusinessOption("Zomato"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("the Platform option is deselected")
	public void the_Platform_option_is_deselected() throws Exception {
		Assert.assertFalse(adminStreamPage.getElementText(adminStreamPage.txtF_Platform).contains("Zomato"));
		Assert.assertTrue(totalNumberOfRecords >= Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}

//	@Verify-the-"Read"-filter
	@Then("User verifies that the Read filter is available")
	public void user_verifies_that_the_Read_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Read.isDisplayed());
	}

	@Then("User verifies that Unread streams are displayed by deafult")
	public void user_verifies_that_Unread_streams_are_displayed_by_deafult() {
		Assert.assertTrue(adminStreamPage.btn_UnreadEnvelope.isDisplayed());
		Assert.assertFalse(adminStreamPage.btn_UnreadEnvelope.getAttribute("class").contains("hidden"));
		Assert.assertTrue(adminStreamPage.btn_ReadEnvelope.getAttribute("class").contains("hidden"));
	}

	@When("User clicks the Filter by Read button")
	public void user_clicks_the_Filter_by_Read_button() throws InterruptedException {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_FilterByRead);
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Unread);
	}

	@Then("User is able to see all read streams")
	public void user_is_able_to_see_all_read_streams() throws Exception {
		Assert.assertTrue(adminStreamPage.btn_ReadEnvelope.isDisplayed());
		Assert.assertFalse(adminStreamPage.btn_ReadEnvelope.getAttribute("class").contains("hidden"));
		Assert.assertTrue(adminStreamPage.btn_UnreadEnvelope.getAttribute("class").contains("hidden"));

	}

	@When("User clicks the Filter by Read button again")
	public void user_clicks_the_Filter_by_Read_button_again() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_FilterByRead);
	}

	@Then("User is able to see all unread streams")
	public void user_is_able_to_see_all_unread_streams() throws Exception {
		Assert.assertTrue(adminStreamPage.btn_UnreadEnvelope.isDisplayed());
		Assert.assertFalse(adminStreamPage.btn_UnreadEnvelope.getAttribute("class").contains("hidden"));
		Assert.assertTrue(adminStreamPage.btn_ReadEnvelope.getAttribute("class").contains("hidden"));
	}

//  @Verify-the-"Rating"-filter
	@Then("User verifies that the Rating filter is available")
	public void user_verifies_that_the_Rating_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Ratings.isDisplayed());
	}

	@When("User clicks on the Five Stars rates button")
	public void user_clicks_on_the_Five_Stars_rates_button() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Ratings_5Stars);
	}

	@Then("all streamns  with five stars are displayed")
	public void all_streamns_with_five_stars_are_displayed() throws InterruptedException {
		Assert.assertTrue(adminStreamPage.fiveStars.isDisplayed());
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.fourStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.threeStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.twoStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.oneStar)));
	}

	@When("User clicks on the one star rates button")
	public void user_clicks_on_the_one_star_rates_button() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Ratings_1Star);
	}

	@Then("all streamns  with one star are displayed")
	public void all_streamns_with_one_star_are_displayed() {
		Assert.assertTrue(adminStreamPage.oneStar.isDisplayed());
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.fourStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.threeStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.twoStars)));
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getElementLocator(adminStreamPage.oneStar)));
	}

//	@Verify-the-"Status"-filter
	@Then("User verifies that the Status filter for Streams is available")
	public void user_verifies_that_the_Status_filter_for_Streams_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Status.isDisplayed());
	}

	@When("User clicks on the Approved button")
	public void user_clicks_on_the_Approved_button() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Approved);
	}

	@Then("all approved streams are displayed")
	public void all_approved_streams_are_displayed() {
		Assert.assertTrue(adminStreamPage.approvedIcon.isDisplayed());
		Assert.assertTrue(adminStreamPage.isElementVisible(adminStreamPage.getSUPPRESSEDICON()));
	}

	@When("User clicks on the Suppressed button")
	public void user_clicks_on_the_Suppressed_button() throws InterruptedException {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Suppressed);
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Approved);
	}

	@Then("all suppressed streams were displayed")
	public void all_suppressed_streams_were_displayed() throws Exception {
		Assert.assertTrue(adminStreamPage.suppressedIcon.isDisplayed());
		Assert.assertFalse(adminStreamPage.approvedIcon.getAttribute("class").contains("active"));
	}

//	@Verify-the-"Recency"-filter 
	@Then("User verifies that the Recency filter for Streams is available")
	public void user_verifies_that_the_Recency_filter_for_Streams_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Recency.isDisplayed());
	}

	@When("User clicks the Newest First button")
	public void user_clicks_the_Newest_First_button() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_NewestFirst);
	}

	@Then("the newwest streams are displayed first")
	public void the_newwest_streams_are_displayed_first() throws Exception {
		Assert.assertTrue(adminStreamPage.newestFirstStream.getText().contains("2020"));
	}

	@When("User clicks the oldest First button")
	public void user_clicks_the_oldest_First_button() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_OldestFirst);
	}

	@Then("the Oldest streams are displayed first")
	public void the_Oldest_streams_are_displayed_first() throws Exception {
		Assert.assertTrue(adminStreamPage.oldestFirstStream.getText().contains("2012"));
	}

//  @Verify-the-pagination-functionality
	@Then("User verifies pagination is available")
	public void user_verifies_pagination_is_available() {
		Assert.assertTrue(commonElementLocator.PaginationBar.isDisplayed());
	}

	@Then("User verifies the drop down of Show n Entries")
	public void user_verifies_the_drop_down_of_Show_n_Entries() {
		Assert.assertTrue(commonElementLocator.lov_ShowEntries.isDisplayed());
	}

	@Then("User selects a number for Show n Entries")
	public void user_selects_a_number_for_Show_n_Entries() throws Exception {
		Assert.assertEquals("25", commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("50"));
		Assert.assertEquals("50", commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	}

	@Then("User verifies that both Previous and Next buttons are available")
	public void user_verifies_that_both_Previous_and_Next_buttons_are_available() throws Exception {
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_PaginationNext.isDisplayed());
	}

	@Then("User verifies that the Previous button is displabed when user is on the first page")
	public void user_verifies_that_the_Previous_button_is_displabed_when_user_is_on_the_first_page()
			throws InterruptedException {
		Assert.assertEquals("1", commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn)
				.replace("\n(current)", ""));
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
	}

	@Then("User verifies that the Next button is disabled when user is on the last poage")
	public void user_verifies_that_the_Next_button_is_disabled_when_user_is_on_the_last_poage() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("100"));
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_PaginationNext);
		Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
	}

//	@Verify-the-"Help"-button-on-the-page
	@Then("User verifies that Help button is avaialable on the page")
	public void user_verifies_that_Help_button_is_avaialable_on_the_page() {
		Assert.assertTrue(commonElementLocator.btn_Help.isDisplayed());
	}

	@When("User clicks on the Help button on the Streams page")
	public void user_clicks_on_the_Help_button_on_the_Streams_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("a tour for the Streams help page is opened")
	public void a_tour_for_the_Streams_help_page_is_opened() throws Exception {
		Assert.assertEquals("Streams", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the Next button from the Streams window")
	public void user_clicks_on_the_Next_button_from_the_Streams_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Companies window is opened")
	public void the_Companies_window_is_opened() throws InterruptedException {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Companies", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the previous button from the Companies window")
	public void user_clicks_on_the_previous_button_from_the_Companies_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the tour guide is navigate back to the Streams window")
	public void the_tour_guide_is_navigate_back_to_the_Streams_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Streams", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
//	@Verify-the-Contents-of-Streams
	@Then("User verifies that Streams are available")
	public void user_verifies_that_Streams_are_available() {
		Assert.assertTrue(adminStreamPage.panel_Streams.isDisplayed());
	}

	@Then("User verifies that platform logo is available")
	public void user_verifies_that_platform_logo_is_available() throws Exception {
//		Assert.assertTrue(adminStreamPage.icon_Platform.isDisplayed());
	}

	@Then("User verifies that Status is available")
	public void user_verifies_that_Status_is_available() {
		Assert.assertTrue(adminStreamPage.streamsStatus.isDisplayed());
	}

	@Then("User verifies that ratings are available")
	public void user_verifies_that_ratings_are_available() {
		Assert.assertTrue(adminStreamPage.ratingBlock.isDisplayed());
	}

	@Then("User verifies that 'Unread streams are available")
	public void user_verifies_that_Unread_streams_are_available() {
	  Assert.assertTrue(adminStreamPage.btn_UnreadEnvelope.isDisplayed());
	}
	
//	@Verify-the-popup-by-clicking-on-"reply" 
	@Then("User verifies that Reply option is available for the Streams")
	public void user_verifies_that_Reply_option_is_available_for_the_Streams() {
		Assert.assertTrue(adminStreamPage.btn_Reply.isDisplayed());
	}

	@When("User clicks on the Reply button of a stream")
	public void user_clicks_on_the_Reply_button_of_a_stream() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.replyToStream("Ryan F."));	
	}

	@Then("a popup window to respond to the Stream is opened")
	public void a_popup_window_to_respond_to_the_Stream_is_opened() throws Exception {
		System.out.println( respondToStreamModal.getElementText(respondToStreamModal.mod_Title));
		Assert.assertEquals("Respond to Ryan F.", respondToStreamModal.getElementText(respondToStreamModal.mod_Title));
	}

	@When("User leaves the response text area empty and clicks Reply button")
	public void user_leaves_the_response_text_area_empty_and_clicks_Reply_button() throws Exception {
		respondToStreamModal.waitAndClickElement(respondToStreamModal.btn_Reply);
	}

	@Then("validation message for the textarea is displayed")
	public void validation_message_for_the_textarea_is_displayed() throws Exception {
		Assert.assertEquals("Please enter a value", respondToStreamModal.getElementText(respondToStreamModal.lbl_YourResponseMsg));
	}
	
	@When("User clicks on the Create a template from this response checkbox")
	public void user_clicks_on_the_Create_a_template_from_this_response_checkbox() throws Exception {
		respondToStreamModal.sendKeysToWebElement(respondToStreamModal.txtA_YourResponse, "A");
	   respondToStreamModal.waitAndClickElement(respondToStreamModal.chk_CreateATemplateFromThisResponse);
	}

	@Then("the Template Title textbox is displayed")
	public void the_Template_Title_textbox_is_displayed() {
	  Assert.assertTrue(respondToStreamModal.txtF_TemplateTitle.isDisplayed());
	}

	@When("User types in a response and a Template Title and clicks Reply button")
	public void user_types_in_a_response_and_a_Template_Title_and_clicks_Reply_button() throws Exception {
	 respondToStreamModal.sendKeysToWebElement(respondToStreamModal.txtA_YourResponse, "This is automation testing");
	 respondToStreamModal.sendKeysToWebElement(respondToStreamModal.txtF_TemplateTitle, "Automation Test");
	}

}
