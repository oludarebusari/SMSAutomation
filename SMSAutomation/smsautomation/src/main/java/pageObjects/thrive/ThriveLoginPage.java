package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;
import utils.JsonConfigReader;

public class ThriveLoginPage extends BasePage {
	
	JsonConfigReader reader = new JsonConfigReader();

	public ThriveLoginPage() throws IOException {
		super();
	}

	
	// Page elements
	public @FindBy(xpath = "//input[@id=\"username\"]") WebElement txtF_UserName;
	public @FindBy(xpath = "//input[@id=\"password\"]") WebElement txtF_PassWord;
	public @FindBy(xpath = "//button[@id=\"_submit\"]") WebElement button_signIn;
	
	
	//Page Methods
	
	public ThriveLoginPage getLoginPage() throws IOException {
		driver.get(reader.getConfigValue("GeneralSettings", "thrBaseURL"));
		return new ThriveLoginPage();
	}

	public ThriveLoginPage enterUserName(String userName) throws Exception {
		sendKeysToWebElement(txtF_UserName, userName);
		return new ThriveLoginPage();
	}

	public ThriveLoginPage enterPassWord(String passWord) throws Exception {
		sendKeysToWebElement(txtF_PassWord, passWord);
		return new ThriveLoginPage();
	}

	public ThriveLoginPage clickOnSubmiButton() throws Exception {
		waitAndClickElement(button_signIn);
		return new ThriveLoginPage();
	}

}
