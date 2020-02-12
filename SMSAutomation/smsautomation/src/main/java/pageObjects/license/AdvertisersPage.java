package pageObjects.license;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.CommonElementLocator;
import pageObjects.BasePage;

public class AdvertisersPage extends BasePage {

	public AdvertisersPage() throws IOException {
		super();
	}


	// Page Elements
	public @FindBy(xpath = CommonElementLocator.ELEM_PAGE_TITLE) WebElement page_Heading;
	public @FindBy(xpath = CommonElementLocator.ELEM_SEARCH_TEXTFIELD) WebElement txt_SearchTxtF;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./a[contains(text(), \"New\")]]") WebElement btn_New;
	public @FindBy(xpath = "//div[@class=\"toggle-group\" and .//label[contains(@class, \"toggle-off\") and text()=\"Show Terminated\"]]") WebElement btn_Show_Terminated;
	public @FindBy(xpath = "//div[@id=\"advertisers_wrapper\"]") WebElement table_Businesses;
	public @FindBy(xpath = "//a[@aria-controls=\"advertisers\"]//span[text()=\"Copy\"]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[@aria-controls=\"advertisers\"]//span[text()=\"CSV\"]") WebElement btn_CSV;
	public @FindBy(xpath = "//ul[@class=\"pagination\"]") WebElement con_Pagination;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"ID\"]") WebElement col_ID;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Business Contact\"]") WebElement col_Business_Contact;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Business Name\"]") WebElement col_Business_Name;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"City, State\"]") WebElement col_City_Sate;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Phone\"]") WebElement col_Phone;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Plan\"]") WebElement col_Plan;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Billing Type\"]") WebElement col_Billing_Type;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Text Number\"]") WebElement col_Text_Number;
	public @FindBy(xpath = "//tr[@role=\"row\"]//th[text()=\"Action\"]") WebElement col_Action;
		
	public @FindBy(xpath = "//tbody") WebElement parentBtn;

	public WebElement getLoginBtnByBusinessContact(String businessContact) {
		return parentBtn.findElement(
				By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + businessContact + "']]//a[(.)=\"Log In\"]"));
	}

	public @FindBy(xpath = "//tr[@role=\"row\" and .//td[text()=\"QA, Aclate\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_LOGIN_LOV;

	// Page Methods
	public AdvertisersPage clickLoginBtnByBusinessContact() throws Exception {
		waitAndClickElement(getLoginBtnByBusinessContact("QA, Aclate"));
		return new AdvertisersPage();
	}

	public String getPageHeading() throws Exception {
		return page_Heading.getText();
	}

}
