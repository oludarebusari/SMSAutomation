package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ActivateAlertModal extends BasePage {

	public ActivateAlertModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//button[@data-dismiss=\"modal\" and text()=\"Activate\"]") WebElement btn_Activate;
	
}
