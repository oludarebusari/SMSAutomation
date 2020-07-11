package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class LeadTrackingDDown extends BasePage {

	public LeadTrackingDDown() throws IOException {
		super();
	}
	

	private final String ORDERSLOCATOR = "//a[normalize-space()=\"Orders\"]";
	private final String ORDERSLEADSBYAPPOINTMENTLOCATOR = "//a[normalize-space()=\"Leads By Appointment\"]";
	private final String DONOTCALLLISTLOCATOR = "//a[normalize-space()=\"Do Not Call List\"]";
	
	public String getDONOTCALLLISTLOCATOR() {
		return DONOTCALLLISTLOCATOR;
	}

	public String getORDERSLEADSBYAPPOINTMENTLOCATOR() {
		return ORDERSLEADSBYAPPOINTMENTLOCATOR;
	}

	public String getORDERSLOCATOR() {
		return ORDERSLOCATOR;
	}

	//Page elements
	public @FindBy(xpath = "//a[normalize-space()=\"Orders\"]") WebElement opt_Orders;
	public @FindBy(xpath = "//anormalize-space()=\"Leads By Appointment\"]") WebElement opt_LeadsByAppointment;
	public @FindBy(xpath = "//a[normalize-space()=\"Do Not Call List\"]") WebElement opt_Do_Not_Call_List;
	
}
