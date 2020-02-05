package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObjects.license.AccountDefaultsPage;
import pageObjects.license.SocialSettingsPage;
import pageObjects.license.WebWidgetPage;
import pageObjects.license.menu.MerchantMenu;
import pageObjects.license.menu.SettingsSubMenu;
import utils.DriverFactory;

public class ViewAndEditAccountDefaultsSettingsInMerchantsPortal extends DriverFactory {

	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	AccountDefaultsPage accountDefaultsPage = PageFactory.initElements(driver, AccountDefaultsPage.class);
	SettingsSubMenu settingSubMenu = PageFactory.initElements(driver, SettingsSubMenu.class);
	SocialSettingsPage socialSettingsPage = PageFactory.initElements(driver, SocialSettingsPage.class);
	WebWidgetPage webWidgetPage = PageFactory.initElements(driver, WebWidgetPage.class);

	@And("User clicks the Settings menu")
	public void user_clicks_the_Settings_menu() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Settings);
	}

	@And("User clicks the Accounts Defaults menu")
	public void user_clicks_the_Accounts_Defaults_menu() throws Exception {
		settingSubMenu.clickAccountDefaults();
	}

	@Then("AccountDefaults page is displayed")
	public void accountdefaults_page_is_displayed() throws Exception {
		Assert.assertEquals("Account Defaults", accountDefaultsPage.getPageTitle());
	}

	@And("User clicks Social Media from the LHS")
	public void user_clicks_Social_Media_from_the_LHS() throws Exception {
		settingSubMenu.clickSocialMedia();
	}

	@Then("user is redirected to the Social Settings and fields like FacebookIntegration,configuremanually and social properties are displayed")
	public void user_is_redirected_to_the_Social_Settings_and_fields_like_FacebookIntegration_configuremanually_and_social_properties_are_displayed()
			throws Exception {
		Assert.assertEquals("Social Settings", socialSettingsPage.getPageTitle());
	}

	@And("User clicks on Web Widget link from the LHS menu")
	public void user_clicks_on_Web_Widget_link_from_the_LHS_menu() throws Exception {
		settingSubMenu.clickWebWidget();
	}

	@Then("User is redirected to the Web Widget page, Configure your widget and preview fields are displayed")
	public void user_is_redirected_to_the_Web_Widget_page_Configure_your_widget_and_preview_fields_are_displayed()
			throws Exception {
		Assert.assertEquals("Configure Your Widget", webWidgetPage.getConfigureYourWidgetTxt());
	}

	@Given("User clicks the Account Defaults")
	public void user_clicks_the_Account_Defaults() throws Exception {
		settingSubMenu.clickAccountDefaults();
	}

	@Then("the Accounts Defaults page is displayed")
	public void the_Accounts_Defaults_page_is_displayed() throws Exception {
		Assert.assertEquals("Account Defaults", accountDefaultsPage.getPageTitle());
	}

	@And("User verifies that the Inbox message limit page section exists")
	public void user_verifies_that_the_Inbox_message_limit_page_section_exists() throws Exception {
		Assert.assertEquals("Inbox Messages Limit", accountDefaultsPage.getInboxMessageLimitTxt());
	}

	@And("User enters the number of limit days and click save button")
	public void user_enters_the_number_of_limit_days_and_click_save_button() throws Exception {
		accountDefaultsPage.setLimitDays("10");
		accountDefaultsPage.clickLimitDaysSaveDtn();
	}

	@Then("Saved validation message is displayed within the Inbox section")
	public void saved_validation_message_is_displayed_within_the_Inbox_section() throws Exception {
		Assert.assertEquals("Saved!", accountDefaultsPage.getAlertSavedTxt()); 
	}

	@And("User enters the default first name variable value and click save button")
	public void user_enters_the_default_first_name_variable_value_and_click_save_button() throws Exception {
		accountDefaultsPage.setDefaultFirstNameVariable("QAlate");
		accountDefaultsPage.clickDefaultValueSaveBtn();
	}

	@Then("Saved validation message is displayed within the Default value section")
	public void saved_validation_message_is_displayed_within_the_Default_value_section() throws Exception {
		Assert.assertEquals("Saved!", accountDefaultsPage.getAlertSavedTxt()); 
	}

}
