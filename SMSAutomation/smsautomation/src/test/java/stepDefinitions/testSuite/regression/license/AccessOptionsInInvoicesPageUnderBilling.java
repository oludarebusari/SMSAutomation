package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.EditBusinessPlanPage;
import pageObjects.thrive.InvoicesPage;
import pageObjects.thrive.Tab.BillingDDown;

public class AccessOptionsInInvoicesPageUnderBilling extends BasePage {

	public AccessOptionsInInvoicesPageUnderBilling() throws IOException {
		super();
	}

 	
	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditBusinessPlanPage editBusinessPlanPage = PageFactory.initElements(driver, EditBusinessPlanPage.class);
	public InvoicesPage invoicesPage = PageFactory.initElements(driver, InvoicesPage.class);
	
	
	final String businessName = "The Broad Street Giant Grinder";
	
	
//	@Verify-the-functionality-of-Edit-Recurring-Plan-for-selected-Businesses-invoice-from-Invoices-page
	@When("User clicks on the Invoices option from the Billing options")
	public void user_clicks_on_the_Invoices_option_from_the_Billing_options() throws Exception {
	  billingDDown.waitAndClickElement(billingDDown.opt_Invoices);
	}

	@Then("User is redirected to the Invoice page")
	public void user_is_redirected_to_the_Invoice_page() throws Exception {
	  Assert.assertEquals("Invoices", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks the drop down action button for an Invoice")
	public void user_clicks_the_drop_down_action_button_for_an_Invoice() throws Exception {
		invoicesPage.waitAndClickElement(invoicesPage.actionDDown(businessName));
	}

	@Then("the drop down action options are displayed")
	public void the_drop_down_action_options_are_displayed() {
	  Assert.assertTrue(invoicesPage.actionDDownOption(businessName, "Edit Recurring Plan").isDisplayed());
	  Assert.assertTrue(invoicesPage.actionDDownOption(businessName, "Restore this invoice").isDisplayed());
	  Assert.assertTrue(invoicesPage.actionDDownOption(businessName, "Merchant Info").isDisplayed());
	  Assert.assertTrue(invoicesPage.actionDDownOption(businessName, "All Merchant Invoices").isDisplayed());
	}

	@When("User clicks on Edit Recurring Plan")
	public void user_clicks_on_Edit_Recurring_Plan() throws Exception {
	   invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "Edit Recurring Plan"));
	}

	@Then("User is redirected to the Edit Business plan page")
	public void user_is_redirected_to_the_Edit_Business_plan_page() throws Exception {
	   Assert.assertEquals("Edit Business Plan", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User edits the required details and clicks Save Plan")
	public void user_edits_the_required_details_and_clicks_Save_Plan() throws Exception {
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_PlanName, "Web Essentials - Edited");
	}

	@Then("changes were updated and notication alert displayed.")
	public void changes_were_updated_and_notication_alert_displayed() {
	
	}
}
