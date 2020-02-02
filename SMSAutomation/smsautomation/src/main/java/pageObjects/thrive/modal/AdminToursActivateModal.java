package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminToursActivateModal extends BasePage {

	public AdminToursActivateModal() throws IOException {
		super();
	}
	
	// Modal elements
		public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Activate Tour\"]") WebElement mod_Title;
		public @FindBy(xpath = "//button[text()=\"Activate\"]") WebElement btn_Activate;


}
