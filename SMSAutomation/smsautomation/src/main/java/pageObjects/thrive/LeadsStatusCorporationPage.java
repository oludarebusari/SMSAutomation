package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LeadsStatusCorporationPage extends BasePage {

	public LeadsStatusCorporationPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//span[@id=\"call-lead\"]") WebElement btn_CallLead;
	public @FindBy(xpath = "//div[@class=\"lead-item\"]") WebElement panel_LeadItem;
}
