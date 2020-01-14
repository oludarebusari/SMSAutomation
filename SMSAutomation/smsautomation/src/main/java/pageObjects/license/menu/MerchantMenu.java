package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;


public class MerchantMenu extends BasePage{

	public MerchantMenu() throws IOException {
		super();
	}
	
	// Menu Elements

		public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and ./a[(.)= \" Inbox\"]]") WebElement menu_Inbox;
		public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and text()= \" Campaigns\"]") WebElement menu_Campaigns;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Subscribers\")]]") WebElement menu_Broadcasts;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Purchase Plans\")]]") WebElement menu_Analytics;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"Subscribers\")]") WebElement menu_Subscribers;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"Add-On Services\")]") WebElement menu_Add_On_Services;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"My Account\")]") WebElement menu_My_Account;
		public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.), \"Settings\")]") WebElement menu_Settings;
		public @FindBy(xpath = "//div[contains(@class, \"toggle-menu\")]") WebElement menu_Collapse_Menu;
//			public @FindBy(xpath = "//button[@id=\"utility-menu\"]") WebElement btn_superadmin;

		// Page Functions
		
		public MerchantMenu clickInbox() throws Exception {
			waitAndClickElement(menu_Inbox);
			return new MerchantMenu();
		}

		public MerchantMenu clickCampaigns() throws Exception {
			waitAndClickElement(menu_Campaigns);
			return new MerchantMenu();
		}

		public MerchantMenu clickBroadcasts() throws Exception {
			waitAndClickElement(menu_Broadcasts);
			return new MerchantMenu();
		}

		public MerchantMenu clickAnalytics() throws Exception {
			waitAndClickElement(menu_Analytics);
			return new MerchantMenu();
		}

		public MerchantMenu clickSubscribers() throws Exception {
			waitAndClickElement(menu_Subscribers);
			return new MerchantMenu();
		}

		public MerchantMenu clickAddOnServices() throws Exception {
			waitAndClickElement(menu_Add_On_Services);
			return new MerchantMenu();
		}

		public MerchantMenu clickMyAccount() throws Exception {
			waitAndClickElement(menu_My_Account);
			return new MerchantMenu();
		}

		public MerchantMenu clickSettings() throws Exception {
			waitAndClickElement(menu_Settings);
			return new MerchantMenu();
		}

		public MerchantMenu clickCollapseMenu() throws Exception {
			waitAndClickElement(menu_Collapse_Menu);
			return new MerchantMenu();
		}

		public String getAddOnServicesMenuTxt() throws Exception {
			return getElementText(menu_Add_On_Services);
		}


}
