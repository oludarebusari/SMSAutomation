package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeactivateAlertModal extends BasePage  {

	public DeactivateAlertModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//button[@data-dismiss=\"modal\" and text()=\"Deactivate\"]") WebElement btn_Deactivate;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[text()=\"Deactivate Alert\"]]//button[@class=\"close\"]") WebElement icon_Close;
}
