package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditStringModal extends BasePage {

	public EditStringModal() throws IOException {
	    super();
	}
	
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[normalize-space()=\"Edit String\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[normalize-space()=\"Edit String\"]]//button[@class=\"close\"]") WebElement btn_Close;;
	public @FindBy(xpath = "//input[@id=\"company_language_strings_type_value\"]") WebElement txtF_EditString;
	public @FindBy(xpath = "//button[contains(@class, \"ladda-button\")]") WebElement btn_SaveString;
}
