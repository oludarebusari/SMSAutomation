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
import pageObjects.thrive.ResellerDashboardPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.ReportsDDown;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.CreateDigitalAuditModal;

public class ViewAndEditReportsInResellersPortal extends BasePage {

	public ViewAndEditReportsInResellersPortal() throws IOException {
		super();
	}

	BusinessReportsPage businessReportsPage = PageFactory.initElements(driver, BusinessReportsPage.class);
	CreateDigitalAuditModal createDigitalAuditModal = PageFactory.initElements(driver, CreateDigitalAuditModal.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	DigitalAuditPage digitalAuditPage = PageFactory.initElements(driver, DigitalAuditPage.class);
	ResellerDashboardPage resellerDashboardPage = PageFactory.initElements(driver, ResellerDashboardPage.class);
	ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	
	Actions action = new Actions(driver);
	
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
		Assert.assertEquals(businessReportsPage.getACTIVEBUSINESSESDESCRIPTION(), businessReportsPage.getElementText(businessReportsPage.activeBusinessDescription));
	}
	
	@When("User hovers over New Merchants")
	public void user_hovers_over_New_Merchants() {
		action.moveToElement(businessReportsPage.col_NewBusiness).perform();
	}

	@Then("User is able to see the New Merchants description")
	public void user_is_able_to_see_the_New_Merchants_description() throws InterruptedException {
		Assert.assertEquals(businessReportsPage.getNEWBUSINESSDESCRIPTION(), businessReportsPage.getElementText(businessReportsPage.newBusinessDescription));
	}

	@When("User hovers over Canceled Merchants")
	public void user_hovers_over_Canceled_Merchants() {
	    action.moveToElement(businessReportsPage.col_CanceledBusiness).perform();
	}

	@Then("User is able to see the Canceled Merchants")
	public void user_is_able_to_see_the_Canceled_Merchants() throws Exception {
		Assert.assertEquals(businessReportsPage.getCANCELEDBUSINESSESDESCRIPTION(), businessReportsPage.getElementText(businessReportsPage.canceledBusinessesDescription));
	}

	@When("User hovers over Period Net Merchants")
	public void user_hovers_over_Period_Net_Merchants() {
		action.moveToElement(businessReportsPage.col_PeriodNetBusinesses).perform();
	}

	@Then("User is able to see Period Net Merchants")
	public void user_is_able_to_see_Period_Net_Merchants() throws Exception {
	   Assert.assertEquals(businessReportsPage.getPERIODNETBUSINESSESDESCRIPTION(), businessReportsPage.getElementText(businessReportsPage.periodNetBusinessesDescription));
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
	public void user_confirms_the_page_count_is_updated_successfully() throws NumberFormatException, InterruptedException {
		Assert.assertEquals(25, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
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
	
//	@Verify-that-user-us-able-to-see-create-digital-audit-window-pops-up
	@When("User clicks on the Digital Audit option")
	public void user_clicks_on_the_Digital_Audit_option() throws Exception {
		reportsDDown.waitAndClickElement(reportsDDown.opt_Digital_Audit);
	}

	@Then("the Digital Audit page is displayeed")
	public void the_Digital_Audit_page_is_displayeed() throws Exception {
	  Assert.assertEquals("Digital Audit", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	@When("User clicks on the New button on the Digital Audit page")
	public void user_clicks_on_the_New_button_on_the_Digital_Audit_page() throws Exception {
	    commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the create digital audit window pop up is opened")
	public void the_create_digital_audit_window_pop_up_is_opened() throws Exception {
	   Assert.assertEquals("Create Digital Audit", createDigitalAuditModal.getElementText(createDigitalAuditModal.mod_Title));
	}

	@When("User enters a URL and Keyword and clicks Add button")
	public void user_enters_a_URL_and_Keyword_and_clicks_Add_button() throws Exception {
		createDigitalAuditModal.sendKeysToWebElement(createDigitalAuditModal.txtF_URL, "http://www.autotest.com");
		createDigitalAuditModal.sendKeysToWebElement(createDigitalAuditModal.txtF_Keyword, "Automation");
		createDigitalAuditModal.waitAndClickElement(createDigitalAuditModal.Add);
	}

	@Then("User verifies that the Digital Audit is created")
	public void user_verifies_that_the_Digital_Audit_is_created() throws Exception {
     Assert.assertTrue(digitalAuditPage.cellValue("http://www.autotest.com").isDisplayed());
	}
	
//	
	
	
}
