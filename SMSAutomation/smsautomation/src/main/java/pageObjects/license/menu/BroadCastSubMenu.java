package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BroadCastSubMenu extends BasePage {

	public BroadCastSubMenu() throws IOException {
		super();
	}

	// Menu Elements 
	
	public @FindBy(xpath = "//a[text()=\"Create Broadcast\"]") WebElement menu_CreateBroadcast;
	public @FindBy(xpath = "//a[text()=\"Manage Broadcasts\"]") WebElement menu_ManageBroadcasts;
	public @FindBy(xpath = "//a[text()=\"Single Campaigns\"]") WebElement menu_BroadcastHistory;

	
	// Menu Methods
	
	public CampaignsSubMenu clickCreateBroadcast() throws Exception {
		waitAndClickElement(menu_CreateBroadcast);
		return new CampaignsSubMenu();
	}

	public CampaignsSubMenu clickManageBroadcasts() throws Exception {
		waitAndClickElement(menu_ManageBroadcasts);
		return new CampaignsSubMenu();
	}

	public CampaignsSubMenu clickBroadcastHistory() throws Exception {
		waitAndClickElement(menu_BroadcastHistory);
		return new CampaignsSubMenu();
	}

}
