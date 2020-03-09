package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SettingsPage extends BasePage {

	public SettingsPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//li[@class=\"first\"]//a[text()[normalize-space()=\"Settings\"]]") WebElement opt_Settings;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Language Strings\"]]") WebElement opt_LanguageStrings;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"Message Templates\"]]") WebElement opt_MessageTemplates;
	
	public @FindBy(xpath = "//th[@id=\"settings-title\"]//a[text()=\"Title\"]") WebElement col_Title;
	public @FindBy(xpath = "//th[@id=\"settings-section\"]//a[text()=\"Group\"]") WebElement col_Group;
	public @FindBy(xpath = "//th[@id=\"settings-value\"]//a[text()=\"Value\"]") WebElement col_Value;
	public @FindBy(xpath = "//th[@id=\"settings-description\"]//a[text()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"settings-updated\"]//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[@id=\"settings-action\"]//a[text()=\"Action\"]") WebElement col_Action;
	
	
	public @FindBy(xpath = "//tbody") WebElement parent_SettingsRecord;
	public WebElement searchRecord(String recordTitle) {
		return parent_SettingsRecord.findElement(By.xpath("//tr[@data-id and ./td[text()=\'" + recordTitle + "']]"));
	}
	public WebElement editSettingByTitle(String recordTitle) {
		return searchRecord(recordTitle).findElement(By.xpath("//div[contains(@class, \"btn-group-sm\") and ./a[text()=\"Edit\"]]"));
	}
	
	public WebElement colValueOption(String option) {
		return parent_SettingsRecord.findElement(By.xpath("//td[@data-field=\"value\" and text()[normalize-space()=\'" + option + "']]"));
	}
	
}
