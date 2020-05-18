package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeletePageModal extends BasePage {

	public DeletePageModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Delete Page\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Delete Page\"]]]//button[text()=\"Delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Delete Page\"]]]//button[text()=\"Cancel\"]") WebElement btn_Cancel;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Delete Page\"]]]//button[@class=\"close\"]") WebElement btn_Close;
	
}
