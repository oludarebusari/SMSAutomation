package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.SocialSettingsPage;
import pageObjects.license.WebWidgetPage;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.menu.SettingsSubMenu;
import utils.DriverFactory;

public class SocialMediaWebWidgetSettingsSteps extends DriverFactory {

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	SettingsSubMenu settingsSubMenu = PageFactory.initElements(driver, SettingsSubMenu.class);
	SocialSettingsPage socialSettingsPage = PageFactory.initElements(driver, SocialSettingsPage.class);
	WebWidgetPage webWidgetPage = PageFactory.initElements(driver, WebWidgetPage.class);
	

	
	private final String FORM_TITLE = "Auto Test";
	private final String FORM_DESCRIPTION = "This is for automation testing";
	private final String BUTTON_TEXT = "Click Me";

	@Then("the Settings options are displayed")
	public void the_Settings_options_are_displayed() {
		Assert.assertTrue(settingsSubMenu.menu_Account_Defaults.isDisplayed());
		Assert.assertTrue(settingsSubMenu.menu_Social_Media.isDisplayed());
		Assert.assertTrue(settingsSubMenu.menu_Web_Widget.isDisplayed());
	}

//	@SMSM-137-Verify-that-user-is-able-to-view-Account-Defaults-Social-Media-and-Web-Widget-options-in-settings-tab
	@When("User hovers over the Social Media option")
	public void user_hovers_over_the_Social_Media_option() {	
		Actions actions = new Actions(driver);
		actions.moveToElement(merchantMenu.menu_Subscribers).perform();
	}

	@Then("the color of the selected option changes to blue")
	public void the_color_of_the_selected_option_changes_to_blue() {
		String color = merchantMenu.menu_Subscribers.getCssValue("color");
		Assert.assertEquals("#00a8e1", merchantMenu.getColor(color));
	}

//	@SMSM-137-Verify-that-user-is-able-to-connect-facebook-account-with-selected-campaign
	@When("User clicks the Social Media option")
	public void user_clicks_the_Social_Media_option() throws Exception {
		settingsSubMenu.waitAndClickElement(settingsSubMenu.menu_Social_Media);
	}

	@Then("the Social Settings page is displayed")
	public void the_Social_Settings_page_is_displayed() throws Exception {
		Assert.assertEquals("Social Settings", socialSettingsPage.getElementText(socialSettingsPage.page_Title));
	}

	@When("User selects a Campaign from Select a campaign dropdown")
	public void user_selects_a_Campaign_from_Select_a_campaign_dropdown() throws InterruptedException {
		socialSettingsPage.waitAndClickElement(socialSettingsPage.lov_Select_A_Campaign);
		socialSettingsPage.waitAndClickElement(socialSettingsPage.campaignOption("\"Test1 (AG Disabled)\""));
	}

	@Then("the selected campaign is displayed on the dropdown text box")
	public void the_selected_campaign_is_displayed_on_the_dropdown_text_box() {
		Assert.assertTrue(socialSettingsPage.lov_Select_A_Campaign.getText().contentEquals("Test1 (AG Disabled)"));
	}

	@When("User clicks on Connect to Facebook button")
	public void user_clicks_on_Connect_to_Facebook_button() throws Exception {
		socialSettingsPage.waitAndClickElement(socialSettingsPage.btn_Connect_To_Facebook);
	}

	@Then("User should be navigated to the facebook login page")
	public void user_should_be_navigated_to_the_facebook_login_page() {
		socialSettingsPage.switchWindow();
		Assert.assertEquals("Log into Facebook | Facebook", driver.getTitle());
	}

//	@SMSM-137-Verify-that-user-is-able-to-manually-configure-a-Facebook-account-with-selected-campaign
	@Then("user enters a name into the FB Name textfield")
	public void user_enters_a_name_into_the_FB_Name_textfield() throws Exception {
		socialSettingsPage.sendKeysToWebElement(socialSettingsPage.txtF_FB_Name, "Auto");
	}

	@Then("User enters a userid into the FB UserID")
	public void user_enters_a_userid_into_the_FB_UserID() throws Exception {
		socialSettingsPage.sendKeysToWebElement(socialSettingsPage.txtF_FB_User_ID, "tommyLee");
	}

	@Then("User clicks the Save Integration button")
	public void user_clicks_the_Save_Integration_button() throws Exception {
		socialSettingsPage.waitAndClickElement(socialSettingsPage.btn_Save_Integration);
	}

//	@SMSM-137-Verify-that-user-is-able-to-save-social-URL's-successfully
	@Then("User enters the URL into Facebook URL textbox in Social Properties section")
	public void user_enters_the_URL_into_Facebook_URL_textbox_in_Social_Properties_section() throws Exception {
		socialSettingsPage.sendKeysToWebElement(socialSettingsPage.txtF_Facebook_URL, "https://www.facebook.com");
	}

	@Then("User clicks Save Social URLs button")
	public void user_clicks_Save_Social_URLs_button() throws Exception {
		socialSettingsPage.waitAndClickElement(socialSettingsPage.btn_Save_Social_URLs);
	}

	@When("User clicks the Back to Dashboard")
	public void user_clicks_the_Back_to_Dashboard() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.BackToDashboard);
		commonElementLocator.waitAndClickElement(commonElementLocator.BackToDashboard);
	}

	@Then("the User is redirected to the Dashboatd page")
	public void the_User_is_redirected_to_the_Dashboatd_page() {
		Assert.assertEquals("https://www.smsmmtest.com/advertisercpanel/", driver.getCurrentUrl());
	}

	@Then("User confirms that the URLs was saved correctly")
	public void user_confirms_that_the_URLs_was_saved_correctly() throws Exception {
		Assert.assertTrue(
				socialSettingsPage.txtF_Facebook_URL.getAttribute("value").contentEquals("https://www.facebook.com"));
	}

//	@SMSM-137-Verify-that-user-is-able-to-edit-details-in-various-fields-to-configure-web-widget
	@When("User clicks the Web Widget option in settings tab")
	public void user_clicks_the_Web_Widget_option_in_settings_tab() throws Exception {
		settingsSubMenu.waitAndClickElement(settingsSubMenu.menu_Web_Widget);
	}

	@Then("User should be navigated to the Web widget page")
	public void user_should_be_navigated_to_the_Web_widget_page() throws Exception {
		Assert.assertEquals("Web Widget", webWidgetPage.getElementText(webWidgetPage.page_Title));
	}

	@Then("User Enters the Form Title")
	public void user_Enters_the_Form_Title() throws Exception {
		webWidgetPage.sendKeysToWebElement(webWidgetPage.txtF_Form_Title, FORM_TITLE);
	}

	@Then("User enters the Form Description")
	public void user_enters_the_Form_Description() throws Exception {
		webWidgetPage.sendKeysToWebElement(webWidgetPage.txtF_Form_Description, FORM_DESCRIPTION);
	}

	@Then("User enters the button text")
	public void user_enters_the_button_text() throws Exception {
		webWidgetPage.sendKeysToWebElement(webWidgetPage.txtF_Button_Text, BUTTON_TEXT);
	}

	@Then("User enters the Thnak You message")
	public void user_enters_the_Thnak_You_message() throws Exception {
		webWidgetPage.sendKeysToWebElement(webWidgetPage.txtF_ThankYou_Message, "Thanks for using QA Automation");
	}

	@Then("User verifies that all the text entered are reflected on the Preview section")
	public void user_verifies_that_all_the_text_entered_are_reflected_on_the_Preview_section() throws Exception {
		Assert.assertEquals(FORM_TITLE, webWidgetPage.getElementText(webWidgetPage.preview_Title));
		Assert.assertEquals(FORM_DESCRIPTION, webWidgetPage.getElementText(webWidgetPage.preview_Description));
		Assert.assertEquals(BUTTON_TEXT, webWidgetPage.preview_ButtonText.getAttribute("value"));
	}
	
//	 @SMSM-137-Verify-that-user-is-able-to-add-remove-various-options-to-configure-web-widget
	@Then("User verifies that the state of the Collect Last name toggle button is No")
	public void user_verifies_that_the_state_of_the_Collect_Last_name_toggle_button_is_No() throws Exception {
		Assert.assertTrue(webWidgetPage.getElementText(webWidgetPage.lbl_Collect_Last_Name("No")).contentEquals("No"));
	}

	@Then("User verifies that Last Name textfield is not displayed on the preview section")
	public void user_verifies_that_Last_Name_textfield_is_not_displayed_on_the_preview_section() {
		Assert.assertFalse(webWidgetPage.txtF_preview_Last_Name.isDisplayed());
	}

	@When("User clicks on the Collect Last name toggle button to changeit's state from No to Yes")
	public void user_clicks_on_the_Collect_Last_name_toggle_button_to_changeit_s_state_from_No_to_Yes() throws InterruptedException {
		webWidgetPage.waitAndClickElement(webWidgetPage.toggle_Collect_last_name);
	}

	@Then("User verifies that a Last Name text field is displayed on the preview section")
	public void user_verifies_that_a_Last_Name_text_field_is_displayed_on_the_preview_section() {
		 Assert.assertTrue(webWidgetPage.txtF_preview_Last_Name.isDisplayed());
	}

	@Then("User verifies the state of Collect email address toggle on configure your widget section")
	public void user_verifies_the_state_of_Collect_email_address_toggle_on_configure_your_widget_section() throws Exception {
		Assert.assertTrue(webWidgetPage.getElementText(webWidgetPage.lbl_Collect_Email_Address("Yes")).contentEquals("Yes"));
	}

	@Then("User verifies that email address textbox is displayed on the Preview section")
	public void user_verifies_that_email_address_textbox_is_displayed_on_the_Preview_section() {
		Assert.assertTrue(webWidgetPage.txtF_preview_Email_Address.isDisplayed());
	}

	@When("User clicks on the toggle for Collect email address")
	public void user_clicks_on_the_toggle_for_Collect_email_address() throws InterruptedException {
		webWidgetPage.waitAndClickElement(webWidgetPage.toggle_Collect_email_address);
	}

	@Then("User verifies that Email address textbox is not displayed on the preview section")
	public void user_verifies_that_Email_address_textbox_is_not_displayed_on_the_preview_section() {
		Assert.assertFalse(webWidgetPage.txtF_preview_Email_Address.isDisplayed());
	}
	
	
//	 @SMSM-137-Verify-that-user-is-able-to-select-a-display-method-and-a-theme-to-configure-web-widget
	@When("User clicks the Choose a Display Method button")
	public void user_clicks_the_Choose_a_Display_Method_button() throws Exception {
	   webWidgetPage.waitAndClickElement(webWidgetPage.toggle_Choose_a_Display_Method);
	}

	@Then("the Preview section should display Join Our Mobile Rewards Club!")
	public void the_Preview_section_should_display_Join_Our_Mobile_Rewards_Club() {
	   Assert.assertTrue(webWidgetPage.preview_Btn_Join_Our_Mobile_Rewards_Club.isDisplayed());
	}

	@When("User clicks on Choose a Theme button")
	public void user_clicks_on_Choose_a_Theme_button() throws Exception {
	webWidgetPage.waitAndClickElement(webWidgetPage.toggle_Choose_a_theme);
	}

	@Then("the Preview section color should change to dark gray")
	public void the_Preview_section_color_should_change_to_dark_gray() {
		String color = webWidgetPage.preview_Container.getCssValue("color");
		Assert.assertEquals("#bbbbbb", merchantMenu.getColor(color));
	}

//  @SMSM-137-Verify-that-user-is-able-to-copy-embed-code-successfully
	@When("User clicks the Select a Campaign drop down and selects a campaign")
	public void user_clicks_the_Select_a_Campaign_drop_down_and_selects_a_campaign() throws Exception {
		webWidgetPage.waitAndClickElement(webWidgetPage.lov_Select_a_Campaign);
		webWidgetPage.waitAndClickElement(webWidgetPage.campaignOption("\"Test 3 (Enabled)\""));
	}

	@Then("the Campaign is displayed on the Select a Campaign textbox")
	public void the_Campaign_is_displayed_on_the_Select_a_Campaign_textbox() throws Exception {
		Assert.assertTrue(webWidgetPage.getElementText(webWidgetPage.lov_Select_a_Campaign).contentEquals("Test 3 (Enabled)"));
	}

	@When("User Select the code and clicks copy embed code button")
	public void user_Select_the_code_and_clicks_copy_embed_code_button() throws Exception {
	   webWidgetPage.waitAndClickElement(webWidgetPage.btn_Copy_Embed_Code);
	}

	@Then("User then the code is copied to clipboard")
	public void user_then_the_code_is_copied_to_clipboard() {
	Assert.assertTrue(webWidgetPage.btn_Copy_Embed_Code.getText().contains("Copied to Clipboard!"));
	}


}
