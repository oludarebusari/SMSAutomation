package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.CommonElementLocator;
import pageObjects.BasePage;

public class SocialSettingsPage extends BasePage {

	public SocialSettingsPage() throws IOException {
		super();
	}

	// Page Elements

	public @FindBy(xpath = CommonElementLocator.ELEM_PAGE_TITLE) WebElement page_Title;
	public @FindBy(xpath = "//h4[contains((.), \"Facebook Integration\")]") WebElement page_Facebook_Integration;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\")]//div[contains(@class, \"selectize-input\")]") WebElement lov_Select_A_Campaign;
	public @FindBy(xpath = "//button[@type=\"button\" and contains((.), \"Connect to Facebook\")]") WebElement btn_Connect_To_Facebook;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[contains((.), \"FB Name\")]]//input[@id=\"fb-name\"]") WebElement txtF_FB_Name;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[contains((.), \"FB User ID\")]]//input[@id=\"fb-user-id\"]") WebElement txtF_FB_User_ID;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[contains((.), \"FB Access Token\")]]//input[@id=\"fb-access-token\"]") WebElement txtF_FB_Access_Token;
	public @FindBy(xpath = "//button[(.)=\"Save Integration\"]") WebElement btn_Save_Integration;
	public @FindBy(xpath = "//h4[contains((.), \"Social Properties\")]") WebElement page_Social_Properties;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[contains((.), \"Facebook URL\")]]//input[@id=\"facebook_url\"]") WebElement txtF_Facebook_URL;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[contains((.), \"Yelp URL\")]]//input[@id=\"yelp_url\"]") WebElement txtF_Yelp_URL;
	public @FindBy(xpath = "//button[@type=\"button\" and contains((.), \"Connect to Facebook\")]") WebElement btn_Save_Social_URLs;
	
	
	// Page Methods

	public String getPageTitle() throws Exception {
		return getElementText(page_Title);
	}
	
	

}
