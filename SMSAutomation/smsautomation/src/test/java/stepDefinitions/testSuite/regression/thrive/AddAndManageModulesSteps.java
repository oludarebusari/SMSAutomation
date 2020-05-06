package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreateEditModulePage;
import pageObjects.thrive.ModulesPage;
import pageObjects.thrive.Tab.BillingDDown;
import pageObjects.thrive.modal.DeleteModuleModal;
import utils.DriverFactory;

public class AddAndManageModulesSteps extends DriverFactory {

	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreateEditModulePage createEditModulePage = PageFactory.initElements(driver, CreateEditModulePage.class);
	public DeleteModuleModal deleteModuleModal = PageFactory.initElements(driver, DeleteModuleModal.class);

	public ModulesPage modulesPage = PageFactory.initElements(driver, ModulesPage.class);

	@When("User clicks on the Billing Menu option on the dashboard")
	public void user_clicks_on_the_Billing_Menu_option_on_the_dashboard() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
	}

	@Then("the Billing options are displayed")
	public void the_Billing_options_are_displayed() {
		Assert.assertTrue(billingDDown.opt_Add_Plan.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Add_Plan.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Modules.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Add_Module.isDisplayed());
	}

//	@Verify-the-navigation-to-Modules-page-under-Billing-menu
	@When("User clicks on the Modules option")
	public void user_clicks_on_the_Modules_option() throws Exception {
		billingDDown.waitAndClickElement(billingDDown.opt_Modules);
	}

	@Then("user is redirected to the Modules page")
	public void user_is_redirected_to_the_Modules_page() throws InterruptedException {
		Assert.assertEquals("Modules", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-the-navigation-to-"Module-Details"-page-by-clicking-New-button-on-Modules-page-or-clicking-Add-Modules-directly-from-Billing-menu
	@When("User clicks on the New button on the Modules page")
	public void user_clicks_on_the_New_button_on_the_Modules_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the Create Module page is displayed")
	public void the_Create_Module_page_is_displayed() throws Exception {
		Assert.assertEquals("Create Module", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User navigates back to the Dasboard page")
	public void user_navigates_back_to_the_Dasboard_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Dashboard);
	}

	@When("User clicks on the Billing Menu option on the dasboard")
	public void user_clicks_on_the_Billing_Menu_option_on_the_dasboard() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
	}

	@When("User clicks the Add Module option")
	public void user_clicks_the_Add_Module_option() throws Exception {
		billingDDown.waitAndClickElement(billingDDown.opt_Add_Module);
	}

//	@Verify-the-UI-and-fields-available-on-"Module-Details"-page @RegressionTest
	@Then("User verifies the fields present on the Create Modules page")
	public void user_verifies_the_fields_present_on_the_Create_Modules_page() {
		Assert.assertTrue(createEditModulePage.txtF_ModuleName.isDisplayed());
		Assert.assertTrue(createEditModulePage.txtA_ModuleDescription.isDisplayed());
		Assert.assertTrue(createEditModulePage.categoriesDDown.isDisplayed());
		Assert.assertTrue(createEditModulePage.iconDDown.isDisplayed());
	}

	@Then("User verifies the details in the Feature panel")
	public void user_verifies_the_details_in_the_Feature_panel() throws Exception {
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_AddSubModuleFromHeadingPanel);
		Assert.assertTrue(createEditModulePage.txtF_Feature.isDisplayed());
		Assert.assertTrue(createEditModulePage.txtF_Price.isDisplayed());
		Assert.assertTrue(createEditModulePage.intervalDDown.isDisplayed());
		Assert.assertTrue(createEditModulePage.btn_AddSubModuleFromHeadingPanel.isDisplayed());
		Assert.assertTrue(createEditModulePage.btn_AddSubModuleFromFooterPanel.isDisplayed());
	}

	@Then("User verifies that a Save Module button is present on the page")
	public void user_verifies_that_a_Save_Module_button_is_present_on_the_page() {
		Assert.assertTrue(createEditModulePage.btn_SaveModule.isDisplayed());
	}

//	@Verify-the-validation-messages-on-"Module-Details"-page-when-required-information-is-missing-or-invalid
	@When("User clicks on the Save Module button without entering any value")
	public void user_clicks_on_the_Save_Module_button_without_entering_any_value() throws Exception {
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_SaveModule);
	}

	@Then("validation error is displayed for Module name and description")
	public void validation_error_is_displayed_for_Module_name_and_description() throws Exception {
		Assert.assertEquals(createEditModulePage.getBLANKERRORMSG(),
				createEditModulePage.getElementText(createEditModulePage.lbl_ModuleNameErrorMsg));
		Assert.assertEquals(createEditModulePage.getBLANKERRORMSG(),
				createEditModulePage.getElementText(createEditModulePage.lbl_ModuleDescriptionErrorMsg));
	}

	@When("User enters a short value for Module Name and description and clicks Save Module button")
	public void user_enters_a_short_value_for_Module_Name_and_description_and_clicks_Save_Module_button()
			throws Exception {
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_ModuleName, "M1");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtA_ModuleDescription, "M1");
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_SaveModule);
	}

	@Then("verify that validation error is displayed for Module name field")
	public void verify_that_validation_error_is_displayed_for_Module_name_field() throws Exception {
		Assert.assertEquals(createEditModulePage.getSHORTVALERRORMSG(),
				createEditModulePage.getElementText(createEditModulePage.lbl_ModuleNameErrorMsg));
	}

	@When("User enters a valid value for Module name, description, clicks the add feature button and clicks save module")
	public void user_enters_a_valid_value_for_Module_name_description_clicks_the_add_feature_button_and_clicks_save_module()
			throws Exception {
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_ModuleName, "Auto Test");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtA_ModuleDescription, "Automation Testing");
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_AddSubModuleFromHeadingPanel);
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_SaveModule);
	}

	@Then("verify that validation error is displayed for the feature text field.")
	public void verify_that_validation_error_is_displayed_for_the_feature_text_field() throws Exception {
		Assert.assertEquals(createEditModulePage.getFEATUREBLANKERRORMSG(),
				createEditModulePage.getElementText(createEditModulePage.lbl_FeatureErrorMsg));
	}

//	@Verify-the-creation-of-a-new-Module-from-"Module-Details"-page
	@Then("user enter values for Module name, description, categories and icon")
	public void user_enter_values_for_Module_name_description_categories_and_icon() throws Exception {
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_ModuleName, "Automation Testing Module");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtA_ModuleDescription,
				"Module for QA Automation");
		createEditModulePage.waitAndClickElement(createEditModulePage.categoriesDDown);
		createEditModulePage.waitAndClickElement(createEditModulePage.categoriesOption("Marketing"));
		createEditModulePage.waitAndClickElement(createEditModulePage.txtA_ModuleDescription);
		createEditModulePage.waitAndClickElement(createEditModulePage.iconDDown);
		createEditModulePage.waitAndClickElement(createEditModulePage.iconOption("fa-ambulance"));
	}

	@When("user clicks the add sub module button under Feature")
	public void user_clicks_the_add_sub_module_button_under_Feature() throws Exception {
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_AddSubModuleFromHeadingPanel);
	}

	@Then("the Feature section is expanded")
	public void the_Feature_section_is_expanded() {
		Assert.assertTrue(createEditModulePage.txtF_Feature.isDisplayed());
	}

	@Then("User enters value for feature, price and Interval details")
	public void user_enters_value_for_feature_price_and_Interval_details() throws Exception {
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_Feature, "Feature for Automation");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_Price, "5.00");
		createEditModulePage.waitAndClickElement(createEditModulePage.intervalOption("Monthly"));
	}

	@When("User clicks the Save Module button")
	public void user_clicks_the_Save_Module_button() throws InterruptedException {
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_SaveModule);
	}

	@Then("a success notification is displayed on the module page")
	public void a_success_notification_is_displayed_on_the_module_page() throws Exception {
		Assert.assertEquals("Item has been successfully created.",
				modulesPage.getElementText(modulesPage.NotificationAlert));
	}

	@Then("user confirms that the module is created")
	public void user_confirms_that_the_module_is_created() {
		Assert.assertTrue(modulesPage.modulePanel("Automation Testing Module").isDisplayed());
	}

//	@Verify-the-"Module-Details"-added-on-Modules-page-once-a-Module-is-created
	@Then("User verifies that modules are displayed in individual tiles")
	public void user_verifies_that_modules_are_displayed_in_individual_tiles() {
		Assert.assertTrue(modulesPage.modulePanel("Automation Testing Module").isDisplayed());
	}

	@Then("User verifies the details on a Module tile")
	public void user_verifies_the_details_on_a_Module_tile() {
		Assert.assertTrue(modulesPage.tile_ModuleName("Automation Testing Module").isDisplayed());
		Assert.assertTrue(modulesPage.tile_ModuleDescription("Module for QA Automation").isDisplayed());
		Assert.assertTrue(modulesPage.tile_Price("5.00\"").isDisplayed());
	}

	@Then("User verifies the action available on a Module Tile")
	public void user_verifies_the_action_available_on_a_Module_Tile() throws InterruptedException {
		modulesPage.waitAndClickElement(modulesPage.moduleDDown("Automation Testing Module"));
		Assert.assertTrue(modulesPage.deleteModuleBtn("Automation Testing Module").isDisplayed());
	}

//	@Verify-Modules-can-be-edited-from-"Modules"-page-by-clicking-the-Edit-button-against-the-specified-Module-tile
	@When("User click the Edit  button on a Module tile")
	public void user_click_the_Edit_button_on_a_Module_tile() throws Exception {
		modulesPage.waitAndClickElement(modulesPage.editModuleBtn("Automation Testing Module"));
	}

	@Then("the Edit Module page is opened")
	public void the_Edit_Module_page_is_opened() throws InterruptedException {
		Assert.assertEquals("Edit Module", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User edits the Module Name, Description, categories, icon and Feature Details")
	public void user_edits_the_Module_Name_Description_categories_icon_and_Feature_Details() throws Exception {
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_ModuleName,
				"Automation Testing Module - Edited");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtA_ModuleDescription,
				"Module for QA Automation - Edited");
		createEditModulePage.waitAndClickElement(createEditModulePage.categoriesDDown);
		createEditModulePage.waitAndClickElement(createEditModulePage.categoriesOption("Hosting"));
		createEditModulePage.waitAndClickElement(createEditModulePage.txtA_ModuleDescription);
		createEditModulePage.waitAndClickElement(createEditModulePage.iconDDown);
		createEditModulePage.waitAndClickElement(createEditModulePage.iconOption("fa-adn"));
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_Feature, "Feature for Automation - Edited");
		createEditModulePage.sendKeysToWebElement(createEditModulePage.txtF_Price, "10.00");
	}

	@When("User clicks Save Module button")
	public void user_clicks_Save_Module_button() throws Exception {
		createEditModulePage.waitAndClickElement(createEditModulePage.btn_SaveModule);
	}

	@Then("an updated notification is displayed on the module page")
	public void an_updated_notification_is_displayed_on_the_module_page() throws Exception {
		Assert.assertEquals("Item has been successfully updated.",
				modulesPage.getElementText(modulesPage.NotificationAlert));
	}

	@Then("user confirms that the module is updated")
	public void user_confirms_that_the_module_is_updated() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_Modules);
		Assert.assertTrue(modulesPage.tile_ModuleName("Automation Testing Module - Edited").isDisplayed());
		Assert.assertTrue(modulesPage.tile_ModuleDescription("Module for QA Automation - Edited").isDisplayed());
		Assert.assertTrue(modulesPage.tile_Price("10.00\"").isDisplayed());
	}

//  @Verify-that-Module-cannot-be-deleted-if-"x"-is-clicked-on-"Delete-Module"-confirmation-popup-for-"Delete-Module"-action
	@When("User click the module action dropdown button on a Module tile")
	public void user_click_the_module_action_dropdown_button_on_a_Module_tile() throws Exception {
		modulesPage.waitAndClickElement(modulesPage.moduleDDown("Automation Testing Module - Edited"));
	}

	@Then("the module action option is displayed")
	public void the_module_action_option_is_displayed() {
		Assert.assertTrue(modulesPage.deleteModuleBtn("Automation Testing Module - Edited").isDisplayed());
	}

	@When("User clicks on the Delete Module option")
	public void user_clicks_on_the_Delete_Module_option() throws Exception {
		modulesPage.waitAndClickElement(modulesPage.deleteModuleBtn("Automation Testing Module - Edited"));
	}

	@Then("a Delete Module confirmation window is opened")
	public void a_Delete_Module_confirmation_window_is_opened() throws Exception {
		Assert.assertEquals("×\nClose\nDelete Module", deleteModuleModal.getElementText(deleteModuleModal.mod_Title));
	}

	@When("User clicks on the X button on the Delete Module window pop up")
	public void user_clicks_on_the_X_button_on_the_Delete_Module_window_pop_up() throws Exception {
		deleteModuleModal.waitAndClickElement(deleteModuleModal.btn_Close);
	}

	@Then("User verifies that the module is not deleted")
	public void user_verifies_that_the_module_is_not_deleted() {
		Assert.assertTrue(modulesPage.tile_ModuleName("Automation Testing Module - Edited").isDisplayed());
	}

//	@Verify-that-Module-is-deleted-if-"Delete"-is-clicked-on-"Delete-Module"-confirmation-popup-for-"Delete-Module"-action
	@When("User clicks on the Delete button on the Delete Module window pop up")
	public void user_clicks_on_the_Delete_button_on_the_Delete_Module_window_pop_up() throws Exception {
		deleteModuleModal.waitAndClickElement(deleteModuleModal.btn_Delete);
	}

	@Then("User verifies that the module is deleted")
	public void user_verifies_that_the_module_is_deleted() {
		Assert.assertFalse(modulesPage.isElementVisible(modulesPage.getMODULELOCATOR()));
	}

//	@Verify-the-"Help"-on-Modules-page-by-clicking-the-Help-button
	@When("User clicks the Help button on the Modules page")
	public void user_clicks_the_Help_button_on_the_Modules_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the tour guide for the modules page is opened")
	public void the_tour_guide_for_the_modules_page_is_opened() throws Exception {
		Assert.assertEquals("Modules", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Modules window pop")
	public void user_clicks_the_Next_button_on_the_Modules_window_pop() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Add A Module help window is opened")
	public void the_Add_A_Module_help_window_is_opened() throws Exception {
		Assert.assertEquals("Add A Module", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on Add A Module window")
	public void user_clicks_the_previous_button_on_Add_A_Module_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the help guide navigates back to Modules help window")
	public void the_help_guide_navigates_back_to_Modules_help_window() throws Exception {
		Assert.assertEquals("Modules", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	@Verify-the-"Help"-on-"Module-Details"-page-by-clicking-the-Help-button
	@When("User clicks the Help button on the Create Modules page")
	public void user_clicks_the_Help_button_on_the_Create_Modules_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the tour guide for the Create Modules page is opened")
	public void the_tour_guide_for_the_Create_Modules_page_is_opened() throws Exception {
		Assert.assertEquals("Name", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Name window pop")
	public void user_clicks_the_Next_button_on_the_Name_window_pop() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Description help window is opened")
	public void the_Description_help_window_is_opened() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Description", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on Description window")
	public void user_clicks_the_previous_button_on_Description_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the help guide navigates back to Name help window")
	public void the_help_guide_navigates_back_to_Name_help_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Name", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
}
