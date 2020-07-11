package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
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
	public @FindBy(xpath = "//button[normalize-space()=\"Save Reseller\"]") WebElement btn_SaveReseller;
	// License Option Selected
		public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Licenses\"]]//div[contains(@class, \"selectize-input\")]") WebElement licenseDDown;
		public WebElement selectedLicenseOpt (String licenseName) {
			return licenseDDown.findElement(By.xpath("//div[@class=\"item\" and text()=\'" + licenseName + "']"));
		}
		
		public WebElement removeSelectedLicenseOptBtn (String licenseName) {
			return licenseDDown.findElement(By.xpath("//div[@class=\"item\" and text()=\'" + licenseName + "']//a[@title=\"Remove\"]"));
		}
		
		public String selectedLicenseOptLocator (String licenseName) {
			return "//div[@class=\"item\" and text()=\'" + licenseName + "']";
		}
		
		public @FindBy (xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentLicenseLOV;
		
		public WebElement licenseOptionInLOV (String licenseName) {
			return parentLicenseLOV.findElement(By.xpath("//div[contains(@class, \"option\") and text()=\'" + licenseName +"']"));
		}
		
		
	// Office Hour Information elements
	public @FindBy (xpath = "//div[@id=\"user-information\"]") WebElement panel_OfficeHour;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default\") and normalize-space()=\"Sun\"]") WebElement btn_Sun;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Mon\"]") WebElement btn_Mon;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Tue\"]") WebElement btn_Tue;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Wed\"]") WebElement btn_Wed;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Thu\"]") WebElement btn_Thu;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Fri\"]") WebElement btn_Fri;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]//label[contains(@class, \"btn-default \") and normalize-space()=\"Sat\"]") WebElement btn_Sat;
	public @FindBy (xpath = "//div[@id=\"user_type_user_daysAvailable\"]") WebElement daysAvailable;
	
	public WebElement selectedDay(String day) {
		return daysAvailable.findElement(By.xpath("//label[contains(@class, \"active\") and normalize-space()=\'" + day + "']"));
	}
	
    // Office Hour Start 
	public @FindBy (xpath = "//div[normalize-space()=\"Office Hour Start\"]") WebElement sec_OfficeHourStart;
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_startHours\"]") WebElement startHoursDDown;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_startAMPM\"]//label[normalize-space()=\"AM\"]") WebElement btn_StartHourAM;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_startAMPM\"]//label[normalize-space()=\"PM\"]") WebElement btn_StartHourPM;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_startAMPM\"]//label[contains(@class, \"active\")]") WebElement selectedStartTypeAMPM;
	
	public WebElement startHourValue (String value) {
		return startHoursDDown.findElement(By.xpath("//option[text()=\'" + value + "']"));
	}
	
	public String getStartHourValueLocator (String value) {
		return "//option[text()=\'" + value + "']";
	}
	
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_startHours\"]//option[@selected]") WebElement selectedStartHour;
	
	// Office Hour End
	public @FindBy (xpath = "//div[normalize-space()=\"Office Hour End\"]") WebElement sec_OfficeHourEnd;
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_stopHours\"]") WebElement endHourDDown;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_stopAMPM\"]//label[normalize-space()=\"AM\"]") WebElement btn_EndHourAM;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_stopAMPM\"]//label[normalize-space()=\"PM\"]") WebElement btn_EndHourPM;
	public @FindBy (xpath = "//div[@id=\"company_licensee_type_stopAMPM\"]//label[contains(@class, \"active\")]") WebElement selectedEndTypeAMPM;
	
	public WebElement endHourValue (String value) {
		return endHourDDown.findElement(By.xpath("//option[text()=\'" + value + "']"));
	}
	
	public String getEndHourValueLocator (String value) {
		return "//option[text()=\'" + value + "']";
	}
	
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_stopHours\"]//option[@selected]") WebElement selectedEndHour;
	
	// Office TimeZone Information
	public @FindBy (xpath = "//div[@id=\"office-timezone-panel\"]") WebElement panel_OfficeTimeZone;
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_officeTimezone\"]") WebElement timeZoneDDown;
	public @FindBy (xpath = "//select[@id=\"company_licensee_type_officeTimezone\"]//option[@selected]") WebElement selectedTimeZone;	
	public WebElement timeZoneValue (String value) {
		return timeZoneDDown.findElement(By.xpath("//option[text()=\'" + value + "']"));
	}
	
	
		
}
