package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeactivatePageModal extends BasePage {

	public DeactivatePageModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"deactivate.page.title\"] or text()[normalize-space()=\"Deactivate this page\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"deactivate.page.title\"] or text()[normalize-space()=\"Deactivate this page\"]]]//button[text()=\"Deactivate\"]") WebElement btn_Deactivate;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"deactivate.page.title\"] or text()[normalize-space()=\"Deactivate this page\"]]]//button[text()=\"Cancel\"]") WebElement btn_Cancel;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"deactivate.page.title\"] or text()[normalize-space()=\"Deactivate this page\"]]]//button[@class=\"close\"]") WebElement btn_Close;
	
}
