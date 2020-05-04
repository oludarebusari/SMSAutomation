package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AdminSSMBGStatusReportPage;
import pageObjects.thrive.AdminStreamStatusPage;
import pageObjects.thrive.SalesLeadsPage;
import pageObjects.thrive.Tab.ReportsDDown;

public class StreamAndSSMBGStatusReportPageSteps  extends BasePage {

	public StreamAndSSMBGStatusReportPageSteps() throws IOException {
		super();
	}

	public AdminStreamStatusPage adminStreamStatusPage = PageFactory.initElements(driver, AdminStreamStatusPage.class);
	public AdminSSMBGStatusReportPage adminSSMBGStatusReportPage = PageFactory.initElements(driver, AdminSSMBGStatusReportPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);
	public SalesLeadsPage salesLeadsPage = PageFactory.initElements(driver, SalesLeadsPage.class);
		
	
	private int defaultPageSize = 0;
	private int totalNumberOfRecords = 0;
	private int currentActivePage = 0;
	private int newActivePage = 0;
	private final String streamPageNumberText = "4";
	
	String downloadpath =  System.getProperty("user.home") + "//Downloads//";
	String fileName = "leads_export.csv";
	
	
	
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
	
//	@Verify-functionality-of-Sorting-and-Show-entries-dropdown-on-"SSMBG-Status-Report"-page
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

//	@Verify-that-Admin-is-able-to-filter-the"SSMBG-Status-Report"-by-clicking-on-In-Progress,-Fulfilled-&-All-tab
	@Then("User verifies the three tabs for filtering SSMBG Status Reports")
	public void user_verifies_the_three_tabs_for_filtering_SSMBG_Status_Reports() {
	      Assert.assertTrue(adminSSMBGStatusReportPage.tab_All.isDisplayed());
	      Assert.assertTrue(adminSSMBGStatusReportPage.tab_Fulfilled.isDisplayed());
	      Assert.assertTrue(adminSSMBGStatusReportPage.tab_InProgress.isDisplayed());
	}

	@Then("User verifies the default filtering option")
	public void user_verifies_the_default_filtering_option() {
		Assert.assertTrue(adminSSMBGStatusReportPage.tab_All.getAttribute("class").contains("active"));
		Assert.assertFalse(adminSSMBGStatusReportPage.tab_Fulfilled.getAttribute("class").contains("active"));
		Assert.assertFalse(adminSSMBGStatusReportPage.tab_InProgress.getAttribute("class").contains("active"));
	}

	@When("User clicks on Fulfilled tab")
	public void user_clicks_on_Fulfilled_tab() throws Exception {
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.tab_Fulfilled);		
	}

	@Then("all records with Status of Fulfilled are displayed")
	public void all_records_with_Status_of_Fulfilled_are_displayed() throws NumberFormatException, InterruptedException {
		totalNumberOfRecords = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal));
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)) <= totalNumberOfRecords);
	}

	@When("User clicks the In Progress tab")
	public void user_clicks_the_In_Progress_tab() throws InterruptedException {
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.tab_InProgress);
	}

	@Then("all records with Status of In Progress are displayed")
	public void all_records_with_Status_of_In_Progress_are_displayed() throws NumberFormatException, InterruptedException {
		totalNumberOfRecords = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal));
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)) <= totalNumberOfRecords);
	}

	@When("User clicks on All tab")
	public void user_clicks_on_All_tab() throws Exception {
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.tab_All);
	}

	@Then("all the records on SSMBG Status report are displayed")
	public void all_the_records_on_SSMBG_Status_report_are_displayed() throws NumberFormatException, InterruptedException {
		totalNumberOfRecords = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal));
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)) == totalNumberOfRecords);
	}

//	@Verify-functionality-of-Sorting-and-Show-entries-dropdown-on-"SSMBG-Status-Report"-page
	@When("User clicks on the Status column title to sort record in ascending order")
	public void user_clicks_on_the_Status_column_title_to_sort_record_in_ascending_order() throws InterruptedException {
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.col_Status);
	}

	@Then("the SSMBG Status Reports are sorted in ascending order")
	public void the_SSMBG_Status_Reports_are_sorted_in_ascending_order() throws Exception {
	Assert.assertEquals("Cancelled", adminSSMBGStatusReportPage.getElementText(adminSSMBGStatusReportPage.getFirstRowRecordByCellValue("Cancelled")));
	}

	@When("User clicks on the Status column title to sort records in descending order")
	public void user_clicks_on_the_Status_column_title_to_sort_records_in_descending_order() throws Exception {
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.col_Status);
	}

	@Then("the SSMBG Status Reports are sorted in descending order")
	public void the_SSMBG_Status_Reports_are_sorted_in_descending_order() throws Exception {
		Assert.assertEquals("Fulfilled", adminSSMBGStatusReportPage.getElementText(adminSSMBGStatusReportPage.getFirstRowRecordByCellValue("Fulfilled")));
	}

	@Then("User verifies the default number of records displayed on the SSMBG Status report page")
	public void user_verifies_the_default_number_of_records_displayed_on_the_SSMBG_Status_report_page() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("10"));
		defaultPageSize = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	}

	@Then("User navigates to anoother page on the SSMBG page")
	public void user_navigates_to_anoother_page_on_the_SSMBG_page() throws Exception {
		currentActivePage = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).replace("\n(current)", ""));
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_PaginationNext);
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.paginationActiveBtn);
		newActivePage = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).replace("\n(current)", ""));
		Assert.assertTrue(newActivePage - currentActivePage == 1);
		}

	@When("User changes the show entries option to All")
	public void user_changes_the_show_entries_option_to_All() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("All"));
	}

	@Then("all records are displayed on a single page")
	public void all_records_are_displayed_on_a_single_page() throws Exception {
	Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
	Assert.assertEquals("1", commonElementLocator.getElementText(commonElementLocator.paginationActiveBtn).replace("\n(current)", ""));
	Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
	}
	
//	@Verify-Admin-is-able-to-search-the-"SSMBG-Status-Report"-by-entering-a-search-criteria-in-Search-box-and-clicking-Search
	@When("User enters a valid search criteria into the search box of the SSMBG Status page and click search")
	public void user_enters_a_valid_search_criteria_into_the_search_box_of_the_SSMBG_Status_page_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "viptextme");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}
	
	@Then("the reseller record is displayed on the SSMBG Status page")
	public void the_reseller_record_is_displayed_on_the_SSMBG_Status_page() {
		Assert.assertTrue(adminSSMBGStatusReportPage.getFirstRowRecordByCellValue("viptextme").isDisplayed());
	}

	@When("User enters an invalid search criteria into the search box of the SSMBG Status page and click search")
	public void user_enters_an_invalid_search_criteria_into_the_search_box_of_the_SSMBG_Status_page_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "00000");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("No record is displayed on the SSMBG Status page")
	public void no_record_is_displayed_on_the_SSMBG_Status_page() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("0"));
	}
	
//	@Verify-Admin-can-"View-Appointments"-for-a-specified-"SSMBG-Status-Report"
	@When("User clicks View Appointments button for a record on the SSMBG Status report page")
	public void user_clicks_View_Appointments_button_for_a_record_on_the_SSMBG_Status_report_page() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "viptextme");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminSSMBGStatusReportPage.waitAndClickElement(adminSSMBGStatusReportPage.clickViewAppointment("viptextme"));
	}

	@Then("the Appointments Set page is opened")
	public void the_Appointments_Set_page_is_opened() throws Exception {
		Assert.assertEquals("Appointments Set", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies that all appintment can be viewed")
	public void user_verifies_that_all_appintment_can_be_viewed() throws Exception {
		String numberOfRecords = commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal);
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
		commonElementLocator.waitAndClickElement(commonElementLocator.showEntriesOption("96"));
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_PaginationNext);
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals(numberOfRecords));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal).contentEquals(numberOfRecords));
	}

	@Then("User verifies the columns on the Appointmnents Set page")
	public void user_verifies_the_columns_on_the_Appointmnents_Set_page() {
	 Assert.assertTrue(salesLeadsPage.col_ResellerName.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Company.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Location.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Ratings.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Vertical.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Status.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Updated.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Note.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_ApptDate.isDisplayed());
	 Assert.assertTrue(salesLeadsPage.col_Action.isDisplayed());
	}
	
	
//	@Verify-admin-can-filter-the-data-on-"Appointments-Set"-page-by-entering-the-details-in-filter-fields"
	@Then("User verifies the filter option on the Appointment Set page")
	public void user_verifies_the_filter_option_on_the_Appointment_Set_page() {
	   Assert.assertTrue(salesLeadsPage.txtF_Business.isDisplayed());
	   Assert.assertTrue(salesLeadsPage.txtF_VerticalDDown.isDisplayed());
	   Assert.assertTrue(salesLeadsPage.txtF_ZipCodes.isDisplayed());
	}

	@When("User enters a value for the Vertical filter")
	public void user_enters_a_value_for_the_Vertical_filter() throws Exception {
	  salesLeadsPage.sendKeysToWebElement(salesLeadsPage.txtF_VerticalDDown, "Italian");
	  salesLeadsPage.waitAndClickElement(salesLeadsPage.verticalOption("Italian"));
	  salesLeadsPage.waitAndClickElement(salesLeadsPage.txtF_Business);
	}

	@Then("Appointments records based on the vertical filter are displayed")
	public void appointments_records_based_on_the_vertical_filter_are_displayed() throws InterruptedException {;
	  Assert.assertTrue(salesLeadsPage.getNumberOfElements(salesLeadsPage.veriticalOptionLocator("Italian")) >= 0);
	  salesLeadsPage.waitAndClickElement(salesLeadsPage.filterOptionRemoveBtn("Italian"));
	}
	
	@When("User clicks the Card view button")
	public void user_clicks_the_Card_view_button() throws Exception {
		salesLeadsPage.waitAndClickElement(salesLeadsPage.btn_CardView);
	}

	@Then("the records are presented in card view")
	public void the_records_are_presented_in_card_view() {
	  Assert.assertTrue(salesLeadsPage.cardView.isDisplayed());
	}
	
	@Then("User enters a value for vertical filter")
	public void user_enters_a_value_for_vertical_filter() throws Exception {
		salesLeadsPage.sendKeysToWebElement(salesLeadsPage.txtF_VerticalDDown, "Italian");
		  salesLeadsPage.waitAndClickElement(salesLeadsPage.verticalOption("Italian"));
		  Assert.assertTrue(salesLeadsPage.getNumberOfElements(salesLeadsPage.veriticalOptionLocator("Italian")) >= 0);
	}
	
//	@Verify-admin-can-toggle-the-view-of-"Appointments-Set"-page-to-show-as-Table-or-Tiles-view
	@Then("User verifies the toggle view buttons are displayed")
	public void user_verifies_the_toggle_view_buttons_are_displayed() {
	   Assert.assertTrue(salesLeadsPage.btn_ListView.isDisplayed());
	   Assert.assertTrue(salesLeadsPage.btn_CardView.isDisplayed());
	   Assert.assertTrue(salesLeadsPage.btn_CalendarView.isDisplayed());
	}

	@Then("User verifies that the current view")
	public void user_verifies_that_the_current_view() {
	 Assert.assertTrue(salesLeadsPage.isElementVisible(salesLeadsPage.getLISTVIEW()));
	 Assert.assertFalse(salesLeadsPage.isElementVisible((salesLeadsPage.getCARDVIEW())));
	 Assert.assertFalse(salesLeadsPage.isElementVisible((salesLeadsPage.getCALENDARVIEW())));
	}

	@Then("the records are displayed in card format")
	public void the_records_are_displayed_in_card_format() {
		Assert.assertFalse(salesLeadsPage.isElementVisible((salesLeadsPage.getLISTVIEW())));
		Assert.assertTrue(salesLeadsPage.isElementVisible(salesLeadsPage.getCARDVIEW()));
		Assert.assertFalse(salesLeadsPage.isElementVisible((salesLeadsPage.getCALENDARVIEW())));
	}

	@When("User clicks the calender view button")
	public void user_clicks_the_calender_view_button() throws Exception {
		salesLeadsPage.waitAndClickElement(salesLeadsPage.btn_CalendarView);
	}

	@Then("the calendar view is displayed")
	public void the_calendar_view_is_displayed() {
		Assert.assertFalse(salesLeadsPage.isElementVisible((salesLeadsPage.getLISTVIEW())));
		Assert.assertFalse(salesLeadsPage.isElementVisible(salesLeadsPage.getCARDVIEW()));
		Assert.assertTrue(salesLeadsPage.isElementVisible((salesLeadsPage.getCALENDARVIEW())));
	}
	
//	Verify-admin-can-toggle-to-"View-all-Leads"-on-Appointments-Set-page
	@Then("User verifies that the View all Lead button is available")
	public void user_verifies_that_the_View_all_Lead_button_is_available() {
		Assert.assertTrue(salesLeadsPage.viewAllLeads.isDisplayed());
	}

	@Then("User verifies that all leads are displayed by default")
	public void user_verifies_that_all_leads_are_displayed_by_default() {
		Actions actions = new Actions(driver);
		actions.moveToElement(salesLeadsPage.viewAllLeads).perform();
		Assert.assertEquals(salesLeadsPage.getViewLeadsOff(), salesLeadsPage.viewAllLeadsTooltip.getAttribute("tooltip"));
	}

	@When("User clicks on the view all leads toggle")
	public void user_clicks_on_the_view_all_leads_toggle() throws Exception {
		salesLeadsPage.waitAndClickElement(salesLeadsPage.viewAllLeads);
	}

	@Then("tthe toggle tooltip text changes and only leads with previous appts or Offers accepted are displayed")
	public void tthe_toggle_tooltip_text_changes_and_only_leads_with_previous_appts_or_Offers_accepted_are_displayed() {
		Actions actions = new Actions(driver);
		actions.moveToElement(salesLeadsPage.viewAllLeads).perform();
		Assert.assertEquals(salesLeadsPage.getViewLeadsOn(), salesLeadsPage.viewAllLeadsTooltip.getAttribute("tooltip"));
	}


//	@Verify-that-Admin-can-export-the-data-to-CSV-for-"Appointments-Set"-page
	@Then("User verifies the Export CSV button and tooltip")
	public void user_verifies_the_Export_CSV_button_and_tooltip() {
		Assert.assertTrue(salesLeadsPage.btn_ExportCSV.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(salesLeadsPage.viewAllLeads).perform();
		Assert.assertEquals(salesLeadsPage.getExportTooltip(), salesLeadsPage.ExportCSVTooltip.getAttribute("data-title"));
		
	}

	@When("User clicks the Export CSV button")
	public void user_clicks_the_Export_CSV_button() throws Exception {
		salesLeadsPage.waitAndClickElement(salesLeadsPage.btn_ExportCSV);
	}

	@Then("a CSV file is downloaded and user verifies the filename")
	public void a_CSV_file_is_downloaded_and_user_verifies_the_filename() throws Exception {
	  Assert.assertTrue(salesLeadsPage.isFileDownloaded(downloadpath, fileName));
	}

}
