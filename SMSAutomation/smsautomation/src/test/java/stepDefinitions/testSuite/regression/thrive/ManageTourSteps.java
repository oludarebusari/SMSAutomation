package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminDashboardPage;
import pageObjects.thrive.AdminToursEditPage;
import pageObjects.thrive.AdminToursPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.AdminToursActivateModal;
import pageObjects.thrive.modal.AdminToursDeactivateModal;
import utils.DriverFactory;

public class ManageTourSteps extends DriverFactory {

	
	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public AdminToursPage adminToursPage = PageFactory.initElements(driver, AdminToursPage.class);
	public AdminToursEditPage adminToursEditPage = PageFactory.initElements(driver, AdminToursEditPage.class);
	public AdminToursDeactivateModal adminToursDeactivateModal = PageFactory.initElements(driver, AdminToursDeactivateModal.class);
	public AdminToursActivateModal adminToursActivateModal = PageFactory.initElements(driver, AdminToursActivateModal.class);
	
	@Given("User clicks on settings on top menu bar")
	public void user_clicks_on_settings_on_top_menu_bar() throws Exception {
		thrDashboardPage.clickSettingsTab();
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
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("Aclate QA")));
	}

	@When("User clicks the Edit button on the Tour")
	public void user_clicks_the_Edit_button_on_the_Tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditByTourName("Aclate QA"));
	}

	@Then("the Edit Tour Page is opened")
	public void the_Edit_Tour_Page_is_opened() throws InterruptedException {
	  Assert.assertTrue(adminToursEditPage.getElementText(adminToursEditPage.pag_Title).contentEquals("Edit Tour"));
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
		adminToursEditPage.sendKeysToWebElement(adminToursEditPage.txtF_Message, "This is QA Automation Testing");
	}

	@Then("User clicks the Save Tour button")
	public void user_clicks_the_Save_Tour_button() throws Exception {
		adminToursEditPage.waitAndClickElement(adminToursEditPage.btn_SaveTour);
	}

	@Then("the tour is saved successfuland user confirmed the changes")
	public void the_tour_is_saved_successfuland_user_confirmed_the_changes() throws Exception {
		 adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "Aclate");
		 adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		 adminToursPage.getElementText(adminToursPage.txt_Role);
	}
	
	@When("User clicks the dropdown button near edit")
	public void user_clicks_the_dropdown_button_near_edit() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditDropdownByTourName("Aclate QA"));
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
		Assert.assertTrue(adminToursDeactivateModal.getElementText(adminToursDeactivateModal.mod_Title).contentEquals("Deactivate Tour"));
	}

	@When("User clicks the Deactivate button on the Deactivate Tour popo up")
	public void user_clicks_the_Deactivate_button_on_the_Deactivate_Tour_popo_up() throws Exception {
		adminToursDeactivateModal.waitAndClickElement(adminToursDeactivateModal.btn_Deactivate);
	}

	@When("User searches for the deactivated Tour")
	public void user_searches_for_the_deactivated_Tour() throws Exception {
		 adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "Aclate");
		 adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}
	
	@Then("the status of the Tour changes to Inactive")
	public void the_status_of_the_Tour_changes_to_Inactive() throws Exception {
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.txt_Status).contains("inactive"));
	}

	@Given("User types in a Tour name on the search textfield to open the deactivated tour")
	public void user_types_in_a_Tour_name_on_the_search_textfield_to_open_the_deactivated_tour() throws Exception {
		 adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "Aclate");
	}

	@Given("User clicks the Search button to bring up the deactivated tour")
	public void user_clicks_the_Search_button_to_bring_up_the_deactivated_tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
	}
	
	@Then("the deactivated Tour is displayed on the page")
	public void the_deactivated_Tour_is_displayed_on_the_page() {
		Assert.assertTrue(adminToursPage.WaitUntilWebElementIsVisible(adminToursPage.btn_EditByTourName("Aclate QA")));
	}
	
	@When("User clicks the dropdown button near edit button for the deactivated tour")
	public void user_clicks_the_dropdown_button_near_edit_button_for_the_deactivated_tour() throws Exception {
		adminToursPage.waitAndClickElement(adminToursPage.btn_EditDropdownByTourName("Aclate QA"));
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
		Assert.assertTrue(adminToursActivateModal.getElementText(adminToursActivateModal.mod_Title).contentEquals("Activate Tour"));
	}

	@When("User clicks the Activate button on the Activate Tour popo up")
	public void user_clicks_the_Activate_button_on_the_Activate_Tour_popo_up() throws Exception {
		adminToursActivateModal.waitAndClickElement(adminToursActivateModal.btn_Activate);
	}

	@Then("the status of the Tour changes to Active")
	public void the_status_of_the_Tour_changes_to_Active() throws Exception {
		 adminToursPage.sendKeysToWebElement(adminToursPage.txtF_Search, "Aclate");
		 adminToursPage.waitAndClickElement(adminToursPage.btn_Search);
		Assert.assertTrue(adminToursPage.getElementText(adminToursPage.txt_Status).contentEquals("Active"));
	}

}
