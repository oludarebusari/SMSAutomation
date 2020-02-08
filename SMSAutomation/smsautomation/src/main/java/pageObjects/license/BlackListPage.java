package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
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
//	public @FindBy(xpath = "//label[text()=\"On\"]") WebElement tog_On;
	public @FindBy(xpath = "//span[contains(@class, \"toggle-handle\")]") WebElement tog_On;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-copy\") and ./span[(.)=\"Copy\"]])[1]") WebElement btn_Copy;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-csv\") and ./span[(.)=\"CSV\"]])[1]") WebElement btn_CSV;
	public @FindBy(xpath = "//div[@id=\"datatables_buttons_info\"]//div") WebElement txt_Copied_To_Clipboard;
	public @FindBy(xpath = "//input[@id=\"table-search-bl\"]") WebElement txt_Blacklist_SearchField;
	public @FindBy(xpath = "//input[@id=\"table-search-wl\"]") WebElement txt_Whitelist_SearchField;
	public @FindBy(xpath = "//a[@id=\"add-number-blacklist\"]") WebElement btn_Blacklist_New;
	public @FindBy(xpath = "//a[@id=\"add-number-whitelist\"]") WebElement btn_Whitelist_New;
	public @FindBy(xpath = "//td[@class=\"dataTables_empty\" and contains(text(), \"No matching\")]") WebElement txt_No_Match_Message;
	public @FindBy(xpath = "//td[@class=\"dataTables_empty\" and contains(text(), \"No data\")]") WebElement txt_No_Data_Message;
	public @FindBy(xpath = "//button[contains(@class, \"remove-list-item\")]") WebElement btn_Whitelist_Remove;
	public @FindBy(xpath = "//h2[@class=\"remove-top\" and text()=\"Whitelist\"]") WebElement txt_Whitelist_Subtitle;
	public @FindBy(xpath = "//h2[@class=\"remove-top\" and text()=\"Blacklist\"]") WebElement txt_Blacklist_Subtitle;
	public @FindBy(xpath = "//tr[@role=\"row\"]") WebElement par_Whitelist_Number;
	public WebElement txt_WhiteList_Number(String num) {
		return par_Whitelist_Number.findElement(By.xpath("//span[text()='" + num + "']"));
	}
	
}
