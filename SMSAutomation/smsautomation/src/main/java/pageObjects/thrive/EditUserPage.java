package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditUserPage extends BasePage{

	public EditUserPage() throws IOException {
		super();
	}
	
	// Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_firstname\"]") WebElement txtF_FirstName;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_lastname\"]") WebElement txtF_LastName;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_email\"]") WebElement txtF_PrimaryEmail;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_plainPassword\"]") WebElement txtF_Password;
	public @FindBy(xpath = "//input[@id=\"merchant_user_type_user_phone\"]") WebElement txtF_CellPhone;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"merchant_user_type_enabled_0\"]]") WebElement btn_Status_Active;
	public @FindBy(xpath = "//label[contains(@class, \"btn-default\") and ./input[@id=\"merchant_user_type_enabled_1\"]]") WebElement btn_Status_Inactive;
	
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./labelnormalize-space()=\"Company\"]]//div[@data-toggle=\"toggle\"]") WebElement tog_Company;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Settings\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Settings;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Users\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Users;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Invoices\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Invoices;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[text()[normalize-space()=\"Plans\"]]]//div[@data-toggle=\"toggle\"]") WebElement tog_Plans;
	
	public @FindBy(xpath = "//button[@id=\"create-user-submit\"]") WebElement btn_SaveUser;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]//p[normalize-space()]") WebElement txt_Save_Alert_Notification;
	public @FindBy (xpath = "//div[@id=\"user-information\" and .//h4[text()=\"Time Zone Information\"]]") WebElement panel_TimeZone;
	public @FindBy (xpath = "//select[@id=\"user_type_user_timezone\"]") WebElement timeZoneDDown;
	public @FindBy (xpath = "//select[@id=\"user_type_user_timezone\"]//option[@selected=\"selected\"]") WebElement selectedTimeZone;	
	public WebElement timeZoneValue (String value) {
		return timeZoneDDown.findElement(By.xpath("//option[text()=\'" + value + "']"));
	}
	
	// Lead Tracking Permissions label
	public @FindBy(xpath = "//label[normalize-space()=\"Create/Update Orders\"]") WebElement lbl_CreateUpdateOrders;
	public @FindBy(xpath = "//label[normalize-space()=\"Manage Leads\"]") WebElement lbl_ManageLeads;
	public @FindBy(xpath = "//label[normalize-space()=\"View Appointments\"]") WebElement lbl_ViewAppointments;
	
	// Toggle switch
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[normalize-space()=\"Create/Update Orders\"]]//div[@data-toggle=\"toggle\"]") WebElement tog_CreateUpdateOrders;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[normalize-space()=\"Manage Leads\"]]//div[@data-toggle=\"toggle\"]") WebElement tog_ManageLeads;
	public @FindBy(xpath = "//div[contains(@class, \"permission-choice\") and ./label[normalize-space()=\"View Appointments\"]]//div[@data-toggle=\"toggle\"]") WebElement tog_ViewAppointments;
	
	public @FindBy(xpath = "//h3[contains(@class, \"group-label\") and contains(text(), \"Lead Tracking\")]//a[@class=\"permissions-enable\"]") WebElement leadPermissionEnable;
	public @FindBy(xpath = "//h3[contains(@class, \"group-label\") and contains(text(), \"Lead Tracking\")]//a[@class=\"permissions-disable\"]") WebElement leadPermissionDisable;
	
	
	public WebElement tog_Deny_CreateUpdateOrders() {
		return tog_CreateUpdateOrders.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-off\")]"));
	}
	
	public WebElement tog_Allow_CreateUpdateOrders() {
		return tog_CreateUpdateOrders.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-on\")]"));
	}
	
	public WebElement tog_Deny_ManageLeads() {
		return tog_ManageLeads.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-off\")]"));
	}
	
	public WebElement tog_Allow_ManageLeads() {
		return tog_ManageLeads.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-on\")]"));
	}
	
	public WebElement tog_Deny_ViewAppointments() {
		return tog_ViewAppointments.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-off\")]"));
	}
	
	public WebElement tog_Allow_ViewAppointments() {
		return tog_ViewAppointments.findElement(By.xpath("//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-on\")]"));
	}
}






