package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminTerritoryReportsPage extends BasePage {

	public AdminTerritoryReportsPage() throws IOException {
		super();
	}

	
	// Filter Buttona
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"Allowed\"]") WebElement btn_AllowedTab;
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"Disallowed\"]") WebElement btn_DisallowedTab;
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"All\"]") WebElement btn_AllTab;
	
	// Page Columns
	public @FindBy(xpath = "//a[text()=\"Reseller\"]") WebElement col_Reseller;
	public @FindBy(xpath = "//a[text()=\"Business\"]") WebElement col_Businesses;
	public @FindBy(xpath = "//a[text()=\"City\"]") WebElement col_City;
	public @FindBy(xpath = "//a[text()=\"State\"]") WebElement col_State;
	public @FindBy(xpath = "//a[text()=\"Postal Code\"]") WebElement col_PostalCode;
	public @FindBy(xpath = "//a[text()=\"Country\"]") WebElement col_Country;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//tr[td=\"TNTextRewards\"]//a[text()=\"Allow\"]") WebElement btn_Allow;
	public @FindBy(xpath = "//tr[td=\"TNTextRewards\"]//a[text()=\"Disallow\"]") WebElement btn_Disallow;
	public @FindBy(xpath = "//tr[td=\"TNTextRewards\"]//a[text()=\"Disallow\"]") WebElement opt_ActionEditReseller;
	public @FindBy(xpath = "//tr[td=\"TNTextRewards\"]//a[text()=\"Disallow\"]") WebElement opt_ActionEditBusiness;
	

	public @FindBy(xpath = "//tbody") WebElement parentElement;
	public WebElement getFirstRowRecordResellerName(String reseller) {
		return parentElement.findElement(By.xpath("//tr[1][td=\'" + reseller + "']"));
	}
	
	public WebElement clickAllowOrDisallowResellerBtn(String reseller) {
		return parentElement.findElement(By.xpath("//tr[td=\'" + reseller + "']//a[text()=\"Allow\" or text()=\"Disallow\"]"));
	}
	
	public WebElement clickActionDDown(String reseller) {
		return parentElement.findElement(By.xpath("//tr[td=\'" + reseller + "']//button[contains(@class, \"user-actions\")]"));
	}
	
	public WebElement clickResellerAction(String option) {
		return parentElement.findElement(By.xpath("//tr[td[text()=\'" + option + "']]//a[normalize-space()=\"Edit " + "" + option + "\"]"));
	}
}
