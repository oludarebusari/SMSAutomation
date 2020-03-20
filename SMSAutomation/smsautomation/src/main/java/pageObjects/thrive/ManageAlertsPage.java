package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageAlertsPage extends BasePage {

	public ManageAlertsPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[@id=\"create-entity\"]") WebElement btn_New;
}
