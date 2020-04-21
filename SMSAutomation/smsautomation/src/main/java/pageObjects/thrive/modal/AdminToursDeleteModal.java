package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminToursDeleteModal extends BasePage {

	public AdminToursDeleteModal() throws IOException {
		super();
	}

	// Modal elements
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Delete Tour\"]") WebElement mod_Title;
	public @FindBy(xpath = "//button[text()=\"Delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[text()=\"Delete Tour\"]]//button[@class=\"close\"]") WebElement btn_Close;
}
