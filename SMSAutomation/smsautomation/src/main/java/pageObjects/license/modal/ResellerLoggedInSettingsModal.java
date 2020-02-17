package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ResellerLoggedInSettingsModal extends BasePage {

	public ResellerLoggedInSettingsModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//a[text()[normalize-space()=\"My Account\"]]") WebElement mod_MyAccount;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"My Company\"]]") WebElement mod_MyCompany;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"My Sites\"]]") WebElement mod_MySites;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Sign Out\"]]") WebElement mod_SignOut;

}
