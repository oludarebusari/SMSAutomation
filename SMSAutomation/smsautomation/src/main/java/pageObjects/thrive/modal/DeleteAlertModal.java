package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeleteAlertModal extends BasePage {

	public DeleteAlertModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//button[@data-dismiss=\"modal\" and text()=\"Delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[text()=\"Delete Alert\"]]//button[@class=\"close\"]") WebElement icon_Close;
}
