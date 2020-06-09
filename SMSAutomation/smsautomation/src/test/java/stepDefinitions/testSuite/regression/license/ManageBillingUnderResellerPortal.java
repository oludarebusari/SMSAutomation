package stepDefinitions.testSuite.regression.license;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.BusinessesPage;
import pageObjects.thrive.EditBusinessPage;
import pageObjects.thrive.EditBusinessPlanPage;
import pageObjects.thrive.EditInvoicePage;
import pageObjects.thrive.InvoicesPage;
import pageObjects.thrive.ManageBillingPage;
import pageObjects.thrive.Tab.BillingDDown;
import pageObjects.thrive.modal.ConfirmInvoiceCancelationModal;
import pageObjects.thrive.modal.RestoreInvoiceModal;
import utils.DriverFactory;

public class ManageBillingUnderResellerPortal extends DriverFactory {

	BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	BusinessesPage businessesPage = PageFactory.initElements(driver, BusinessesPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	ConfirmInvoiceCancelationModal confirmInvoiceCancelationModal = PageFactory.initElements(driver,
			ConfirmInvoiceCancelationModal.class);
	EditBusinessPlanPage editBusinessPlanPage = PageFactory.initElements(driver, EditBusinessPlanPage.class);
	EditBusinessPage editBusinessPage = PageFactory.initElements(driver, EditBusinessPage.class);
	EditInvoicePage editInvoicePage = PageFactory.initElements(driver, EditInvoicePage.class);
	ManageBillingPage manageBillingPage = PageFactory.initElements(driver, ManageBillingPage.class);
	RestoreInvoiceModal restoreInvoiceModal = PageFactory.initElements(driver, RestoreInvoiceModal.class);
	InvoicesPage invoicesPage = PageFactory.initElements(driver, InvoicesPage.class);

	DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	String businessName = "The Broad Street Giant Grinder";

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
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Edit Recurring Plan"));
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
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Edit Recurring Plan"));
		Assert.assertFalse(
				editBusinessPlanPage.isElementVisible(editBusinessPlanPage.featureLocator("Web Essentials Ongoing")));
	}

//	@Verify-merchant-info-details-in-manage-billing-page
	@When("User clicks the Merchant Info option")
	public void user_clicks_the_Merchant_Info_option() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Merchant Info"));
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
		Assert.assertTrue(editBusinessPage.billingInformationPanel.isDisplayed());
	}

//	 @Verify-Invoice-details-are-displayed-on-clicking-view-button-on-Manage-billing-page
	@When("User clicks the view button under actions to view selected merchant invoice details")
	public void user_clicks_the_view_button_under_actions_to_view_selected_merchant_invoice_details() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.btn_View(businessName));
	}

	@Then("User is redirected to the invoice page for the selected merchant")
	public void user_is_redirected_to_the_invoice_page_for_the_selected_merchant() throws Exception {
		Assert.assertEquals("Edit Invoice", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the sub sections under the Invoice section")
	public void user_verifies_the_sub_sections_under_the_Invoice_section() {
		Assert.assertTrue(editInvoicePage.panel_Invoices.isDisplayed());
		Assert.assertTrue(editInvoicePage.col_Feature.isDisplayed());
		Assert.assertTrue(editInvoicePage.col_OneTimePrice.isDisplayed());
		Assert.assertTrue(editInvoicePage.col_RecurringPrice.isDisplayed());
	}

	@Then("User verifies the links on the page")
	public void user_verifies_the_links_on_the_page() {
		Assert.assertTrue(editInvoicePage.lnk_EditRecurringPlan.isDisplayed());
		Assert.assertTrue(editInvoicePage.lnk_EditBillingInformation.isDisplayed());
	}

	@Then("User verifies Company Information section is available")
	public void user_verifies_Company_Information_section_is_available() {
		Assert.assertTrue(editInvoicePage.panel_CompanyInformation.isDisplayed());
	}

	@Then("User verifies Users Section is available on the page")
	public void user_verifies_Users_Section_is_available_on_the_page() {
		Assert.assertTrue(editInvoicePage.panel_Users.isDisplayed());
	}

	@Then("User verifies that Transaction History section is available on the page")
	public void user_verifies_that_Transaction_History_section_is_available_on_the_page() {
		Assert.assertTrue(editInvoicePage.panel_TransactionHistory.isDisplayed());
	}

//	@Verify-all-merchant-invoices-page-is-displayed
	@When("User clicks on All Merchant Invoices from the drop down")
	public void user_clicks_on_All_Merchant_Invoices_from_the_drop_down() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage
				.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "All Merchant Invoices"));
	}

	@Then("User is redirected to Merchant Invoice page")
	public void user_is_redirected_to_Merchant_Invoice_page() throws Exception {
		Assert.assertEquals("Invoices", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the invoice page")
	public void user_verifies_the_columns_on_the_invoice_page() {
		Assert.assertTrue(invoicesPage.col_Invoice.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Business.isDisplayed());
		Assert.assertTrue(invoicesPage.col_PaymentMethod.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Amount.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Updated.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Due.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Status.isDisplayed());
		Assert.assertTrue(invoicesPage.col_Action.isDisplayed());
	}

//	@Restore-invoice-option-in-manage-billing-page
	@When("User clicks on Restore this Invoice from action drop down options")
	public void user_clicks_on_Restore_this_Invoice_from_action_drop_down_options() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage
				.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Restore this invoice"));
	}

	@Then("the Restore Invoice modal is displayed")
	public void the_Restore_Invoice_modal_is_displayed() throws Exception {
		Assert.assertEquals("Restore Invoice", restoreInvoiceModal.getElementText(restoreInvoiceModal.mod_Title));
	}

	@Then("User sets a new date to invoice")
	public void user_sets_a_new_date_to_invoice() throws Exception {
		restoreInvoiceModal.sendKeysToWebElement(restoreInvoiceModal.txtF_dueDate,
				LocalDate.now().plusDays(4).format(df).toString());
	}

	@Then("User clicks on the checkbox to Send an Invoice restore alert email to the Merchant")
	public void user_clicks_on_the_checkbox_to_Send_an_Invoice_restore_alert_email_to_the_Merchant()
			throws InterruptedException {
		restoreInvoiceModal.waitAndClickElement(restoreInvoiceModal.chkBok_SendEmail);
	}

	@When("User clicks on the Restore Invoice button")
	public void user_clicks_on_the_Restore_Invoice_button() throws Exception {
		restoreInvoiceModal.waitAndClickElement(restoreInvoiceModal.btn_RestoreInvoice);
	}

	@Then("the Invoice is restored and status is changed due")
	public void the_Invoice_is_restored_and_status_is_changed_due() throws Exception {
		Assert.assertTrue(
				invoicesPage.getElementText(invoicesPage.CellValue(businessName, "Pending")).contains("Pending"));
	}

//	@Cancel-invoice-option-in-manage-billing-page
	@When("User clicks on Cancel this invoice from action drop down options")
	public void user_clicks_on_Cancel_this_invoice_from_action_drop_down_options() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Cancel this invoice"));
	}

	@Then("the Confirm Invoice Cancelation modal is displayed")
	public void the_Confirm_Invoice_Cancelation_modal_is_displayed() throws Exception {
		Assert.assertEquals("Confirm Invoice Cancelation",
				confirmInvoiceCancelationModal.getElementText(confirmInvoiceCancelationModal.mod_Title));
	}

	@Then("User clicks on the checkbox to Send an invoice cancelation alert emailto the merchant")
	public void user_clicks_on_the_checkbox_to_Send_an_invoice_cancelation_alert_emailto_the_merchant()
			throws Exception {
		confirmInvoiceCancelationModal.waitAndClickElement(confirmInvoiceCancelationModal.chkBox_SendEmail);
	}

	@When("User clicks on the Cancel Invoice button")
	public void user_clicks_on_the_Cancel_Invoice_button() throws Exception {
		confirmInvoiceCancelationModal.waitAndClickElement(confirmInvoiceCancelationModal.btn_CancelInvoice);
	}

	@Then("the Invoice is cancelled and status of the Invoice changed to Cancelled")
	public void the_Invoice_is_cancelled_and_status_of_the_Invoice_changed_to_Cancelled() throws Exception {
		Assert.assertTrue(invoicesPage.getElementText(invoicesPage.CellValue(businessName, "Cancelled"))
				.contentEquals("Cancelled"));
	}

//	@Validate-the-help-button-functionality-on-Manage-Billing-page
	@When("User clicks the help button on the Manage Billing page")
	public void user_clicks_the_help_button_on_the_Manage_Billing_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("Actionable Tiles modal is displayed")
	public void actionable_Tiles_modal_is_displayed() throws Exception {
		Assert.assertEquals("Actionable Tiles",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Actionable Tiles modal")
	public void user_clicks_the_Next_button_on_the_Actionable_Tiles_modal() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Late Payments Tile modal is displayed")
	public void the_Late_Payments_Tile_modal_is_displayed() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Late Payments Tile",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the previous button on the Late Payments Tile modal")
	public void user_clicks_on_the_previous_button_on_the_Late_Payments_Tile_modal() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("User is navigated to the Actionable Tiles modal Modal")
	public void user_is_navigated_to_the_Actionable_Tiles_modal_Modal() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Actionable Tiles",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	@Change-the-billing-type-to-Credit-Card-in-Edit-Merchant-Page
	@When("User clicks on Merchant Info from action drop down options")
	public void user_clicks_on_Merchant_Info_from_action_drop_down_options() throws Exception {
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Merchant Info"));
	}

	@When("User clicks the Invoice toggle under Billing Information")
	public void user_clicks_the_Invoice_toggle_under_Billing_Information() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.tog_Invoice);
	}

	@Then("the toggle changes to Credit Card and Credit card detail elemets displayed")
	public void the_toggle_changes_to_Credit_Card_and_Credit_card_detail_elemets_displayed() throws Exception {
		Assert.assertEquals("Credit Card", editBusinessPage.getElementText(editBusinessPage.tog_CreditCard));
		Assert.assertTrue(editBusinessPage.panel_CreditCard.isDisplayed());
	}

//	@Edit-merchant-info-details-select-the-previously-purchased-domain
	@Then("User clicks on Merchant Info from drop down options")
	public void user_clicks_on_Merchant_Info_from_drop_down_options() throws Exception {
	   manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
	   manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Merchant Info"));
	}
	
	@When("User selects a different Business Category option")
	public void user_selects_a_different_Business_Category_option() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Arcades\""));
	}

	@When("User clicks on the Site toggle")
	public void user_clicks_on_the_Site_toggle() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.tog_previouslyPurchasedDomain);
	}

	@When("User clicks on the Save button")
	public void user_clicks_on_the_Save_button() throws InterruptedException {
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}
	
	@When("User verifies the changes made to the merchant info details")
	public void user_verifies_the_changes_made_to_the_merchant_info_details() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_ManageBilling);
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Merchant Info"));
		Assert.assertEquals("Arcades", editBusinessPage.getElementText(editBusinessPage.businessCategoryOpt("\"Arcades\"")));
		Assert.assertEquals("A Subdomain", editBusinessPage.getElementText(editBusinessPage.tog_subDomain));
	}
	
//	#Revert Changes made to merchant info details
	@When("User reverted changes made to merchant info details")
	public void user_reverted_changes_made_to_merchant_info_details() throws Exception {
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Korean\""));
	    editBusinessPage.waitAndClickElement(editBusinessPage.tog_subDomain);
	    editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}
	
//	@Edit-the-address-in-Billing-information-in-Edit-Merchant-page
	@Then("User edits the Address field under Billing information")
	public void user_edits_the_Address_field_under_Billing_information() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_Address, "234 Automation Street");
	}

	@Then("User edits the City field under Billing information")
	public void user_edits_the_City_field_under_Billing_information() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_City, "GeorgeTown");
	}

	@Then("User select a country from the Country drop down")
	public void user_select_a_country_from_the_Country_drop_down() throws Exception {
	   editBusinessPage.waitAndClickElement(editBusinessPage.countryDDown);
	   editBusinessPage.clickOnTextFromDropdownList(editBusinessPage.countryDDown, "Canada");
	}

	@Then("User selects a state from the State drop down")
	public void user_selects_a_state_from_the_State_drop_down() throws Exception {
	  editBusinessPage.waitAndClickElement(editBusinessPage.stateDDown);
	  editBusinessPage.clickOnTextFromDropdownList(editBusinessPage.stateDDown, "Alberta");
	}

	@Then("User enters a zipcode")
	public void user_enters_a_zipcode() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_ZipCode, "T3H 4C7");
	}

	@Then("User clicks the Save button and verifies the nottification alert")
	public void user_clicks_the_Save_button_and_verifies_the_nottification_alert() throws Exception {
	   editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	   Assert.assertEquals("×\nClose\nItem has been successfully updated.", editBusinessPage.getElementText(editBusinessPage.txt_SentNotification));
	}
	
	@Then("User verifies the changes made to the Billing information")
	public void user_verifies_the_changes_made_to_the_Billing_information() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Billing);
		billingDDown.waitAndClickElement(billingDDown.opt_ManageBilling);
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDown(businessName));
		manageBillingPage.waitAndClickElement(manageBillingPage.ActionDDownOption(businessName, "Merchant Info"));
		Assert.assertTrue(editBusinessPage.txtF_Address.getAttribute("value").contentEquals("234 Automation Street"));
		Assert.assertTrue(editBusinessPage.txtF_City.getAttribute("value").contentEquals("GeorgeTown"));
		Assert.assertTrue(editBusinessPage.countryStateDDownOption("Canada").getText().contentEquals("Canada"));
		Assert.assertTrue(editBusinessPage.countryStateDDownOption("Alberta").getText().contentEquals("Alberta"));		
		Assert.assertTrue(editBusinessPage.txtF_ZipCode.getAttribute("value").contentEquals("T3H 4C7"));
	}

	@Then("User Revert the changes made to the Billing Information")
	public void user_Revert_the_changes_made_to_the_Billing_Information() throws Exception {
	   editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_Address, "990 Industrial Way");
	   editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_City, "Georgia");
	   editBusinessPage.waitAndClickElement(editBusinessPage.countryDDown);
	   editBusinessPage.clickOnTextFromDropdownList(editBusinessPage.countryDDown, "USA");
	   editBusinessPage.waitAndClickElement(editBusinessPage.stateDDown);
	   editBusinessPage.clickOnTextFromDropdownList(editBusinessPage.stateDDown, "California");
	   editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_ZipCode, "93401");
	   editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}

}
