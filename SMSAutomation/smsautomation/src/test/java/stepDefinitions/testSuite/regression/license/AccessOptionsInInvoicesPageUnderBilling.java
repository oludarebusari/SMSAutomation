package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.BusinessPage;
import pageObjects.thrive.BusinessesPage;
import pageObjects.thrive.EditBusinessPage;
import pageObjects.thrive.EditBusinessPlanPage;
import pageObjects.thrive.InvoicesPage;
import pageObjects.thrive.Tab.BillingDDown;
import pageObjects.thrive.modal.RestoreInvoiceModal;

public class AccessOptionsInInvoicesPageUnderBilling extends BasePage {

	public AccessOptionsInInvoicesPageUnderBilling() throws IOException {
		super();
	}

	public BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	public BusinessesPage businessesPage = PageFactory.initElements(driver, BusinessesPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public EditBusinessPlanPage editBusinessPlanPage = PageFactory.initElements(driver, EditBusinessPlanPage.class);
	public EditBusinessPage editBusinessPage = PageFactory.initElements(driver, EditBusinessPage.class);
	public InvoicesPage invoicesPage = PageFactory.initElements(driver, InvoicesPage.class);
	public RestoreInvoiceModal restoreInvoiceModal = PageFactory.initElements(driver, RestoreInvoiceModal.class);

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
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_OneTimePrice, "50.00");
		editBusinessPlanPage.sendKeysToWebElement(editBusinessPlanPage.txtF_RecurringPrice, "12.00");
		editBusinessPlanPage.waitAndClickElement(editBusinessPlanPage.btn_SavePlan);
	}

	@Then("changes were updated and notification alert displayed.")
	public void changes_were_updated_and_notication_alert_displayed() throws Exception {
		Assert.assertEquals("Item has been successfully updated.",
				businessesPage.getElementText(businessesPage.NotificationAlert));
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_Invoices);
		invoicesPage.waitAndClickElement(invoicesPage.actionDDown(businessName));
		invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "Edit Recurring Plan"));
		Assert.assertTrue(editBusinessPlanPage.txtF_OneTimePrice.getAttribute("value").contains("50.00"));
		Assert.assertTrue(editBusinessPlanPage.txtF_RecurringPrice.getAttribute("value").contains("12.00"));
	}

//	@[SMSM-214] @Verify-the-functionality-of-View-Merchant-Info-from-Invoices-page
	@When("User clicks on Merchant Info")
	public void user_clicks_on_Merchant_Info() throws Exception {
		invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "Merchant Info"));
	}

	@When("User edits some of the required fields on the Edit Merchant")
	public void user_edits_some_of_the_required_fields_on_the_Edit_Merchant() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Arcades\""));
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessPhone, "555-454-1234");
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}

	@Then("User verifies that the changes made on the Edit Merchant were saved correctly")
	public void user_verifies_that_the_changes_made_on_the_Edit_Merchant_were_saved_correctly() throws Exception {
		Assert.assertEquals("×\nClose\nItem has been successfully updated.",
				editBusinessPage.getElementText(editBusinessPage.txt_SentNotification));
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_Invoices);
		invoicesPage.waitAndClickElement(invoicesPage.actionDDown(businessName));
		invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "Merchant Info"));
		Assert.assertEquals("Arcades", editBusinessPage.getElementText(editBusinessPage.businessCategoryOpt("\"Arcades\"")));
		Assert.assertTrue(editBusinessPage.txtF_BusinessPhone.getAttribute("value").contentEquals("555-454-1234"));
	}
	
//	#Revert changes made to Business
	@Then("User revert the changes made to the business record")
	public void user_revert_the_changes_made_to_the_business_record() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Korean\""));
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessPhone, "555-555-1555");
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}
	
//	@Verify-User-can-check-for-all-Business-invoices-from-Invoices-Page
	@When("User clicks on All Merchants Invoices")
	public void user_clicks_on_All_Merchants_Invoices() throws Exception {
		invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "All Merchant Invoices"));
	}

	@Then("All all invoices for the Business are displayed")
	public void all_all_invoices_for_the_Business_are_displayed() throws Exception {
		Assert.assertEquals(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)), invoicesPage.getNumberOfElements(invoicesPage.CellValues("The Broad Street Giant Grinder")));
	}

//	@Verify-Cancelled-invoices-can-be-restored-from-Invoices-page
	@When("User clicks the drop down action button for a Cancelled Invoice")
	public void user_clicks_the_drop_down_action_button_for_a_Cancelled_Invoice() throws Exception {
		invoicesPage.waitAndClickElement(invoicesPage.actionDDown(businessName));
	}

	@When("User clicks on Restore this invoice")
	public void user_clicks_on_Restore_this_invoice() throws Exception {
		invoicesPage.waitAndClickElement(invoicesPage.actionDDownOption(businessName, "Restore this invoice"));
	}

	@Then("User clicks the Restore Invoice button on the modal")
	public void user_clicks_the_Restore_Invoice_button_on_the_modal() {
		
	}

	@Then("User verifies that the invoices is restored")
	public void user_verifies_that_the_invoices_is_restored() {
	
	}
}
