package pageObjects;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommomPageLocators extends BasePage {

	public CommomPageLocators() throws IOException {
		super();
	}
	
	// Login Page elements
	
	public @FindBy (xpath = "//input[@id=\"id_username\"]") WebElement txtF_UserName;
	public @FindBy (xpath = "//input[@id=\"id_password\"]") WebElement txtF_PassWord;
	public @FindBy (xpath = "//button[@id=\"_submit\"]") WebElement btn_signIn;
	
}
