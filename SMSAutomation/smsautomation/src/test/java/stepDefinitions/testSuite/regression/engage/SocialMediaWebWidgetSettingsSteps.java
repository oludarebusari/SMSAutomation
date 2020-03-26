package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.SocialSettingsPage;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.menu.SettingsSubMenu;
import utils.DriverFactory;

public class SocialMediaWebWidgetSettingsSteps extends DriverFactory {
	
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	SettingsSubMenu settingsSubMenu = PageFactory.initElements(driver, SettingsSubMenu.class);
	SocialSettingsPage socialSettingsPage = PageFactory.initElements(driver, SocialSettingsPage.class);
	
	
	@Then("the Settings options are displayed")
	public void the_Settings_options_are_displayed() {
	   Assert.assertTrue(settingsSubMenu.menu_Account_Defaults.isDisplayed());
	   Assert.assertTrue(settingsSubMenu.menu_Social_Media.isDisplayed());
	   Assert.assertTrue(settingsSubMenu.menu_Web_Widget.isDisplayed());
	}

//	 @SMSM-137-Verify-that-user-is-able-to-view-Account-Defaults-Social-Media-and-Web-Widget-options-in-settings-tab
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
	    Thread.sleep(19000);
	}


}
