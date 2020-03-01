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
	
	
//	@SMSM-135 @Print-the-Invoice
	@When("User clicks the Print Invoice")
	public void user_clicks_the_Print_Invoice() throws Exception {
	  viewInvoicePage.waitAndClickElement(viewInvoicePage.lnk_Print);
	}

	@Then("the windows print dialog is opened")
	public void the_windows_print_dialog_is_opened() throws Exception {
		String newWinHandle = "";
		for (String winHandle: driver.getWindowHandles()) {
			newWinHandle = winHandle;
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(driver.getWindowHandle().equals(newWinHandle));
	}

	
//	@SMSM-135 @Edit-Company-information-from-Invoice-page
	@Then("User validate the Company Information is present")
	public void user_validate_the_Company_Information_is_present() {
		Assert.assertTrue(viewInvoicePage.tile_CompanyInformation.isDisplayed());
	}

	@When("User clicks te Edit icon from Company Information pane")
	public void user_clicks_te_Edit_icon_from_Company_Information_pane() throws Exception {
	viewInvoicePage.waitAndClickElement(viewInvoicePage.btn_CompanyInformationEdit);
	}

	@Then("the Edit Company page is opened")
	public void the_Edit_Company_page_is_opened() {
	
	}

	@Then("User edits the Business name")
	public void user_edits_the_Business_name() {
	  
	}

	@Then("User edits the Support email")
	public void user_edits_the_Support_email() {

	}

	@Then("User edits the Business phone")
	public void user_edits_the_Business_phone() {
	
	}

	@When("User clicks the company logo choose button, selects a file and clicks open")
	public void user_clicks_the_company_logo_choose_button_selects_a_file_and_clicks_open() {
	  
	}

	@Then("the file is selected")
	public void the_file_is_selected() {
	  
	}

	@When("User clicks on Save button")
	public void user_clicks_on_Save_button() {
	   
	}

	@Then("a success message is displayed")
	public void a_success_message_is_displayed() {
	    
	}

}
