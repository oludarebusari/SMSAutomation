package stepDefinitions.testSuite.regression.license;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.ManageBillingPage;
import pageObjects.thrive.Tab.BillingDDown;
import utils.DriverFactory;

public class ManageBillingUnderResellerPortal extends DriverFactory {

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
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
	 Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) > 0);
	}
	
//	@verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Late
	@When("User clicks the Late filter")
	public void user_clicks_the_Late_filter() throws Exception {
	  manageBillingPage.waitAndClickElement(manageBillingPage.filter_Late);
	}

	@Then("all the records with Late status are displayed")
	public void all_the_records_with_Late_status_are_displayed() throws NumberFormatException, InterruptedException {
	 Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) > 0);
	}
	
//	@verify-results-are-displayed-based-on-the-filter-selected-in-Manage-Billing-page-:-Pending
	@When("User clicks the Pending filter")
	public void user_clicks_the_Pending_filter() {

	}

	@Then("all the records with Pending status are displayed")
	public void all_the_records_with_Pending_status_are_displayed() {
	
	}
}
