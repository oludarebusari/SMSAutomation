package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SaveChangesToPageModal extends BasePage  {

	public SaveChangesToPageModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Save Changes\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\\\"modal-title\\\" and text()[normalize-space()=\\\"Save changes?\\\"]]]//button[text()=\"Stay on page\"]") WebElement btn_StayOnPage;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Save changes?\"]]]//button[text()=\"Discard changes\"]") WebElement btn_DiscardChanges;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[@class=\"modal-title\" and text()[normalize-space()=\"Save changes?\"]]]//button[text()=\"Save changes\"]") WebElement btn_SaveChanges;
}
