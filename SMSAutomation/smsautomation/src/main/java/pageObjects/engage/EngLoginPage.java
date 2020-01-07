package pageObjects.engage;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EngLoginPage extends BasePage {
	

	public @FindBy(xpath = "//input[@id=\"id_username\"]") WebElement textfield_UserName;
	public @FindBy(xpath = "//input[@id=\"id_password\"]") WebElement textfield_PassWord;
	public @FindBy(xpath = "//button[@id=\"_submit\"]") WebElement button_signIn;

	public EngLoginPage() throws IOException {
		super();
	}

	public EngLoginPage getLoginPage() throws IOException {
		driver.get("https://staging.smsmmadmin.com/");
		return new EngLoginPage();
	}

	public EngLoginPage enterUserName(String userName) throws Exception {
		sendKeysToWebElement(textfield_UserName, userName);
		return new EngLoginPage();
	}

	public EngLoginPage enterPassWord(String passWord) throws Exception {
		sendKeysToWebElement(textfield_PassWord, passWord);
		return new EngLoginPage();
	}

	public EngLoginPage clickOnSubmiButton() throws Exception {
		waitAndClickElement(button_signIn);
		return new EngLoginPage();
	}

	/*
	 * public LoginEngPage confirmContactUsFormSubmissionWasSuccessful() throws
	 * Exception { WebElement thanksContactUsPage =
	 * getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
	 * WaitUntilWebElementIsVisible(thanksContactUsPage);
	 * Assert.assertEquals("thankyouforyourmessage!",
	 * thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
	 * return new LoginEngPage(); }
	 */

}
