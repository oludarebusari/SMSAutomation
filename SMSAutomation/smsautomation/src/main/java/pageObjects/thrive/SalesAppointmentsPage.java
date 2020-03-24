package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SalesAppointmentsPage extends BasePage {

	public SalesAppointmentsPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//input[@id=\"lead_filter_type_update_range\"]") WebElement txtF_DateRange;
	public @FindBy(xpath = "//div[contains(@class, \"dropdown-menu\")]") WebElement mod_Date;
	
}
