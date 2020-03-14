package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ActivatePageModal extends BasePage {

	public ActivatePageModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Activate this page\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Activate this page\"]]]//button[text()=\"Activate\"]") WebElement btn_Activate;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Activate this page\"]]]//button[text()=\"Cancel\"]") WebElement btn_Cancel;
	
}
