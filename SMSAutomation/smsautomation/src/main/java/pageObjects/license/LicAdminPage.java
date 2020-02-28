package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;
import pageObjects.license.menu.CampaignsSubMenu;

public class LicAdminPage extends BasePage {

   CampaignsSubMenu campaignSubMenu = new CampaignsSubMenu();

	public LicAdminPage() throws IOException {
		super();
	}

	//Menu Elements
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Businesses\")]]") WebElement menu_Businesses;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Affiliates\")]]") WebElement menu_Affiliates;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Subscribers\")]]") WebElement menu_Subscribers;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Purchase Plans\")]]") WebElement menu_Purchase_Plans;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Content\"]") WebElement menu_Content;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Analytics\")]]") WebElement menu_Analytics;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Reports\"]") WebElement menu_Reports;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Tools\"]") WebElement menu_Tools;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Add-On Services\")]]") WebElement menu_Add_On_Services;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Super Admin\"]") WebElement menu_Super_Admin;
	public @FindBy(xpath = "//div[contains(@class, \"toggle-menu\")]") WebElement menu_Collapse_Menu;
	public @FindBy(xpath = "//div[@class=\"utility-menu\" and ./a[contains(text(), \" Resources & Support\")]]") WebElement menu_Resources_Support;
	public @FindBy(xpath = "//button[@id=\"utility-menu\"]") WebElement btn_superadmin;

	// Other Page Objects
	public @FindBy(xpath = "//div[contains(@class, \"text-warning\")]") WebElement btn_Panel_Suspended_Businesses;
	public @FindBy(xpath = "//div[contains(@class, \"panel-button\") and .//div[text()=\"All-Time Subscribers\"]]") WebElement btn_Panel_All_Time_Subscribers;
	public @FindBy(xpath = "//input[@id=\"id_password\"]") WebElement btn_Panel_Email_Addresses;
	public @FindBy(xpath = "//div[contains(@class, \"panel-button\") and .//div[text()=\"Check-Ins\"]]") WebElement btn_Panel_Check_Ins;
	public @FindBy(xpath = "//div[contains(@class, \"panel-button\") and .//div[text()=\"Messages Sent\"]]") WebElement btn_Panel_Message_Sent;
	public @FindBy(xpath = "//div[contains(@class, \"panel-button\") and .//div[text()=\"Billed\"]]") WebElement btn_Panel_Billed;
	public @FindBy(xpath = "//div[contains(@class, \"panel-button\") and .//div[text()=\"Last Month\"]]") WebElement btn_Panel_LastMonth;
	public @FindBy(xpath = "//a[@id=\"showFinancials\"]") WebElement btn_Show;
	public @FindBy(xpath = "//a[@id=\"alwaysShowFinancials\"]") WebElement btn_Always_Show;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Inbox: Unread Messages\"]]") WebElement toggle_Inbox_Unread_Messages;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Platform News & Release Notes\"]]") WebElement toggle_Platform_News_Release_Notes;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Campaigns w/o Broadcasts in 7 Days\"]]") WebElement toggle_Campaigns_WO_Broadcast_In_7_Days;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Tablets w/o Check-Ins in 24 Hours\"]]") WebElement toggle_Tablets_WO_Check_Ins_In_24_Hours;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Campaign Summary\"]]") WebElement toggle_Campaign_Summary;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and .//a[text()=\" Broadcast Manager\"]]") WebElement toggle_Broadcast_Managers;
	public @FindBy(xpath = "//div[@class=\"modal-header\" and .//h4[@id=\"terminate_modal_label\"]]//button[@aria-label=\"Close\"]") WebElement win_Update_Status_Of_Business;

	
	// Methods
	/*
	 * public LicAdminPage clickAffiliates() throws Exception {
	 * waitAndClickElement(menu_Affiliates); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickSubscribers() throws Exception {
	 * waitAndClickElement(menu_Subscribers); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickPurchasePlans() throws Exception {
	 * waitAndClickElement(menu_Purchase_Plans); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickContent() throws Exception {
	 * waitAndClickElement(menu_Content); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickAnalytics() throws Exception {
	 * waitAndClickElement(menu_Analytics); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickReports() throws Exception {
	 * waitAndClickElement(menu_Reports); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickTools() throws Exception {
	 * waitAndClickElement(menu_Tools); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickAddOnServices() throws Exception {
	 * waitAndClickElement(menu_Add_On_Services); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickSuperAdmin() throws Exception {
	 * waitAndClickElement(menu_Super_Admin); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickResourceAndSupport() throws Exception {
	 * waitAndClickElement(menu_Resources_Support); return new LicAdminPage(); }
	 * 
	 * public LicAdminPage clickSuperAdminMenu() throws Exception {
	 * waitAndClickElement(btn_superadmin); return new LicAdminPage(); }
	 */

	public LicAdminPage clickOnCampaigns_WO_Broadcast_In_7_Days() throws Exception {
//		waitAndClickElement(toggle_Campaigns_WO_Broadcast_In_7_Days);
		return new LicAdminPage();
	}
	
	public LicAdminPage waitForBusinessesDialogToDisappear() throws IOException {
		waitUntilPreLoadElementDissapears(By.xpath("//div[@class=\"modal-header\" and .//h4[@id=\"terminate_modal_label\"]]//button[@aria-label=\"Close\"]"));
		return new LicAdminPage();
		
	}
}
