package pageObjects.thrive.modal;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminEditSettingsModal extends BasePage {

	public AdminEditSettingsModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[text()=\"Edit Setting\"]") WebElement mod_Title;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_settings_type_title\"])[2]") WebElement txtF_Title;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_settings_type_slug\"])[2]") WebElement txtF_Slug;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_settings_type_section\"])[2]") WebElement txtF_Group;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//select[@id=\"admin_settings_type_type\"])[2]") WebElement typeDDown;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//select[@id=\"admin_settings_type_group\"])[2]") WebElement accessLevelDDown;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_settings_type_title\"])[2]") WebElement txtF_AdminSettingTypeValue;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//textarea[@id=\"admin_settings_type_description\"])[2]") WebElement txtF_Description;
	public @FindBy(xpath = "(//button[contains(@class, \"ladda-button\")])[2]") WebElement btn_SaveSettings;
}

