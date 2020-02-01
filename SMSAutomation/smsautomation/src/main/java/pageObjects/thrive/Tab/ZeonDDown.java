package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class ZeonDDown extends BasePage {

	public ZeonDDown() throws IOException {
		super();
	}

	//Page elements
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Orders\"]]") WebElement opt_Orders;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Entertainment Deals\"]]") WebElement opt_Entertainment_Deals;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Leads By Appointment\"]]") WebElement opt_Leads_By_Appointment;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Verify Appointments\"]]") WebElement opt_Verify_Appointments;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Sales Work Orders\"]]") WebElement opt_Sales_Work_Orders;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Sales Appointment List\"]]") WebElement opt_Sales_Appointment_List;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Do Not Call List\"]]") WebElement opt_Do_Not_Call_List;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Caller Ids\"]]") WebElement opt_Caller_Ids;
		
	// Page methods
	public ZeonDDown clickOrderOpt() throws Exception {
		waitAndClickElement(opt_Orders);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickEntertainmentDealsOpt() throws Exception {
		waitAndClickElement(opt_Entertainment_Deals);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickLeadsByAppointmentOpt() throws Exception {
		waitAndClickElement(opt_Leads_By_Appointment);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickVerifyAppointmentsOpt() throws Exception {
		waitAndClickElement(opt_Verify_Appointments);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickSalesWorkOrderOpt() throws Exception {
		waitAndClickElement(opt_Sales_Work_Orders);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickSalesAppointmentListOpt() throws Exception {
		waitAndClickElement(opt_Sales_Appointment_List);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickDoNotCallListOpt() throws Exception {
		waitAndClickElement(opt_Do_Not_Call_List);
		return new ZeonDDown();
	}
	
	public ZeonDDown clickCallerIdsOpt() throws Exception {
		waitAndClickElement(opt_Caller_Ids);
		return new ZeonDDown();
	}
	
}
