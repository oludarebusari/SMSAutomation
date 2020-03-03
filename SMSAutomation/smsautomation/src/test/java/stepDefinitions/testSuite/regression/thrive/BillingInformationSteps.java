package stepDefinitions.testSuite.regression.thrive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BillingPage;
import pageObjects.thrive.EditCompanyPage;
import pageObjects.thrive.ViewInvoicePage;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class BillingInformationSteps extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();

	public BillingPage billingPage = PageFactory.initElements(driver, BillingPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditCompanyPage editCompanyPage = PageFactory.initElements(driver, EditCompanyPage.class);
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
		System.out
				.println(viewInvoicePage.getElementText(viewInvoicePage.InvoiceBalance).substring(7).replace(")", ""));
		Assert.assertEquals("495.00",
				viewInvoicePage.getElementText(viewInvoicePage.InvoiceBalance).substring(7).replace(")", ""));
	}

//	@SMSM-135 @Print-the-Invoice
	@When("User clicks the Print Invoice")
	public void user_clicks_the_Print_Invoice() throws Exception {
		viewInvoicePage.waitAndClickElement(viewInvoicePage.lnk_Print);
	}

	@Then("the windows print dialog is opened")
	public void the_windows_print_dialog_is_opened() throws Exception {
		String newWinHandle = "";
		for (String winHandle : driver.getWindowHandles()) {
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

	@When("User clicks te Edit icon from Company Information panel")
	public void user_clicks_te_Edit_icon_from_Company_Information_panel() throws Exception {
		viewInvoicePage.waitAndClickElement(viewInvoicePage.btn_CompanyInformationEdit);

	}

	@Then("the Edit Company page is opened")
	public void the_Edit_Company_page_is_opened() throws Exception {
		Assert.assertEquals("Edit Company", editCompanyPage.getElementText(editCompanyPage.pag_Title));
	}

	@Then("User edits the Business name")
	public void user_edits_the_Business_name() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessName, "AclateEdit");
	}

	@Then("User edits the Support email")
	public void user_edits_the_Support_email() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_SupportEmail, "test@aclate.com");
	}

	@Then("User edits the Business phone")
	public void user_edits_the_Business_phone() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessPhone, "555-434-0123");
	}

	@When("User clicks the company logo choose button, selects a file and clicks open")
	public void user_clicks_the_company_logo_choose_button_selects_a_file_and_clicks_open() throws Exception {
		if (reader.getConfigValue("DriverConfig", "environment").equals("remoteHub")) {
			editCompanyPage.sendKeysToWebElement(editCompanyPage.btn_ChooseFile,
					"//Development//SMSAutomation//smsautomation//src//main//resources//testData//AutoFile.png");
		} else {
			File file = new File("src/main//resources//testData//AutoFile.png");
			editCompanyPage.sendKeysToWebElement(editCompanyPage.btn_ChooseFile, file.getAbsolutePath());
		}
	}

	@When("User clicks on Save button")
	public void user_clicks_on_Save_button() throws Exception {
		editCompanyPage.waitAndClickElement(editCompanyPage.btn_Save);
	}

	@Then("a success message is displayed")
	public void a_success_message_is_displayed() throws Exception {
		Assert.assertTrue(editCompanyPage.getElementText(editCompanyPage.txt_Action_Notification)
				.contentEquals("This company has been successfully updated."));
		Assert.assertTrue(editCompanyPage.logo_Company.getAttribute("title").contentEquals("AutoFile.png"));
	}

//	Revert-changes-to-Company 
	@When("User changes Business name, support email and business phone to their original value")
	public void user_changes_Business_name_support_email_and_business_phone_to_their_original_value() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessName, "AclateQA");
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_SupportEmail, "testAclate@test.com");
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessPhone, "555-223-1718");
	}

//	@SMSM-135 @Edit-Billing-information-from-Invoice-page @RegressionTest 
	@When("User clicks Edit Billing Information link")
	public void user_clicks_Edit_Billing_Information_link() throws Exception {
		viewInvoicePage.waitAndClickElement(viewInvoicePage.lnk_EditBillingInformation);
	}

	@Then("User verifies that Business Information section exists")
	public void user_verifies_that_Business_Information_section_exists() {
		Assert.assertTrue(editCompanyPage.panel_BusinessInformation.isDisplayed());
	}

	@Then("User edits the Business Information pnhone number")
	public void user_edits_the_Business_Information_pnhone_number() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessPhone, "555-223-1785");
	}

	@Then("User verifies that Billing Information section exists")
	public void user_verifies_that_Billing_Information_section_exists() {
		Assert.assertTrue(editCompanyPage.panel_BillingInformation.isDisplayed());
	}

	@Then("User edits the State and Country from billing Info Section")
	public void user_edits_the_State_and_Country_from_billing_Info_Section() throws Exception {
		editCompanyPage.waitAndClickElement(editCompanyPage.lov_Country);
		editCompanyPage.waitAndClickElement(editCompanyPage.opt_Country("Canada"));
		editCompanyPage.waitAndClickElement(editCompanyPage.lov_State);
		editCompanyPage.waitAndClickElement(editCompanyPage.opt_State("Quebec"));
	}

//	 #Revert-changes-to-Billing Information 
	@When("User changes Business phone, State and country to thier original value")
	public void user_changes_Business_phone_State_and_country_to_thier_original_value() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_BusinessPhone, "555-223-1718");
		editCompanyPage.waitAndClickElement(editCompanyPage.lov_Country);
		editCompanyPage.waitAndClickElement(editCompanyPage.opt_Country("USA"));
		editCompanyPage.waitAndClickElement(editCompanyPage.lov_State);
		editCompanyPage.waitAndClickElement(editCompanyPage.opt_State("Alabama"));
	}

//	 @SMSM-135 @Check-for-transaction-history-from-Invoice-page
	@Then("User verifies that the Transaction History panel is present on the View Invoice page")
	public void user_verifies_that_the_Transaction_History_panel_is_present_on_the_View_Invoice_page() {

	}

	@Then("User verifies that Date column is present under Transaction history")
	public void user_verifies_that_Date_column_is_present_under_Transaction_history() {

	}

	@Then("USer verifies that Status columnr is present under Transaction history")
	public void user_verifies_that_Status_columnr_is_present_under_Transaction_history() {

	}

	@Then("User verifies that Amount Due column is present under Transaction history")
	public void user_verifies_that_Amount_Due_column_is_present_under_Transaction_history() {

	}

}
