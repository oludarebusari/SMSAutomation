package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditResellerPage extends BasePage {

	public EditResellerPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\") and .//p[text()[normalize-space()]]]") WebElement alert_SuccessNotification;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_name\"]") WebElement txtF_BusinessName;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_supportEmail\"]") WebElement txtF_SupportEmail;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_phone\"]") WebElement txtF_BusinessPhone;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_adminDomain\"]") WebElement txtF_BackendDomain;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_subdomainBase\"]") WebElement txtF_SubdomainBase;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_logoFile\"]") WebElement btn_CompanyLogo_ChooseFile;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_squareLogoFile\"]") WebElement btn_HeaderLogo_ChooseFile;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"company_licensee_type_status_0\"]]") WebElement btn_Status_Demo;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"company_licensee_type_status_1\"]]") WebElement btn_Status_Live;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"company_licensee_type_status_2\"]]") WebElement btn_Status_Inactive;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Engage Account\"]]]//div[contains(@class, \"selectize-input\")]") WebElement lov_EngageAccount;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Licenses\"]]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_Licenses;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_singleCompanyAddress_address\"]") WebElement txtF_Address;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_singleCompanyAddress_city\"]") WebElement txtF_City;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Country\"]]]//select[@id=\"company_licensee_type_singleCompanyAddress_country\"]") WebElement lov_Country;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"State\"]]]//select[@id=\"company_licensee_type_singleCompanyAddress_state\"]") WebElement lov_State;
	public @FindBy(xpath = "//input[@id=\"company_licensee_type_singleCompanyAddress_zipCode\"]") WebElement txtF_ZipCode;
	public @FindBy(xpath = "//textarea[@id=\"company_licensee_type_territories\"]") WebElement txtF_Allowed_ZipCodes;	
	public @FindBy(xpath = "//button[contains(@class, \"btn-block\")]") WebElement btn_Save_Reseller;
}
