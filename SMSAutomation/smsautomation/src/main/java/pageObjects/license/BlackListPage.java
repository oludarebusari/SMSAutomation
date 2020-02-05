package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BlackListPage extends BasePage {

	public BlackListPage() throws IOException {
		super();
	}

	// Blacklist/Whitelist Purchase elements
	
	public @FindBy(xpath = "//div[contains(@class, \"page-heading\")]") WebElement pag_Blacklist_Whitelist;
	
	
}
