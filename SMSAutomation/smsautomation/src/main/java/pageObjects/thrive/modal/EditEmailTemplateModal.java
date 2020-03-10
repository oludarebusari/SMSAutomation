package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditEmailTemplateModal extends BasePage {

	public EditEmailTemplateModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[contains(text(), \"Edit Message Template\")]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Subject\"]]]//input[@id=\"merchant_email_template_type_subject\"]") WebElement txtF_Subject;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"To\"]]]//input[@id=\"merchant_email_template_type_recipient\"]") WebElement txtF_To;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"CC\"]]]//input[@id=\"merchant_email_template_type_carbon_copy\"]") WebElement txtF_CC;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"BCC\"]]]//input[@id=\"merchant_email_template_type_blind_carbon_copy\"]") WebElement txtF_BCC;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Header\"]]]//textarea[@id=\"merchant_email_template_type_header\"]") WebElement txtF_Header;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Email Body\"]]]//textarea[@id=\"merchant_email_template_type_body\"]") WebElement txtF_EmailBody;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"SMS Text\"]]]//textarea[@id=\"merchant_email_template_type_shortBody\"]") WebElement txtF_SMSText;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Footer\"]]]//textarea[@id=\"merchant_email_template_type_footer\"]") WebElement txtF_Footer;	
	
	public @FindBy(xpath = "//button[contains(@class, \"ladda-button\")]") WebElement btn_SaveSettings;
	
	
}
