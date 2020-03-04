package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditCompanyPage extends BasePage {

	public EditCompanyPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[contains(@class, \"pull-left\")]") WebElement pag_Title;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]//p[normalize-space()]") WebElement txt_Action_Notification;
	public @FindBy(xpath = "//button[@id=\"submit-btn\"]") WebElement btn_Save;
	
	// Business Information Elements
	public @FindBy(xpath = "//div[@id=\"create-business-panel\"]") WebElement panel_BusinessInformation;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_name\"]") WebElement txtF_BusinessName;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_supportEmail\"]") WebElement txtF_SupportEmail;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_phone\"]") WebElement txtF_BusinessPhone;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_logoFile\"]") WebElement btn_ChooseFile;
	public @FindBy(xpath = "//div[@class=\"form-group\"]//img") WebElement logo_Company;	
	
	// Billing Information Elements
	public @FindBy(xpath = "//div[@id=\"create-billing-panel\"]") WebElement panel_BillingInformation;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_singleCompanyAddress_address\"]") WebElement txtF_Address;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_singleCompanyAddress_city\"]") WebElement txtF_City;
	public @FindBy(xpath = "//select[@id=\"company_type_companyAddress_country\"]") WebElement lov_Country;
	public WebElement opt_Country (String country) {
		return lov_Country.findElement(By.xpath("//option[text()=\'" + country + "']"));
	}
	public WebElement selectedCountry () {
		return lov_Country.findElement(By.xpath("//select[@id=\"company_type_companyAddress_country\"]//option[@selected]"));
	}
	public @FindBy(xpath = "//select[@id=\"company_type_companyAddress_state\"]") WebElement lov_State;
	public WebElement opt_State (String state) {
	    return lov_State.findElement(By.xpath("//option[text()=\'" + state + "']"));
	}
	public WebElement selectedState() {
	    return lov_State.findElement(By.xpath("//select[@id=\"company_type_companyAddress_state\"]//option[@selected]"));
	}
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_singleCompanyAddress_zipCode\"]") WebElement txtF_ZipCode;
}
