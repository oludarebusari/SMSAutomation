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
import pageObjects.thrive.modal.AddToAllResellerModal;
import pageObjects.thrive.modal.DeletePlanModal;

public class AddAndManagePlansSteps extends BasePage {

	public AddAndManagePlansSteps() throws IOException {
		super();
	}

	public AddToAllResellerModal addToAllResellerModal = PageFactory.initElements(driver, AddToAllResellerModal.class);
	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreateEditPlanPage createEditPlanPage = PageFactory.initElements(driver, CreateEditPlanPage.class);
	public DeletePlanModal deletePlanModal = PageFactory.initElements(driver, DeletePlanModal.class);
	public ManagePlansPage managePlansPage = PageFactory.initElements(driver, ManagePlansPage.class);
	
	String planName = "Automation Plan";
	String planNameEdited = planName + " - Edited";
	
		
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

//	@Verify-the-creation-of-a-new-Plan-from-"Plan-Details"-page
	@When("User enters the details on a new plan and click the Save plan button")
	public void user_enters_the_details_on_a_new_plan_and_click_the_Save_plan_button() throws Exception {
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_PlanName, planName);
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtA_PlanDescription, "This plan is used for Automation");
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.btn_AddSubModuleFromHeadingPanel);
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.featureDDown);
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.featureOption("Social Essentials Setup"));
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_OneTimePrice, "5.00");
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_RecurringPrice, "10.00");
      createEditPlanPage.waitAndClickElement(createEditPlanPage.txtF_Date);
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.btn_Day);
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.btn_SavePlan);	  
	}

	@Then("a new plan with the entered details is created")
	public void a_new_plan_with_the_entered_details_is_created() {
	  Assert.assertTrue(managePlansPage.getCellValue(planName).isDisplayed());
	  Assert.assertTrue(managePlansPage.getCellValue("This plan is used for Automation").isDisplayed());
	  Assert.assertTrue(managePlansPage.getPriceByPlanName("Automation Plan", "5.00").isDisplayed());
	  Assert.assertTrue(managePlansPage.getPriceByPlanName("Automation Plan", "10.00").isDisplayed());
	}	
	
//	@Verify-Plan-can-be-edited-from-"Manage-Plans"-page-by-clicking-the-Edit-button-against-the-specified-Plan
	@Then("User verifies the Edit and dropdown button exist on a plan")
	public void user_verifies_the_Edit_and_dropdown_button_exist_on_a_plan() {
	 Assert.assertTrue(managePlansPage.editBtn(planName).isDisplayed());
	 Assert.assertTrue(managePlansPage.planActionDDown(planName).isDisplayed());
	}

	@When("User clicks the Edit button on a plan")
	public void user_clicks_the_Edit_button_on_a_plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.editBtn(planName));
	}

	@Then("the Edit Plan page is opened")
	public void the_Edit_Plan_page_is_opened() throws Exception {
		Assert.assertEquals("Edit Plan", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User moidifies few fields and clicks the Save Plan button")
	public void user_moidifies_few_fields_and_clicks_the_Save_Plan_button() throws Exception {
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_PlanName, "Automation Plan - Edited");
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtA_PlanDescription, "This plan is used for Automation - Edited");
	  createEditPlanPage.sendKeysToWebElement(createEditPlanPage.txtF_OneTimePrice, "8.00");
	  createEditPlanPage.waitAndClickElement(createEditPlanPage.btn_SavePlan);
	}

	@Then("an update alert notification is displayed")
	public void an_update_alert_notification_is_displayed() throws InterruptedException {
		Assert.assertEquals("Item has been successfully updated.", createEditPlanPage.getElementText(createEditPlanPage.NotificationAlert));
	}

	@Then("User confirms the modifications were saved correctly.")
	public void user_confirms_the_modifications_were_saved_correctly() {
	 Assert.assertTrue(managePlansPage.getCellValue("Automation Plan - Edited").isDisplayed());
	 Assert.assertTrue(managePlansPage.getCellValue("This plan is used for Automation - Edited").isDisplayed());
	 Assert.assertTrue(managePlansPage.getPriceByPlanName("Automation Plan - Edited", "8.00").isDisplayed());
	}

	
//	@Verify-Plan-can-be-edited-from-"Manage-Plans"-page-by-clicking-the-Edit-button-against-the-specified-Plan
	@When("User clicks the drop down action button for the plan")
	public void user_clicks_the_drop_down_action_button_for_the_plan() throws Exception {
	 managePlansPage.waitAndClickElement(managePlansPage.planActionDDown("Automation Plan - Edited"));
	}

	@Then("Deactivate and Delete action options for the plan are displayed")
	public void deactivate_and_Delete_action_options_for_the_plan_are_displayed() {
	  Assert.assertTrue(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Deactivate").isDisplayed());
	  Assert.assertTrue(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Delete").isDisplayed());
	}

	@When("User clicks the Deactivate option on the plan")
	public void user_clicks_the_Deactivate_option_on_the_plan() throws Exception {
	  managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Deactivate"));
	}

	@Then("the plan is deactivated and the Plan status has changed to {string}")
	public void the_plan_is_deactivated_and_the_Plan_status_has_changed_to(String string) {
	  Assert.assertTrue(managePlansPage.getCellValue("Inactive").isDisplayed());
	}

	@When("User clicks the drop down action button for the plan again")
	public void user_clicks_the_drop_down_action_button_for_the_plan_again() throws Exception {
		 managePlansPage.waitAndClickElement(managePlansPage.planActionDDown("Automation Plan - Edited"));
	}

	@Then("Activate and Delete action options for the plan are displayed")
	public void activate_and_Delete_action_options_for_the_plan_are_displayed() {
		Assert.assertTrue(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Activate").isDisplayed());
		Assert.assertTrue(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Delete").isDisplayed());
	}
	
//	@Verify-that-an-"Inactive"-plan-can-be-activated-by-clicking-on-Activate-in-the-Edit-drop-down
	@Then("User verifies the status of the created plan is Inactive")
	public void user_verifies_the_status_of_the_created_plan_is_Inactive() {
		 Assert.assertTrue(managePlansPage.getCellValue("Inactive").isDisplayed());
	}

	@When("User clicks the drop down button of the plan to activate")
	public void user_clicks_the_drop_down_button_of_the_plan_to_activate() throws Exception {
		 managePlansPage.waitAndClickElement(managePlansPage.planActionDDown("Automation Plan - Edited"));
	}

	@When("User clicks the Activate button for the plan")
	public void user_clicks_the_Activate_button_for_the_plan() throws Exception {
	   managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Activate"));
	}

	@Then("the plan is activated and the plan status has changed to Activate")
	public void the_plan_is_activated_and_the_plan_status_has_changed_to_Activate() {
		 Assert.assertTrue(managePlansPage.getCellValue("Active").isDisplayed());
	}
	
	
//	@Verify-clicking-'x'-icon-on-confirm-Delete-Plan-popup-closes-the-popup-and-does-not-delete-the-Plan
	@When("User clicks the Delete action option for the plan")
	public void user_clicks_the_Delete_action_option_for_the_plan() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.ActionDDownOption("Automation Plan - Edited", "Delete"));
	}

	@Then("the Delete Plan window is opened")
	public void the_Delete_Plan_window_is_opened() throws Exception {
		Assert.assertEquals("Delete Plan", deletePlanModal.getElementText(deletePlanModal.mod_Title));
	}
	
	@When("User clicks the Close button on the Delete Plan modal")
	public void user_clicks_the_Close_button_on_the_Delete_Plan_modal() throws InterruptedException {
		deletePlanModal.waitAndClickElement(deletePlanModal.btn_Close);
	}

	@Then("User verifies that the Plan is not delete")
	public void user_verifies_that_the_Plan_is_not_delete() {
	 Assert.assertTrue(managePlansPage.getCellValue("Automation Plan - Edited").isDisplayed());
	}

	
//	@Verify-Deletion-of-an-existing-Plan-on-"Manage-Plans"-dashboard
	@When("User clicks the Delete button on the Delete Plan modal")
	public void user_clicks_the_Delete_button_on_the_Delete_Plan_modal() throws Exception {
	  deletePlanModal.waitAndClickElement(deletePlanModal.btn_Delete);
	}
	
	@Then("user confirms that the plan is deleted successfully")
	public void user_confirms_that_the_plan_is_deleted_successfully() {
		Assert.assertFalse(managePlansPage.isElementVisible(managePlansPage.getPLANLOCATOR()));
	}
	
	
}
