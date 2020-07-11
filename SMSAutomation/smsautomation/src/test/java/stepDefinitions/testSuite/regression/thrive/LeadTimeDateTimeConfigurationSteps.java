package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.EditResellerPage;
import pageObjects.thrive.EditUserPage;
import pageObjects.thrive.ManageResellerPage;
import pageObjects.thrive.ResellerUsersPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.UsersDDown;

public class LeadTimeDateTimeConfigurationSteps extends BasePage {

	public LeadTimeDateTimeConfigurationSteps() throws IOException {
		super();
	}

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	EditResellerPage editResellerPage = PageFactory.initElements(driver, EditResellerPage.class);
	EditUserPage editUserPage = PageFactory.initElements(driver, EditUserPage.class);
	ManageResellerPage manageResellerPage = PageFactory.initElements(driver, ManageResellerPage.class);
	ResellerUsersPage resellerUsersPage = PageFactory.initElements(driver, ResellerUsersPage.class);
	UsersDDown usersDDown = PageFactory.initElements(driver, UsersDDown.class);

//	@Date/Time-Configuration:-Reseller-Level:-Verify-Display
	@Then("User verifies the Office Hour Information sections available.")
	public void user_verifies_the_Office_Hour_Information_sections_available() throws InterruptedException {
		Assert.assertTrue(editResellerPage.panel_OfficeHour.isDisplayed());
		Assert.assertTrue(editResellerPage.sec_OfficeHourStart.isDisplayed());
		Assert.assertTrue(editResellerPage.sec_OfficeHourEnd.isDisplayed());
		Assert.assertTrue(editResellerPage.panel_OfficeTimeZone.isDisplayed());
	}

	@Then("User verifies the available Days options")
	public void user_verifies_the_available_Days_options() throws InterruptedException {
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Sun));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Mon));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Tue));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Wed));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Thu));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Fri));
		Assert.assertTrue(editResellerPage.isElementClickable(editResellerPage.btn_Sat));

		// Asserts enabled Sunday button
		editResellerPage.waitAndClickElement(editResellerPage.btn_Sun);
		String color = editResellerPage.btn_Sun.getCssValue("background-color");
		Assert.assertEquals("#e6e6e6", editResellerPage.getColor(color));

		// Asserts disabled Saturday button
		String color1 = editResellerPage.btn_Sat.getCssValue("background-color");
		Assert.assertEquals("#ffffff", editResellerPage.getColor(color1));
	}

	@Then("User verifies the Office Hours Start options")
	public void user_verifies_the_Office_Hours_Start_options() throws InterruptedException {
		Assert.assertTrue(editResellerPage.startHoursDDown.isDisplayed());
		Assert.assertTrue(editResellerPage.btn_StartHourAM.isDisplayed());
		Assert.assertTrue(editResellerPage.btn_StartHourPM.isDisplayed());
		editResellerPage.waitAndClickElement(editResellerPage.startHoursDDown);
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.getStartHourValueLocator("0:00")));
		Assert.assertTrue(editResellerPage.startHourValue("1:00").isDisplayed());
		Assert.assertTrue(editResellerPage.startHourValue("12:00").isDisplayed());
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.getStartHourValueLocator("12:25")));
		editResellerPage.waitAndClickElement(editResellerPage.startHourValue("2:00"));
		editResellerPage.waitAndClickElement(editResellerPage.btn_StartHourPM);
	}

	@Then("User verifies the Office Hours End Options")
	public void user_verifies_the_Office_Hours_End_Options() throws InterruptedException {
		Assert.assertTrue(editResellerPage.endHourDDown.isDisplayed());
		Assert.assertTrue(editResellerPage.btn_EndHourAM.isDisplayed());
		Assert.assertTrue(editResellerPage.btn_EndHourPM.isDisplayed());
		editResellerPage.waitAndClickElement(editResellerPage.endHourDDown);
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.getEndHourValueLocator("0:30")));
		Assert.assertTrue(editResellerPage.endHourValue("1:00").isDisplayed());
		Assert.assertTrue(editResellerPage.endHourValue("12:00").isDisplayed());
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.getEndHourValueLocator("13:00")));
		editResellerPage.waitAndClickElement(editResellerPage.btn_EndHourPM);

	}

	@Then("User verifies the Time Zone options")
	public void user_verifies_the_Time_Zone_options() throws Exception {
		Assert.assertEquals("Central Time - UTC-6:00 (CST) / UTC-5:00 (CDT)",
				editResellerPage.getElementText(editResellerPage.selectedTimeZone));
		editResellerPage.waitAndClickElement(editResellerPage.timeZoneDDown);
		editResellerPage
				.waitAndClickElement(editResellerPage.timeZoneValue("Mountain Time - UTC-07:00 (MST) UTC-06:00 (MDT)"));
	}

	@Then("User clicks the Save Reseller button")
	public void user_clicks_the_Save_Reseller_button() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.btn_SaveReseller);
	}

	@When("User queries the same Reseller record")
	public void user_queries_the_same_Reseller_record() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Companies);
		companiesDDown.waitAndClickElement(companiesDDown.opt_Resellers);
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AclateLead");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Edit_Dropdown("AclateLead"));
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Edit("AclateLead"));
	}

	@Then("User verifies that the changes to the Reseller record were saved correctly")
	public void user_verifies_that_the_changes_to_the_Reseller_record_were_saved_correctly() throws Exception {
		Assert.assertEquals("Sun", editResellerPage.getElementText(editResellerPage.selectedDay("Sun")));
		Assert.assertEquals("2:00", editResellerPage.getElementText(editResellerPage.selectedStartHour));
		Assert.assertEquals("PM", editResellerPage.getElementText(editResellerPage.selectedStartTypeAMPM));
		Assert.assertEquals("PM", editResellerPage.getElementText(editResellerPage.selectedEndTypeAMPM));
		Assert.assertEquals("Mountain Time - UTC-07:00 (MST) UTC-06:00 (MDT)",
				editResellerPage.getElementText(editResellerPage.selectedTimeZone));
	}

	@When("User makes a change to the Days available setting")
	public void user_made_a_change_to_the_Days_available_setting() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.btn_Sun);
		editResellerPage.waitAndClickElement(editResellerPage.btn_Mon);
	}

	@Then("User verifies the changes made to the Days available setting")
	public void user_verifies_the_changes_made_to_the_Days_available_setting() throws InterruptedException {
		Assert.assertEquals("Mon", editResellerPage.getElementText(editResellerPage.selectedDay("Mon")));
	}

	@When("User makes a change to the Office Hours Start setting")
	public void user_makes_a_change_to_the_Office_Hours_Start_setting() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.startHoursDDown);
		editResellerPage.waitAndClickElement(editResellerPage.startHourValue("4:00"));
	}

	@Then("User verifies the changes made to Office Hours Start setting")
	public void user_verifies_the_changes_made_to_Office_Hours_Start_setting() throws Exception {
		Assert.assertEquals("4:00", editResellerPage.getElementText(editResellerPage.selectedStartHour));
	}

	@Then("User verifies the changes made to the Time Zone setting")
	public void user_verifies_the_changes_made_to_the_Time_Zone_setting() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.timeZoneDDown);
		editResellerPage
				.waitAndClickElement(editResellerPage.timeZoneValue("Central Time - UTC-6:00 (CST) / UTC-5:00 (CDT)"));
	}

	@Then("User verifies the changes made to thwe Time Zone setting")
	public void user_verifies_the_changes_made_to_thwe_Time_Zone_setting() throws Exception {
		Assert.assertEquals("Central Time - UTC-6:00 (CST) / UTC-5:00 (CDT)",
				editResellerPage.getElementText(editResellerPage.selectedTimeZone));
	}

	// #Revert changes to Reseller
	@Then("User reverts changes made to Reseller")
	public void user_reverts_changes_made_to_Reseller() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.btn_Mon);
		editResellerPage.waitAndClickElement(editResellerPage.btn_StartHourAM);
		editResellerPage.waitAndClickElement(editResellerPage.btn_EndHourAM);
		editResellerPage.waitAndClickElement(editResellerPage.btn_SaveReseller);
	}

//  @Date/Time-Configuration:-Reseller-User-Level:-Verify-Display
	@When("User clicks the edit button for a selected user")
	public void user_clicks_the_edit_button_for_a_selected_user() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "TestAuto");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown("TestAuto"));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction("TestAuto"));
	}

	@Then("User verifies the Time Zone Information is displayed")
	public void user_verifies_the_Time_Zone_Information_is_displayed() {
		Assert.assertTrue(editUserPage.panel_TimeZone.isDisplayed());
	}

	@Then("User verifies User level timezone option")
	public void user_verifies_User_level_timezone_option() throws Exception {
		// User verifies the default time zone selected
		Assert.assertEquals("Central Time - UTC-6:00 (CST) / UTC-5:00 (CDT)",
				editUserPage.getElementText(editUserPage.selectedTimeZone));
	}

	@When("User updates the Time Zone value")
	public void user_updates_the_Time_Zone_value() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.timeZoneDDown);
		editUserPage.waitAndClickElement(editUserPage.timeZoneValue("Mountain Time - UTC-07:00 (MST) UTC-06:00 (MDT)"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@When("User clicks the Save User button")
	public void user_clicks_the_Save_User_button() throws Exception {

		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

	@When("User re-query the same user record")
	public void user_re_query_the_same_user_record() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Users);
		usersDDown.waitAndClickElement(usersDDown.opt_Resellers);
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "TestAuto");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown("TestAuto"));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction("TestAuto"));
	}

	@Then("User verifies that the updated timezone value is reflected")
	public void user_verifies_that_the_updated_timezone_value_is_reflected() throws InterruptedException {
		Assert.assertEquals("Mountain Time - UTC-07:00 (MST) UTC-06:00 (MDT)",
				editUserPage.getElementText(editUserPage.selectedTimeZone));
	}

	
//	#Revert changes to User
	@Then("User reverts changes made to User record")
	public void user_reverts_changes_made_to_User_record() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.timeZoneDDown);
		editUserPage.waitAndClickElement(editUserPage.timeZoneValue("Central Time - UTC-6:00 (CST) / UTC-5:00 (CDT)"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}


	
}
