package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.Tab.ZeonDDown;
import utils.DriverFactory;

public class ZeonTabOptionsSteps extends DriverFactory {

	public ZeonTabOptionsSteps() throws IOException {
		super();
	}

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
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
		Assert.assertEquals("Overall Appointments Set", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks the date range from date picker and clicks the Apply button")
	public void user_clicks_the_date_range_from_date_picker_and_clicks_the_Apply_button() {
	
	}

	@Then("User get overall appointments set displayed")
	public void user_get_overall_appointments_set_displayed() {
	
	}

}
