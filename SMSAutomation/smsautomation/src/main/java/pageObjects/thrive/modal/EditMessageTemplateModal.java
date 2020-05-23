package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditMessageTemplateModal extends BasePage {

	public EditMessageTemplateModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[contains(text(), \"Edit Message Template\")]") WebElement mod_Title;
	public @FindBy(xpath = "(//button[@class=\"close\"]//span[@aria-hidden=\"true\"])[3]") WebElement btn_Close;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Subject\"]]]//input[@id=\"merchant_email_template_type_subject\"]") WebElement txtF_Subject;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"To\"]]]//input[@id=\"merchant_email_template_type_recipient\"]") WebElement txtF_To;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"CC\"]]]//input[@id=\"merchant_email_template_type_carbon_copy\"]") WebElement txtF_CC;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"BCC\"]]]//input[@id=\"merchant_email_template_type_blind_carbon_copy\"]") WebElement txtF_BCC;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Header\"]]]//textarea[@id=\"merchant_email_template_type_header\"]") WebElement txtF_Header;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Email Body\"]]]//textarea[@id=\"merchant_email_template_type_body\"]") WebElement txtF_EmailBody;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"SMS Text\"]]]//textarea[@id=\"merchant_email_template_type_shortBody\"]") WebElement txtF_SMSText;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Footer\"]]]//textarea[@id=\"merchant_email_template_type_footer\"]") WebElement txtF_Footer;	
	
	public @FindBy(xpath = "//button[contains(@class, \"ladda-button\")]") WebElement btn_SaveSettings;
	
	
	// Message Templates locators
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_subject\"])[2]") WebElement txtF_MSubject;
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_recipient\"])[2]") WebElement txtF_MTo;
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_sender\"])[2]") WebElement txtF_FROM;
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_carbon_copy\"])[2]") WebElement txtF_MCC;
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_blind_carbon_copy\"])[2]") WebElement txtF_MBCC;
	public @FindBy(xpath = "(//textarea[@id=\"admin_email_template_type_header\"])[2]") WebElement txtA_Header;
	public @FindBy(xpath = "(//textarea[@id=\"admin_email_template_type_body\"])[2]") WebElement txtA_EmailBody;
	public @FindBy(xpath = "(//textarea[@id=\"admin_email_template_type_shortBody\"])[2]") WebElement txtA_SMSText;
	public @FindBy(xpath = "(//textarea[@id=\"admin_email_template_type_footer\"])[2]") WebElement txtA_Footer;	
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_title\"])[2]") WebElement txtF_Title;	
	public @FindBy(xpath = "(//input[@id=\"admin_email_template_type_slug\"])[2]") WebElement txtF_Slug;	
	public @FindBy(xpath = "(//select[@id=\"admin_email_template_type_group\"])[2]") WebElement txtF_Role;	
	public @FindBy(xpath = "(//textarea[@id=\"admin_email_template_type_description\"])[2]") WebElement txtA_Description;
	public @FindBy(xpath = "(//button[contains(@class, \"ladda-button\")])[2]") WebElement btn_MSaveSettings;
	
	
	
//	Error Messages
	public @FindBy(xpath = "//div[contains(@class, \"form-group has-error\") and ./label[normalize-space()=\"From\"]]") WebElement error_From;
	public @FindBy(xpath = "//div[contains(@class, \"form-group has-error\") and ./label[normalize-space()=\"To\"]]") WebElement error_To;
	
	
}
