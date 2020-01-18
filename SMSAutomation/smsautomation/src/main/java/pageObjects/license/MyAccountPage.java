package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.ElementLocator;
import pageObjects.BasePage;
import utils.Constant;

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
	public @FindBy(xpath = "//a[@data-target=\"#credit-card-modal\"]") WebElement btn_Payment_Edit;
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
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Billing Contact\"]") WebElement mod_Billing_Contact_Title;
	public @FindBy(xpath = "//input[@id=\"billing-first-name\"]") WebElement txtF_Billing_Contact_First;
	public @FindBy(xpath = "//input[@id=\"billing-last-name\"]") WebElement txtF_Billing_Contact_LastName;
	public @FindBy(xpath = "//input[@id=\"billing-email\"]") WebElement txtF_Billing_Contact_Email;
	public @FindBy(xpath = "//input[@id=\"billing-address-1\"]") WebElement txtF_Billing_Contact_StreetAddr;
	public @FindBy(xpath = "//input[@id=\"billing-address-2\"]") WebElement txtF_Billing_Contact_Suite;
	public @FindBy(xpath = "//input[@id=\"billing-city\"]") WebElement txtF_Billing_Contact_City;
	public @FindBy(xpath = "(//div[contains(@class, \"form-group\") and ./label[(.)=\"State\"]]//div[contains(@class, \"selectize-input\")])[1]") WebElement lov_Billing_Contact_State;
	public @FindBy(xpath = "//input[@id=\"billing-postal-code\"]") WebElement txtF_Billing_Contact_PostalCode;
	public @FindBy(xpath = "//button[@id=\"save-billing-details\"]") WebElement btn_Billing_Contact_Edit_SaveChanges;

	// Credit Card Edit elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Change Password\"]") WebElement mod_Credit_Card_Title;
	public @FindBy(xpath = "//input[@id=\"billing-first-name\"]") WebElement txtF_Name_On_Card;
	public @FindBy(xpath = "//input[@id=\"billing-first-name\"]") WebElement txtF_Card_Number;
	public @FindBy(xpath = "//input[@id=\"billing-first-name\"]") WebElement txtF_Zip_Code;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\") and ./input[@id=\"exp-month-selectized\"]]") WebElement txtF_Exp_Month;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\") and ./input[@id=\"exp-year-selectized\"]]") WebElement txtF_Exp_Year;
	public @FindBy(xpath = "//input[@id=\"cvv\"]") WebElement txtF_CVV;
	public @FindBy(xpath = "//button[@id=\"save-card-details\"]") WebElement btn_Update_Credit_Card;

	// Page Methods

	public String getPageTitle() throws Exception {
		return getElementText(page_Title);
	}

	public String getMyPlanTxt() throws Exception {
		return getElementText(page_My_Plan_Section);
	}

	public String getAccountDetailsTxt() throws Exception {
		return getElementText(page_Account_Details_Section);
	}

	public String getAccountResourcesTxt() throws Exception {
		return getElementText(page_Account_Resources_Section);
	}

	public MyAccountPage clickPlanDetailsLink() throws Exception {
		waitAndClickElement(lnk_Plan_Details);
		return new MyAccountPage();
	}

	public MyAccountPage clickNewPlanChangePlanBtn() throws Exception {
		waitAndClickElement(btn_Change_Plan_New_Plan);
		return new MyAccountPage();
	}

	public MyAccountPage clickChangePlanBtn() throws Exception {
		waitAndClickElement(btn_Change_Plan);
		return new MyAccountPage();
	}

	public MyAccountPage clickAccountContactEditBtn() throws Exception {
		waitAndClickElement(btn_Account_Contact_Edit);
		return new MyAccountPage();
	}

	public MyAccountPage clickAccountContactChangePasswordBtn() throws Exception {
		waitAndClickElement(btn_Account_Contact_Change_Password);
		return new MyAccountPage();
	}

	public MyAccountPage clickBillingContactEditBtn() throws Exception {
		waitAndClickElement(btn_Billing_Contact_Edit);
		return new MyAccountPage();
	}

	public MyAccountPage clickCreditCardEditBtn() throws Exception {
		waitAndClickElement(btn_Payment_Edit);
		return new MyAccountPage();
	}

	public String getPlanDetailsTxt() throws Exception {
		return getElementText(win_Plan_Details_Body);
	}

	public String getPlanUpdateMessageTxt() throws Exception {
		return getElementText(txt_Plan_Update_Message);
	}

	public String getPlanNameTxt() throws Exception {
		return getElementText(txt_Plan_Name);
	}

	// New Plan Window methods
	public String getNewPlanWindowTitle() throws Exception {
		return getElementText(mod_New_Plan_Title);
	}

	public MyAccountPage selectPlan(String planName) throws Exception {
		waitAndClickElement(rBtn_Plan_Name_Opt(planName));
		return new MyAccountPage();
	}

	// Account Contact methods

	public String getAccountContactEditTitle() throws Exception {
		return getElementText(mod_Account_Contact_Edit_Title);
	}

	public MyAccountPage setFirstName(String FirstName) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_First, FirstName);
		return new MyAccountPage();
	}

	public MyAccountPage setLastName(String LastName) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_LastName, LastName);
		return new MyAccountPage();
	}

	public MyAccountPage setStreetAddress(String Address) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_StreetAddr, Address);
		return new MyAccountPage();
	}

	public MyAccountPage setAccountContactCity(String city) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_City, city);
		return new MyAccountPage();
	}

	public MyAccountPage setAccountContactPostalCode(String postalCode) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_PostalCode, postalCode);
		return new MyAccountPage();
	}

	public MyAccountPage clickAccountContactEditSaveChanges() throws Exception {
		waitAndClickElement(btn_Account_Contact_Edit_SaveChanges);
		return new MyAccountPage();
	}

	public String getAccountDetailsSavedMessageTxt() throws Exception {
		return getElementText(txtF_Account_Details_Save_Alert);
	}

	// Billing Contact methods

	public String getBillingContactEditTitle() throws Exception {
		return getElementText(mod_Billing_Contact_Title);
	}

	public MyAccountPage setBillingCity(String city) throws Exception {
		sendKeysToWebElement(txtF_Billing_Contact_City, city);
		return new MyAccountPage();
	}

	public MyAccountPage setBillingPostalCode(String postalCode) throws Exception {
		sendKeysToWebElement(txtF_Billing_Contact_PostalCode, postalCode);
		return new MyAccountPage();
	}

	public MyAccountPage clickBillingContactEditSaveChanges() throws Exception {
		waitAndClickElement(btn_Billing_Contact_Edit_SaveChanges);
		return new MyAccountPage();
	}

	// Change Password methods

	public String getChangePasswordWindowTitle() throws Exception {
		return getElementText(mod_Account_Contact_ChangePassword_Title);
	}
	
	public MyAccountPage setCurrentPassword(String currentPass) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_ChangePassword_CurrPass, currentPass);
		return new MyAccountPage();
	}

	public MyAccountPage setNewPassword(String newPass) throws Exception {
		sendKeysToWebElement(txtF_Account_Contact_ChangePassword_NewPass, newPass);
		return new MyAccountPage();
	}

	public MyAccountPage clickChangePasswordBtn() throws Exception {
		waitAndClickElement(btn_Account_Contact_ChangePassword_ChangePass);
		return new MyAccountPage();
	}
	
	public String getCurrentPasswordErrorMsg() throws Exception {
		return getElementText(err_Current_Password);
	}
	
	public String getNewPasswordErrorMsg() throws Exception {
		return getElementText(err_New_Password);
	}
	
	public String getInvalidCurrentPasswordErrorMsg() throws Exception {
		return getElementText(err_Invalid_Current_Password);
	}

	public String getWeakNewPasswordWarningMsg() throws Exception {
		return getElementText(wrn_TooWeak_New_Password);
	}
	
	public String getWeakNewPasswordTooltip() throws Exception {
		return getElementText(txt_Weak_New_PasswordTooltip);
	}
	
	public MyAccountPage clickNewPasswordTooltipIcon() throws Exception {
		waitAndClickElement(icon_New_PasswordTooltip);
		return new MyAccountPage();
	}
	
	public String getPasswordRequirementsTxt() throws Exception {
		return getElementText(txt_Weak_New_PasswordTooltip);
	}
}
