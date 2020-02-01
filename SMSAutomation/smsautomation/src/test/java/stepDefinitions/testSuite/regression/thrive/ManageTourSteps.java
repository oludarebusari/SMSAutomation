package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.AdminToursPage;
import pageObjects.thrive.Tab.SettingsDDown;
import utils.DriverFactory;

public class ManageTourSteps extends DriverFactory {

	
	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public AdminToursPage adminToursPage = PageFactory.initElements(driver, AdminToursPage.class);
	
	@Given("User clicks on settings on top menu bar")
	public void user_clicks_on_settings_on_top_menu_bar() throws Exception {
		thrDashboardPage.clickSettingsTab();
	}

	@Then("the settings options are displayed")
	public void the_settings_options_are_displayed() throws Exception {
//		 Assert.assertTrue(settingsDDown.getElementText(settingsDDown.opt_Settings).contains("Settings"));
		 Assert.assertEquals("Settings", settingsDDown.getElementText(settingsDDown.opt_Settings));
	}

	@Given("User clicks on Tours under settings")
	public void user_clicks_on_Manage_tour_under_settings() throws Exception {
		settingsDDown.clickToursOpt();
	}

	@Then("User is redirected to Tours page")
	public void user_is_redirected_to_Tours_page() throws Exception {
		Assert.assertEquals("Tours", adminToursPage.getToursPageTitle());
	}
	

	@Given("User types in a Tour name on the search textfield")
	public void user_types_in_a_Tour_name_on_the_search_textfield() {
	
	}

	@Given("User clicks the Search button")
	public void user_clicks_the_Search_button() {

	}
	
	@Then("the Tour is displayed on the page")
	public void the_Tour_is_displayed_on_the_page() {
	
	}

}
