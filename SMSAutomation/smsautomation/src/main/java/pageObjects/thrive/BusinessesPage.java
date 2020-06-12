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
	public @FindBy(xpath = "//a[normalize-space()=\"Company\"]") WebElement col_Company;
	public @FindBy(xpath = "//a[normalize-space()=\"Phone\"]") WebElement col_Phone;
	public @FindBy(xpath = "//a[normalize-space()=\"Support Email\"]") WebElement col_SupportEmail;
	public @FindBy(xpath = "//a[normalize-space()=\"Location\"]") WebElement col_Location;
	public @FindBy(xpath = "//span[normalize-space()=\"$/Mo\"]") WebElement col_Mo;
	public @FindBy(xpath = "//a[normalize-space()=\"Created\"]") WebElement col_Created;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[normalize-space()=\"Action\"]") WebElement col_Action;
	
}
