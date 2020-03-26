package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.SocialSettingsPage;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.menu.SettingsSubMenu;
import utils.DriverFactory;

public class SocialMediaWebWidgetSettingsSteps extends DriverFactory {
	
	
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
	  
	}

	@Then("the color of the selected option changes to blue")
	public void the_color_of_the_selected_option_changes_to_blue() {
	 
	}

//	@SMSM-137-Verify-that-user-is-able-to-connect-facebook-account-with-selected-campaign
	@When("User selects a Campaign from Select a campaign dropdown")
	public void user_selects_a_Campaign_from_Select_a_campaign_dropdown() {

	}

	@Then("the selected campaign is displayed on the dropdown text box")
	public void the_selected_campaign_is_displayed_on_the_dropdown_text_box() {
	  
	}

	@When("User clicks on Connect to Facebook button")
	public void user_clicks_on_Connect_to_Facebook_button() {

	}

	@Then("User should be navigated to the facebook login page")
	public void user_should_be_navigated_to_the_facebook_login_page() {
	
	}

}
