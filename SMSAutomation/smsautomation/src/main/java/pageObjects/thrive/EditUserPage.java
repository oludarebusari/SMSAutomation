package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditUserPage extends BasePage{

	public EditUserPage() throws IOException {
		super();
	}
	
	//Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_firstname\"]") WebElement txtF_FirstName;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_lastname\"]") WebElement txtF_LastName;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_email\"]") WebElement txtF_PrimaryEmail;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_plainPassword\"]") WebElement txtF_Password;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_phone\"]") WebElement txtF_CellPhone;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"merchant_user_type_enabled_0\"]]") WebElement btn_Status_Active;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"merchant_user_type_enabled_1\"]]") WebElement btn_Status_Inactive;
	
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Company\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Company;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Settings\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Settings;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Users\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Users;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Invoices\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Invoices;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Plans\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Plans;
	
	public @FindBy(xpath = "//button[@id=\"create-user-submit\"]") WebElement btn_SaveUser;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]//p[normalize-space()]") WebElement txt_Save_Alert_Notification;

}
