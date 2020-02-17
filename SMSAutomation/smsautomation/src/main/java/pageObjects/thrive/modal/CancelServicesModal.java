package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CancelServicesModal extends BasePage {

	public CancelServicesModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Cancel Services\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Cancel Services\"]") WebElement btn_Cancel_Services;
	
}
