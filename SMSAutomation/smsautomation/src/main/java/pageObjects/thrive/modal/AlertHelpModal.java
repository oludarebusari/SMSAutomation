package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AlertHelpModal extends BasePage{

	public AlertHelpModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h3[@class=\"popover-title\"]") WebElement mod_Title;
	
}
