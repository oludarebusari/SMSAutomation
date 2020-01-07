package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import pageObjects.license.menu.AddOnServicesSubMenu;

public class AdvertisercpanelPage extends BasePage {
	
	private AddOnServicesSubMenu submenu;

	public AdvertisercpanelPage() throws IOException {
		super();
		this.submenu = new AddOnServicesSubMenu();
	}

	// Menu Elements

	public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and ./a[(.)= \" Inbox\"]]") WebElement menu_Inbox;
	public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and text()= \" Campaigns\"]") WebElement menu_Campaigns;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Subscribers\")]]") WebElement menu_Broadcasts;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Purchase Plans\")]]") WebElement menu_Analytics;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Content\"]") WebElement menu_Subscribers;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Add-On Services\"]") WebElement menu_Add_On_Services;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Super Admin\"]") WebElement menu_My_Account;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and text()=\" Super Admin\"]") WebElement menu_Settings;
	public @FindBy(xpath = "//div[contains(@class, \"toggle-menu\")]") WebElement menu_Collapse_Menu;
//		public @FindBy(xpath = "//button[@id=\"utility-menu\"]") WebElement btn_superadmin;

	public AdvertisercpanelPage clickInbox() throws Exception {
		waitAndClickElement(menu_Inbox);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickCampaigns() throws Exception {
		waitAndClickElement(menu_Campaigns);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickBroadcasts() throws Exception {
		waitAndClickElement(menu_Broadcasts);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickAnalytics() throws Exception {
		waitAndClickElement(menu_Analytics);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickSubscribers() throws Exception {
		waitAndClickElement(menu_Subscribers);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickAddOnServices() throws Exception {
		waitAndClickElement(menu_Add_On_Services);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickMyAccount() throws Exception {
		waitAndClickElement(menu_My_Account);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickMySettings() throws Exception {
		waitAndClickElement(menu_Settings);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickCollapseMenu() throws Exception {
		waitAndClickElement(menu_Collapse_Menu);
		return new AdvertisercpanelPage();
	}

	public AdvertisercpanelPage clickGiftbar() throws Exception {
		submenu.clickGiftbar();
		return new AdvertisercpanelPage();
	}
}
