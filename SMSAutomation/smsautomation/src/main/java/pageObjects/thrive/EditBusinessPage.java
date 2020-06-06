package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditBusinessPage extends BasePage {

	public EditBusinessPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]") WebElement txt_SentNotification;
//	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_name\"]") WebElement txtF_BusinessName;
	public @FindBy(xpath = "//input[@id=\"company_licensee_merchant_type_name\" or @id=\"company_admin_merchant_type_name\"]") WebElement txtF_BusinessName;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Business Category\"]]]//div[contains(@class, \"selectize-input\")]") WebElement lov_BusinessCategory;
	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_supportEmail\"]") WebElement txtF_SupportEmail;
//	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_phone\"]") WebElement txtF_BusinessPhone;
	public @FindBy(xpath = "//input[@id=\"company_licensee_merchant_type_phone\" or @id=\"company_admin_merchant_type_phone\"]") WebElement txtF_BusinessPhone;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"company_admin_merchant_type_status_0\"]]") WebElement btn_StatusLive;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"company_admin_merchant_type_status_1\"]]") WebElement btn_StatusInactive;
//	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_singleCompanyAddress_address\"]") WebElement txt_Address;
	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_singleCompanyAddress_address\" or @id=\"company_licensee_merchant_type_singleCompanyAddress_address\"]") WebElement txtF_Address;
	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_singleCompanyAddress_city\" or @id=\"company_licensee_merchant_type_singleCompanyAddress_city\"]") WebElement txtF_City;
	public @FindBy(xpath = "//select[@id=\"company_admin_merchant_type_singleCompanyAddress_country\" or @id=\"company_type_companyAddress_country\"]") WebElement countryDDown;
	public @FindBy(xpath = "//select[@id=\"company_admin_merchant_type_singleCompanyAddress_state\" or @id=\"company_type_companyAddress_state\"]") WebElement stateDDown;
	public @FindBy(xpath = "//input[@id=\"company_admin_merchant_type_singleCompanyAddress_zipCode\" or @id=\"company_licensee_merchant_type_singleCompanyAddress_zipCode\"]") WebElement txtF_ZipCode;
	public @FindBy(xpath = "//button[@type=\"submit\" and text()[normalize-space()=\"Save Business\"]]") WebElement btn_SaveBusiness;
	public @FindBy(xpath = "//div[@id=\"create-business-panel\"]") WebElement businessInformationPanel;
	public @FindBy(xpath = "//div[@id=\"create-billing-panel\"]") WebElement billingInformationPanel;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Business Category\"]]]") WebElement par_BusinessCategory;
	public WebElement businessCategoryOpt(String option) {
		return par_BusinessCategory.findElement(By.xpath("//div[contains(@class, \"selectize-control\")]//div[text()=" + option + "]"));
	}	
	
	
	public @FindBy(xpath = "//label[contains(@class, \"toggle-off\") and text()=\"Invoice\"]") WebElement tog_Invoice;
	public @FindBy(xpath = "//label[contains(@class, \"toggle-on\") and text()=\"Credit Card\"]") WebElement tog_CreditCard;
	public @FindBy(xpath = "//input[@id=\"company_licensee_merchant_type_paymentMethod_creditCardNumber\"]") WebElement txtF_CCN;
	public @FindBy(xpath = "//input[@id=\"company_licensee_merchant_type_paymentMethod_creditCardExpirationDate\"]") WebElement txtF_CCExpiryDate;
	public @FindBy(xpath = "//input[@id=\"company_licensee_merchant_type_paymentMethod_creditCardCVV\"]") WebElement txtF_CVV;
	public @FindBy(xpath = "//div[@class=\"well\"]") WebElement panel_CreditCard;
	
	
}
