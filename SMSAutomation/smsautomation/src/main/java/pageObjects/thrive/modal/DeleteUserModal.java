package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeleteUserModal extends BasePage {

	public DeleteUserModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Delete User\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//button[contains(@class, \"modal-proceed\")]") WebElement btn_Delete;
	public @FindBy(xpath = "//button[contains(@class, \"modal-cancel\")]") WebElement btn_Cancel;
}
