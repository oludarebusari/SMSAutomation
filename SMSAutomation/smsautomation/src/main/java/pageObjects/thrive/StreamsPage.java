package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class StreamsPage extends BasePage {

	public StreamsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public @FindBy(xpath = "//a[@id=\"edit-settings\"]") WebElement btn_Settings;
	public @FindBy(xpath = "//a[contains(@class, \"btn-primary\") and ./strong]") WebElement btn_ManageYourConnection;
	public @FindBy(xpath = "//a[contains(@class, \"btn-primary\") and ./strong]") WebElement btn_ManageYourConnectionDDown;

}
