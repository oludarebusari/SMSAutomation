package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.CommonElementLocator;
import pageObjects.BasePage;

public class SubscribersPage extends BasePage {

	public SubscribersPage() throws IOException {
		super();
	}

	// Page elements
	public @FindBy(xpath = CommonElementLocator.ELEM_PAGE_TITLE) WebElement pag_Title;
	public @FindBy(xpath = "//input[contains(@class, \"table-search\")]") WebElement txtF_Search;
	public @FindBy(xpath = "//div[@id=\"subscribers_wrapper\"]") WebElement table_Subscribers;
	public @FindBy(xpath = "//div[@id=\"subscribers_info\"]") WebElement num_Subscribers;
	public @FindBy(xpath = "//input[@id=\"optin-dates\"]") WebElement txtF_OptIn_Date_Range;
	public @FindBy(xpath = "//input[@id=\"checkin-dates\"]") WebElement txtF_CheckIn_Count;
	public @FindBy(xpath = "//button[@id=\"importTrigger\"]") WebElement btn_Import;
	public @FindBy(xpath = "//button[@data-toggle=\"dropdown\" and text()[normalize-space()]]") WebElement btn_Bulk_Edit;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-copy\")]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_CSV;
	
}
