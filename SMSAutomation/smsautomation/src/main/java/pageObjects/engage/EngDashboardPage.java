package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EngDashboardPage extends BasePage{
	
	public @FindBy(xpath = "//input[@id=\"id_username\"]") WebElement textfield_UserName;
	public @FindBy(xpath = "//input[@id=\"id_password\"]") WebElement textfield_PassWord;
	public @FindBy(xpath = "//button[@id=\"_submit\"]") WebElement button_signIn;

	public EngDashboardPage() throws IOException {
		super();
	}

}
