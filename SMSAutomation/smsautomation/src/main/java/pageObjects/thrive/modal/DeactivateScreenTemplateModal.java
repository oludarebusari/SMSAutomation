package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeactivateScreenTemplateModal extends BasePage {

	public DeactivateScreenTemplateModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Deactivate Screen Template\"]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Deactivate\"]") WebElement btn_Deactivate;
	
}
