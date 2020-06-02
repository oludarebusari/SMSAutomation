package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.BusinessReportsPage;
import pageObjects.thrive.DigitalAuditPage;
import pageObjects.thrive.EditBusinessPage;
import pageObjects.thrive.EditUserPage;
import pageObjects.thrive.ResellerDashboardPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.ReportsDDown;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.CreateDigitalAuditModal;
import pageObjects.thrive.modal.DeleteAuditModal;

public class ViewAndEditReportsInResellersPortal extends BasePage {

	public ViewAndEditReportsInResellersPortal() throws IOException {
		super();
	}

	BusinessReportsPage businessReportsPage = PageFactory.initElements(driver, BusinessReportsPage.class);
	CreateDigitalAuditModal createDigitalAuditModal = PageFactory.initElements(driver, CreateDigitalAuditModal.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	DigitalAuditPage digitalAuditPage = PageFactory.initElements(driver, DigitalAuditPage.class);
	DeleteAuditModal deleteAuditModal = PageFactory.initElements(driver, DeleteAuditModal.class);
	EditBusinessPage editBusinessPage = PageFactory.initElements(driver, EditBusinessPage.class);
	ResellerDashboardPage resellerDashboardPage = PageFactory.initElements(driver, ResellerDashboardPage.class);
	ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);

	Actions action = new Actions(driver);
	String downloadpath = System.getProperty("user.home") + "//Downloads//";
	String fileName = "oohlalaspatogo.com-";
	String digitAuditViewURL = "https://thrive.stage2-aut.mastermindsdigital.com/licensee/digital-audit/8928/view";

//	@Verify-that-user-is-able-to-see-2-options-on-reports-tab
	@When("User clicks on the Reports tab on the top menu bar")
	public void user_clicks_on_the_Reports_tab_on_the_top_menu_bar() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Reports);
	}

	@Then("User confirms the options under the Report menu")
	public void user_confirms_the_options_under_the_Report_menu() throws Exception {
		Assert.assertTrue(reportsDDown.opt_Businesses.isDisplayed());
		Assert.assertTrue(reportsDDown.opt_Digital_Audit.isDisplayed());
	}

//	@Verify-that-User-is-able-to-Hover-the-mouse-on-merchants-(heading),-then-description-appears-for-that-particular-heading
	@When("User clicks on the Businesses option")
	public void user_clicks_on_the_Businesses_option() throws Exception {
		reportsDDown.waitAndClickElement(reportsDDown.opt_Businesses);
	}

	@Then("the Businesses page is displayed")
	public void the_Businesses_page_is_displayed() throws Exception {
		Assert.assertEquals("Business Reports", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies that all businesses count as per the month")
	public void user_verifies_that_all_businesses_count_as_per_the_month() {
		Assert.assertTrue(businessReportsPage.col_ActiveBusinessess.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_NewBusiness.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_CanceledBusiness.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_PeriodNetBusinesses.isDisplayed());
	}

	@When("User hovers over Active Merchants")
	public void user_hovers_over_Active_Merchants() {
		action.moveToElement(businessReportsPage.col_ActiveBusinessess).perform();
	}

	@Then("User is able to see Active Merchants description")
	public void user_is_able_to_see_Active_Merchants_description() throws InterruptedException {
		Assert.assertEquals(businessReportsPage.getACTIVEBUSINESSESDESCRIPTION(),
				businessReportsPage.getElementText(businessReportsPage.activeBusinessDescription));
	}

	@When("User hovers over New Merchants")
	public void user_hovers_over_New_Merchants() {
		action.moveToElement(businessReportsPage.col_NewBusiness).perform();
	}

	@Then("User is able to see the New Merchants description")
	public void user_is_able_to_see_the_New_Merchants_description() throws InterruptedException {
		Assert.assertEquals(businessReportsPage.getNEWBUSINESSDESCRIPTION(),
				businessReportsPage.getElementText(businessReportsPage.newBusinessDescription));
	}

	@When("User hovers over Canceled Merchants")
	public void user_hovers_over_Canceled_Merchants() {
		action.moveToElement(businessReportsPage.col_CanceledBusiness).perform();
	}

	@Then("User is able to see the Canceled Merchants")
	public void user_is_able_to_see_the_Canceled_Merchants() throws Exception {
		Assert.assertEquals(businessReportsPage.getCANCELEDBUSINESSESDESCRIPTION(),
				businessReportsPage.getElementText(businessReportsPage.canceledBusinessesDescription));
	}

	@When("User hovers over Period Net Merchants")
	public void user_hovers_over_Period_Net_Merchants() {
		action.moveToElement(businessReportsPage.col_PeriodNetBusinesses).perform();
	}

	@Then("User is able to see Period Net Merchants")
	public void user_is_able_to_see_Period_Net_Merchants() throws Exception {
		Assert.assertEquals(businessReportsPage.getPERIODNETBUSINESSESDESCRIPTION(),
				businessReportsPage.getElementText(businessReportsPage.periodNetBusinessesDescription));
	}

//	@Verify-that-user-is-able-to-change-selected-count-and-view-more-entries-on-page
	@When("User clicks the page drop down count")
	public void user_clicks_the_page_drop_down_count() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	}

	@Then("the page drop down is expanded")
	public void the_page_drop_down_is_expanded() {
		Assert.assertTrue(commonElementLocator.tableRecordsCount.isDisplayed());
	}

	@When("User clicks on a number from the drop down")
	public void user_clicks_on_a_number_from_the_drop_down() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("25"));
	}

	@Then("User confirms the page count is updated successfully")
	public void user_confirms_the_page_count_is_updated_successfully()
			throws NumberFormatException, InterruptedException {
		Assert.assertEquals(25,
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
	}

//  @Verify-that-user-is-able-to-see-data-in-the-table-reordered-accordingly
	@Then("User verifies that the Active Business column is available")
	public void user_verifies_that_the_Active_Business_column_is_available() {
		Assert.assertTrue(businessReportsPage.col_ActiveBusinessess.isDisplayed());
	}

	@When("User clicks the Active Business column")
	public void user_clicks_the_Active_Business_column() throws InterruptedException {
		businessReportsPage.waitAndClickElement(businessReportsPage.col_ActiveBusinessess);
	}

	@Then("the data on the table is reordered accordingly")
	public void the_data_on_the_table_is_reordered_accordingly() {
		Assert.assertTrue(businessReportsPage.firstSortedRecord("5").isDisplayed());
	}

//	@Verify-that-user-is-able-to-see-create-digital-audit-window-pops-up
	@When("User clicks on the Digital Audit option")
	public void user_clicks_on_the_Digital_Audit_option() throws Exception {
		reportsDDown.waitAndClickElement(reportsDDown.opt_Digital_Audit);
	}

	@Then("the Digital Audit page is displayed")
	public void the_Digital_Audit_page_is_displayed() throws Exception {
		Assert.assertEquals("Digital Audit", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks on the New button on the Digital Audit page")
	public void user_clicks_on_the_New_button_on_the_Digital_Audit_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the create digital audit window pop up is opened")
	public void the_create_digital_audit_window_pop_up_is_opened() throws Exception {
		Assert.assertEquals("Create Digital Audit",
				createDigitalAuditModal.getElementText(createDigitalAuditModal.mod_Title));
	}

//	@Verify-that-digital-audit-is-added-under-digital-audit-page
	@When("User enters a URL and Keyword and clicks Add button")
	public void user_enters_a_URL_and_Keyword_and_clicks_Add_button() throws Exception {
		createDigitalAuditModal.sendKeysToWebElement(createDigitalAuditModal.txtF_URL, "https://www.autotest.com");
		createDigitalAuditModal.sendKeysToWebElement(createDigitalAuditModal.txtF_Keyword, "Automation");
		createDigitalAuditModal.waitAndClickElement(createDigitalAuditModal.Add);
	}

	@Then("User verifies that the Digital Audit is created")
	public void user_verifies_that_the_Digital_Audit_is_created() throws Exception {
		Thread.sleep(1000);
		Assert.assertTrue(digitalAuditPage.cellValue("https://www.autotest.com").isDisplayed());
	}

//	@Verify-that-user-is-able-to-download-pdf-file-for-selected-URL-locally-on-your-system
	@Then("User verifies the columns on the digital audit page")
	public void user_verifies_the_columns_on_the_digital_audit_page() {
		Assert.assertTrue(digitalAuditPage.col_URL.isDisplayed());
		Assert.assertTrue(digitalAuditPage.col_Keyword.isDisplayed());
		Assert.assertTrue(digitalAuditPage.col_Status.isDisplayed());
		Assert.assertTrue(digitalAuditPage.col_Created.isDisplayed());
		Assert.assertTrue(digitalAuditPage.col_Actions.isDisplayed());
	}

	@When("User clicks the download button for a Digital Audit")
	public void user_clicks_the_download_button_for_a_Digital_Audit() throws Exception {
		digitalAuditPage.waitAndClickElement(digitalAuditPage.btn_Download("http://oohlalaspatogo.com"));
	}

	@Then("user confirms that a pdf file is downloaded")
	public void user_confirms_that_a_pdf_file_is_downloaded() throws Exception {
		Assert.assertTrue(digitalAuditPage.isFileDownloadedWithDynamicFilename(downloadpath, fileName));
	}

//	@Verify-that-user-is-redirected-to-digital-audit-view-page-and-user-can-view-the-data
	@When("User clicks the drop down button for a digital audit")
	public void user_clicks_the_drop_down_button_for_a_digital_audit() throws InterruptedException {
		digitalAuditPage.waitAndClickElement(digitalAuditPage.btn_downloadDDown("https://www.trishnorman.com/"));
	}

	@When("User clicks the View button")
	public void user_clicks_the_View_button() throws Exception {
		digitalAuditPage.waitAndClickElement(digitalAuditPage.btn_ViewDDownAction("https://www.trishnorman.com/"));
	}

	@Then("user is redirected to the view page of the digital audit")
	public void user_is_redirected_to_the_view_page_of_the_digital_audit() {
		digitalAuditPage.switchWindow();
		Assert.assertEquals(digitAuditViewURL, driver.getCurrentUrl());
	}

//	@Verify that user is able to delete 
	@When("User selects the the Digital Audit URL to delete and clicks the Delete button")
	public void user_selects_the_the_Digital_Audit_URL_to_delete_and_clicks_the_Delete_button() throws Exception {
		digitalAuditPage.waitAndClickElement(digitalAuditPage.btn_Delete("https://www.autotest.com"));
	}

	@When("selects the the Digital Audit URL to delete and clicks the Delete button")
	public void selects_the_the_Digital_Audit_URL_to_delete_and_clicks_the_Delete_button() throws Exception {
		digitalAuditPage.waitAndClickElement(digitalAuditPage.btn_Delete("https://www.autotest.com"));
	}

	@Then("the Delete Audit modal is opened")
	public void the_Delete_Audit_modal_is_opened() throws InterruptedException {
		Assert.assertEquals("Delete Audit", deleteAuditModal.getElementText(deleteAuditModal.mod_Title));
	}

	@When("User clicks the Delete button on the Delete Audit modal")
	public void user_clicks_the_Delete_button_on_the_Delete_Audit_modal() throws InterruptedException {
		deleteAuditModal.waitAndClickElement(deleteAuditModal.btn_Delete);
	}

	@Then("User confirms that the Digital Audit URL is deleted")
	public void user_confirms_that_the_Digital_Audit_URL_is_deleted() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "https://www.autotest.com");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)) == 0);
	}

//	@Verify-that-user-is-able-to-search-for-a-digital-audit-using-keyword
	@When("User types in the keyword to search for into the Search textbox and click Search button")
	public void user_types_in_the_keyword_to_search_for_into_the_Search_textbox_and_click_Search_button()
			throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "cmt");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the Digital Audit record is displayed")
	public void the_Digital_Audit_record_is_displayed() {
		Assert.assertTrue(digitalAuditPage.cellValue("cmt").isDisplayed());
	}

//	@Verify-the-help-button-functionality-within-digital-audit-page@Verify-the-help-button-functionality-within-digital-audit-page
	@When("User clicks the Help button on the Digital Audit page")
	public void user_clicks_the_Help_button_on_the_Digital_Audit_page() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Create New Audit help tour window appears")
	public void the_Create_New_Audit_help_tour_window_appears() throws Exception {
		Assert.assertEquals("Create New Audit",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Create New Audit help window")
	public void user_clicks_the_Next_button_on_the_Create_New_Audit_help_window() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the URL window is displayed")
	public void the_URL_window_is_displayed() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("URL", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on the URL window")
	public void user_clicks_the_previous_button_on_the_URL_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("User is navigated to the create New Audit window")
	public void user_is_navigated_to_the_create_New_Audit_window() throws Exception {
		Assert.assertEquals("Create New Audit",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	 @Verify-admin-can-edit-a-company's-details-under-a-particular-Reseller
	@Then("User verifies that the edit drop down button is available for each Ressler")
	public void user_verifies_that_the_edit_drop_down_button_is_available_for_each_Ressler()
			throws InterruptedException {
		Assert.assertEquals(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)),
				resellerDashboardPage.getNumberOfElements(resellerDashboardPage.getEDITBTN()));
	}

	@When("User clicks the Edit option for a Reseller")
	public void user_clicks_the_Edit_option_for_a_Reseller() throws Exception {
		resellerDashboardPage.waitAndClickElement(resellerDashboardPage.btn_Edit("Estero Inn"));
	}

	@Then("the Edit Business window is opened")
	public void the_Edit_Business_window_is_opened() throws Exception {
		Assert.assertEquals("Edit Business", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User edits some information on the Edit Business page and clicks Save button")
	public void user_edits_some_information_on_the_Edit_Business_page_and_clicks_Save_button() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessName, "Estero Inn - Edited");
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessPhone, "554-554-1414");
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}

	@Then("User confirms that the information is saved correctly")
	public void user_confirms_that_the_information_is_saved_correctly() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Dashboard);
		Assert.assertTrue(resellerDashboardPage.cellValue("Estero Inn - Edited").isDisplayed());
	}

//	Revert Changes
	@Then("User revert the changes made to Reseller Business")
	public void user_revert_the_changes_made_to_Reseller_Business() throws Exception {
		resellerDashboardPage.waitAndClickElement(resellerDashboardPage.btn_Edit("Estero Inn - Edited"));
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessName, "Estero Inn");
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessPhone, "555-555-1785");
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}

}
