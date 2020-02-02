package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminDashboardPage extends BasePage {

	public AdminDashboardPage() throws IOException {
		super();

	}

	// Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()=\"Dashboard\"]]") WebElement txt_Page_Title;
	public @FindBy(xpath = "//li[@class=\"first\" and .//a[text()[normalize-space()=\"Dashboard\"]]]") WebElement tab_Dashboard;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Experience\"]]") WebElement tab_Experience;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Companies\"]]") WebElement tab_Companies;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Users\"]]") WebElement tab_Users;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Billing\"]]") WebElement tab_Billing;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Zeon\"]]") WebElement tab_Zeon;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Settings\"]]") WebElement tab_Settings;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement tab_Reports;
	public @FindBy(xpath = "//li[@class=\"last\" and .//a[text()[normalize-space()=\"Support\"]]]") WebElement tab_Support;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement lnk_Resellers;
	public @FindBy(xpath = "//a[@class=\"dropdown-toggle\" and text()[normalize-space()=\"Reports\"]]") WebElement lnk_Businesses;

		
	// Page methods
	
	public AdminDashboardPage clickDasboardTab() throws Exception {
		waitAndClickElement(tab_Dashboard);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickExperienceTab() throws Exception {
	    waitAndClickElement(tab_Experience);	
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickCompaniesTab() throws Exception {
		waitAndClickElement(tab_Companies);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickUsersTab() throws Exception  {
		waitAndClickElement(tab_Users);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickBillingTab() throws Exception {
		waitAndClickElement(tab_Billing);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickZeonTab() throws Exception {
		waitAndClickElement(tab_Zeon);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickSettingsTab() throws Exception  {
		waitAndClickElement(tab_Settings);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickReportsTab() throws Exception  {
		waitAndClickElement(tab_Reports);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickSupportTab() throws Exception  {
		waitAndClickElement(tab_Support);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickResellersLink() throws Exception  {
		waitAndClickElement(lnk_Resellers);
		return new AdminDashboardPage();
	}
	
	public AdminDashboardPage clickBusinessesLink() throws Exception  {
		waitAndClickElement(lnk_Businesses);
		return new AdminDashboardPage();
	}
	

}
