package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BroadcastConfirmationPage extends BasePage {

	public BroadcastConfirmationPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[text()]") WebElement lbl_ConfirmationMessage;
}
