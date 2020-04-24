package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminEditLanguageStringsModal extends BasePage {

	public AdminEditLanguageStringsModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h4[text()=\"Edit Language Strings\"]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\" and .//h4[text()=\"Edit Language Strings\"]]//button[@class=\"close\"]") WebElement btn_Close;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_language_strings_type_title\"])[2]") WebElement txtF_Title;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_language_strings_type_slug\"])[2]") WebElement txtF_Slug;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//select[@id=\"admin_language_strings_type_type\"])[2]") WebElement typeDDown;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_language_strings_type_section\"])[2]") WebElement txtF_Group;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//select[@id=\"admin_language_strings_type_group\"])[2]") WebElement roleDDown;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//input[@id=\"admin_settings_type_title\"])[2]") WebElement txtF_AdminLanguageStringValue;
	public @FindBy(xpath = "(//div[@class=\"form-group\"]//textarea[@id=\"admin_language_strings_type_description\"])[2]") WebElement txtF_Description;
	public @FindBy(xpath = "(//button[contains(@class, \"ladda-button\")])[2]") WebElement btn_SaveSettings;

}
