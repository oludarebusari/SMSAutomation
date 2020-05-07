package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AddToAllResellerModal extends BasePage {

	public AddToAllResellerModal() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//button[text()=\"No\"]") WebElement btn_No;
	public @FindBy(xpath = "//button[text()=\"Yes\"]") WebElement btn_Yes;
}
