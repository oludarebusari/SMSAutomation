package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DeletePlanModal extends BasePage {

	public DeletePlanModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Delete Plan\"]") WebElement mod_Title;
	public @FindBy(xpath = "(//button[@class=\"close\" and .//span[@class=\"sr-only\"]])[2]") WebElement btn_Close;
	public @FindBy(xpath = "//button[text()=\"Delete\"]") WebElement btn_Delete;
	
}
