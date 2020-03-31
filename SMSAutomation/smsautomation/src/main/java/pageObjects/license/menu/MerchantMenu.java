package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class MerchantMenu extends BasePage {

	public MerchantMenu() throws IOException {
		super();
	}

	// Menu Elements

	public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and ./a[(.)= \" Inbox\"]]") WebElement menu_Inbox;
	public @FindBy(xpath = "//div[contains(@class, \"side-menu-item\") and text()= \" Campaigns\"]") WebElement menu_Campaigns;
	public @FindBy(xpath = "//div[@title=\"Broadcasts\"]") WebElement menu_Broadcasts;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and ./a[contains(text(), \"Purchase Plans\")]]") WebElement menu_Analytics;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"Subscribers\")]") WebElement menu_Subscribers;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"Add-On Services\")]") WebElement menu_Add_On_Services;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.),\"My Account\")]") WebElement menu_My_Account;
	public @FindBy(xpath = "//div[@class=\"side-menu-item\" and contains((.), \"Settings\")]") WebElement menu_Settings;
	public @FindBy(xpath = "//div[contains(@class, \"toggle-menu\")]") WebElement menu_Collapse_Menu;

	public String getColor(String colorRGBA) {
		String[] hexValue = colorRGBA.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}
}
