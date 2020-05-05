package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeleteModuleModal extends BasePage {

	public DeleteModuleModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[text()=\"Delete Module\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[text()=\"Delete Module\"]]//button[@class=\"close\"]") WebElement btn_Close;
	public @FindBy(xpath = "//button[text()=\"Delete\"]") WebElement btn_Delete;
}
