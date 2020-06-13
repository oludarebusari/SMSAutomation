package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CampaignsSubMenu extends BasePage{

	public CampaignsSubMenu() throws IOException {
		super();
	}

	// Menu Elements
	
	public @FindBy(xpath = "//h4[@class=\"close-submenu\" and text()=\"Campaigns\"]") WebElement title_CampaignsSubMenu;
	public @FindBy(xpath = "//a[text()=\"Single Campaigns\"]") WebElement menu_SingleCampaigns;
	public @FindBy(xpath = "//a[text()=\"Campaign Groups\"]") WebElement menu_CampaignGroups;
	public @FindBy(xpath = "//a[text()=\"Sweepstakes\"]") WebElement menu_Sweepstakes;
	public @FindBy(xpath = "//a[text()=\"Manage Multiple Locations\"]") WebElement menu_ManageMultipleLocations;
	

}
