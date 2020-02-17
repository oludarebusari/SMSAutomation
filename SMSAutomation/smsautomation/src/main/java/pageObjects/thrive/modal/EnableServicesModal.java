package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EnableServicesModal extends BasePage {

	public EnableServicesModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Enable Services\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Enable Services\"]") WebElement btn_Enable_Services;
	
}
