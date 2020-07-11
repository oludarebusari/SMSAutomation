package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.CreateEditCampaignPage;
import pageObjects.engage.SingleCampaignsPage;
import pageObjects.engage.modal.CreateReminderModal;
import pageObjects.engage.modal.CreateRewardModal;
import pageObjects.engage.modal.SingleCampaignSummaryModal;
import pageObjects.engage.modal.TriggerModal;
import pageObjects.license.menu.CampaignsSubMenu;
import pageObjects.license.menu.MerchantMenu;
import utils.DriverFactory;

public class AgeGateSteps extends DriverFactory {

	CreateEditCampaignPage createEditCampaignPage = PageFactory.initElements(driver, CreateEditCampaignPage.class);
	CreateRewardModal createRewardModal = PageFactory.initElements(driver, CreateRewardModal.class);
	CreateReminderModal createReminderModal = PageFactory.initElements(driver, CreateReminderModal.class);
	CampaignsSubMenu campaignsSubMenu = PageFactory.initElements(driver, CampaignsSubMenu.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	SingleCampaignsPage singleCampaignsPage = PageFactory.initElements(driver, SingleCampaignsPage.class);
	SingleCampaignSummaryModal singleCampaignSummaryModal = PageFactory.initElements(driver,
			SingleCampaignSummaryModal.class);
	TriggerModal triggerModal = PageFactory.initElements(driver, TriggerModal.class);
	
	String campaignName = "AutoTest";

//	@Verify-Age-field-is-not-displayed-when-Age-gate-filter-is-disabled
	@When("User clicks the New button on the Single Campaigns page")
	public void user_clicks_the_New_button_on_the_Single_Campaigns_page() throws Exception {
		singleCampaignsPage.waitAndClickElement(singleCampaignsPage.newBtn);
	}

	@Then("the Create A Campaign page is displayed")
	public void the_Create_A_Campaign_page_is_displayed() throws Exception {
		Assert.assertEquals("Create A Campaign",
				createEditCampaignPage.getElementText(createEditCampaignPage.page_Title).replace("\nExpand All", ""));
	}

	@When("User clicks on the Campaign Information section")
	public void user_clicks_on_the_Campaign_Information_section() throws Exception {
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.panel_CampaignInformation);
	}

	@Then("the Campaign Information section is opened")
	public void the_Campaign_Information_section_is_opened() {
		Assert.assertTrue(createEditCampaignPage.campaignInformationContent.isDisplayed());
	}

	@Then("User verifies that the Age field is not displayed")
	public void user_verifies_that_the_Age_field_is_not_displayed() {
		Assert.assertFalse(createEditCampaignPage.txtF_AgeGate.isDisplayed());
	}

//	@Verify-Age-field-is-displayed-when-Age-gate-filter-is-enabled
	@When("User clicks on the Disable toggle button")
	public void user_clicks_on_the_Disable_toggle_button() throws Exception {
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.tog_AgeGateDisabled);
	}

	@Then("User verifies that the Age field is displayed")
	public void user_verifies_that_the_Age_field_is_displayed() {
		Assert.assertTrue(createEditCampaignPage.txtF_AgeGate.isDisplayed());
	}

//	@Verify-default-value-for-Age-field
	@Then("User verifies the default value for Age field")
	public void user_verifies_the_default_value_for_Age_field() throws Exception {
	 Assert.assertEquals(21, Integer.parseInt(createEditCampaignPage.txtF_AgeGate.getAttribute("value")));
	}

//	@Verify-Age-field-value-is-editable
	@Then("User enters a new value for AgeGate")
	public void user_enters_a_new_value_for_AgeGate() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "18");
	}
	
	@Then("User enters a new value for AgeGate and clicks Save Campaign button")
	public void user_enters_a_new_value_for_AgeGate_and_clicks_Save_Campaign_button() {

	}
	
	@Then("User verifies that the values was saved successfully")
	public void user_verifies_that_the_values_was_saved_successfully() {
	 
	}

//	@Verify-Age-field-should-only-allow-positive-integer-number
	@When("User enters alphabetical characters into the Age field")
	public void user_enters_alphabetical_characters_into_the_Age_field() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "ABC");
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.txtF_CampaignName);
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() {
		Assert.assertTrue(createEditCampaignPage.ageGateMsg.isDisplayed());
	}

	@When("User enters special characters into the Age field")
	public void user_enters_special_characters_into_the_Age_field() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "@#%%");
	}

	@When("User enters a negative number into the Age field")
	public void user_enters_a_negative_number_into_the_Age_field() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "-10");
	}

// @Verify-valid-interval-for-Age-Gate-(10-40)
	@When("User update the Age field value to ten")
	public void user_update_the_Age_field_value_to_ten() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "10");
	}
	
	@Then("the Age Gate field is updated with value ten without error message")
	public void the_Age_Gate_field_is_updated_with_value_ten_without_error_message() {
		Assert.assertFalse(createEditCampaignPage
				.isElementVisible(createEditCampaignPage.getElementLocator(createEditCampaignPage.ageGateMsg)));
		Assert.assertEquals(10, Integer.parseInt(createEditCampaignPage.txtF_AgeGate.getAttribute("value")));
	}

	@When("User update the Age field value to forty")
	public void user_update_the_Age_field_value_to_forty() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "40");
	}

	@Then("the Age Gate field is updated with value forty without error message")
	public void the_Age_Gate_field_is_updated_with_value_forty_without_error_message() {
		Assert.assertFalse(createEditCampaignPage.isElementVisible(createEditCampaignPage.getElementLocator(createEditCampaignPage.ageGateMsg)));
		Assert.assertEquals(40, Integer.parseInt(createEditCampaignPage.txtF_AgeGate.getAttribute("value")));
	}

	@When("User update the Age field value to twenty-five")
	public void user_update_the_Age_field_value_to_twenty_five() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "25");
	}

	@Then("the Age Gate field is updated with value twenty-five without error message")
	public void the_Age_Gate_field_is_updated_with_value_twenty_five_without_error_message() {
		Assert.assertFalse(createEditCampaignPage.isElementVisible(createEditCampaignPage.getElementLocator(createEditCampaignPage.ageGateMsg)));
		Assert.assertEquals(25, Integer.parseInt(createEditCampaignPage.txtF_AgeGate.getAttribute("value")));
	}
	
//	 @Verify-Age-Gate-field-do-not-accept-values-other-than-valid-interval-(10-40)
	@When("User update the Age Gate field value to nine")
	public void user_update_the_Age_Gate_field_value_to_nine() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "9");
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.txtF_CampaignName);
	}

	@When("User update the Age Gate field value to forty-one")
	public void user_update_the_Age_Gate_field_value_to_forty_one() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "41");
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.txtF_CampaignName);
	}

	@When("User update the Age Gate field value to zero")
	public void user_update_the_Age_Gate_field_value_to_zero() throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_AgeGate, "0");
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.txtF_CampaignName);
	}

//	@Create-a-campaign-with-Age-Gate-filter-ON
	@Then("User clicks What type of business is this section and select a business type")
	public void user_clicks_What_type_of_business_is_this_section_and_select_a_business_type()
			throws InterruptedException {
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.campaignDDown);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.selectCampaign("\"Arcades\""));
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.businessTypeContinueBtn);
	}

	@Then("User clicks on Yes button from the Will you be using a Loyalty tablet section")
	public void user_clicks_on_Yes_button_from_the_Will_you_be_using_a_Loyalty_tablet_section()
			throws InterruptedException {
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.loyaltyTabletYesBtn);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.loyaltyTabletYesBtn);
	}

	@Then("User enters Campaign name, keyword, Messages per month")
	public void user_clicks_the_Campaign_Infornmation_section_and_enters_Campaign_name_keyword_Messages_per_month()
			throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_CampaignName, campaignName);
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtF_Keyword, "automation");

	}

	@Then("User enables the Age Gate filter, set a value and clicks the Continue button")
	public void user_enables_the_Age_Gate_filter_set_a_value_and_clicks_the_Continue_button() throws Exception {
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.messageSettingDDown);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.selectMessagesPerMonth("4"));
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.tog_AgeGateDisabled);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.messageSettingsContinueBtn);
	}

	@Then("User enters the Welcome message and click the continue button from the Texts section")
	public void user_enters_the_Welcome_message_and_click_the_continue_button_from_the_Texts_section()
			throws Exception {
		createEditCampaignPage.sendKeysToWebElement(createEditCampaignPage.txtA_Message, "This is used for Automation test");
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.textsContinueBtn);
	}

	@Then("User create a reward and clicks the continue button")
	public void user_create_a_reward_and_clicks_the_continue_button() throws Exception {
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.createBirthdayRewardBtn);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.createBirthdayRewardBtn);
		createRewardModal.sendKeysToWebElement(createRewardModal.txtF_DaysBeforeBirthday, "3");
		createRewardModal.sendKeysToWebElement(createRewardModal.txtF_RewardName, "Automation Reward");
		createRewardModal.sendKeysToWebElement(createRewardModal.txtA_Message, "This message is for Automation Reward");
		createRewardModal.waitAndClickElement(createRewardModal.btn_AddReward);
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.rewardssContinueBtn);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.rewardssContinueBtn);
	}

	@Then("User adds engagement in Engagement section and clicks the continue button")
	public void user_adds_engagement_in_Engagement_section_and_clicks_the_continue_button() throws Exception {
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.btn_EngagementAdd);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.btn_EngagementAdd);
		triggerModal.waitAndClickElement(triggerModal.btn_JoinTheCampaign);
		createReminderModal.sendKeysToWebElement(createReminderModal.txtF_DaysAfterJoiningCampaign, "2");
		createReminderModal.sendKeysToWebElement(createReminderModal.txtA_Message, "Message Automation test");
		createReminderModal.waitAndClickElement(createReminderModal.btn_AddMessage);
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.engagementsContinueBtn);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.engagementsContinueBtn);
	}

	@Then("User adds a logo on the Tablet design section")
	public void user_adds_a_logo_on_the_Tablet_design_section() {
		// TODO:
	}

	@Then("User clicks the Save to Complete Setup button")
	public void user_clicks_the_Save_to_Complete_Setup_button() throws Exception {
		createEditCampaignPage.WaitUntilWebElementIsVisible(createEditCampaignPage.btn_SaveToCompleteSetup);
		createEditCampaignPage.waitAndClickElement(createEditCampaignPage.btn_SaveToCompleteSetup);
		singleCampaignSummaryModal.waitAndClickElement(singleCampaignSummaryModal.btn_Close);
	}

	@Then("User verifies that the campaign is created successfully")
	public void user_verifies_that_the_campaign_is_created_successfully() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Campaigns);
		campaignsSubMenu.waitAndClickElement(campaignsSubMenu.menu_SingleCampaigns);
		Assert.assertTrue(singleCampaignsPage.selectSingleCampaignByName(campaignName).isDisplayed());
	}
	
	@Then("User deletes the created campaign")
	public void user_deletes_the_created_campaign() throws InterruptedException {
		singleCampaignsPage.waitAndClickElement(singleCampaignsPage.actionDDown(campaignName));
		singleCampaignsPage.waitAndClickElement(singleCampaignsPage.actionDDownOpt(campaignName));
	}
}
