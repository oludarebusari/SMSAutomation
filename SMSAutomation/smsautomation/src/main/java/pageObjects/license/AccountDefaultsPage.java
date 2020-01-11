package pageObjects.license;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;


public class AccountDefaultsPage extends BasePage {

	public AccountDefaultsPage() throws IOException {
		super();
	}
	
	//Page Elements
	
	public @FindBy(xpath = "//div[contains(@class, \"page-heading\")]") WebElement page_Title;
	public @FindBy(xpath = "//h4[contains((.), \"Inbox Messages Limit\")]") WebElement page_Inbox_Messages_Limit;
	public @FindBy(xpath = "//input[@id=\"messages_limit_days\"]") WebElement txtF_Limit_Days;
	public @FindBy(xpath = "//form[@id=\"messages_limit_days_form\"]//button[(.)=\"Save\"]") WebElement btn_Limit_Days_Save;
	public @FindBy(xpath = "//h2[contains((.), \"Engagement Settings\")]") WebElement page_Engagement_Settings;
	public @FindBy(xpath = "//h4[contains((.), \"Default {firstName} Value\")]") WebElement page_Default_Value;
	public @FindBy(xpath = "//input[@id=\"first_name\"]") WebElement txtF_Default_Value;
	public @FindBy(xpath = "//form[@id=\"first_name_form\"]//button[(.)=\"Save\"]") WebElement btn_Default_Value_Save;
	public @FindBy(xpath = "//button[contains((.), \"Save Engagement Settings\")]") WebElement btn_Save_Engagements_Settings;
	public @FindBy(xpath = "//div[@data-toggle=\"toggle\"]") WebElement toggle_Default_Custom;
	public @FindBy(xpath = "//div[@id=\"messages_limit_days_saved\"]") WebElement alert_Saved;
	
	
	//Page Methods
	
	public String getPageTitle() throws Exception {
		return getElementText(page_Title);
	}
	
	public String getInboxMessageLimitTxt() throws Exception {
		return getElementText(page_Inbox_Messages_Limit);
	}
	public AccountDefaultsPage setLimitDays(String LimitDays) throws Exception {
		sendKeysToWebElement(txtF_Limit_Days, LimitDays);
		return new AccountDefaultsPage();
	}
	
	public AccountDefaultsPage clickLimitDaysSaveDtn() throws Exception {
		waitAndClickElement(btn_Limit_Days_Save);
		return new AccountDefaultsPage();
	}
	
	public String getAlertSavedTxt() throws Exception {
		return getElementText(alert_Saved);
	}
	
	public AccountDefaultsPage getEngagementSettingsTxt() throws Exception {
		getElementText(page_Engagement_Settings);
		return new AccountDefaultsPage();
	}
	
	public AccountDefaultsPage getDefaultValueTxt() throws Exception {
		getElementText(page_Default_Value);
		return new AccountDefaultsPage();
	}
	
	public AccountDefaultsPage setDefaultFirstNameVariable(String name) throws Exception {
		sendKeysToWebElement(txtF_Default_Value, name);
		return new AccountDefaultsPage();
	}
	
	public AccountDefaultsPage clickDefaultValueSaveBtn() throws Exception {
		waitAndClickElement(btn_Default_Value_Save);
		return new AccountDefaultsPage();
	}
		
	public AccountDefaultsPage clickSaveEngagementSettingsBtn() throws Exception {
		waitAndClickElement(btn_Save_Engagements_Settings);
		return new AccountDefaultsPage();
	}
	
	public AccountDefaultsPage clickAccountDefaultsToggleBtn() throws Exception {
		waitAndClickElement(toggle_Default_Custom);
		return new AccountDefaultsPage();
	}
	
}
