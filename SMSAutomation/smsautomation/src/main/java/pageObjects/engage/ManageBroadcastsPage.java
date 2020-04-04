package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageBroadcastsPage extends BasePage {

	public ManageBroadcastsPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//div[contains(@class, \"page-heading\") and ./h1]") WebElement pag_Heading;
}
