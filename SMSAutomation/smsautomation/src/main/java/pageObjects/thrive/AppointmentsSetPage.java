package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AppointmentsSetPage extends BasePage {

	public AppointmentsSetPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//span[@id=\"call-lead\"]") WebElement btn_CallLead;
	
}
