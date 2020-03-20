package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.ManagerAlertsPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.DateSelectionModal;
import pageObjects.thrive.modal.EditAlertModal;
import utils.DriverFactory;

public class ManageAlertsSteps extends DriverFactory {

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	DateSelectionModal dateSelectionModal= PageFactory.initElements(driver, DateSelectionModal.class);
	EditAlertModal editAlertModal = PageFactory.initElements(driver, EditAlertModal.class);
	ManagerAlertsPage managerAlertsPage = PageFactory.initElements(driver, ManagerAlertsPage.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	private final String ALERT_TEXT = "Alert-Automation test1";

//	@SMSM-184-Navigate-to-Manage-Alert-option-under-settings-on-thrive-system
	@When("User clicks settings from the top menu bar")
	public void user_clicks_settings_from_the_top_menu_bar() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Settings);
	}

	@Then("the Settings menu is expanded and settings options are displayed")
	public void the_Settings_menu_is_expanded_and_settings_options_are_displayed() {
		Assert.assertTrue(settingsDDown.opt_Settings.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Language_Strings.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Message_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Page_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Screen_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Image_Gallery.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Video_Gallery.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Alerts.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Tours.isDisplayed());
	}

	@When("User clicks on Alert option")
	public void user_clicks_on_Alert_option() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Alerts);
	}

	@Then("the Manage Alert page is displayed")
	public void the_Manage_Alert_page_is_displayed() throws Exception {
		Assert.assertEquals("Manage Alerts", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@SMSM-184 @Edit-existing-alert-in-the-list
	@When("User types in an Alert text on the search box and clicks search")
	public void user_types_in_an_Alert_text_on_the_search_box_and_clicks_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Alert-Automation test1");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Alert is displayed on the Manage Alert paage")
	public void the_Alert_is_displayed_on_the_Manage_Alert_paage() {
		Assert.assertTrue(managerAlertsPage.searchAlertByAlertText("Alert-Automation test1").isDisplayed());
	}

	@When("User clicks the Edit button button beside the displayed Alert")
	public void user_clicks_the_Edit_button_button_beside_the_displayed_Alert() throws Exception {
		managerAlertsPage.waitAndClickElement(managerAlertsPage.editAlert("Alert-Automation test1"));
	}

	@Then("the Edit Alert window is displayed")
	public void the_Edit_Alert_window_is_displayed() throws Exception {
		Assert.assertEquals("Edit Alert", editAlertModal.getElementText(editAlertModal.mod_Title));
	}

	@When("User makes modification to the Alert and clicks Save Alert button")
	public void user_makes_modification_to_the_Alert_and_clicks_Save_Alert_button() throws Exception {
		editAlertModal.sendKeysToWebElement(editAlertModal.txtF_Text, "Alert-Automation testing");
		editAlertModal.waitAndClickElement(editAlertModal.txtF_Date);
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_DateThisMonth);
		Thread.sleep(6000);
		editAlertModal.waitAndClickElement(editAlertModal.btn_SaveAlert);
		
	}

	@Then("User confirms the changes are saved correctly")
	public void user_confirms_the_changes_are_saved_correctly() {

	}

//	@SMSM-184 @Renew-existing-alert-in-the-list
	@When("User types in an Alert text on the search box for alert to renew and clicks search")
	public void user_types_in_an_Alert_text_on_the_search_box_for_alert_to_renew_and_clicks_search() {

	}

	@Then("the Alert to be renewed is displayed on the Manage Alert paage")
	public void the_Alert_to_be_renewed_is_displayed_on_the_Manage_Alert_paage() {

	}

	@When("User clicks the Date text field")
	public void user_clicks_the_Date_text_field() {

	}

	@Then("the Date window is displayed")
	public void the_Date_window_is_displayed() {

	}

	@When("User specifies a date in the future and clicks Apply button")
	public void user_specifies_a_date_in_the_future_and_clicks_Apply_button() {

	}

	@When("User clicks the Save Alert button on the Edit Alert page")
	public void user_clicks_the_Save_Alert_button_on_the_Edit_Alert_page() {

	}

	@Then("user confirms that the status of the lert is now active")
	public void user_confirms_that_the_status_of_the_lert_is_now_active() {

	}

	@When("User clicks the action dropdown button")
	public void user_clicks_the_action_dropdown_button() {

	}

	@Then("the dropdown action options are displayed")
	public void the_dropdown_action_options_are_displayed() {

	}

	@When("User clicks the Delete button")
	public void user_clicks_the_Delete_button() {

	}

	@When("User clicks the Detele button on the Delete Alert window")
	public void user_clicks_the_Detele_button_on_the_Delete_Alert_window() {

	}

	@Then("the Alert is deleted and User is redirected to the Manage Alert page")
	public void the_Alert_is_deleted_and_User_is_redirected_to_the_Manage_Alert_page() {

	}

	@When("User search for the deleted Alert")
	public void user_search_for_the_deleted_Alert() {

	}

	@Then("zero record is displayed")
	public void zero_record_is_displayed() {

	}

}
