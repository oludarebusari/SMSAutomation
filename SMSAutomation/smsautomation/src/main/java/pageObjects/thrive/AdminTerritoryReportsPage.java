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
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"Allowed\"]") WebElement btn_Allowed;
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"Disallowed\"]") WebElement btn_Disallowed;
	public @FindBy(xpath = "//div[@id=\"report-filters\"]//a[text()=\"All\"]") WebElement btn_All;
	
	// Page Columns
	public @FindBy(xpath = "//a[text()=\"Reseller\"]") WebElement col_Reseller;
	public @FindBy(xpath = "//a[text()=\"Business\"]") WebElement col_Businesses;
	public @FindBy(xpath = "//a[text()=\"City\"]") WebElement col_City;
	public @FindBy(xpath = "//a[text()=\"State\"]") WebElement col_State;
	public @FindBy(xpath = "//a[text()=\"Postal Code\"]") WebElement col_PostalCode;
	public @FindBy(xpath = "//a[text()=\"Country\"]") WebElement col_Country;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;

	public @FindBy(xpath = "//tbody") WebElement parentElement;
	public WebElement getFirstRowRecordResellerName(String reseller) {
		return parentElement.findElement(By.xpath("//tr[1][td=\'" + reseller + "']"));
	}
}
