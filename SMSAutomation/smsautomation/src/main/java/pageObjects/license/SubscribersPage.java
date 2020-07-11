package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
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
	public @FindBy (xpath = "(//div[contains(@class, \"selectize-input\")])[1]") WebElement campaignDDown;
	public @FindBy(xpath = "//input[@id=\"optin-dates\"]") WebElement txtF_OptIn_Date_Range;
	public @FindBy(xpath = "//input[@id=\"checkin-dates\"]") WebElement txtF_CheckIn_Count;
	public @FindBy(xpath = "//button[@id=\"importTrigger\"]") WebElement btn_Import;
	public @FindBy(xpath = "//button[@data-toggle=\"dropdown\" and text()[normalize-space()]]") WebElement btn_Bulk_Edit;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-copy\")]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_CSV;
	public @FindBy(xpath = "//div[contains(@class, \"pull-right open\")]//a[contains(@title, \"Reply\")]") WebElement btn_Reply;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_Reply_Dropdown;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_Blacklist;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_Unsubscribe_WText;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\")]") WebElement btn_Unsubscribe_WOText;
	public @FindBy(xpath = "//div[@id=\"message-sent-ok\" and text()[normalize-space()=\"Message has been sent.\"]]") WebElement txt_Notification;
	public @FindBy(xpath = "//tbody") WebElement par_Subscribers;
	public WebElement btn_Reply_Dropdown(String num) {
		return par_Subscribers.findElement(By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + num + "']]//button[contains(@class, \"toggle-dropdown\")]//i[contains(@class, \"fa fa-caret-down\")]"));
	}
	public WebElement selectSubscriber(String num) {
		return par_Subscribers.findElement(By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + num + "']]//td[contains(@class, \"select-checkbox\")]"));
	}
	public WebElement btn_Reply(String num) {
		return par_Subscribers.findElement(By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + num + "']]//a[contains(@title, \"Reply\")]"));
	}
	public WebElement opt_ReplyDDown(String num, String optionName) {
		return par_Subscribers.findElement(By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + num + "']]//ul[@class=\"dropdown-menu\"]//a[text()=\'" + optionName + "']"));
	}
   
	public WebElement opt_BulkEdit(String option) {
		return par_Subscribers.findElement(By.xpath("//div[@id=\"bulk-edit-menu\"]//a[text()=\'" + option + "']"));
	}
   
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement par_Campaign;
	public WebElement campaignOpt (String option) {
		return par_Campaign.findElement(By.xpath("//div[contains(@class, \"option\") and text()=\'" + option + "']"));
	}
	
}
