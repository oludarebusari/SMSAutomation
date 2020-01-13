package pageObjects.license;

import java.io.IOException;

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
	public @FindBy(xpath = "//a[@data-target=\"#credit-card-modal\"]") WebElement btn_Payment_Edit;
	
	
	//Page Methods
	
	public String getPageTitle() throws Exception {
		return getElementText(page_Title);
	}
	
	public String getMyPlanTxt() throws Exception {
		return getElementText(page_My_Plan_Section);
	}
}
