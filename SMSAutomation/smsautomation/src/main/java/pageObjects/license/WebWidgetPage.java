package pageObjects.license;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.ElementLocator;
import pageObjects.BasePage;

public class WebWidgetPage extends BasePage {

	public WebWidgetPage() throws IOException {
		super();
	}

	// Page Elements

	public @FindBy(xpath = ElementLocator.ELEM_PAGE_TITLE) WebElement page_Title;
	public @FindBy(xpath = "//h3[(.)=\"Configure Your Widget\"]") WebElement page_Configure_Your_Widget;
	public @FindBy(xpath = "//input[@name=\"name\"]") WebElement page_Earn_Rewards;
	
	public @FindBy(xpath = "//input[@id=\"set_title\"]") WebElement txtF_Form_Title;
	public @FindBy(xpath = "//input[@id=\"set_desc\"]") WebElement txtF_Form_Description;
	public @FindBy(xpath = "//input[@id=\"set_btn\"]") WebElement txtF_Button_Text;
	public @FindBy(xpath = "//input[@id=\"set_thanks\"]") WebElement txtF_ThankYou_Message;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Include border and spacing around form?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Increase_border_and_spacing_around_form;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Collect first name?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Collect_first_name;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Collect last name?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Collect_last_name;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Collect email address?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Collect_email_address;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Allow user to submit a message?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Allow_User_to_submit_a_message;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Alert account admin about new submissions?\")]]//div[@class=\"toggle-group\"]") WebElement toggle_Alert_account_admin_about_new_submissions;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Choose a Display Method\")]]//label[contains((.), \"Inline Form\")]") WebElement toggle_Choose_a_Display_Method;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//label[contains((.), \"Choose a Theme\")]]//div[@class=\"toggle-group\" and .//label[contains((.), \"Light Theme\")]]") WebElement toggle_Choose_a_theme;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\")]//div[contains(@class, \"selectize-input\")]") WebElement LOV_Select_a_Campaign;
	public @FindBy(xpath = "//a[@id=\"sms-widget-form-copy\"]") WebElement btn_Copy_to_Clipboard;
	
	public @FindBy(xpath = "//input[@id=\"x_sms_widget_fname\"]") WebElement txtF_First_Name;
	public @FindBy(xpath = "//input[@id=\"x_sms_widget_phone\"]") WebElement txtF_Phone;
	public @FindBy(xpath = "//input[@id=\"x_sms_widget_email\"]") WebElement txtF_Email_Address;
	public @FindBy(xpath = "//div[contains(@class, \"x_sms_widget_group_part\")]") WebElement btn_Sign_Up;
	
		
	// Page Methods
	
	public String getPageTitle() throws Exception {
		return getElementText(page_Title);
	}

	public String getConfigureYourWidgetTxt() throws Exception {
		return getElementText(page_Configure_Your_Widget);
	}
}
