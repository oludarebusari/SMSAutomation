package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminToursDeactivateModal extends BasePage {

	public AdminToursDeactivateModal() throws IOException {
		super();
	}
	
	// Modal elements
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Deactivate Tour\"]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Deactivate\"]") WebElement btn_Deactivate;

}
