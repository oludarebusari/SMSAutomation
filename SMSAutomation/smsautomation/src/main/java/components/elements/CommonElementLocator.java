package components.elements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CommonElementLocator extends BasePage {

	public CommonElementLocator() throws IOException {
		super();
	}
	// The following elements can be used in multiple sections of this project.
	public final static String ELEM_PAGE_TITLE =  "//div[contains(@class, \"page-heading\")]";
	public final static String ELEM_SEARCH_TEXTFIELD = "//input[contains(@class, \"table-search\")]";
	

	//Thrive menu options
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Dashboard\"]]") WebElement menu_Dashboard;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Experience\"]]") WebElement menu_Experience;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Companies\"]]") WebElement menu_Companies;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Users\"]]") WebElement menu_Users;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Billing\"]]") WebElement menu_Billing;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Zeon\"]]") WebElement menu_Zeon;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Settings\"]]") WebElement menu_Settings;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Reports\"]]") WebElement menu_Reports;
	public @FindBy(xpath = "//li[@class=\"last\" and .//a[text()[normalize-space()=\"Support\"]]]") WebElement menu_Support;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Help;
	
	//Pagination elements
	public @FindBy(xpath = "//select[@id=\"pager-per-page\"]") WebElement lov_ShowEntries;
	public WebElement showEntriesOption(String option) {
		return lov_ShowEntries.findElement(By.xpath("//option[text()[normalize-space()=\'" + option + "']]"));
	}
	public @FindBy(xpath = "//div[@id=\"data-table_length\"]") WebElement lbl_ShowEntries;
	public @FindBy(xpath = "//li[contains(@class, \"pagination-prev\")]/a") WebElement btn_PaginationPrevious;
	public @FindBy(xpath = "//li[contains(@class, \"pagination-prev\")]") WebElement btn_PaginationPreviousDisabled;
	public @FindBy(xpath = "//li[contains(@class, \"pagination-next\")]/a") WebElement btn_PaginationNext;
	public @FindBy(xpath = "//li[contains(@class, \"pagination-next\")]") WebElement btn_PaginationNextDisabled;
	public @FindBy(xpath = "//span[@id=\"pagination-end\"]") WebElement btn_PaginationEnd;
	public @FindBy(xpath = "//span[@id=\"pagination-total\"]") WebElement btn_PaginationTotal;
	
	//Record elements
	public @FindBy(xpath = "//") WebElement parent_Element;
	public WebElement firstName(String index) {
		return parent_Element.findElement(By.xpath("(//tr/td[text()])['" + index + "']"));
	}
	
	public @FindBy(xpath = "(//tr/td[text()])[1]") WebElement sort_FirstName;
	public @FindBy(xpath = "(//tr/td[text()])[2]") WebElement sort_LastName;
	public @FindBy(xpath = "(//tr/td[text()])[3]") WebElement sort_Status;
	public @FindBy(xpath = "(//tr/td[text()])[4]") WebElement sort_Updated;
	
	
	//Help
	public @FindBy(xpath = "//h3[@class=\"popover-title\"]") WebElement mod_Tours_Help_Title;
	public @FindBy(xpath = "//button[@data-role=\"prev\"]") WebElement btn_Tours_Help_Prev;
	public @FindBy(xpath = "//button[@data-role=\"next\"]") WebElement btn_Tours_Help_Next;
	public @FindBy(xpath = "//button[@data-role=\"end\"]") WebElement btn_Tours_Help_EndTour;
	public @FindBy(xpath = "//div[contains(@class, \"tour-mmd-tour\")]") WebElement mod_Tours;
	
	
	
}
