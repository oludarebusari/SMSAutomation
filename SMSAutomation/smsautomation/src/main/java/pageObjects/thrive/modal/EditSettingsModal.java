package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditSettingsModal  extends BasePage {

	public EditSettingsModal() throws IOException {
		super();
	} 

	public @FindBy(xpath = "//h4[text()=\"Edit Setting\"]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[text()=\"Edit Setting\"]]//button[@class=\"close\"]") WebElement btn_Close;
	public @FindBy(xpath = "//select[@id=\"merchant_settings_type_value\"]") WebElement lov_EditSetting;
	public WebElement editSettingOption(String option) {
		return lov_EditSetting.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}
	public @FindBy(xpath = "//input[@id=\"company_settings_type_value\"]") WebElement txtF_EditSetting;
	public @FindBy(xpath = "//button[contains(@class, \"ladda-button\")]") WebElement btn_SaveSettings;

}
