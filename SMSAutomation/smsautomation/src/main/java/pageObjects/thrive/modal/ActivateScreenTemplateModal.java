package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ActivateScreenTemplateModal extends BasePage {

	public ActivateScreenTemplateModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Activate Screen Template\"]") WebElement mod_Title;
	public @FindBy(xpath = "//button[normalize-space()=\"Activate\"]") WebElement btn_Activate;
	
}
