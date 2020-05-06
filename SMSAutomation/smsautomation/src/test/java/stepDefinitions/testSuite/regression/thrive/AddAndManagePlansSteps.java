package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.CreateEditPlanPage;
import pageObjects.thrive.ManagePlansPage;
import pageObjects.thrive.Tab.BillingDDown;

public class AddAndManagePlansSteps extends BasePage {

	public AddAndManagePlansSteps() throws IOException {
		super();
	}

	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreateEditPlanPage createEditPlanPage = PageFactory.initElements(driver, CreateEditPlanPage.class);
	public ManagePlansPage managePlansPage = PageFactory.initElements(driver, ManagePlansPage.class);
	
		
//	@Verify-the-navigation-to-"Manage-Plans"-page-under-Billing-menu
	@When("User clicks on Plan option")
	public void user_clicks_on_Plan_option() throws Exception {
	  billingDDown.waitAndClickElement(billingDDown.opt_Plans);
	}

	@Then("user is redirected to the Manage Plans page")
	public void user_is_redirected_to_the_Manage_Plans_page() throws Exception {
		Assert.assertEquals("Manage Plans", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the Manage Plans page")
	public void user_verifies_the_columns_on_the_Manage_Plans_page() {
		Assert.assertTrue(managePlansPage.col_Plan.isDisplayed());
		Assert.assertTrue(managePlansPage.col_Description.isDisplayed());
		Assert.assertTrue(managePlansPage.col_Fees.isDisplayed());
		Assert.assertTrue(managePlansPage.col_Status.isDisplayed());
		Assert.assertTrue(managePlansPage.col_Action.isDisplayed());
	}

//	@Verify-the-navigation-to-Plan-Details"-page-by-clicking-New-button-on-"Manage-Plans"-page-or-clicking-Add-Plan-directly-from-Billing-menu
	@When("User clicks the New button on the Manage Plans page")
	public void user_clicks_the_New_button_on_the_Manage_Plans_page() throws Exception {
	   commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the Create Plan page is opened")
	public void the_Create_Plan_page_is_opened() throws Exception {
	  Assert.assertEquals("Create Plan", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks Billing menu and clicks Plan")
	public void user_clicks_Billing_menu_and_clicks_Plan() throws Exception {
	 commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
	 billingDDown.WaitUntilWebElementIsVisible(billingDDown.opt_Plans);
	 billingDDown.waitAndClickElement(billingDDown.opt_Plans);
	}

	@When("User clicks Billing menu and click Add Plan option")
	public void user_clicks_Billing_menu_and_click_Add_Plan_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		 billingDDown.WaitUntilWebElementIsVisible(billingDDown.opt_Plans);
		 billingDDown.waitAndClickElement(billingDDown.opt_Add_Plan);
	}
	
//	@Verify-the-UI-and-fields-available-on-"Plan-Details"-page
	@Then("User verifies the fields available on the Create Plan page")
	public void user_verifies_the_fields_available_on_the_Create_Plan_page() {
	 Assert.assertTrue(createEditPlanPage.txtF_PlanName.isDisplayed());
	 Assert.assertTrue(createEditPlanPage.txtA_PlanDescription.isDisplayed());
	 Assert.assertTrue(createEditPlanPage.statusDDown.isDisplayed());
	 Assert.assertTrue(createEditPlanPage.panel_Feature.isDisplayed());
	 Assert.assertTrue(createEditPlanPage.btn_AddSubModuleFromHeadingPanel.isDisplayed());
	 Assert.assertTrue(createEditPlanPage.btn_AddSubModuleFromFooterPanel.isDisplayed());
	}

//
	@When("User enters the details on a new plan and click the Save plan button")
	public void user_enters_the_details_on_a_new_plan_and_click_the_Save_plan_button() throws Exception {
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_PlanName, "Automation Plan");
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtA_PlanDescription, "This plan is used for Automation");
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.btn_AddSubModuleFromHeadingPanel);
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.featureDDown);
	}

	@Then("a new plan with the entered details is created")
	public void a_new_plan_with_the_entered_details_is_created() {
	  
	}	
	
}
