package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminDashboardPage extends BasePage {

	public AdminDashboardPage() throws IOException {
		super();

	}

	// Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()=\"Dashboard\"]]") WebElement pag_Title;
	public @FindBy(xpath = "//li[@class=\"first\" and .//a[text()[normalize-space()=\"Dashboard\"]]]") WebElement tab_Dashboard;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Experience\"]]") WebElement tab_Experience;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Companies\"]]") WebElement tab_Companies;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Users\"]]") WebElement tab_Users;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Billing\"]]") WebElement tab_Billing;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Zeon\"]]") WebElement tab_Zeon;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Settings\"]]") WebElement tab_Settings;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement tab_Reports;
	public @FindBy(xpath = "//li[@class=\"last\" and .//a[text()[normalize-space()=\"Support\"]]]") WebElement tab_Support;
	public @FindBy(xpath = "//div[contains(@class, \"quarter-right\")]") WebElement btn_Help;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement lnk_Resellers;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement lnk_Businesses;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-licensees\"]") WebElement reseller_Summary;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-merchants\"]") WebElement business_Summary;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-posts\"]") WebElement socialPost_Summary;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-revenue\"]") WebElement revenue_Summary;
	public @FindBy(xpath = "//tbody") WebElement list_Reseller;
	public @FindBy(xpath = "//span[@id=\"pagination-total\"]") WebElement num_Reseller;
	
	//Reseller Columns
	public @FindBy(xpath = "//div[@id=\"overview\"]//h4") WebElement panel_Reseller_Title;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Company\")]") WebElement col_Company;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Location\")]") WebElement col_Locaton;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Phone\")]") WebElement col_Phone;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Support Email\")]") WebElement col_SupportEmail;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Created\")]") WebElement col_Created;
	public @FindBy(xpath = "//tr/th[contains(text(), \"Action\")]") WebElement col_Action;
	
	
	// Selecting Reseller, click Reseller button and dropdown
	public @FindBy(xpath = "//tbody") WebElement parent;
	public WebElement btn_SignIn(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-licensee\") and ./td[text()=\'" + reseller + "']]//a[@title=\"Sign In\"]"));
	}
	
	public WebElement btn_SignIn_Dropdown(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-licensee\") and ./td[text()=\'" + reseller + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement txt_CompanyName(String companyName) {
		return parent.findElement(By.xpath("//td[@class=\"new-licensee-name\" and text()=\'" + companyName + "']"));
	}
	
	public WebElement txt_PhoneNumber(String phoneNumber) {
		return parent.findElement(By.xpath("//td[@class=\"new-licensee-phone\" and text()=\'" + phoneNumber + "']"));
	}
	
	public WebElement opt_Reseller(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-licensee\") and ./td[text()=\'" + reseller + "']]"));
	}
	
	//Dropdown Action options
	public WebElement btn_Edit_Reseller_Company(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-licensee\") and ./td[text()=\'" + reseller + "']]//a[@title=\"Edit\"]"));
	}
	
	public WebElement btn_Cancel_Services(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-licensee\") and ./td[text()=\'" + reseller + "']]//a[@title=\"Cancel Services\"]"));
	}
}
