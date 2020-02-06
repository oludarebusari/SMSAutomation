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
	public @FindBy(xpath = "//label[text()=\"Off\"]") WebElement tog_Off;
	public @FindBy(xpath = "//input[@id=\"table-search-bl\"]") WebElement txt_Blacklist_SearchField;
	public @FindBy(xpath = "//a[@id=\"add-number-blacklist\"]") WebElement btn_Blacklist_New;
	public @FindBy(xpath = "//a[@id=\"add-number-whitelist\"]") WebElement btn_Whitelist_New;
	public @FindBy(xpath = "//h2[@class=\"remove-top\" and text()=\"Whitelist\"]") WebElement txt_Whitelist_Subtitle;
	
	
}
