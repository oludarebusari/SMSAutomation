package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CampaignsSubMenu extends BasePage{

	public CampaignsSubMenu() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[text()=\"Single Campaigns\"]") WebElement menu_SingleCampaigns;
	public @FindBy(xpath = "//a[text()=\"Campaign Groups\"]") WebElement menu_CampaignGroups;
	public @FindBy(xpath = "//a[text()=\"Sweepstakes\"]") WebElement menu_Sweepstakes;
	public @FindBy(xpath = "//a[text()=\"Manage Multiple Locations\"]") WebElement menu_ManageMultipleLocations;
	
	
	public CampaignsSubMenu clickSingleCampaigns() throws Exception {
		waitAndClickElement(menu_SingleCampaigns);
		return new CampaignsSubMenu();
	}

	public CampaignsSubMenu clickCampaignGroups() throws Exception {
		waitAndClickElement(menu_CampaignGroups);
		return new CampaignsSubMenu();
	}
	
	public CampaignsSubMenu clickSweepstakes() throws Exception {
		waitAndClickElement(menu_Sweepstakes);
		return new CampaignsSubMenu();
	}
	
	public CampaignsSubMenu clickManageMultipleLocations() throws Exception {
		waitAndClickElement(menu_ManageMultipleLocations);
		return new CampaignsSubMenu();
	}
}
