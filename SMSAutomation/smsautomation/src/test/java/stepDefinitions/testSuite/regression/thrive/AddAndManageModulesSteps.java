package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreateModulePage;
import pageObjects.thrive.Tab.BillingDDown;
import utils.DriverFactory;

public class AddAndManageModulesSteps extends DriverFactory {
	
	
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreateModulePage createModulePage = PageFactory.initElements(driver, CreateModulePage.class);
	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);

	
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
		Assert.assertTrue(createModulePage.txtF_ModuleName.isDisplayed());
		Assert.assertTrue(createModulePage.txtA_ModuleDescription.isDisplayed());
		Assert.assertTrue(createModulePage.categoriesDDown.isDisplayed());
		Assert.assertTrue(createModulePage.iconDDown.isDisplayed());
	}

	@Then("User verifies the details in the Feature panel")
	public void user_verifies_the_details_in_the_Feature_panel() throws Exception {
		createModulePage.waitAndClickElement(createModulePage.btn_AddSubModuleFromHeadingPanel);
		Assert.assertTrue(createModulePage.txtF_Feature.isDisplayed());
		Assert.assertTrue(createModulePage.txtF_Price.isDisplayed());
		Assert.assertTrue(createModulePage.intervalDDown.isDisplayed());
		Assert.assertTrue(createModulePage.btn_AddSubModuleFromHeadingPanel.isDisplayed());
		Assert.assertTrue(createModulePage.btn_AddSubModuleFromFooterPanel.isDisplayed());
	}

	@Then("User verifies that a Save Module button is present on the page")
	public void user_verifies_that_a_Save_Module_button_is_present_on_the_page() {
		Assert.assertTrue(createModulePage.btn_SaveModule.isDisplayed());
	}

//	@Verify-the-validation-messages-on-"Module-Details"-page-when-required-information-is-missing-or-invalid
	@When("User clicks on the Save Module button without entering any value")
	public void user_clicks_on_the_Save_Module_button_without_entering_any_value() throws Exception {
	createModulePage.waitAndClickElement(createModulePage.btn_SaveModule);
	}

	@Then("validation error is displayed for Module name and description")
	public void validation_error_is_displayed_for_Module_name_and_description() throws Exception {
		Assert.assertEquals(createModulePage.getBLANKERRORMSG(), createModulePage.getElementText(createModulePage.lbl_ModuleNameErrorMsg));
		Assert.assertEquals(createModulePage.getBLANKERRORMSG(), createModulePage.getElementText(createModulePage.lbl_ModuleDescriptionErrorMsg));
	}

	@When("User enters a short value for Module Name and description and clicks Save Module button")
	public void user_enters_a_short_value_for_Module_Name_and_description_and_clicks_Save_Module_button() throws Exception {
		createModulePage.sendKeysToWebElement(createModulePage.txtF_ModuleName, "M1");
		createModulePage.sendKeysToWebElement(createModulePage.txtA_ModuleDescription, "M1");
		createModulePage.waitAndClickElement(createModulePage.btn_SaveModule);
	}

	@Then("verify that validation error is displayed for Module name field")
	public void verify_that_validation_error_is_displayed_for_Module_name_field() throws Exception {
		Assert.assertEquals(createModulePage.getSHORTVALERRORMSG(), createModulePage.getElementText(createModulePage.lbl_ModuleNameErrorMsg));
	}

	@When("User enters a valid value for Module name, description, clicks the add feature button and clicks save module")
	public void user_enters_a_valid_value_for_Module_name_description_clicks_the_add_feature_button_and_clicks_save_module() throws Exception {
		createModulePage.sendKeysToWebElement(createModulePage.txtF_ModuleName, "Auto Test");
		createModulePage.sendKeysToWebElement(createModulePage.txtA_ModuleDescription, "Automation Testing");
		createModulePage.waitAndClickElement(createModulePage.btn_AddSubModuleFromHeadingPanel);
		createModulePage.waitAndClickElement(createModulePage.btn_SaveModule);
	}

	@Then("verify that validation error is displayed for the feature text field.")
	public void verify_that_validation_error_is_displayed_for_the_feature_text_field() throws Exception {
		Assert.assertEquals(createModulePage.getFEATUREBLANKERRORMSG(), createModulePage.getElementText(createModulePage.lbl_FeatureErrorMsg));
	}
	
}
