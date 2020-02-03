package pageObjects.thrive;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;


public class ThriveLoginPage extends BasePage {

	public ThriveLoginPage() throws IOException {
		super();
	}
	
	// Page elements
	public @FindBy(xpath = "//input[@id=\"username\"]") WebElement txtF_UserName;
	public @FindBy(xpath = "//input[@id=\"password\"]") WebElement txtF_PassWord;
	public @FindBy(xpath = "//button[@id=\"_submit\"]") WebElement button_signIn;
	
}
