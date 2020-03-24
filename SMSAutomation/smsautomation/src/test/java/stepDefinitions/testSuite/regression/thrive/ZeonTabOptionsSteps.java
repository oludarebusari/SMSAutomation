package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreateOrder;
import pageObjects.thrive.OrdersPage;
import pageObjects.thrive.SalesAppointmentsPage;
import pageObjects.thrive.Tab.ZeonDDown;
import pageObjects.thrive.modal.DateSelectionModal;
import utils.DriverFactory;

public class ZeonTabOptionsSteps extends DriverFactory {

	public ZeonTabOptionsSteps() throws IOException {
		super();
	}

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CreateOrder createOrder = PageFactory.initElements(driver, CreateOrder.class);
	DateSelectionModal dateSelectionModal = PageFactory.initElements(driver, DateSelectionModal.class);
	OrdersPage ordersPage = PageFactory.initElements(driver, OrdersPage.class);
	SalesAppointmentsPage salesAppointmentsPage = PageFactory.initElements(driver, SalesAppointmentsPage.class);
	ZeonDDown zeonDDown = PageFactory.initElements(driver, ZeonDDown.class);

	@When("User clicks Zeon from the top menu bar")
	public void user_clicks_Zeon_from_the_top_menu_bar() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Zeon);
	}

	@Then("the Zeon menu is expanded and Zeon options are displayed")
	public void the_Zeon_menu_is_expanded_and_Zeon_options_are_displayed() {
		Assert.assertTrue(zeonDDown.opt_Orders.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Entertainment_Deals.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Leads_By_Appointment.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Verify_Appointments.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Sales_Work_Orders.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Sales_Appointment_List.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Do_Not_Call_List.isDisplayed());
		Assert.assertTrue(zeonDDown.opt_Caller_Ids.isDisplayed());
	}

	@When("User clicks on the Sales Appointment List option")
	public void user_clicks_on_the_Sales_Appointment_List_option() throws Exception {
		zeonDDown.waitAndClickElement(zeonDDown.opt_Sales_Appointment_List);
	}

	@Then("User is redirected to the Overall Appointments Set page")
	public void user_is_redirected_to_the_Overall_Appointments_Set_page() throws Exception {
		Assert.assertEquals("Overall Appointments Set",
				commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks the date textfield, and specify a date and clicks the Apply button")
	public void user_clicks_the_date_textfield_and_specify_a_date_and_clicks_the_Apply_button() throws Exception {
		salesAppointmentsPage.waitAndClickElement(salesAppointmentsPage.txtF_DateRange);
		dateSelectionModal.sendKeysToWebElement(dateSelectionModal.txtF_From, "");
		dateSelectionModal.sendKeysToWebElement(dateSelectionModal.txtF_From, "06/03/2019");
		dateSelectionModal.sendKeysToWebElement(dateSelectionModal.txtF_To, "06/10/2019");
		dateSelectionModal.waitAndClickElement(dateSelectionModal.btn_Apply);
	}

	@Then("User get overall appointments set displayed")
	public void user_get_overall_appointments_set_displayed() throws Exception {
		Assert.assertEquals("Overall Appointments Set",
				commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@[SMSM-224]-Verify-user-is-on-Work-Orders-page
	@When("User clicks on the Orders option")
	public void user_clicks_on_the_Orders_option() throws Exception {
		zeonDDown.waitAndClickElement(zeonDDown.opt_Orders);
	}

	@Then("User is redirected to the Orders page")
	public void user_is_redirected_to_the_Orders_page() throws Exception {
		Assert.assertEquals("Orders", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies that a list of orders are displayed")
	public void user_verifies_that_a_list_of_orders_are_displayed() throws Exception {
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.btn_PaginationTotal)) > 0);
	}

//	 @[SMSM-224]-Verify-the-available-menus-on-Work-Orders-page
	@Then("User verifies the New button is available")
	public void user_verifies_the_New_button_is_available() {
		Assert.assertTrue(commonElementLocator.btn_New.isDisplayed());
	}

	@Then("User verifies that the Reseller textbox is available")
	public void user_verifies_that_the_Reseller_textbox_is_available() {
		Assert.assertTrue(ordersPage.txtF_Reseller.isDisplayed());
	}

	@Then("User verifies that the Status filter is available")
	public void user_verifies_that_the_Status_filter_is_available() {
		Assert.assertTrue(ordersPage.lov_Status.isDisplayed());
	}

	@Then("User verifies that Order field is available")
	public void user_verifies_that_Order_field_is_available() {
		Assert.assertTrue(ordersPage.txtF_Order.isDisplayed());
	}

	@Then("User verifies Next-Previous options are available")
	public void user_verifies_Next_Previous_options_are_available() {
		Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
	}

	@Then("User verifies the show n Entries ia available")
	public void user_verifies_the_show_n_Entries_ia_available() {
		Assert.assertTrue(commonElementLocator.lov_ShowEntries.isDisplayed());
	}

	@When("User clicks the New button on the Orders page")
	public void user_clicks_the_New_button_on_the_Orders_page() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the Create Order page is opened")
	public void the_Create_Order_page_is_opened() throws InterruptedException {
		Assert.assertEquals("Create Order", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the Order Details section is available")
	public void user_verifies_the_Order_Details_section_is_available() {
		Assert.assertTrue(createOrder.sec_OrderDetails.isDisplayed());
	}

	@Then("User verifies the Acquire Leads section is available")
	public void user_verifies_the_Acquire_Leads_section_is_available() {
		Assert.assertTrue(createOrder.sec_AcquireLeads.isDisplayed());
	}

	@Then("User verifies the Acquire button ia available")
	public void user_verifies_the_Acquire_button_ia_available() {
		Assert.assertTrue(createOrder.btn_AcquireLeads.isDisplayed());
	}

//	 @[SMSM-224]-Verify-the-validation-messages
	@When("User clicks the Acquire Leads button while keeping blank all fields")
	public void user_clicks_the_Acquire_Leads_button_while_keeping_blank_all_fields() throws Exception {
	createOrder.waitAndClickElement(createOrder.btn_AcquireLeads);
	}

	@Then("error message is displayed for mandatory fields")
	public void error_message_is_displayed_for_mandatory_fields() {
		Assert.assertTrue(createOrder.errorMsg_BusinessName.isDisplayed());
		Assert.assertTrue(createOrder.errorMsg_OrderType.isDisplayed());
		Assert.assertTrue(createOrder.errorMsg_Appointments.isDisplayed());
		Assert.assertTrue(createOrder.errorMsg_DueDate.isDisplayed());
		Assert.assertTrue(createOrder.errorMsg_Verticals.isDisplayed());
	}

	@When("User enters valid data onto the madatory fields")
	public void user_enters_valid_data_onto_the_madatory_fields() {
	
	}

	@Then("the error messages get hidden")
	public void the_error_messages_get_hidden() {

	}

	@When("Users leave a single mandatory field blank")
	public void users_leave_a_single_mandatory_field_blank() {
	
	}

	@Then("User verifies that the Acquire Leads button is disabled")
	public void user_verifies_that_the_Acquire_Leads_button_is_disabled() {
	
	}

}
