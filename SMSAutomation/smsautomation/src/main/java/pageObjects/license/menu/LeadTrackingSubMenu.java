package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LeadTrackingSubMenu  extends BasePage {

	public LeadTrackingSubMenu() throws IOException {
		super();
	}
	
	
	public @FindBy(xpath = "//a[normalize-space()=\"Orders\"]") WebElement menu_Orders;
	public @FindBy(xpath = "//a[normalize-space()=\"Leads By Appointment\"]") WebElement menu_LeadsByAppointment;
	public @FindBy(xpath = "//a[normalize-space()=\"Do Not Call List\"]") WebElement menu_DoNotCallList;

}
