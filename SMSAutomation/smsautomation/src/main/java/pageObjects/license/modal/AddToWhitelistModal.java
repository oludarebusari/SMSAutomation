package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AddToWhitelistModal extends BasePage {

	public AddToWhitelistModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Add to Whitelist\"]") WebElement mod_Add_To_Whitelist_Title;
	public @FindBy(xpath = "//input[@id=\"phone-number\"]") WebElement txt_Phone_Number;
	public @FindBy(xpath = "//button[@id=\"add-to-list\"]") WebElement btn_Add_Number;
}
