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
	public @FindBy(xpath = "//a[@data-target=\"#credit-card-modal\"]") WebElement btn_Payment_Edit;
	public @FindBy(xpath = "//a[@data-target=\"#plan_details_modal\"]") WebElement lnk_Plan_Details;
	public @FindBy(xpath = "//div[@class=\"modal-content\" and .//h4[(.)=\"Plan Details\"]]//div[@class=\"modal-body\"]") WebElement win_Plan_Details_Body;
	public @FindBy(xpath = "//div[@id=\"plan-update-message\"]") WebElement txt_Plan_Update_Message;
	public @FindBy(xpath = "//h3[@class=\"remove-top\"]") WebElement txt_Plan_Name;
		
	//New Plan Window elements
	public @FindBy(xpath = "//div[@class=\"modal-content\"]//h3[(.)=\"Select a New Plan\"]") WebElement mod_New_Plan_Title;
	public @FindBy(xpath = "//div[contains(@class, \"list-group remove-bottom\")]") WebElement parentBtn;
	public WebElement rBtn_Plan_Name_Opt(String name) {
		return parentBtn.findElement(By.xpath("//a[@data-name='"+ name + "']"));
	};
	public @FindBy(xpath = "//button[@id=\"change-plan\"]") WebElement btn_Change_Plan_New_Plan;
	
	//Page Methods
	
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
	
	public String getPlanDetailsTxt() throws Exception {
		return getElementText(win_Plan_Details_Body);
	}
	
	public String getPlanUpdateMessageTxt() throws Exception {
		return getElementText(txt_Plan_Update_Message);
	}
	
	public String getPlanNameTxt() throws Exception {
		return getElementText(txt_Plan_Name);
	}
	
	public String getNewPlanWindowTitle() throws Exception {
		return getElementText(mod_New_Plan_Title);
	}
	
	public MyAccountPage selectPlan(String planName) throws Exception {
		waitAndClickElement(rBtn_Plan_Name_Opt(planName));
		return new MyAccountPage();
	}

}
