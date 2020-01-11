package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import utils.JsonConfigReader;


public class LicLoginPage extends BasePage{
	
	JsonConfigReader reader = new JsonConfigReader();
	
	// Page Elements 
	
	public @FindBy(xpath = "//input[@id=\"id_username\"]") WebElement textfield_UserName;
	public @FindBy(xpath = "//input[@id=\"id_password\"]") WebElement textfield_PassWord;
	public @FindBy(xpath = "//button[@id=\"_submit\"]") WebElement button_signIn;

	public LicLoginPage() throws IOException {
		super();
	}

	// Page Methods
	
	public LicLoginPage getLoginPage() throws IOException {
		driver.get(reader.getConfigValue("GeneralSettings", "licBaseURL"));
		return new LicLoginPage();
	}

	public LicLoginPage enterUserName(String userName) throws Exception {
		sendKeysToWebElement(textfield_UserName, userName);
		return new LicLoginPage();
	}

	public LicLoginPage enterPassWord(String passWord) throws Exception {
		sendKeysToWebElement(textfield_PassWord, passWord);
		return new LicLoginPage();
	}

	public LicLoginPage clickOnSubmiButton() throws Exception {
		waitAndClickElement(button_signIn);
		return new LicLoginPage();
	}

}
