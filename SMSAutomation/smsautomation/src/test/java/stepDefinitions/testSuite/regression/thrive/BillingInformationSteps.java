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

	@Then("User verifies that the Invoice History section is present")
	public void user_verifies_that_the_Invoice_History_section_is_present() {
		Assert.assertTrue(billingPage.tile_InvoiceHistory.isDisplayed());
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

	@When("User clicks the Edit icon from Company Information panel")
	public void user_clicks_the_Edit_icon_from_Company_Information_panel() throws Exception {
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
		if (reader.getConfigValue("DriverConfig", "environment").equals("remoteHub")) {
			editCompanyPage.scrollToElementByWebElementLocator(editCompanyPage.btn_Save);
			editCompanyPage.waitAndClickElement(editCompanyPage.btn_Save);
		} else {
			editCompanyPage.waitAndClickElement(editCompanyPage.btn_Save);
		}
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

	@Then("User verifies that the edited Billing info fields were saved correctly")
	public void user_verifies_that_the_edited_Billing_info_fields_were_saved_correctly() throws Exception {
		Assert.assertEquals("555-223-1785", editCompanyPage.txtF_BusinessPhone.getAttribute("value"));
		Assert.assertEquals("Canada", editCompanyPage.getElementText(editCompanyPage.selectedCountry()));
		Assert.assertEquals("Quebec", editCompanyPage.getElementText(editCompanyPage.selectedState()));
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
		Assert.assertTrue(viewInvoicePage.tile_TransactionHistory.isDisplayed());
	}

	@Then("User verifies that Date column is present under Transaction history")
	public void user_verifies_that_Date_column_is_present_under_Transaction_history() {
		Assert.assertTrue(viewInvoicePage.col_TranssactionHistoryDate.isDisplayed());
	}

	@Then("USer verifies that Status columnr is present under Transaction history")
	public void user_verifies_that_Status_columnr_is_present_under_Transaction_history() {
		Assert.assertTrue(viewInvoicePage.col_Status.isDisplayed());
	}

	@Then("User verifies that Amount Due column is present under Transaction history")
	public void user_verifies_that_Amount_Due_column_is_present_under_Transaction_history() {
		Assert.assertTrue(viewInvoicePage.col_AmountDue.isDisplayed());
	}

//	@SMSM-135 @Edit-Payment-Information-from-Billing-page
	@When("User clicks the Edit Payment link from the Billing page")
	public void user_clicks_the_Edit_Payment_link_from_the_Billing_page() throws Exception {
		billingPage.waitAndClickElement(billingPage.lnk_EditPaymentMethod);
	}

	@Then("User edits the Address field")
	public void user_edits_the_Address_field() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_Address, "45 Test Street");
	}

	@Then("User edits the City field")
	public void user_edits_the_City_field() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_City, "Washington");
	}

	@Then("User edits the ZipCode field")
	public void user_edits_the_ZipCode_field() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_ZipCode, "94402");
	}

//  Revert Changes to Payment Information
	@Then("User verifies that the edited fields were saved correctly")
	public void user_verifies_that_the_edited_fields_were_saved_correctly() throws InterruptedException {
		Assert.assertEquals("45 Test Street", editCompanyPage.txtF_Address.getAttribute("value"));
		Assert.assertEquals("Washington", editCompanyPage.txtF_City.getAttribute("value"));
		Assert.assertEquals("94402", editCompanyPage.txtF_ZipCode.getAttribute("value"));
	}

	@Then("User changes Address City and ZipCode fields to thier original value")
	public void user_changes_Address_City_and_ZipCode_fields_to_thier_original_value() throws Exception {
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_Address, "123 main street");
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_City, "BAHAMA");
		editCompanyPage.sendKeysToWebElement(editCompanyPage.txtF_ZipCode, "93401");
	}
	

//	@SMSM-135 @Edit-Billing-Information-from-Billing-page @RegressionTest
	@When("User clicks the Edit Billing Information link")
	public void user_clicks_the_Edit_Billing_Information_link() throws Exception {
		billingPage.waitAndClickElement(billingPage.lnk_EditBillingInformation);
	}
	
//	@SMSM-135 @check-for-Invoice-History-from-Billing-page
	@Then("User verifies that Due Column is present")
	public void user_verifies_that_Due_Column_is_present() {
		Assert.assertTrue(billingPage.col_Due.isDisplayed());
	}

	@Then("User verifies Amount Column is present")
	public void user_verifies_Amount_Column_is_present() {
	 Assert.assertTrue(billingPage.col_Amount.isDisplayed());
	}

	@Then("User verifies Status column is present")
	public void user_verifies_Status_column_is_present() {
	  Assert.assertTrue(billingPage.col_Status.isDisplayed());
	}

	@Then("User verifies Action Column is present")
	public void user_verifies_Action_Column_is_present() {
		Assert.assertTrue(billingPage.col_Action.isDisplayed());
	}

//	@SMSM-135 @View-the-selected-Invoice-details-from-Invoice-History
	@When("User clicks the View button for an Invoice")
	public void user_clicks_the_View_button_for_an_Invoice() throws Exception {
		billingPage.waitAndClickElement(billingPage.btn_ViewButtonByAmount("495"));
	}

	@Then("the details of the Invoice clicked is displayed on the Invoice page")
	public void the_details_of_the_Invoice_clicked_is_displayed_on_the_Invoice_page() throws Exception {
	  Assert.assertEquals("View Invoice", viewInvoicePage.getElementText(viewInvoicePage.pag_Title));
	  Assert.assertTrue(viewInvoicePage.tile_CompanyInformation.isDisplayed());
	  Assert.assertTrue(viewInvoicePage.tile_TransactionHistory.isDisplayed());
	}
	
//	 @SMSM-135 @Verify-Help-option-for-Billing-page
	@Then("User verifies that Help button is present on the page")
	public void user_verifies_that_Help_button_is_present_on_the_page() {
	
	}

	@When("User clicks the Help button")
	public void user_clicks_the_Help_button() {
	
	}

	@Then("the help tour guide is opened")
	public void the_help_tour_guide_is_opened() {
	
	}

	



}
