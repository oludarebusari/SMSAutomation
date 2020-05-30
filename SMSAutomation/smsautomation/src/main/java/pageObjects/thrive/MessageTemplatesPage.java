package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class MessageTemplatesPage extends BasePage {

	public MessageTemplatesPage() throws IOException {
		super();
	}
	
	private final String EDITBTN = "//a[@title=\"Edit\"]";
	public String getEDITBTN() {
		return EDITBTN;
	}
	
	public @FindBy(xpath = "//th[@id=\"email-templates-title\"]//a[text()=\"Title\"]") WebElement col_Title;
	public @FindBy(xpath = "//th[@id=\"email-templates-subject\"]//a[text()=\"Subject\"]") WebElement col_Subject;
	public @FindBy(xpath = "//th[@id=\"email-templates-description\"]//a[text()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"email-templates-updated\"]//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[@id=\"email-templates-action\" and text()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//*[@id=\"main-nav\"]/ul[1]/li[6]/a") WebElement menu_Settings;
	public @FindBy(xpath = "//a[@title=\"Edit\"]") WebElement btn_Edit;
	
	
	public @FindBy(xpath = "//tbody") WebElement parent_Record;
	public WebElement searchRecord(String recordTitle) {
		return parent_Record.findElement(By.xpath("//tr[@data-id and ./td[text()=\'" + recordTitle + "']]"));
	}
	public WebElement editMessageTemplatesByTitle(String recordTitle) {
		return searchRecord(recordTitle).findElement(By.xpath("//div[contains(@class, \"btn-group-sm\") and ./a[text()=\"Edit\"]]"));
	}
	
	public WebElement colValueOption(String option) { 
		  return  parent_Record.findElement(By.xpath("//td[@data-field=\"subject\" and text()[normalize-space()=\'" + option + "']]")); 
	}
	 

	public WebElement cellValue(String option) {
		return parent_Record.findElement(By.xpath("//tr//td[normalize-space()=" + option + "]"));
	}
	
	public WebElement firstSortedRecord(String option) {
		return parent_Record.findElement(By.xpath("//tr[1][td[text()=\'" + option + "']]"));
	}
}
