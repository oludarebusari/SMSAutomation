package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreateOrderPage;
import pageObjects.thrive.OrdersPage;
import pageObjects.thrive.ThriveLoginPage;
import pageObjects.thrive.Tab.LeadTrackingDDown;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class OrdersSteps extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CreateOrderPage createOrderPage = PageFactory.initElements(driver, CreateOrderPage.class);
	LeadTrackingDDown leadTrackingDDown = PageFactory.initElements(driver, LeadTrackingDDown.class);
	OrdersPage ordersPage = PageFactory.initElements(driver, OrdersPage.class);
	ThriveLoginPage thrLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);
	
//	 @Accessing-Orders-page-with-user-having-“Create/Update-Orders”-permission
	@When("User enters a valid username with Create-Update Lead permission")
	public void user_enters_a_valid_username_with_Create_Update_Lead_permission() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_UserName, reader.getConfigValue("LT-CreateUpdateOrders", "username"));
	}

	@When("User enters password for the user with Create-Update Lead Permission")
	public void user_enters_password_for_the_user_with_Create_Update_Lead_Permission() throws Exception {
	   thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_PassWord, reader.getConfigValue("LT-CreateUpdateOrders", "password"));
	}

	@When("User Clicks on the Lead Tracking menu")
	public void user_Clicks_on_the_Lead_Tracking_menu() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_LeadTracking);
	}

	@When("User clicks the Order option")
	public void user_clicks_the_Order_option() throws InterruptedException {
		leadTrackingDDown.waitAndClickElement(leadTrackingDDown.opt_Orders);
	}

	@Then("User is redirected to the Orders page")
	public void user_is_redirected_to_the_Orders_page() throws Exception {
	   Assert.assertEquals("Orders", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies that New button exists on the Orders page")
	public void user_verifies_that_New_button_exists_on_the_Orders_page() {
		Assert.assertTrue(commonElementLocator.btn_New.isDisplayed());
	}

	@Then("User is able to click the Edit button of an Order")
	public void user_is_able_to_click_the_Edit_button_of_an_Order() {
		Assert.assertTrue(ordersPage.isElementClickable(ordersPage.btn_Edit("1222")));
	}

	@Then("User verifies that View Performance option is not available")
	public void user_verifies_that_View_Performance_option_is_not_available() {
		Assert.assertFalse(ordersPage.isElementVisible(ordersPage.getVIEWLEADSLOCATOR()));
	}

//	@Accessing-Orders-page-with-user-having-"Manage-Leads"-permission
	@When("User enters a valid username with Manage Lead tracking permission")
	public void user_enters_a_valid_username_with_Manage_Lead_tracking_permission() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_UserName, reader.getConfigValue("LT-ManageLeads", "username"));
	}

	@When("User enters password for the user with Manage Leads Permission")
	public void user_enters_password_for_the_user_with_Manage_Leads_Permission() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_PassWord, reader.getConfigValue("LT-ManageLeads", "password"));
	}

	@Then("User is able to click the View Leads button of an Order")
	public void user_is_able_to_click_the_View_Leads_button_of_an_Order() {
		Assert.assertTrue(ordersPage.isElementClickable(ordersPage.btn_ViewLeads("1222")));
	}
	
	@Then("User is able to access the View Performance button")
	public void user_is_able_to_access_the_View_Performance_button() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.actionDDown("1222"));
		Assert.assertTrue(ordersPage.actionDDownOpt("1222", "View Performance").isDisplayed());
	}
	
	@Then("User is not able to see New button to create New Order")
	public void user_is_not_able_to_see_New_button_to_create_New_Order() {
	Assert.assertFalse(commonElementLocator.isElementVisible(commonElementLocator.getNEWBTNLOCATOR()));
	}

	@Then("User Verifies that Edit button is not available on the Orders page")
	public void user_Verifies_that_Edit_button_is_not_available_on_the_Orders_page() {
		Assert.assertFalse(ordersPage.isElementVisible(ordersPage.getEDITLOCATOR()));
	}

	@When("User enters a valid username with Create Update and Manage Lead tracking permission")
	public void user_enters_a_valid_username_with_Create_Update_and_Manage_Lead_tracking_permission() throws Exception {
		thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_UserName, reader.getConfigValue("LT-CreateUpdate-ManageLeads", "username"));
	}

	@When("User enters password for the user with Create update and Manage Leads Permission")
	public void user_enters_password_for_the_user_with_Create_update_and_Manage_Leads_Permission() throws Exception {
	  thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_PassWord, reader.getConfigValue("LT-CreateUpdate-ManageLeads", "password"));
	}
	
	@Then("User is able to click the Edit button of an Order on the page")
	public void user_is_able_to_click_the_Edit_button_of_an_Order_on_the_page() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.actionDDown("1222"));
		Assert.assertTrue(ordersPage.isElementClickable(ordersPage.actionDDownOpt("1222", "Edit")));
	}

	@Then("User does not have access to the View Performance option")
	public void user_does_not_have_access_to_the_View_Performance_option() throws Exception {
	   ordersPage.waitAndClickElement(ordersPage.actionDDown("1222"));
	   Assert.assertFalse(ordersPage.isElementVisible(ordersPage.getVIEWPERFORMANCELOCATOR()));
	}

//	@Accessing-Orders-page-with-user-not-having-any-of-“Manage-Leads”-or-“Create/Update-Orders”-permissions
	@When("User enters a valid username without Create Update and Manage Lead tracking permission")
	public void user_enters_a_valid_username_without_Create_Update_and_Manage_Lead_tracking_permission() throws Exception {
	   thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_UserName, reader.getConfigValue("LT-ViewPerformance", "username"));
	}

	@When("User enters password for the user without Create update and Manage Leads Permission")
	public void user_enters_password_for_the_user_without_Create_update_and_Manage_Leads_Permission() throws Exception {
	   thrLoginPage.sendKeysToWebElement(thrLoginPage.txtF_PassWord, reader.getConfigValue("LT-ViewPerformance", "password"));
	}
	
	@Then("User verifies that the Orders option is not displayed")
	public void user_verifies_that_the_Orders_option_is_not_displayed() {
		Assert.assertFalse(leadTrackingDDown.isElementVisible(leadTrackingDDown.getORDERSLOCATOR()));
	}
	
//	@Verify-the-options-available-on-Orders-page
	@Then("User verifies that New button is available")
	public void user_verifies_that_New_button_is_available() {
		Assert.assertTrue(commonElementLocator.btn_New.isDisplayed());
	}

	@Then("User verifies that Status filter is available")
	public void user_verifies_that_Status_filter_is_available() {
		Assert.assertTrue(ordersPage.lov_Status.isDisplayed());
	}

	@Then("User verifies that Order field is available")
	public void user_verifies_that_Order_field_is_available() {
	  Assert.assertTrue(ordersPage.lov_Order.isDisplayed());
	}

	@Then("User verifies that Next-Prevoius buttons are available")
	public void user_verifies_that_Next_Prevoius_buttons_are_available() {
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_PaginationNext.isDisplayed());
	}

	@Then("User verifies ShownEntries is available")
	public void user_verifies_ShownEntries_is_available() {
	   Assert.assertTrue(commonElementLocator.lov_ShowEntries.isDisplayed());
	}
	
	@Then("User enters a reseller name and select the Reseller")
	public void user_enters_a_reseller_name_and_select_the_Reseller() throws Exception {
		ordersPage.sendKeysToWebElement(ordersPage.lov_Reseller, "108rewards");
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Active"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Active"));
	}
	
	
//	@Search-Order-using-Status
	@When("User selects Active Status")
	public void user_selects_Active_Status() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Active"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Active"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User verifies only Active orders are displayed")
	public void user_verifies_only_Active_orders_are_displayed() throws Exception {
		Assert.assertEquals(83, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}
	
	@When("User selects Cancelled Status")
	public void user_selects_Cancelled_Status() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Active"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Cancelled"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User verifies only Cancelled orders are displayed")
	public void user_verifies_only_Cancelled_orders_are_displayed() throws Exception, Exception {
		Assert.assertEquals(938, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}

	@When("User selects Complete Status")
	public void user_selects_Complete_Status() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Cancelled"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Complete"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User verifies only Completed orders are displayed")
	public void user_verifies_only_Completed_orders_are_displayed() throws Exception, InterruptedException {
		Assert.assertEquals(111, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}

	@When("User selects Fulfilled Status")
	public void user_selects_Fulfilled_Status() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Complete"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Fulfilled"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User verifies only Fulfilled orders are displayed")
	public void user_verifies_only_Fulfilled_orders_are_displayed() throws Exception, InterruptedException {
		Assert.assertEquals(148, Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)));
	}
	
// 	@Search-Order-using-Order-number
	@When("User selects an Order number")
	public void user_selects_an_Order_number() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.removeStatusOpt("Active"));
		ordersPage.waitAndClickElement(ordersPage.lov_Status);
		ordersPage.waitAndClickElement(ordersPage.statusOpt("Fulfilled"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
		ordersPage.waitAndClickElement(ordersPage.lov_Order);
		ordersPage.waitAndClickElement(ordersPage.orderOpt("111"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("User verifies that order is displayed based on the search criteria")
	public void user_verifies_that_order_is_displayed_based_on_the_search_criteria() throws Exception {
	   Assert.assertTrue(ordersPage.selectOrder("111").isDisplayed());
	}
	
//	@Sort-results
	@When("User clicks on the Order title")
	public void user_clicks_on_the_Order_title() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.col_Order);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Order title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Order_title() {
	   Assert.assertTrue(ordersPage.firstOrderInASortedList("1191").isDisplayed());
	}

	@When("User clicks on the Order title again")
	public void user_clicks_on_the_Order_title_again() throws Exception {
		ordersPage.waitAndClickElement(ordersPage.col_Order);
	}

	@Then("User verifies that the records are sorted in descending order based on the Order title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Order_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("1295").isDisplayed());
	}
	
	@Then("User resets the record to it's original state")
	public void user_resets_the_record_to_it_s_original_state() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_LeadTracking);
		leadTrackingDDown.waitAndClickElement(leadTrackingDDown.opt_Orders);
	}

	@When("User clicks on the Busines Name title")
	public void user_clicks_on_the_Busines_Name_title() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_BusinessName);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Business Name title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Business_Name_title() throws InterruptedException {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("108rewards").isDisplayed());
	}

	@When("User clicks on the Business Name title again")
	public void user_clicks_on_the_Business_Name_title_again() throws InterruptedException {
	   ordersPage.waitAndClickElement(ordersPage.col_BusinessName);
	}

	@Then("User verifies that the records are sorted in descending order based on the Business Name title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Business_Name_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("test nawaz").isDisplayed());
	}

	@When("User clicks on the Progress title")
	public void user_clicks_on_the_Progress_title() throws Exception {
	   ordersPage.waitAndClickElement(ordersPage.col_Progress);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Progress title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Progress_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("0%").isDisplayed());
	}

	@When("User clicks on the Progress title again")
	public void user_clicks_on_the_Progress_title_again() throws Exception {
		 ordersPage.waitAndClickElement(ordersPage.col_Progress);
	}

	@Then("User verifies that the records are sorted in descending order based on the Progress title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Progress_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("100%").isDisplayed());
	}

	@When("User clicks on the Due date title")
	public void user_clicks_on_the_Due_date_title() throws InterruptedException {
	  ordersPage.waitAndClickElement(ordersPage.col_Due);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Due date title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Due_date_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("12/31/2019").isDisplayed());
	}

	@When("User clicks on the Due date title again")
	public void user_clicks_on_the_Due_date_title_again() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Due);
	}

	@Then("User verifies that the records are sorted in descending order based on the Due date title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Due_date_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("04/12/2022").isDisplayed());
	}

	@When("User clicks on the Appointment title")
	public void user_clicks_on_the_Appointment_title() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Appointments);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Appointment title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Appointment_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("0").isDisplayed());
	}

	@When("User clicks on the Appointment title again")
	public void user_clicks_on_the_Appointment_title_again() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Appointments);
	}

	@Then("User verifies that the records are sorted in descending order based on the Appointment title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Appointment_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("44").isDisplayed());
	}

	@When("User clicks on the Required title")
	public void user_clicks_on_the_Required_title() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Required);
	}

	@Then("user verifies that the records are sorted in ascending order based on the Required title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Required_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("1").isDisplayed());
	}

	@When("User clicks on the Required title again")
	public void user_clicks_on_the_Required_title_again() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Required);
	}

	@Then("User verifies that the records are sorted in descending order based on the Required title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Required_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("1000").isDisplayed());
	}

	@When("User clicks on the Leads title")
	public void user_clicks_on_the_Leads_title() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Leads);
	}

	
	@Then("user verifies that the records are sorted in ascending order based on the Leads title")
	public void user_verifies_that_the_records_are_sorted_in_ascending_order_based_on_the_Leads_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("0").isDisplayed());
	}

	@When("User clicks on the Leads title again")
	public void user_clicks_on_the_Leads_title_again() throws InterruptedException {
		ordersPage.waitAndClickElement(ordersPage.col_Leads);
	}

	@Then("User verifies that the records are sorted in descending order based on the Leads title")
	public void user_verifies_that_the_records_are_sorted_in_descending_order_based_on_the_Leads_title() {
		Assert.assertTrue(ordersPage.firstOrderInASortedList("12,938").isDisplayed());
	}
	
	
//	@Accessing-Create-Order-page-with-a-user-having-“Create/Update-Orders”-permission
	@Then("User is redirected to the Create Order Page")
	public void user_is_redirected_to_the_Create_Order_Page() throws Exception {
		Assert.assertEquals("Create Order",  commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-fields/Options-available-on-Create-Order-page
	@Then("User clicks on the New button on the Create Order page")
	public void user_clicks_on_the_New_button_on_the_Create_Order_page() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("User verifies the available fields on the Create Order page")
	public void user_verifies_the_available_fields_on_the_Create_Order_page() throws InterruptedException {
		Assert.assertTrue(createOrderPage.businessNameDDown.isDisplayed());
		Assert.assertTrue(createOrderPage.orderTypeDDown.isDisplayed());
		createOrderPage.waitAndClickElement(createOrderPage.orderTypeDDown);
		createOrderPage.WaitUntilWebElementIsVisible(createOrderPage.orderTypeOption("Engage"));
		Assert.assertTrue(createOrderPage.orderTypeOption("Engage").isDisplayed());
		Assert.assertTrue(createOrderPage.orderTypeOption("Thrive").isDisplayed());
		Assert.assertTrue(createOrderPage.orderTypeOption("Lead Tracking").isDisplayed());
		Assert.assertTrue(createOrderPage.txtF_StartDate.isDisplayed());
		Assert.assertTrue(createOrderPage.txtF_DueDate.isDisplayed());
		Assert.assertTrue(createOrderPage.txtF_Appointments.isDisplayed());
		Assert.assertTrue(createOrderPage.txtArea_Notes.isDisplayed());
		Assert.assertTrue(createOrderPage.verticalsDDown.isDisplayed());
		Assert.assertTrue(createOrderPage.postalCodesDDown.isDisplayed());
		Assert.assertTrue(createOrderPage.averageRatingDDOwn.isDisplayed());
	}
	
	
//	Verify-validation-message-for-mandatory-fields
	@Then("User clicks the Acquire Leads button leaving all the Mandatory fields empty")
	public void user_clicks_the_Acquire_Leads_button_leaving_all_the_Mandatory_fields_empty() throws InterruptedException {
	   createOrderPage.waitAndClickElement(createOrderPage.btn_AcquireLeads);
	}
	
	@Then("User verifies that error messages appears below the Mandatory fields")
	public void user_verifies_that_error_messages_appears_below_the_Mandatory_fields() throws InterruptedException {
		Assert.assertTrue(createOrderPage.errorMsg_OrderType.isDisplayed());
		Assert.assertTrue(createOrderPage.errorMsg_Appointments.isDisplayed());
		Assert.assertTrue(createOrderPage.errorMsg_DueDate.isDisplayed());
		Assert.assertTrue(createOrderPage.errorMsg_Verticals.isDisplayed());
	}
	
	@Then("User verifies that the Acquire Leads button is disabled")
	public void user_verifies_that_the_Acquire_Leads_button_is_disabled() throws Exception {
		Assert.assertFalse(createOrderPage.btn_AcquireLeads.isEnabled());
	}

	@When("User enters valid input into the Mandatory fields")
	public void user_enters_valid_input_into_the_Mandatory_fields() throws Exception {
		createOrderPage.waitAndClickElement(createOrderPage.orderTypeDDown);
		createOrderPage.waitAndClickElement(createOrderPage.orderTypeOption("Thrive"));
		createOrderPage.sendKeysToWebElement(createOrderPage.txtF_Appointments, "1");
		createOrderPage.waitAndClickElement(createOrderPage.txtF_DueDate);
		createOrderPage.waitAndClickElement(createOrderPage.btn_DueDateNextMonth);
    	createOrderPage.waitAndClickElement(createOrderPage.calendarDay("5"));
    	createOrderPage.waitAndClickElement(createOrderPage.verticalsDDown);
    	createOrderPage.waitAndClickElement(createOrderPage.selectVertical("Arcades"));
    	commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}
	
	@Then("User verifies error messages are not displayed")
	public void user_verifies_error_messages_are_not_displayed() throws Exception {
	 Assert.assertFalse(createOrderPage.isElementVisible(createOrderPage.getORDERTYPEERRORMSGLOCATOR()));
	 Assert.assertFalse(createOrderPage.isElementVisible(createOrderPage.getAPPOITNMENTERRORMSGLOCATOR()));
	 Assert.assertFalse(createOrderPage.isElementVisible(createOrderPage.getDUEDATEERRORMSGLOCATOR()));
	 Assert.assertFalse(createOrderPage.isElementVisible(createOrderPage.getVERTICALSERRORMSGLOCATOR()));
	}
	
	@Then("User verifies that Acquire Leads button is enablled")
	public void user_verifies_that_Acquire_Leads_button_is_enablled() {
		Assert.assertTrue(createOrderPage.btn_AcquireLeads.isEnabled());
	}
	
	
//	@Create-a-new-Order
	@When("User selects a business name")
	public void user_selects_a_business_name() {
	
	}

	@When("User selects all available Order types")
	public void user_selects_all_available_Order_types() {

	}

	@When("User selects a Start date")
	public void user_selects_a_Start_date() {
	
	}

	@When("User selects a Due date")
	public void user_selects_a_Due_date() {
	 
	}

	@When("User enters an appointment limit")
	public void user_enters_an_appointment_limit() {
	 
	}

	@When("User a Vertical")
	public void user_a_Vertical() {
	 
	}

	@When("User enters a postal code")
	public void user_enters_a_postal_code() {
	
	}

	@When("User selects At Least {int} for Number of reviews")
	public void user_selects_At_Least_for_Number_of_reviews(Integer int1) {
	 
	}

	@When("User selects At least {int} for Average ratings")
	public void user_selects_At_least_for_Average_ratings(Integer int1) {
	 
	}

	@When("User clicks the Acquire Leads button")
	public void user_clicks_the_Acquire_Leads_button() {

	}

	@Then("User verifies the notification message displayed about the order")
	public void user_verifies_the_notification_message_displayed_about_the_order() {
	 
	}

	@When("User navigates to Lead Tracking")
	public void user_navigates_to_Lead_Tracking() {
	  
	}
	
}
