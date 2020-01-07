package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageSitesPage extends BasePage {

	public ManageSitesPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = "//a[text()=\"Manage Resellers\"]") WebElement menu_Manage_Resellers;
	public @FindBy(xpath = "//a[text()=\"Business Search\"]") WebElement menu_Business_Search;
	public @FindBy(xpath = "//a[contains(text(), \"Edit\")]") WebElement menu_Edit;
	public @FindBy(xpath = "//a[contains(text(), \"Reports\")]") WebElement menu_Reports;
	public @FindBy(xpath = "//a[contains(text(), \"Engineering\")]") WebElement menu_Engineering;
	public @FindBy(xpath = "//a[contains(text(), \"Accounting\")]") WebElement menu_Accounting;
	public @FindBy(xpath = "//a[contains(text(), \"Other\")]") WebElement menu_Other;
	public @FindBy(xpath = "//button[@type=\"submit\"]") WebElement btn_Sing_Out;
	public @FindBy(xpath = "//input[@class=\"table-search form-control\"]") WebElement SearchTxtF;
	public @FindBy(xpath = "//tbody") WebElement Reseller;

	public WebElement loginAS(String resellerName, String account) {
		return Reseller.findElement(
				By.xpath("//tr[@role=\"row\" and ./td[text()='" + resellerName + "']]//a[text()='" + account + "']"));
	}

	// Page Methods
	
	public ManageSitesPage clickManageResellers() throws Exception {
		waitAndClickElement(menu_Manage_Resellers);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickBusinessSearch() throws Exception {
		waitAndClickElement(menu_Manage_Resellers);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickEdit() throws Exception {
		waitAndClickElement(menu_Business_Search);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickReports() throws Exception {
		waitAndClickElement(menu_Edit);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickEngineering() throws Exception {
		waitAndClickElement(menu_Engineering);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickAccounting() throws Exception {
		waitAndClickElement(menu_Accounting);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickOther() throws Exception {
		waitAndClickElement(menu_Other);
		return new ManageSitesPage();
	}

	public ManageSitesPage clickSignOut() throws Exception {
		waitAndClickElement(btn_Sing_Out);
		return new ManageSitesPage();
	}

	public ManageSitesPage loginToReseller(String resellerName, String account) throws Exception {
		sendKeysToWebElement(SearchTxtF, "test");
		waitAndClickElement(loginAS(resellerName, account));
		return new ManageSitesPage();
	}
}
