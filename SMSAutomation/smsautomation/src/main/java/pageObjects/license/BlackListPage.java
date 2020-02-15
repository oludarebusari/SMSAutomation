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
	public @FindBy(xpath = "//span[contains(@class, \"toggle-handle\")]") WebElement tog_On;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-copy\") and ./span[(.)=\"Copy\"]])[1]") WebElement btn_Copy_WL;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-csv\") and ./span[(.)=\"CSV\"]])[1]") WebElement btn_CSV_WL;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-copy\") and ./span[(.)=\"Copy\"]])[2]") WebElement btn_Copy_BL;
	public @FindBy(xpath = "(//a[contains(@class, \"buttons-csv\") and ./span[(.)=\"CSV\"]])[2]") WebElement btn_CSV_BL;
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
	public @FindBy(xpath = "//tbody") WebElement parent;
	public WebElement btn_Remove(String PhoneNo) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and .//span[text()=\"" + PhoneNo + "\"]]//button[contains(@class, \"remove-list-item\")]"));
	}
	public @FindBy(xpath = "//tr[@role=\"row\" and .//span[text()=\"525-252-5252\"]]//button[contains(@class, \"remove-list-item\")]") WebElement par_Remove;
	public @FindBy(xpath = "//tr[@role=\"row\"]") WebElement par_Whitelist_Number;
	public WebElement txt_Black_WhiteList_Number(String num) {
		return par_Whitelist_Number.findElement(By.xpath("//span[text()=\"" + num + "\"]"));
	}
	public @FindBy(xpath = "//div[@id=\"datatables_buttons_info\"]") WebElement win_Copy_To_Clipboard_Title;
	public @FindBy(xpath = "//div[@id=\"datatables_buttons_info\"]/h2") WebElement copy_To_Clipboard_Title;
	
	public @FindBy(xpath = "//div[contains(@class, \"btn-group-sm\")]") WebElement btn_Parent;
	public WebElement btn_Copy_L(int index) {
		return btn_Parent.findElement(By.xpath("(//a[contains(@class, \"buttons-copy\") and ./span[(.)=\"Copy\"]])['" + index + "']"));
	}
	
	public @FindBy(xpath = "//table[@id=\"blacklisted-numbers\"]/thead/tr[@role=\"row\"]/th[@class=\"sorting\"]") WebElement btn_Sort;
	
	
}
