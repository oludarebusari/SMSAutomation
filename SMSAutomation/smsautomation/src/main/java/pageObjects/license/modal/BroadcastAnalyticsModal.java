package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BroadcastAnalyticsModal extends BasePage {

	public BroadcastAnalyticsModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Broadcast Analytics\"]") WebElement mod_Title;
}
