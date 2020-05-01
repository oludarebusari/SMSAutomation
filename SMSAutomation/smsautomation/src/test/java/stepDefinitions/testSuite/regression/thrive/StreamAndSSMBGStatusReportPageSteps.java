package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AdminSSMBGStatusReportPage;
import pageObjects.thrive.AdminStreamStatusPage;
import pageObjects.thrive.Tab.ReportsDDown;

public class StreamAndSSMBGStatusReportPageSteps  extends BasePage {

	public StreamAndSSMBGStatusReportPageSteps() throws IOException {
		super();
	}

	public AdminStreamStatusPage adminStreamStatusPage = PageFactory.initElements(driver, AdminStreamStatusPage.class);
	public AdminSSMBGStatusReportPage adminSSMBGStatusReportPage = PageFactory.initElements(driver, AdminSSMBGStatusReportPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);
	
	
	
	private int defaultPageSize = 0;
	private final String streamPageNumberText = "4";
	
//	@Verify-the-details-on-Streams-Connection-Status-report-page-and-verify-the-columns 
	@When("User clicks the Stream Status Report option")
	public void user_clicks_the_Stream_Status_Report_option() throws Exception {
	  reportsDDown.waitAndClickElement(reportsDDown.opt_Streams_Status_Report);
	}

	@Then("the Streams Connection Status page is displayed for the Reseler")
	public void the_Streams_Connection_Status_page_is_displayed_for_the_Reseler() throws InterruptedException {
		Assert.assertEquals("Streams Connection Status", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the page")
	public void user_verifies_the_columns_on_the_page() {
	  Assert.assertTrue(adminStreamStatusPage.col_Reseller.isDisplayed());
	  Assert.assertTrue(adminStreamStatusPage.col_Business.isDisplayed());
	  Assert.assertTrue(adminStreamStatusPage.col_Site.isDisplayed());
	  Assert.assertTrue(adminStreamStatusPage.col_DateReported.isDisplayed());
	  Assert.assertTrue(adminStreamStatusPage.col_StatusNotes.isDisplayed());
	  Assert.assertTrue(adminStreamStatusPage.col_Action.isDisplayed());
	}

	
//	
	@When("User clicks on the Reseller column title to sort record in ascending order")
	public void user_clicks_on_the_Reseller_column_title_to_sort_record_in_ascending_order() throws InterruptedException {
	   adminStreamStatusPage.waitAndClickElement(adminStreamStatusPage.col_Reseller);
	}

	@Then("the Streams Reports are sorted in ascending order")
	public void the_Streams_Reports_are_sorted_in_ascending_order() {
		Assert.assertTrue(adminStreamStatusPage.getFirstRowRecordResellerName("309VIP").isDisplayed());
	}

	@When("User clicks on the Reseller column title to sort records in descending order")
	public void user_clicks_on_the_Reseller_column_title_to_sort_records_in_descending_order() throws InterruptedException {
		adminStreamStatusPage.waitAndClickElement(adminStreamStatusPage.col_Reseller);
	}

	@Then("the Streams Reports are sorted in descending order")
	public void the_Streams_Reports_are_sorted_in_descending_order() {
		Assert.assertTrue(adminStreamStatusPage.getFirstRowRecordResellerName("WickedLoyal").isDisplayed());
	}

	@When("User clicks on the Business column title to sort record in ascending order")
	public void user_clicks_on_the_Business_column_title_to_sort_record_in_ascending_order() throws Exception {
		  adminStreamStatusPage.waitAndClickElement(adminStreamStatusPage.col_Business);
	}

	@Then("the Streams Reports are sorted in ascending order by Business")
	public void the_Streams_Reports_are_sorted_in_ascending_order_by_Business() {
		Assert.assertTrue(adminStreamStatusPage.getFirstRowRecordResellerName("100 Main Beef and BBQ").isDisplayed());
	}

	@When("User clicks on the Business column title to sort record in descending order")
	public void user_clicks_on_the_Business_column_title_to_sort_record_in_descending_order() throws InterruptedException {
		adminStreamStatusPage.waitAndClickElement(adminStreamStatusPage.col_Business);
	}

	@Then("the Streams Reports are sorted in descending order by Business")
	public void the_Streams_Reports_are_sorted_in_descending_order_by_Business() {
		Assert.assertTrue(adminStreamStatusPage.getFirstRowRecordResellerName("Zen Blendz Juice Bar").isDisplayed());
	}

	@Then("User verifies the default number of records displayed on the Stream page")
	public void user_verifies_the_default_number_of_records_displayed_on_the_Stream_page() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("10"));
		defaultPageSize = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	}

	@Then("User navigates to anoother page on the Stream page")
	public void user_navigates_to_anoother_page_on_the_Stream_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.pageButton(streamPageNumberText));
		Assert.assertEquals(Integer.parseInt(streamPageNumberText) * defaultPageSize,
				Integer.parseInt((commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd))));
	}

	
//	@Verify-Admin-is-able-to-search-the-Streams-connection-Status-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search
	@When("User enters a valid search criteria into the search box of the Stream page and click search")
	public void user_enters_a_valid_search_criteria_into_the_search_box_of_the_Stream_page_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "SteelcityRewards");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the reseller record is displayed on the Stream page")
	public void the_reseller_record_is_displayed_on_the_Stream_page() {
		Assert.assertTrue(adminStreamStatusPage.getFirstRowRecordResellerName("SteelcityRewards").isDisplayed());
	}

	@When("User enters an invalid search criteria into the search box of the Stream page and click search")
	public void user_enters_an_invalid_search_criteria_into_the_search_box_of_the_Stream_page_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "00000");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("No record is displayed on the Stream page")
	public void no_record_is_displayed_on_the_Stream_page() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("0"));
	}


//	@Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button
	@When("User clicks on the Help button on the Stream Connection Status page")
	public void user_clicks_on_the_Help_button_on_the_Stream_Connection_Status_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("a tour guide for is opened on the Stream page")
	public void a_tour_guide_for_is_opened_on_the_Stream_page() throws Exception {
		Assert.assertEquals("Stream Connection Status", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
	@When("User clicks on the Next button from the Stream Connection Status window")
	public void user_clicks_on_the_Next_button_from_the_Stream_Connection_Status_window() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Search window is opened")
	public void the_Search_window_is_opened() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Search", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the previous button from the Search window")
	public void user_clicks_on_the_previous_button_from_the_Search_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the tour guide is navigate back to the Stream Connection Status window")
	public void the_tour_guide_is_navigate_back_to_the_Stream_Connection_Status_window() throws Exception {
		Assert.assertEquals("Stream Connection Status", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
	
//	@Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button
	@When("User clicks the SSMBG Status Report option")
	public void user_clicks_the_SSMBG_Status_Report_option() throws Exception {
	  reportsDDown.waitAndClickElement(reportsDDown.opt_SSMBG_Status_Report);
	}

	@Then("the SSMBG Status Report page is displayed")
	public void the_SSMBG_Status_Report_page_is_displayed() throws Exception {
		Assert.assertEquals("SSMBG Status Report", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the column headers present on SSMBG Status Report page")
	public void user_verifies_the_column_headers_present_on_SSMBG_Status_Report_page() {
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_SalesCount.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_SalesRequired.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_DueDate.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_Reseller.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_ISSAssociate.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_ISSDaysLeft.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_Status.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_DateComplated.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_ResellerTestimonial.isDisplayed());
	   Assert.assertTrue(adminSSMBGStatusReportPage.col_Action.isDisplayed());
	}

	@Then("User verifies that each record has a View Appointment buttom")
	public void user_verifies_that_each_record_has_a_View_Appointment_buttom() throws Exception {
	    Assert.assertEquals(adminSSMBGStatusReportPage.getNumberOfElements(adminSSMBGStatusReportPage.getVIEWAPPOINTMENTLOCATOR()), Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)));
	}

}
