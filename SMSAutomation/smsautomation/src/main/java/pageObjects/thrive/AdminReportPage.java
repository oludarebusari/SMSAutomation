package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminReportPage extends BasePage {

	public AdminReportPage() throws IOException {
		super();
	}
	
	// Page Columns
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Reseller\"]") WebElement col_Reseller;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Reseller\"]//a") WebElement col_ResellerArrowIcon;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Active Businesses\"]") WebElement col_ActiveBusinesses;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Active Businesses\"]//a") WebElement col_ActiveBusinessesArrowIcon;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"New Business\"]") WebElement col_NewBusiness;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"New Business\"]//a") WebElement col_NewBusinessArrowIcon;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Canceled Businesses\"]") WebElement col_CanceledBusinesses;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Canceled Businesses\"]//a") WebElement col_CanceledBusinessesArrowIcon;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Period Net Businesses\"]") WebElement col_PeriodNetBusinesses;
	public @FindBy(xpath = "//tr[@class=\"heading\"]//th[normalize-space()=\"Period Net Businesses\"]//a") WebElement col_PeriodNetBusinessesArrowIcon;
	
	// Date Elements
	public @FindBy(xpath = "//input[@id=\"simple_search_date\"]") WebElement txtF_SearchDate;
	public @FindBy(xpath = "//div[contains(@class, \"daterangepicker\") and .//div[@class=\"calendar-date\"]]") WebElement win_DatePicker;
	public @FindBy(xpath = "//div[@class=\"ranges\"]//li[text()=\"This Month\"]") WebElement btn_ThisMonth;
	public @FindBy(xpath = "//div[@class=\"ranges\"]//li[text()=\"Last Month\"]") WebElement btn_LastMonth;
	public @FindBy(xpath = "//input[@name=\"daterangepicker_start\"]") WebElement txtF_From;
	public @FindBy(xpath = "//input[@name=\"daterangepicker_end\"]") WebElement txtF_To;
	public @FindBy(xpath = "//button[text()=\"Apply\"]") WebElement btn_Apply;
	public @FindBy(xpath = "//button[text()=\"Cancel\"]") WebElement btn_Cancel;
	
	//Other Elements
	public @FindBy(xpath = "//tbody") WebElement parentElement;
	public WebElement getFirstRowRecordResellerName(String reseller) {
		return parentElement.findElement(By.xpath("//tr[1][td=\'" + reseller + "']"));
	}

}
