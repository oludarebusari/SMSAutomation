package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LanguageStringsPage extends BasePage{

	public LanguageStringsPage() throws IOException {
		super();
	}
	
	private final String EDITBTN = "//a[@title=\"Edit\"]";
	
	public String getEDITBTN() {
		return EDITBTN;
	}
	
	public @FindBy(xpath = "//th[@id=\"string-title\"]//a[text()=\"Title\"]") WebElement col_Title;
	public @FindBy(xpath = "//th[@id=\"string-section\"]//a[text()=\"Group\"]") WebElement col_Group;
	public @FindBy(xpath = "//th[@id=\"string-group\"]//a[text()=\"Access Level\"]") WebElement col_AccessLevel;
	public @FindBy(xpath = "//th[@id=\"string-value\"]//a[text()=\"Value\"]") WebElement col_Value;
	public @FindBy(xpath = "//th[@id=\"string-description\"]//a[text()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"string-updated\"]//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[@id=\"string-action\" and text()=\"Action\"]") WebElement col_Action;
	
	public @FindBy(xpath = "//input[@id=\"company_language_strings_type_value\"]") WebElement txtF_EditString;
	
	
	public @FindBy(xpath = "//tbody") WebElement parent_SettingsRecord;
	public WebElement searchRecord(String recordTitle) {
		return parent_SettingsRecord.findElement(By.xpath("//tr[@data-id and ./td[text()=\'" + recordTitle + "']]"));
	}
	public WebElement editLanguageStringsByTitle(String recordTitle) {
		return searchRecord(recordTitle).findElement(By.xpath("//div[contains(@class, \"btn-group-sm\") and ./a[text()=\"Edit\"]]"));
	}
	
	public WebElement colValueOption(String option) {
		return parent_SettingsRecord.findElement(By.xpath("//td[@data-field=\"value\" and text()[normalize-space()=\'" + option + "']]"));
	}
	

}
