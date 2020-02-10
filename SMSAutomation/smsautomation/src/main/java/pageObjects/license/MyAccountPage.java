package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import components.elements.ElementLocator;
import pageObjects.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = ElementLocator.ELEM_PAGE_TITLE) WebElement page_Title;
	public @FindBy(xpath = "//h4[(.)=\"My Plan\"]") WebElement page_My_Plan_Section;
	public @FindBy(xpath = "//h4[(.)=\"Account Details\"]") WebElement page_Account_Details_Section;
	public @FindBy(xpath = "//h4[(.)=\"Account Resources\"]") WebElement page_Account_Resources_Section;
	public @FindBy(xpath = "//button[@data-target=\"#plan-modal\"]") WebElement btn_Change_Plan;
	public @FindBy(xpath = "//a[@data-target=\"#account-details-modal\"]") WebElement btn_Account_Contact_Edit;
	public @FindBy(xpath = "//a[@data-target=\"#change-password-modal\"]") WebElement btn_Account_Contact_Change_Password;
	public @FindBy(xpath = "//a[@data-target=\"#billing-details-modal\"]") WebElement btn_Billing_Contact_Edit;
	public @FindBy(xpath = "//a[@data-target=\"#credit-card-modal\"]") WebElement btn_Credit_Card_Edit;
	public @FindBy(xpath = "//a[@data-target=\"#plan_details_modal\"]") WebElement lnk_Plan_Details;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[(.)=\"Plan Details\"]]//div[@class=\"modal-body\"]") WebElement win_Plan_Details_Body;
	public @FindBy(xpath = "//div[@id=\"plan-update-message\"]") WebElement txt_Plan_Update_Message;
	public @FindBy(xpath = "//h3[@class=\"remove-top\"]") WebElement txt_Plan_Name;

	// New Plan Window elements
	public @FindBy(xpath = "//div[@class=\"modal-content\"]//h3[(.)=\"Select a New Plan\"]") WebElement mod_New_Plan_Title;
	public @FindBy(xpath = "//div[contains(@class, \"list-group remove-bottom\")]") WebElement parentBtn;

	public WebElement rBtn_Plan_Name_Opt(String name) {
		return parentBtn.findElement(By.xpath("//a[@data-name='" + name + "']"));
	};

	public @FindBy(xpath = "//button[@id=\"change-plan\"]") WebElement btn_Change_Plan_New_Plan;

	// Account Resources elements
	public @FindBy(xpath = "//a[@data-target=\"#prepaid-blocks-modal\"]") WebElement lnk_Prepaid_Blocks;
	public @FindBy(xpath = "//a[contains(text(), \"Blacklist/Whitelist\")]") WebElement lnk_Blacklist_Whitelist;
	public @FindBy(xpath = "//a[@data-target=\"#autopurchase-modal\"]") WebElement lnk_Auto_Purchase;
	public @FindBy(xpath = "//a[@data-target=\"#purchase-history-modal\"]") WebElement lnk_Purchase_History;
	public @FindBy(xpath = "//div[@id=\"autopurchase-update-message\"]") WebElement txt_Auto_Purchase_Update_Message;
	public @FindBy(xpath = "//div[@id=\"prepaid-blocks-update-message\"]") WebElement txt_Purchase_Message_Credit_Update_Message;
	
	
	// Account Contacts Edit elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Account Contact\"]") WebElement mod_Account_Contact_Edit_Title;
	public @FindBy(xpath = "//input[@id=\"first-name\"]") WebElement txtF_Account_Contact_First;
	public @FindBy(xpath = "//input[@id=\"last-name\"]") WebElement txtF_Account_Contact_LastName;
	public @FindBy(xpath = "//input[@id=\"email\"]") WebElement txtF_Account_Contact_Email;
	public @FindBy(xpath = "//input[@id=\"phone\"]") WebElement txtF_Account_Contact_Phone;
	public @FindBy(xpath = "//input[@id=\"address-1\"]") WebElement txtF_Account_Contact_StreetAddr;
	public @FindBy(xpath = "//input[@id=\"address-2\"]") WebElement txtF_Account_Contact_Suite;
	public @FindBy(xpath = "//input[@id=\"city\"]") WebElement txtF_Account_Contact_City;
	public @FindBy(xpath = "(//div[contains(@class, \"form-group\") and ./label[(.)=\"State\"]]//div[contains(@class, \"selectize-input\")])[1]") WebElement lov_Account_Contact_State;
	public @FindBy(xpath = "//input[@id=\"postal-code\"]") WebElement txtF_Account_Contact_PostalCode;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[(.)=\"Email Notifications\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Account_Contact_Email_Notification;
	public @FindBy(xpath = "//button[@id=\"save-account-details\"]") WebElement btn_Account_Contact_Edit_SaveChanges;
	public @FindBy(xpath = "//div[@id=\"account-details-saved-alert\"]") WebElement txtF_Account_Details_Save_Alert;

	// Account Contacts Change Password elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Change Password\"]") WebElement mod_Account_Contact_ChangePassword_Title;
	public @FindBy(xpath = "//input[@id=\"old-password\"]") WebElement txtF_Account_Contact_ChangePassword_CurrPass;
	public @FindBy(xpath = "//input[@id=\"new-password\"]") WebElement txtF_Account_Contact_ChangePassword_NewPass;
	public @FindBy(xpath = "//button[@id=\"change-password\"]") WebElement btn_Account_Contact_ChangePassword_ChangePass;
	public @FindBy(xpath = "//label[@id=\"old-password-error\" and contains(text(), \"field\")]") WebElement err_Current_Password;
	public @FindBy(xpath = "//label[@id=\"new-password-error\" and contains(text(), \"field\")]") WebElement err_New_Password;
	public @FindBy(xpath = "//div[@class=\"alert alert-danger\" and ./div[(.)=\"Invalid Current Password\"]]") WebElement err_Invalid_Current_Password;
	public @FindBy(xpath = "//label[@id=\"new-password-error\"]") WebElement wrn_TooWeak_New_Password;
	public @FindBy(xpath = "//div[@class=\"tooltip-inner\"]") WebElement txt_Weak_New_PasswordTooltip;
	public @FindBy(xpath = "//i[@data-toggle=\"tooltip\"]") WebElement icon_New_PasswordTooltip;

	// Billing Contact Edit elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Billing Contact\"]") WebElement mod_Bill_Contact_Title;
	public @FindBy(xpath = "//input[@id=\"billing-first-name\"]") WebElement txtF_Bill_Contact_First;
	public @FindBy(xpath = "//input[@id=\"billing-last-name\"]") WebElement txtF_Bill_Contact_LastName;
	public @FindBy(xpath = "//input[@id=\"billing-email\"]") WebElement txtF_Bill_Contact_Email;
	public @FindBy(xpath = "//input[@id=\"billing-address-1\"]") WebElement txtF_Bill_Contact_StreetAddr;
	public @FindBy(xpath = "//input[@id=\"billing-address-2\"]") WebElement txtF_Bill_Contact_Suite;
	public @FindBy(xpath = "//input[@id=\"billing-city\"]") WebElement txtF_Bill_Contact_City;
	public @FindBy(xpath = "(//div[contains(@class, \"form-group\") and ./label[(.)=\"State\"]]//div[contains(@class, \"selectize-input\")])[1]") WebElement lov_Bill_Contact_State;
	public @FindBy(xpath = "//input[@id=\"billing-postal-code\"]") WebElement txtF_Bill_Contact_PostalCode;
	public @FindBy(xpath = "//button[@id=\"save-billing-details\"]") WebElement btn_Bill_Contact_Edit_SaveChanges;
	public @FindBy(xpath = "//span[@data-update-on=\"bill_city\"]") WebElement txt_Bill_Contact_City;
	public @FindBy(xpath = "//span[@data-update-on=\"bill_eni_state_id\"]") WebElement txt_Bill_Contact_State;
	public @FindBy(xpath = "//span[@data-update-on=\"bill_postal\"]") WebElement txt_Bill_Contact_PostalCode;

	// Credit Card Edit elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Credit Card Details\"]") WebElement mod_Credit_Card_Title;
	public @FindBy(xpath = "//input[@id=\"card-name\"]") WebElement txtF_Name_On_Card;
	public @FindBy(xpath = "//input[@id=\"card-number\"]") WebElement txtF_Card_Number;
	public @FindBy(xpath = "//input[@id=\"card-zip\"]") WebElement txtF_Zip_Code;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\") and ./input[@id=\"exp-month-selectized\"]]") WebElement lov_Exp_Month;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\") and ./input[@id=\"exp-year-selectized\"]]") WebElement lov_Exp_Year;
	public @FindBy(xpath = "//input[@id=\"cvv\"]") WebElement txtF_CVV;
	public @FindBy(xpath = "//button[@id=\"save-card-details\"]") WebElement btn_Update_Credit_Card;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentLOVVal;

	public WebElement num_CreditCardMonth(String num) {
		return parentBtn.findElement(By.xpath("//div[text()='" + num + "']"));
	};

	public @FindBy(xpath = "//div[contains(@class, \"alert-danger\") and ./div[contains(text(), \"CC processing\")]]") WebElement txt_Credit_Card_Update_Msg;
	public @FindBy(xpath = "//div[contains(@class, \"col-sm-6\")]//b[(.)=\"Billing Period\"]") WebElement txt_Billing_Period;
	public @FindBy(xpath = "//div[contains(@class, \"input-group-sm\")]//option[text()=\"25\"]") WebElement pag_Purchase_Page_Size;

	public @FindBy(xpath = "//div[contains(@class, \"input-group-sm\")]") WebElement parentSize;

	public WebElement num_PageSize(String num) {
		return parentSize.findElement(By.xpath("//option[text()='" + num + "']"));
	};


}
