package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminReportPage;
import pageObjects.thrive.AdminTerritoryReportsPage;
import pageObjects.thrive.EditBusinessPage;
import pageObjects.thrive.EditResellerPage;
import pageObjects.thrive.EditUserPage;
import pageObjects.thrive.Tab.ExperienceDDown;
import pageObjects.thrive.Tab.ReportsDDown;
import utils.DriverFactory;

public class AdminResellerAndTerritoryReportPageSteps extends DriverFactory {

	public AdminReportPage adminReportPage = PageFactory.initElements(driver, AdminReportPage.class);
	public AdminTerritoryReportsPage adminTerritoryReportsPage = PageFactory.initElements(driver,
			AdminTerritoryReportsPage.class);
	public EditBusinessPage editBusinessPage = PageFactory.initElements(driver, EditBusinessPage.class);
	public EditResellerPage editResellerPage = PageFactory.initElements(driver, EditResellerPage.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);

	private final String CUSTOMDATE_START = "04/05/2020";
	private final String CUSTOMDATE_END = "04/10/2020";
	private final String RESELLER = "TNTextRewards";
	private final String BUSINESS ="AclateQA";
	private final String CUSTOMDATERANGE = CUSTOMDATE_START + " to " + CUSTOMDATE_END;
	private final String resellerPageNumberText = "3";
	private final String territoryPageNumberText = "3";
	private int defaultPageSize = 0;

// Reports dropdown verification
	@When("User clicks on the Report Menu option on the dashboard")
	public void user_clicks_on_the_Report_Menu_option_on_the_dashboard() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Reports);
	}
	
	@Then("the Reports options are displayed")
	public void the_Reports_options_are_displayed() {
		Assert.assertTrue(reportsDDown.opt_Reseller_Report.isDisplayed());
		Assert.assertTrue(reportsDDown.opt_Territory_Report.isDisplayed());
		Assert.assertTrue(reportsDDown.opt_Streams_Status_Report.isDisplayed());
		Assert.assertTrue(reportsDDown.opt_SSMBG_Status_Report.isDisplayed());
	}


	@When("User clicks the Reseller Report")
	public void user_clicks_the_Reseller_Report() throws Exception {
		reportsDDown.waitAndClickElement(reportsDDown.opt_Reseller_Report);
	}

	@Then("the Reseller Report page is displayed")
	public void the_Reseller_Report_page_is_displayed() throws Exception {
		Assert.assertEquals("Reports", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

// @Verify-that-admin-can-view-all-Reseller-details-along-with-their-Businesses-count,-on-Reseller-Reports-page
	@Then("User verifies the columns on the Report Page")
	public void user_verifies_the_columns_on_the_Report_Page() {
		Assert.assertTrue(adminReportPage.col_Reseller.isDisplayed());
		Assert.assertTrue(adminReportPage.col_ActiveBusinesses.isDisplayed());
		Assert.assertTrue(adminReportPage.col_NewBusiness.isDisplayed());
		Assert.assertTrue(adminReportPage.col_CanceledBusinesses.isDisplayed());
		Assert.assertTrue(adminReportPage.col_PeriodNetBusinesses.isDisplayed());
		Assert.assertTrue(commonElementLocator.lbl_ShowEntries.isDisplayed());
		Assert.assertTrue(commonElementLocator.lbl_PaginationTotal.isDisplayed());
	}

//	@SMSM-178 @Verify-that-Admin-is-able-to-filter-the-Reports-with-Date-Range-for-Resellers
	@When("User clicks the Date Range Picker from the page")
	public void user_clicks_the_Date_Range_Picker_from_the_page() throws Exception {
		adminReportPage.waitAndClickElement(adminReportPage.txtF_SearchDate);
	}

	@Then("the Date Picker window is opened")
	public void the_Date_Picker_window_is_opened() {
		Assert.assertTrue(adminReportPage.win_DatePicker.isDisplayed());
	}

	@When("User clicks on the Last Month option")
	public void user_clicks_on_the_Last_Month_option() throws Exception {
		adminReportPage.waitAndClickElement(adminReportPage.btn_LastMonth);
	}

	@Then("the Date Range and records are updated")
	public void the_Date_Range_and_records_are_updated() {
		System.out.println(adminReportPage.getLastMonthInRange());
		Assert.assertTrue(adminReportPage.txtF_SearchDate.getAttribute("value")
				.contentEquals(adminReportPage.getLastMonthInRange()));
		// Note, I cannot check changes in data because our data is currently static
	}

	@When("User enters a custom range and clicks the Apply button")
	public void user_enters_a_custom_range_and_clicks_the_Apply_button() throws Exception {
		adminReportPage.waitAndClickElement(adminReportPage.txtF_SearchDate);
		adminReportPage.sendKeysToWebElement(adminReportPage.txtF_From, CUSTOMDATE_START);
		adminReportPage.sendKeysToWebElement(adminReportPage.txtF_To, CUSTOMDATE_END);
		adminReportPage.waitAndClickElement(adminReportPage.btn_Apply);
	}

	@Then("the Date Range and records are updated as per the date specified")
	public void the_Date_Range_and_records_are_updated_as_per_the_date_specified() {
		Assert.assertTrue(adminReportPage.txtF_SearchDate.getAttribute("value").contentEquals(CUSTOMDATERANGE));
		// Note, I cannot check changes in data because our data is currently static
	}

// @Verify-functionality-of-Show-entries-drop-down-and-sorting-on-"Reports"-page-for-Licensees
	@When("User clicks the Reseller column title to sort by Reseller in ascending order")
	public void user_clicks_the_Reseller_column_title_to_sort_by_Reseller_in_ascending_order() throws Exception {
		adminReportPage.waitAndClickElement(adminReportPage.col_ResellerArrowIcon);
	}

	@Then("the reports are sorted in ascending order")
	public void the_reports_are_sorted_in_ascending_order() throws Exception {
		Assert.assertTrue(adminReportPage.getFirstRowRecordResellerName("212Insider").isDisplayed());
	}

	@When("User clicks the Reseller column title to sort by Reseller in descending order")
	public void user_clicks_the_Reseller_column_title_to_sort_by_Reseller_in_descending_order() throws Exception {
		adminReportPage.waitAndClickElement(adminReportPage.col_ResellerArrowIcon);
	}

	@Then("the reports are sorted in descending order")
	public void the_reports_are_sorted_in_descending_order() {
		Assert.assertTrue(adminReportPage.getFirstRowRecordResellerName("YourVIPRewards").isDisplayed());
	}

	@Then("User verifies the default number of records displayed")
	public void user_verifies_the_default_number_of_records_displayed() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("10"));
		defaultPageSize = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	}

	@Then("User navigates to anoother page")
	public void user_navigates_to_anoother_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.pageButton(resellerPageNumberText));
		Assert.assertEquals(Integer.parseInt(resellerPageNumberText) * defaultPageSize,
				Integer.parseInt((commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd))));
	}

//  @Verify-Admin-is-able-to-search-the-Licensee-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search
	@When("User enters a valid search criteria ino the search box and click search")
	public void user_enters_a_valid_search_criteria_ino_the_search_box_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "915Rewards");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the reseller record is displayed")
	public void the_reseller_record_is_displayed() {
		Assert.assertTrue(adminReportPage.getFirstRowRecordResellerName("915Rewards").isDisplayed());
	}

	@When("User enters an invalid search criteria into the search box and click search")
	public void user_enters_an_invalid_search_criteria_into_the_search_box_and_click_search() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Invalid");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("No record is displayed")
	public void no_record_is_displayed() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("0"));
	}

//	@Verify-the-Help-on-"Reports"-page-for-Licensees-by-clicking-the-Help-button
	@When("User clicks on the Help button on the Resellers page")
	public void user_clicks_on_the_Help_button_on_the_Resellers_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("a tour guide for is opened")
	public void a_tour_guide_for_is_opened() throws Exception {
		Assert.assertEquals("Reports", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the Next button from the Reports window")
	public void user_clicks_on_the_Next_button_from_the_Reports_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Data Range window is opened")
	public void the_Data_Range_window_is_opened() throws InterruptedException {
		Assert.assertEquals("Date Range", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the previous button from the Data Rage window")
	public void user_clicks_on_the_previous_button_from_the_Data_Rage_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the tour guide is navigate back to the Reports window")
	public void the_tour_guide_is_navigate_back_to_the_Reports_window() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Reports", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	@Verify-that-admin-can-view-all-Reseller-details-along-with-Business,-City,-State,-Postal-Code,-Country,-Action,-on-"Territory-Report"-page
	@When("User clicks the Territory Report")
	public void user_clicks_the_Territory_Report() throws Exception {
		reportsDDown.waitAndClickElement(reportsDDown.opt_Territory_Report);
	}

	@Then("the Territory Report page is displayed")
	public void the_Territory_Report_page_is_displayed() throws Exception {
		Assert.assertEquals("Territory Report", commonElementLocator.getElementText(commonElementLocator.pag_Title));
		;
	}

	@Then("User verifies the column headers on the Territory Report page")
	public void user_verifies_the_column_headers_on_the_Territory_Report_page() {
		Assert.assertTrue(adminTerritoryReportsPage.col_Reseller.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_Businesses.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_City.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_State.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_PostalCode.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_Country.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.col_Action.isDisplayed());
	}

//	@Verify-that-Admin-is-able-to-filter-the-Territory-reports-by-clicking-on-Allowed,-Disallowed-&-All-tab
	@Then("User verifies the button for filtering on the Territory Reports")
	public void user_verifies_the_button_for_filtering_on_the_Territory_Reports() {
		Assert.assertTrue(adminTerritoryReportsPage.btn_AllowedTab.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.btn_DisallowedTab.isDisplayed());
		Assert.assertTrue(adminTerritoryReportsPage.btn_AllTab.isDisplayed());
	}

	@When("User clicks on the Allowed report filter")
	public void user_clicks_on_the_Allowed_report_filter() throws Exception {
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.btn_AllowedTab);
	}

	@Then("user verifies that the Allowed button is active")
	public void user_verifies_that_the_Allowed_button_is_active() {
		Assert.assertTrue(adminTerritoryReportsPage.btn_AllowedTab.getAttribute("class").contains("active"));
		// Data changes cannot be verified at the moment because of the static nature of
		// our data
	}

	@When("User clicks Disallowed report filter")
	public void user_clicks_Disallowed_report_filter() throws Exception {
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.btn_DisallowedTab);
	}

	@Then("user verifies that the Disallowed button is active")
	public void user_verifies_that_the_Disallowed_button_is_active() {
		Assert.assertTrue(adminTerritoryReportsPage.btn_DisallowedTab.getAttribute("class").contains("active"));
		// Data changes cannot be verified at the moment because of the static nature of
		// our data
	}

	@When("User clicks All report filter")
	public void user_clicks_All_report_filter() throws Exception {
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.btn_AllTab);
	}

	@Then("user verifies that the All button is active")
	public void user_verifies_that_the_All_button_is_active() {
		Assert.assertTrue(adminTerritoryReportsPage.btn_AllTab.getAttribute("class").contains("active"));
		// Data changes cannot be verified at the moment because of the static nature of
		// our data
	}

//	@Verify-functionality-of-sorting-and-Show-entries-dropdown-and-pagination-on-"Territory-Report"-page
	@When("User clicks the Reseller column title to sort by Teritory Report in ascending order")
	public void user_clicks_the_Reseller_column_title_to_sort_by_Teritory_Report_in_ascending_order() throws Exception {
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.col_Reseller);
	}

	@Then("the Territory reports are sorted in ascending order")
	public void the_Territory_reports_are_sorted_in_ascending_order() {
		Assert.assertTrue(adminTerritoryReportsPage.getFirstRowRecordResellerName("309VIP").isDisplayed());
	}

	@When("User clicks the Reseller column title to sort by Territory Report in descending order")
	public void user_clicks_the_Reseller_column_title_to_sort_by_Territory_Report_in_descending_order()
			throws Exception {
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.col_Reseller);
	}

	@Then("the Territory reports are sorted in descending order")
	public void the_Territory_reports_are_sorted_in_descending_order() {
		Assert.assertTrue(adminTerritoryReportsPage.getFirstRowRecordResellerName("WestchesterLoyalty").isDisplayed());
	}

	@Then("User verifies the default number of records is displayed for Territory reports")
	public void user_verifies_the_default_number_of_records_is_displayed_for_Territory_reports()
			throws InterruptedException {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("10"));
		defaultPageSize = Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	}

	@Then("User navigates to anoother page on the territory page")
	public void user_navigates_to_anoother_page_on_the_territory_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.pageButton(territoryPageNumberText));
		Assert.assertEquals(Integer.parseInt(territoryPageNumberText) * defaultPageSize,
				Integer.parseInt((commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd))));

	}

//	@Verify-Admin-is-able-to-search-the-"Territory-Reports"-by-entering-a-search-criteria-in-Search-box-and-clicking-Search
	@When("User enters a valid search criteria ino the search box on Territory report page and click search")
	public void user_enters_a_valid_search_criteria_ino_the_search_box_on_Territory_report_page_and_click_search()
			throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the reseller record is displayed on the Territory report page")
	public void the_reseller_record_is_displayed_on_the_Territory_report_page() {
		Assert.assertTrue(adminReportPage.getFirstRowRecordResellerName("AutomationQA").isDisplayed());
	}

	@When("User enters an invalid search criteria into the search box on the Territory page and click search")
	public void user_enters_an_invalid_search_criteria_into_the_search_box_on_the_Territory_page_and_click_search()
			throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Invalid");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("No record is displayed on the Territory page")
	public void no_record_is_displayed_on_the_Territory_page() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd).contentEquals("0"));
	}

//	@Verify-the-Help-on-"Territory-Reports"-page-by-clicking-the-Help-button
	@When("User clicks on the Help button on the Territory Reports page")
	public void user_clicks_on_the_Help_button_on_the_Territory_Reports_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("a tour guide for Territory Report is launched")
	public void a_tour_guide_for_Territory_Report_is_launched() throws Exception {
		Assert.assertEquals("Licensee Territory Report",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the Next button from the Licensee Territory Report window")
	public void user_clicks_on_the_Next_button_from_the_Licensee_Territory_Report_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Filter Report window is opened")
	public void the_Filter_Report_window_is_opened() throws Exception {
		commonElementLocator.WaitUntilWebElementIsVisible(commonElementLocator.mod_Help_Title);
		Assert.assertEquals("Filter Report", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks on the previous button from the Filter Report window")
	public void user_clicks_on_the_previous_button_from_the_Filter_Report_window() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("the tour guide is navigate back to the Licensee Territory Report window")
	public void the_tour_guide_is_navigate_back_to_the_Licensee_Territory_Report_window() throws Exception {
		Assert.assertEquals("Licensee Territory Report",
				commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

//	@Verify-Admin-is-able-to-Allow/Disallow-a-Reseller-under-Territory-report
	@When("User clicks the Allow button under the Action column for Reseller")
	public void user_clicks_the_Allow_button_under_the_Action_column_for_Reseller() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, RESELLER);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminTerritoryReportsPage
				.waitAndClickElement(adminTerritoryReportsPage.clickAllowOrDisallowResellerBtn(RESELLER));
	}

	@Then("the Action column for the specified Reseller gets changed to Disallow")
	public void the_Action_column_for_the_specified_Reseller_gets_changed_to_Disallow() throws Exception {
		Thread.sleep(500);
		Assert.assertTrue(adminTerritoryReportsPage.btn_Disallow.isDisplayed());
	}

	@When("User clicks the Disallow button under the Action column for Reseller")
	public void user_clicks_the_Disallow_button_under_the_Action_column_for_Reseller() throws Exception {
		adminTerritoryReportsPage
				.waitAndClickElement(adminTerritoryReportsPage.clickAllowOrDisallowResellerBtn(RESELLER));
		;
	}

	@Then("the Action column for the specified Reseller gets changed to Allow")
	public void the_Action_column_for_the_specified_Reseller_gets_changed_to_Allow() {
		Assert.assertTrue(adminTerritoryReportsPage.btn_Allow.isDisplayed());
	}

//	@Verify-Admin-can-edit-the-Reseller-details-from-Territory-report-page
	@When("User clicks the drop down button under Action column and clicks Edit Reseller")
	public void user_clicks_the_drop_down_button_under_Action_column_and_clicks_Edit_Reseller() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, RESELLER);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickActionDDown(RESELLER));
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickResellerAction(RESELLER));
	}

	@Then("User is redirected to Edit Reseller page")
	public void user_is_redirected_to_Edit_Reseller_page() throws Exception {
		Assert.assertEquals("Edit Reseller", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User makes changes and clicks the Save Reseller")
	public void user_makes_changes_and_clicks_the_Save_Reseller() throws Exception {
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessName, RESELLER + "_Edited");
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_SubdomainBase, RESELLER + "1" + ".com");
		editResellerPage.waitAndClickElement(editResellerPage.btn_Save_Reseller);
	}

	@Then("the Reseller is updated successfully")
	public void the_Reseller_is_updated_successfully() throws Exception {
		Assert.assertEquals("×\nClose\nThis company has been successfully updated.",
				editResellerPage.getElementText(editResellerPage.alert_SuccessNotification));
	}

	@Then("user confirms the changes made to Reseller were saved correctly")
	public void user_confirms_the_changes_made_to_Reseller_were_saved_correctly() throws Exception {
		driver.navigate().back();
		driver.navigate().back();
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, RESELLER + "_Edited");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickActionDDown(RESELLER + "_Edited"));
		adminTerritoryReportsPage
				.waitAndClickElement(adminTerritoryReportsPage.clickResellerAction(RESELLER + "_Edited"));
		Assert.assertTrue(editResellerPage.txtF_BusinessName.getAttribute("value").contentEquals(RESELLER + "_Edited"));
		Assert.assertTrue(editResellerPage.txtF_SubdomainBase.getAttribute("value").contentEquals(RESELLER.toLowerCase() + "1" + ".com"));
	}
	
	@Then("User revert the changes made to Reseller.")
	public void user_revert_the_changes_made_to_Reseller() throws Exception {
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_BusinessName, RESELLER);
		editResellerPage.sendKeysToWebElement(editResellerPage.txtF_SubdomainBase, RESELLER.toLowerCase() + ".com");
		editResellerPage.waitAndClickElement(editResellerPage.btn_Save_Reseller);
	}

//	@Verify-Admin-can-edit-the-Business-details-from-Territory-report-page
	@When("User clicks the drop down button under Action column and clicks Edit Business")
	public void user_clicks_the_drop_down_button_under_Action_column_and_clicks_Edit_Business() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, RESELLER);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickActionDDown(RESELLER));
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickResellerAction(BUSINESS));
	}

	@Then("User is redirected to Edit Business page")
	public void user_is_redirected_to_Edit_Business_page() throws Exception {
		Assert.assertEquals("Edit Business", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User makes changes to Business and clicks the Save Business")
	public void user_makes_changes_to_Business_and_clicks_the_Save_Business() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessName, BUSINESS + "_Edited");
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Mexican\""));
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}
		
	@Then("the Business is updated successfully")
	public void the_Business_is_updated_successfully() throws Exception {
		Assert.assertEquals("×\nClose\nThis company has been successfully updated.",
				editResellerPage.getElementText(editResellerPage.alert_SuccessNotification));
	}

	@Then("user confirms the changes made to Business were saved correctly")
	public void user_confirms_the_changes_made_to_Business_were_saved_correctly() throws Exception {
		driver.navigate().back();
		driver.navigate().back();
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, RESELLER);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		adminTerritoryReportsPage.waitAndClickElement(adminTerritoryReportsPage.clickActionDDown(RESELLER));
		adminTerritoryReportsPage
				.waitAndClickElement(adminTerritoryReportsPage.clickResellerAction(BUSINESS + "_Edited"));
		Assert.assertTrue(editBusinessPage.txtF_BusinessName.getAttribute("value").contentEquals(BUSINESS + "_Edited"));
		Assert.assertTrue(editBusinessPage.getElementText(editBusinessPage.lov_BusinessCategory).contentEquals("Mexican"));
	}

	
	@Then("User revert the changes made to Business.")
	public void user_revert_the_changes_made_to_Business() throws Exception {
		editBusinessPage.sendKeysToWebElement(editBusinessPage.txtF_BusinessName, BUSINESS);
		editBusinessPage.waitAndClickElement(editBusinessPage.lov_BusinessCategory);
		editBusinessPage.waitAndClickElement(editBusinessPage.businessCategoryOpt("\"Restaurant\""));
		editBusinessPage.waitAndClickElement(editBusinessPage.btn_SaveBusiness);
	}

}
