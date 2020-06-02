package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeleteAuditModal extends BasePage {

	public DeleteAuditModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Delete Audit\"]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Delete\"]") WebElement btn_Delete;

}
