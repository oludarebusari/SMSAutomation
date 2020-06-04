package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BusinessesPage extends BasePage {

	public BusinessesPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//div[@role=\"alert\"]//p") WebElement NotificationAlert;
}
