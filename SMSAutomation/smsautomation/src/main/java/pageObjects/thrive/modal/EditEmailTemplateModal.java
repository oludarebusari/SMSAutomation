package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditEmailTemplateModal extends BasePage {

	public EditEmailTemplateModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[contains(text(), \"Edit String\")]") WebElement mod_Title;
	
	
	
}
