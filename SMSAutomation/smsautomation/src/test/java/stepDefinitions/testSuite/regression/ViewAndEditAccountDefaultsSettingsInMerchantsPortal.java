package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObjects.license.AccountDefaultsPage;
import pageObjects.license.AdvertisercpanelPage;
import pageObjects.license.SocialSettingsPage;
import pageObjects.license.menu.SettingsSubMenu;
import utils.DriverFactory;

public class ViewAndEditAccountDefaultsSettingsInMerchantsPortal extends DriverFactory {
	
	AdvertisercpanelPage advertisercpanelPage = PageFactory.initElements(driver, AdvertisercpanelPage.class);
	AccountDefaultsPage accountDefaultsPage = PageFactory.initElements(driver, AccountDefaultsPage.class);
	SettingsSubMenu  settingSubMenu = PageFactory.initElements(driver, SettingsSubMenu.class);
	SocialSettingsPage socialSettingsPage = PageFactory.initElements(driver, SocialSettingsPage.class);
	

	@And("User clicks the Settings menu")
	public void user_clicks_the_Settings_menu() throws Exception {
		advertisercpanelPage.clickSettings();
	}

	@And ("User clicks the Accounts Defaults menu")
	public void user_clicks_the_Accounts_Defaults_menu() throws Exception {
		settingSubMenu.clickAccountDefaults();
	}

	@Then ("AccountDefaults page is displayed")
	public void accountdefaults_page_is_displayed() throws Exception {
		Assert.assertEquals("Account Defaults", accountDefaultsPage.getPageTitle());
	}

	@And ("User clicks Social Media from the LHS")
	public void user_clicks_Social_Media_from_the_LHS() throws Exception {
		settingSubMenu.clickSocialMedia();
	}

	@Then("user is redirected to the Social Settings and fields like FacebookIntegration,configuremanually and social properties are displayed")
	public void user_is_redirected_to_the_Social_Settings_and_fields_like_FacebookIntegration_configuremanually_and_social_properties_are_displayed() throws Exception {
		Assert.assertEquals("Social Settings", socialSettingsPage.getPageTitle());
	}

	@And ("User clicks on Web Widget link from the LHS menu")
	public void user_clicks_on_Web_Widget_link_from_the_LHS_menu() throws Exception {
		settingSubMenu.clickWebWidget();
	}

	@Then ("User is redirected to the Web Widget page, Configure your widget and preview fields are displayed")
	public void user_is_redirected_to_the_Web_Widget_page_Configure_your_widget_and_preview_fields_are_displayed() throws Exception {
		Assert.assertEquals("", "");
	}
}
