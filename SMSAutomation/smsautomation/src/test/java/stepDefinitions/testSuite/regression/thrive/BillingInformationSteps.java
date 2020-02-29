package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BillingPage;
import pageObjects.thrive.ViewInvoicePage;
import utils.DriverFactory;

public class BillingInformationSteps extends DriverFactory {

	public BillingPage billingPage = PageFactory.initElements(driver, BillingPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ViewInvoicePage viewInvoicePage = PageFactory.initElements(driver, ViewInvoicePage.class);
	

//	@SMSM-135 @Validate-the-options-in-Billing-page 
	@When("User clicks the Billing menu option")
	public void user_clicks_the_Billing_menu_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
	}

	@Then("User is redirected to Billing page")
	public void user_is_redirected_to_Billing_page() throws Exception {
		Assert.assertEquals("Billing", billingPage.getElementText(billingPage.pag_Title));
	}

	@Then("User verifies the Current Balance Tile")
	public void user_verifies_the_Current_Balance_Tile() {
		Assert.assertTrue(billingPage.tile_CurrentBalance.isDisplayed());
	}

	@Then("User verifies the Invoice Method Payment Tile")
	public void user_verifies_the_Invoice_Method_Payment_Tile() {
		Assert.assertTrue(billingPage.tile_InvoicePaymentMethod.isDisplayed());
	}

	@Then("User verifies the Billing information Tile")
	public void user_verifies_the_Billing_information_Tile() {
		Assert.assertTrue(billingPage.tile_BillingInformation.isDisplayed());
	}

	@Then("User verifies that Invoice History is present")
	public void user_verifies_that_Invoice_History_is_present() {
		Assert.assertTrue(billingPage.InvoiceHistory.isDisplayed());
	}

//	@SMSM-135 @View-the-Invoice-and-Current-Balance
	@Then("User verifies that the View Invoice link is present")
	public void user_verifies_that_the_View_Invoice_link_is_present() throws Exception {
		Thread.sleep(500);
		Assert.assertTrue(billingPage.lnk_ViewInvoice.isDisplayed());
	}

	@When("User clicks on View Invoice link")
	public void user_clicks_on_View_Invoice_link() throws Exception {
		billingPage.waitAndClickElement(billingPage.lnk_ViewInvoice);
	}

	@Then("the View Invoice page is opened")
	public void the_View_Invoice_page_is_opened() throws Exception {
		Assert.assertEquals("View Invoice", viewInvoicePage.getElementText(viewInvoicePage.pag_Title));
	}

	@Then("User verifies One TimePrice, Recurring price and Date is present on the page")
	public void user_verifies_One_TimePrice_Recurring_price_and_Date_is_present_on_the_page() {
		Assert.assertTrue(viewInvoicePage.col_OneTimePrice.isDisplayed());
		Assert.assertTrue(viewInvoicePage.col_RecurringPrice.isDisplayed());
		Assert.assertTrue(viewInvoicePage.col_Date.isDisplayed());
	}

	@Then("User verifies the Current Balance on the Invoice page")
	public void user_verifies_the_Current_Balance_on_the_Invoice_page() throws Exception {
		System.out.println(viewInvoicePage.getElementText(viewInvoicePage.InvoiceBalance).substring(7).replace(")", ""));
		Assert.assertEquals("495.00", viewInvoicePage.getElementText(viewInvoicePage.InvoiceBalance).substring(7).replace(")", ""));
	}

}
