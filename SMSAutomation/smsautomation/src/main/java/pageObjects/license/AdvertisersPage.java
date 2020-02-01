package pageObjects.license;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.ElementLocator;
import pageObjects.BasePage;

public class AdvertisersPage extends BasePage {

	public AdvertisersPage() throws IOException {
		super();
	}


	// Page Elements
	public @FindBy(xpath = ElementLocator.ELEM_PAGE_TITLE) WebElement page_Heading;
	public @FindBy(xpath = "//input[contains(@class, \"table-search\")]") WebElement txt_SearchTxtF;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./a[contains(text(), \"New\")]]") WebElement btn_New;
	public @FindBy(xpath = "//div[@class=\"toggle-group\" and .//label[contains(@class, \"toggle-off\") and text()=\"Show Terminated\"]]") WebElement btn_Show_Terminated;
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
