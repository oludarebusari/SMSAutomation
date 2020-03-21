package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.ManageAlertsPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.ActivateAlertModal;
import pageObjects.thrive.modal.CreateAlertModal;
import pageObjects.thrive.modal.DateSelectionModal;
import pageObjects.thrive.modal.DeactivateAlertModal;
import pageObjects.thrive.modal.DeleteAlertModal;
import pageObjects.thrive.modal.EditAlertModal;
import utils.DriverFactory;

public class ManageAlertsSteps extends DriverFactory {

	ActivateAlertModal activateAlertModal = PageFactory.initElements(driver, ActivateAlertModal.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CreateAlertModal createAlertModal = PageFactory.initElements(driver, CreateAlertModal.class);
	DateSelectionModal dateSelectionModal = PageFactory.initElements(driver, DateSelectionModal.class);
	DeleteAlertModal deleteAlertModal = PageFactory.initElements(driver, DeleteAlertModal.class);
	DeactivateAlertModal deactivateAlertModal = PageFactory.initElements(driver, DeactivateAlertModal.class);
	EditAlertModal editAlertModal = PageFactory.initElements(driver, EditAlertModal.class);
	ManageAlertsPage manageAlertsPage = PageFactory.initElements(driver, ManageAlertsPage.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);

	private final String ALERT_TEXT1 = "Alert-Automation test1";
	private final String ALERT_TEXT2 = "Alert-Automation test2";
	private final String ALERT_TEXT_EDITED = "Alert-Automation testing";

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
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT1);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Alert is displayed on the Manage Alert paage")
	public void the_Alert_is_displayed_on_the_Manage_Alert_paage() {
		Assert.assertTrue(manageAlertsPage.searchAlertByAlertText(ALERT_TEXT1).isDisplayed());
	}

	@When("User clicks the Edit button beside the displayed Alert")
	public void user_clicks_the_Edit_button_beside_the_displayed_Alert() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.editAlert(ALERT_TEXT1));
	}

	@Then("the Edit Alert window is displayed")
	public void the_Edit_Alert_window_is_displayed() throws Exception {
		Assert.assertEquals("Edit Alert", editAlertModal.getElementText(editAlertModal.mod_Title));
	}

	@When("User makes modification to the Alert and clicks Save Alert button")
	public void user_makes_modification_to_the_Alert_and_clicks_Save_Alert_button() throws Exception {
		editAlertModal.sendKeysToWebElement(editAlertModal.txtF_Text, ALERT_TEXT_EDITED);
		editAlertModal.waitAndClickElement(editAlertModal.txtF_Date);
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_DateThisMonth);
		editAlertModal.waitAndClickElement(editAlertModal.btn_SaveAlert);
	}

	@Then("User confirms the changes are saved correctly")
	public void user_confirms_the_changes_are_saved_correctly() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT_EDITED);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertEquals(ALERT_TEXT_EDITED,
				manageAlertsPage.getElementText(manageAlertsPage.searchForCellValue(ALERT_TEXT_EDITED)));
	}

	@Then("User revert the changes made to the Alert record")
	public void user_revert_the_changes_made_to_the_Alert_record() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.editAlert(ALERT_TEXT_EDITED));
		editAlertModal.sendKeysToWebElement(editAlertModal.txtF_Text, ALERT_TEXT1);
		editAlertModal.sendKeysToWebElement(editAlertModal.txtF_Date, "03/15/2020 04:00 pm to 12/31/2020 03:59 pm");
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_Apply);
		editAlertModal.waitAndClickElement(editAlertModal.btn_SaveAlert);
	}

//	@SMSM-184 @Renew-existing-alert-in-the-list
	@When("User types in an Alert text on the search box for alert to renew and clicks search")
	public void user_types_in_an_Alert_text_on_the_search_box_for_alert_to_renew_and_clicks_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Alert to be renewed is displayed on the Manage Alert paage")
	public void the_Alert_to_be_renewed_is_displayed_on_the_Manage_Alert_paage() {
		Assert.assertTrue(manageAlertsPage.searchAlertByAlertText(ALERT_TEXT2).isDisplayed());
	}

	@When("User clicks the Edit button besides the Alert")
	public void user_clicks_the_Edit_button_besides_the_Alert() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.editAlert(ALERT_TEXT2));
	}

	@When("User clicks the Date text field")
	public void user_clicks_the_Date_text_field() throws Exception {
		editAlertModal.waitAndClickElement(editAlertModal.txtF_Date);
	}

	@Then("the Date window is displayed")
	public void the_Date_window_is_displayed() {
		Assert.assertTrue(dateSelectionModal.mod_Date.isDisplayed());
	}

	@When("User specifies a date in the future and clicks Apply button")
	public void user_specifies_a_date_in_the_future_and_clicks_Apply_button() throws Exception { 
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_DateThisMonth);
	}

	@When("User clicks the Save Alert button on the Edit Alert page")
	public void user_clicks_the_Save_Alert_button_on_the_Edit_Alert_page() throws Exception {
		editAlertModal.waitAndClickElement(editAlertModal.btn_SaveAlert);
	}

	@Then("user confirms that the status of the alert is now Inactive")
	public void user_confirms_that_the_status_of_the_alert_is_now_Inactive() throws Exception {
		Assert.assertTrue(manageAlertsPage.searchForCellValue("Inactive").isDisplayed());
	}
	
//	@SMSM-184 @Activate-existing-alert-in-the-list
	@When("User types in an Alert text on the search box for a renewed alert and clicks search")
	public void user_types_in_an_Alert_text_on_the_search_box_for_a_renewed_alert_and_clicks_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the renewed Alert is displayed on the Manage Alert paage")
	public void the_renewed_Alert_is_displayed_on_the_Manage_Alert_paage() {
		Assert.assertTrue(manageAlertsPage.searchAlertByAlertText(ALERT_TEXT2).isDisplayed());
	}

	@When("User clicks the action dropdown button")
	public void user_clicks_the_action_dropdown_button() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.btn_ActionDDOwn(ALERT_TEXT2));
	}

	@Then("the dropdown action options are displayed")
	public void the_dropdown_action_options_are_displayed() {
		Assert.assertTrue(manageAlertsPage.btn_Activate(ALERT_TEXT2).isDisplayed());
		Assert.assertTrue(manageAlertsPage.btn_Delete(ALERT_TEXT2).isDisplayed());
	}

	@When("User clicks the Activate button")
	public void user_clicks_the_Activate_button() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.btn_Activate(ALERT_TEXT2));
	}

	@When("User clicks the Activate button on the Activate Alert window")
	public void user_clicks_the_Activate_button_on_the_Activate_Alert_window() throws Exception {
		activateAlertModal.waitAndClickElement(activateAlertModal.btn_Activate);
	}

	@Then("the Alert is activated and User is redirected to the Manage Alert page")
	public void the_Alert_is_activated_and_User_is_redirected_to_the_Manage_Alert_page() throws Exception {
		Assert.assertEquals("Manage Alerts", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@And("the alert notification is displayed on the manage alert page")
	public void the_alert_notification_is_displayed_on_the_manage_alert_page() throws Exception {
		Assert.assertTrue(manageAlertsPage.alert_Notification.isDisplayed());
	}

	@When("User search for the activated Alert")
	public void user_search_for_the_activated_Alert() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the alert is displayed with an Active status.")
	public void the_alert_is_displayed_with_an_Active_status() {
		Assert.assertTrue(manageAlertsPage.searchForCellValue("Active").isDisplayed());
	}

//	 @SMSM-184 @Deactivate-existing-alert-in-the-list
	@When("User searches for an active alert")
	public void user_searches_for_an_active_alert() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the active alert is displayed on the Manage page")
	public void the_active_alert_is_displayed_on_the_Manage_page() {
		Assert.assertTrue(manageAlertsPage.searchAlertByAlertText(ALERT_TEXT2).isDisplayed());
	}

	@Then("the dropdown options for active alerts are displayed")
	public void the_dropdown_options_for_active_alerts_are_displayed() {
		Assert.assertTrue(manageAlertsPage.btn_Deactivate(ALERT_TEXT2).isDisplayed());
		Assert.assertTrue(manageAlertsPage.btn_Delete(ALERT_TEXT2).isDisplayed());
	}

	@When("User clicks the Deactivate button")
	public void user_clicks_the_Deactivate_button() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.btn_Deactivate(ALERT_TEXT2));
	}

	@When("User clicks the Deactivate button on the Deactivate Alert window")
	public void user_clicks_the_Deactivate_button_on_the_Deactivate_Alert_window() throws Exception {
		deactivateAlertModal.waitAndClickElement(deactivateAlertModal.btn_Deactivate);
	}

	@Then("the alert is deactivated and User is redirected to the Manage Alert page")
	public void the_alert_is_deactivated_and_User_is_redirected_to_the_Manage_Alert_page() throws Exception {
		Assert.assertEquals("Manage Alerts", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User search for the deactivated Alert")
	public void user_search_for_the_deactivated_Alert() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the alert is displayed with an Inactive status")
	public void the_alert_is_displayed_with_an_Inactive_status() {
		Assert.assertTrue(manageAlertsPage.searchForCellValue("Inactive").isDisplayed());
	}


//	@SMSM-184 @Delete-existing-alert-in-the-list
	@When("User searches for an alert to delete")
	public void user_searches_for_an_alert_to_delete() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the alert to be deleted is displayed on the manage page")
	public void the_alert_to_be_deleted_is_displayed_on_the_manage_page() {
		Assert.assertTrue(manageAlertsPage.searchAlertByAlertText(ALERT_TEXT2).isDisplayed());
	}

	@Then("the dropdown options for the alert to be deleted are displayed")
	public void the_dropdown_options_for_the_alert_to_be_deleted_are_displayed() {
		Assert.assertTrue(manageAlertsPage.btn_Activate(ALERT_TEXT2).isDisplayed());
		Assert.assertTrue(manageAlertsPage.btn_Delete(ALERT_TEXT2).isDisplayed());
	}

	@When("User clicks the Delete button")
	public void user_clicks_the_Delete_button() throws Exception {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.btn_Delete(ALERT_TEXT2));
	}

	@When("User clicks the Delete button on the Delete Alert window")
	public void user_clicks_the_Delete_button_on_the_Delete_Alert_window() throws Exception {
		deleteAlertModal.waitAndClickElement(deleteAlertModal.btn_Delete);
	}

	@Then("the alert is deleted and user is redirected to the Manage Alerts page")
	public void the_alert_is_deleted_and_user_is_redirected_to_the_Manage_Alerts_page() throws Exception {
		Assert.assertEquals("Manage Alerts", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User search for the deleted alert")
	public void user_search_for_the_deleted_alert() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, ALERT_TEXT2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("zero result is displayed")
	public void zero_result_is_displayed() {

	}

//	@SMSM-184 @Create-a-new-alert
	@When("User clicks the new button on the Manage Alert poage")
	public void user_clicks_the_new_button_on_the_Manage_Alert_poage() throws InterruptedException {
		manageAlertsPage.waitAndClickElement(manageAlertsPage.btn_New);
		;
	}

	@Then("the create Alert window is opened")
	public void the_create_Alert_window_is_opened() throws Exception {
		Assert.assertEquals("Create Alert", createAlertModal.getElementText(createAlertModal.mod_Title));
	}

	@When("User enters the new alert information and clicks Schedule this Alert button")
	public void user_enters_the_new_alert_information_and_clicks_Schedule_this_Alert_button() throws Exception {
		createAlertModal.sendKeysToWebElement(createAlertModal.txtF_Text, ALERT_TEXT2);
		createAlertModal.sendKeysToWebElement(createAlertModal.txtF_Date, "02/01/2020 12:00 am to 02/29/2020 3:59 am");
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_Apply);
		createAlertModal.waitAndClickElement(createAlertModal.lov_Roles);
		createAlertModal.waitAndClickElement(createAlertModal.rolesOption("Admin"));
		createAlertModal.waitAndClickElement(createAlertModal.txtF_Text);
		createAlertModal.waitAndClickElement(createAlertModal.btn_ScheduleThisAlert);
	}

	@Then("the created and schedule successfully")
	public void the_created_and_schedule_successfully() throws Exception {

	}

}
