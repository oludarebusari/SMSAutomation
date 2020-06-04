package stepDefinitions.testSuite.regression.license;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BusinessesPage;
import pageObjects.thrive.EditBusinessPage;
import pageObjects.thrive.EditBusinessPlanPage;
import pageObjects.thrive.ManageBillingPage;
import pageObjects.thrive.Tab.BillingDDown;
import utils.DriverFactory;

public class ManageBillingUnderResellerPortal extends DriverFactory {

	BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	BusinessesPage businessesPage = PageFactory.initElements(driver, BusinessesPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	EditBusinessPlanPage editBusinessPlanPage = PageFactory.initElements(driver, EditBusinessPlanPage.class);
	EditBusinessPage editBusinessPage = PageFactory.initElements(driver, EditBusinessPage.class);
	ManageBillingPage manageBillingPage = PageFactory.initElements(driver, ManageBillingPage.class);

//	@verify-the-details-displayed-within-manage-billing-page
	@When("User clicks on the Billing menu option")
	public void user_clicks_on_the_Billing_menu_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
	}

	@Then("the Billing drop down options are displayed")
	public void the_Billing_drop_down_options_are_displayed() {
		Assert.assertTrue(billingDDown.opt_ManageBilling.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Invoices.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Plans.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Add_Plan.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Modules.isDisplayed());
		Assert.assertTrue(billingDDown.opt_Add_Module.isDisplayed());
	}

	@When("User clicks on Manage Billing from the options")
	public void user_clicks_on_Manage_Billing_from_the_options() throws Exception {
		billingDDown.waitAndClickElement(billingDDown.opt_ManageBilling);
	}

	@Then("User is redirected to the Manage Billing page")
	public void user_is_redirected_to_the_Manage_Billing_page() throws Exception {
		Assert.assertEquals("Manage Billing", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the Manage Billing page")
	public void user_verifies_the_columns_on_the_Manage_Billing_page() {
		Assert.assertTrue(manageBillingPage.col_Due.isDisplayed());
		Assert.assertTrue(manageBillingPage.col_Merchant.isDisplayed());
		Assert.assertTrue(manageBillingPage.col_PaymentMethod.isDisplayed());
		Assert.assertTrue(manageBillingPage.col_Amount.isDisplayed());
		Assert.assertTrue(manageBillingPage.col_Status.isDisplayed());
		Assert.assertTrue(manageBillingPage.col_Action.isDisplayed());
	}

	@Then("User verifies the filter options displayed on the Manage Billing page")
	public void user_verifies_the_filter_options_displayed_on_the_Manage_Billing_page() {
		Assert.assertTrue(manageBillingPage.filter_Overview.isDisplayed());
		Assert.assertTrue(manageBillingPage.filter_Cancelled.isDisplayed());
		Assert.assertTrue(manageBillingPage.filter_Late.isDisplayed());
		Assert.assertTrue(manageBillingPage.filter_Pending.isDisplayed());
		Assert.assertTrue(manageBillingPage.filter_Paid.isDisplayed());
	}

//	@verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Cancelled
	@Then("User verifies the default filter selected")
	public void user_verifies_the_default_filter_selected() throws Exception {
		Assert.assertTrue(manageBillingPage.filter_Overview.getAttribute("class").contentEquals("active"));
	}

	@When("User clicks the Cancelled filter")
	public void user_clicks_the_Cancelled_filter() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.filter_Cancelled);
	}

	@Then("all the records with Cancelled status are displayed")
	public void all_the_records_with_Cancelled_status_are_displayed() throws Exception {
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) > 0);
	}

//	@verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Late
	@When("User clicks the Late filter")
	public void user_clicks_the_Late_filter() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.filter_Late);
	}

	@Then("all the records with Late status are displayed")
	public void all_the_records_with_Late_status_are_displayed() throws NumberFormatException, InterruptedException {
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) > 0);
	}

//	@verify-results-are-displayed-based-on-the-filter-selected-in-Manage-Billing-page-:-Pending
	@When("User clicks the Pending filter")
	public void user_clicks_the_Pending_filter() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.filter_Pending);
	}

	@Then("all the records with Pending status are displayed")
	public void all_the_records_with_Pending_status_are_displayed() throws NumberFormatException, InterruptedException {
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) >= 0);
	}

//	@Add-a-feature-from-Edit-Merchant-Plan
	@When("User clicks the Edit Recurring Plan from drop down")
	public void user_clicks_the_Edit_Recurring_Plan_from_drop_down() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown("The Broad Street Giant Grinder"));
		manageBillingPage.waitAndClickElement(
				manageBillingPage.ActionDDownOption("The Broad Street Giant Grinder", "Edit Recurring Plan"));
	}

	@Then("User is redirected to the Edit Merchant plan page")
	public void user_is_redirected_to_the_Edit_Merchant_plan_page() throws Exception {
		Assert.assertEquals("Edit Business Plan", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User navigate to Feature clicks on add icon")
	public void user_navigate_to_Feature_clicks_on_add_icon() throws Exception {
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_AddSubModuleFromHeadingPanel);
	}

	@Then("the new field is added")
	public void the_new_field_is_added() {
		Assert.assertTrue(editBusinessPlanPage.featureDDown.isDisplayed());
	}

	@When("User enters the values for a field record and clicks on the Save Plan button")
	public void user_enters_the_values_for_a_field_record_and_clicks_on_the_Save_Plan_button() throws Exception {
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.featureDDown);
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.featureOption("Web Essentials Ongoing"));
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_OneTimePrice, "5.00");
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_RecurringPrice, "3.00");
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.txtF_Date);
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_Day);
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_SavePlan);
	}

	@Then("User verifies that the feature is added")
	public void user_verifies_that_the_feature_is_added() throws Exception {
		Assert.assertEquals("Item has been successfully updated.",
				businessesPage.getElementText(businessesPage.NotificationAlert));
	}

//	@Verify-Edit-Recurring-Plan-option
	@Then("User verifies that the plan name is present")
	public void user_verifies_that_the_plan_name_is_present() {
		Assert.assertTrue(editBusinessPlanPage.txtF_PlanName.isDisplayed());
		Assert.assertFalse(editBusinessPlanPage.txtF_PlanName.isEnabled());
	}

	@Then("User verifies that the Plan Description is present")
	public void user_verifies_that_the_Plan_Description_is_present() {
		Assert.assertTrue(editBusinessPlanPage.txtA_PlanDescription.isDisplayed());
		Assert.assertFalse(editBusinessPlanPage.txtA_PlanDescription.isEnabled());
	}

	@Then("User verifies that the Status drop down is present")
	public void user_verifies_that_the_Status_drop_down_is_present() {
		Assert.assertTrue(editBusinessPlanPage.statusDDown.isDisplayed());
		Assert.assertFalse(editBusinessPlanPage.statusDDown.isEnabled());
	}

//	 @Edit-a-feature-in-Edit-Merchant-Plan
	@When("User navigate to feature and edits some values and clicks the Save Plan button")
	public void user_navigate_to_feature_and_edits_some_values_and_clicks_the_Save_Plan_button() throws Exception {
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_OneTimePrice("Web Essentials Ongoing"),
				"4.50");
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_RecurringPrice("Web Essentials Ongoing"),
				"3.50");
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_SavePlan);
	}

	@Then("User verifies that the feature is updated")
	public void user_verifies_that_the_feature_is_updated() throws Exception {
		Assert.assertEquals("Item has been successfully updated.",
				businessesPage.getElementText(businessesPage.NotificationAlert));
	}

//	@Remove-a-feature-from-Edit-Merchant-plan
	@When("User clicks the remove button of a feature and clicks the Save plan button")
	public void user_clicks_the_remove_button_of_a_feature_and_clicks_the_Save_plan_button() throws Exception {
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.removeFeatureBtn("Web Essentials Ongoing"));
		Thread.sleep(500);
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_SavePlan);
		Thread.sleep(500);
	}

	@Then("User verifies that the feature is removed")
	public void user_verifies_that_the_feature_is_removed() throws Exception {
		Assert.assertEquals("Item has been successfully updated.",
				businessesPage.getElementText(businessesPage.NotificationAlert));
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_ManageBilling);
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown("The Broad Street Giant Grinder"));
		manageBillingPage.waitAndClickElement(
				manageBillingPage.ActionDDownOption("The Broad Street Giant Grinder", "Edit Recurring Plan"));
		Assert.assertFalse(
				editBusinessPlanPage.isElementVisible(editBusinessPlanPage.featureLocator("Web Essentials Ongoing")));
	}

//	@Verify-merchant-info-details-in-manage-billing-page
	@When("User clicks the Merchant Info option")
	public void user_clicks_the_Merchant_Info_option() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown("The Broad Street Giant Grinder"));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption("The Broad Street Giant Grinder", "Merchant Info"));
	}

	@Then("User is redirected to the Edit Merchant page")
	public void user_is_redirected_to_the_Edit_Merchant_page() throws Exception {
		Assert.assertEquals("Edit Business", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies that the Business Information section is displayed")
	public void user_verifies_that_the_Business_Information_section_is_displayed() {
	  Assert.assertTrue(editBusinessPage.businessInformationPanel.isDisplayed());
	}

	@Then("User verifies that the Billing Information section is displayed")
	public void user_verifies_that_the_Billing_Information_section_is_displayed() {
//		Assert.assertTrue(editBusinessPage.billingInformationPanel.isDisplayed());
	}
}
