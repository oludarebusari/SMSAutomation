package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.AdminToursEditPage;
import pageObjects.thrive.AdminToursPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.AdminToursActivateModal;
import pageObjects.thrive.modal.AdminToursDeactivateModal;
import pageObjects.thrive.modal.AdminToursDeleteModal;
import pageObjects.thrive.modal.AdminToursHelpModal;
import utils.DriverFactory;

public class ManageTourSteps extends DriverFactory {

	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	public AdminToursPage adminToursPage = PageFactory.initElements(driver, AdminToursPage.class);
	public AdminToursEditPage adminToursEditPage = PageFactory.initElements(driver, AdminToursEditPage.class);
	public AdminToursDeactivateModal adminToursDeactivateModal = PageFactory.initElements(driver,
			AdminToursDeactivateModal.class);
	public AdminToursDeleteModal adminToursDeleteModal = PageFactory.initElements(driver, AdminToursDeleteModal.class);
	public AdminToursActivateModal adminToursActivateModal = PageFactory.initElements(driver,
			AdminToursActivateModal.class);
	public AdminToursHelpModal adminToursHelpModal = PageFactory.initElements(driver, AdminToursHelpModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);

//	@SMSM-185-Navigate-to-manage-tour-option
	@Given("User clicks on settings on top menu bar")
	public void user_clicks_on_settings_on_top_menu_bar() throws Exception {
		thrDashboardPage.waitAndClickElement(commonElementLocator.menu_Settings);
	}

	@Then("the settings options are displayed")
	public void the_settings_options_are_displayed() throws Exception {
		Assert.assertEquals("Settings", settingsDDown.getElementText(settingsDDown.opt_Settings));
	}

	@Given("User clicks on Tours under settings")
	public void user_clicks_on_Manage_tour_under_settings() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Tours);
	}

	@Then("User is redirected to Tours page")
	public void user_is_redirected_to_Tours_page() throws Exception {
		Assert.assertEquals("Tours", adminToursPage.getElementText(adminToursPage.pag_Title));
	}

//	@SMSM-185-Search-and-edit-existing-tour-in-the-edit
	@Given("User types in a Tour name on the search textfield")
	public void user_types_in_a_Tour_name_on_the_search_textfield() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "Aclate");
	}

	@Given("User clicks the Search button")
	public void user_clicks_the_Search_button() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the Tour is displayed on the page")
	public void the_Tour_is_displayed_on_the_page() throws Exception {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("AclateQA")));
	}

	@When("User clicks the Edit button on the Tour")
	public void user_clicks_the_Edit_button_on_the_Tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("AclateQA"));
	}

	@Then("the Edit Tour Page is opened")
	public void the_Edit_Tour_Page_is_opened() throws InterruptedException {
		Assert.assertTrue(adminToursEditPage.getElementText(adminToursEditPage.pag_Title).contentEquals("Edit Tour"));
	}

	@Then("User edits the Tour Name")
	public void user_edits_the_Tour_Name() throws Exception {
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_TourName, "QATest");
	}

	@Then("User edits the path")
	public void user_edits_the_path() throws Exception {
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Path, "/aclateQA2");
	}

	@Then("User selects additional Role from the dropdown")
	public void user_selects_additional_Role_from_the_dropdown() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.lov_Role);
		adminToursEditPage.waitAndClickElement(adminToursEditPage.selectRole("Admin"));
	}

	@Then("User navigate to a step and edit the step")
	public void user_navigate_to_a_step_and_edit_the_step() throws Exception {
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Message("0"), "This is QA Automation Testing");
	}

	@Then("User clicks the Save Tour button")
	public void user_clicks_the_Save_Tour_button() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_SaveTour);
		Thread.sleep(2000);
	}

	@Then("the tour is saved successfuland user confirmed the changes")
	public void the_tour_is_saved_successfuland_user_confirmed_the_changes() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.txt_TourName).contentEquals("QATest"));
	}

//	@SMSM-185-Deactivate-existing-tour-in-the-edit 
	@Given("User types in a Tour name on the search textfield to open an active tour")
	public void user_types_in_a_Tour_name_on_the_search_textfield_to_open_an_active_tour() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
	}

	@Given("User clicks the Search button for the active tour")
	public void user_clicks_the_Search_button_for_the_active_tour() throws InterruptedException {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the searched Tour is displayed on the page")
	public void the_searched_Tour_is_displayed_on_the_page() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("QATest")));
	}

	@When("User clicks the dropdown button near edit")
	public void user_clicks_the_dropdown_button_near_edit() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditDropdownByTourName("QATest"));
	}

	@Then("a list of actions for activated tour were displayed")
	public void a_list_of_actions_for_activated_tour_were_displayed() throws Exception {
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.btn_Deactivate).contentEquals("Deactivate"));
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.btn_Delete).contentEquals("Delete"));
	}

	@When("User clicks the Deactivate")
	public void user_clicks_the_Deactivate() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Deactivate);
	}

	@Then("the Deactivate Tour pop up is opened")
	public void the_Deactivate_Tour_pop_up_is_opened() throws Exception {
		Assert.assertTrue(adminToursDeactivateModal.getElementText(adminToursDeactivateModal.mod_Title)
				.contentEquals("Deactivate Tour"));
	}

	@When("User clicks the Deactivate button on the Deactivate Tour popo up")
	public void user_clicks_the_Deactivate_button_on_the_Deactivate_Tour_popo_up() throws Exception {
		adminToursDeactivateModal.waitAndClickElement(adminToursDeactivateModal.btn_Deactivate);
	}

	@When("User searches for the deactivated Tour")
	public void user_searches_for_the_deactivated_Tour() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the status of the Tour changes to Inactive")
	public void the_status_of_the_Tour_changes_to_Inactive() throws Exception {
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.txt_Status).contains("inactive"));
	}

	@Given("User types in a Tour name on the search textfield to open the deactivated tour")
	public void user_types_in_a_Tour_name_on_the_search_textfield_to_open_the_deactivated_tour() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
	}

	@Given("User clicks the Search button to bring up the deactivated tour")
	public void user_clicks_the_Search_button_to_bring_up_the_deactivated_tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the deactivated Tour is displayed on the page")
	public void the_deactivated_Tour_is_displayed_on_the_page() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("QATest")));
	}

	@When("User clicks the dropdown button near edit button for the deactivated tour")
	public void user_clicks_the_dropdown_button_near_edit_button_for_the_deactivated_tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditDropdownByTourName("QATest"));
	}

	@Then("a list of actions for deactivated tour is displayed")
	public void a_list_of_actions_for_deactivated_tour_is_displayed() throws Exception {
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.btn_Activate).contentEquals("Activate"));
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.btn_Delete).contentEquals("Delete"));
	}

	@When("User clicks the Activate")
	public void user_clicks_the_Activate() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Activate);
	}

	@Then("the Activate Tour pop up is opened")
	public void the_Activate_Tour_pop_up_is_opened() throws Exception {
		Assert.assertTrue(adminToursActivateModal.getElementText(adminToursActivateModal.mod_Title)
				.contentEquals("Activate Tour"));
	}

	@When("User clicks the Activate button on the Activate Tour popo up")
	public void user_clicks_the_Activate_button_on_the_Activate_Tour_popo_up() throws Exception {
		adminToursActivateModal.waitAndClickElement(adminToursActivateModal.btn_Activate);
	}

	@Then("the status of the Tour changes to Active")
	public void the_status_of_the_Tour_changes_to_Active() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.txt_Status).contentEquals("Active"));
	}

	@Given("User clicks on the Help button on top right of screen")
	public void user_clicks_on_the_Help_button_on_top_right_of_screen() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Help);
	}

	@Given("Tour guide should starts successfully.")
	public void tour_guide_should_starts_successfully() throws Exception {
		Assert.assertTrue(adminToursHelpModal.getElementText(adminToursHelpModal.mod_Tours_Help_Title)
				.contentEquals("Guided Tours"));
	}

	@When("User clicks on Next button on Manage user group")
	public void user_clicks_on_Next_button_on_Manage_user_grou() throws Exception {
		adminToursHelpModal.waitAndClickElement(adminToursHelpModal.btn_Tours_Help_Next);
	}

	@Then("Tour guide should proceed to next step")
	public void tour_guide_should_proceed_to_next_step() throws Exception {
		Assert.assertTrue(adminToursHelpModal.getElementText(adminToursHelpModal.mod_Tours_Help_Title)
				.contentEquals("Add a New Guided Tour"));
	}

	@When("User clicks on Previous button on Manage user group")
	public void user_clicks_on_Previous_button_on_Manage_user_group() throws Exception {
		adminToursHelpModal.waitAndClickElement(adminToursHelpModal.btn_Tours_Help_Prev);
	}

	@Then("Tour guide is navigated to previous step")
	public void tour_guide_is_navigated_to_previous_step() throws Exception {
		Assert.assertTrue(adminToursHelpModal.getElementText(adminToursHelpModal.mod_Tours_Help_Title)
				.contentEquals("Guided Tours"));
	}

	@When("User clicks on End Tour button")
	public void user_clicks_on_End_Tour_button() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_EndTour);
		Thread.sleep(200);
	}

	@Then("Tour ends successfully")
	public void tour_ends_successfully() {
		Assert.assertFalse(adminToursHelpModal.isElementClickable(adminToursHelpModal.btn_Tours_Help_EndTour));

	}

//	@SMSM-185-Edit-the-existing-tour-in-the-list-add-a-step
	@Given("User types a tour name to search in the search textfield")
	public void user_types_a_tour_name_to_search_in_the_search_textfield() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "QATest");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the searched Tour is displayed")
	public void the_searched_Tour_is_displayed() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("QATest")));
	}

	@When("User clicks the Edit button on the Tour displayed")
	public void user_clicks_the_Edit_button_on_the_Tour_displayed() throws InterruptedException {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("QATest"));
	}

	@Then("User click on the Add Step button")
	public void user_click_on_the_Add_Step_button() throws InterruptedException {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_AddStep);
	}

	@Then("User enters details for selector, title, path and message")
	public void user_enters_details_for_selector_title_path_and_message() throws Exception {
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_TourName, "AclateQA");
		adminToursEditPage.waitAndClickElement(adminToursEditPage.removeRole("Admin"));
		adminToursEditPage.waitAndClickElement(adminToursEditPage.lov_Role);
		adminToursEditPage.waitAndClickElement(adminToursEditPage.selectRole("Merchant"));
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Selector("1"), "Test1");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Title("1"), "MyTest");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_StepPath("1"), "/Autotest");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Message("1"), "Testing");
	}

	@Then("the tour is saved successful and user confirmed the changes")
	public void the_tour_is_saved_successful_and_user_confirmed_the_changes() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "AclateQA");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("AclateQA"));
		Assert.assertEquals("Test1", adminToursEditPage.txtF_Selector("1").getAttribute("value"));
	}
	
//	@SMSM-185-Edit-the-existing-tour-in-the-list-remove-a-step
	@Given("User searches for a tour to edit")
	public void user_searches_for_a_tour_to_edit() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "AclateQA");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the searched Tour is successfully displayed")
	public void the_searched_Tour_is_successfully_displayed() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("AclateQA")));
	}

	@When("User clicks the Edit button to modify the tour")
	public void user_clicks_the_Edit_button_to_modify_the_tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("AclateQA"));
	}

	@Then("User click on the Remove Step button")
	public void user_click_on_the_Remove_Step_button() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_RemoveStep("1"));
		Thread.sleep(2000);
	}

	@Then("Click the Save Tour button")
	public void click_the_Save_Tour_button() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_SaveTour);
	}

//	@SMSM-185-Create-a-Tour
	@When("User enters the details of a new Tour")
	public void user_enters_the_details_of_a_new_Tour() throws Exception {
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_TourName, "AclateQA1");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Path, "/testing");
		adminToursEditPage.waitAndClickElement(adminToursEditPage.lov_Role);
		adminToursEditPage.waitAndClickElement(adminToursEditPage.selectRole("Admin"));
		adminToursEditPage.waitAndClickElement(adminToursEditPage.txtF_TourName);

		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_AddStep);
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Selector("0"), "TestA");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Title("0"), "Auto Test1");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_StepPath("0"), "/autotest1");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Message("0"), "Automation Testing1");

		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_AddStep);
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Selector("1"), "TestB");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Title("1"), "Auto Test2");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_StepPath("1"), "/autotest2");
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Message("1"), "Automation Testing2");

	}

//	@SMSM-185-Edit-an-existing-tour-in-the-list-by-removing-the-role-assigned-to-the-tour
	@When("User types the tour name to edit into the Search textField")
	public void user_types_the_tour_name_to_edit_into_the_Search_textField() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "AclateQA1");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}

	@Then("the tour is displayed on the tour page")
	public void the_tour_is_displayed_on_the_tour_page() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("AclateQA1")));
	}

	@When("User clicks the tour's Edit button")
	public void user_clicks_the_tour_s_Edit_button() throws InterruptedException {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("AclateQA1"));
	}

	@When("User clicks the Remove role button")
	public void user_clicks_the_Remove_role_button() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.removeRole("Admin"));
	}

	@Then("user confirms the role is removed from the tour")
	public void user_confirms_the_role_is_removed_from_the_tour() throws Exception {
		adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "AclateQA1");
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		Assert.assertEquals("", adminToursPage.getElementText(adminToursPage.getCellValueByRowAndColumn("1", "2")));
	}
	
//	@SMSM-185-Cancel-Delete-existing-tour-process
	@When("User clicks the tour's drop down button")
	public void user_clicks_the_tour_s_drop_down_button() throws Exception {
	  adminToursPage.waitAndClickElement(adminToursPage.btn_EditDropdownByTourName("AclateQA1"));
	}

	@Then("a list of actions that can be performed on the tour is displayed")
	public void a_list_of_actions_that_can_be_performed_on_the_tour_is_displayed() {
		Assert.assertTrue(adminToursPage.btn_Deactivate.isDisplayed());
		Assert.assertTrue(adminToursPage.btn_Delete.isDisplayed());
	}

	@Then("the Delete confirmation window is opened")
	public void the_Delete_confirmation_window_is_opened() throws Exception {
		Assert.assertEquals("Delete Tour", adminToursDeleteModal.getElementText(adminToursDeleteModal.mod_Title));
	}

	@When("User closes the Delete Confirmation window")
	public void user_closes_the_Delete_Confirmation_window() throws Exception {
		adminToursDeleteModal.waitAndClickElement(adminToursDeleteModal.btn_Close);
	}

	@Then("User verifies that the tour is not deleted")
	public void user_verifies_that_the_tour_is_not_deleted() {
		
	}
}
