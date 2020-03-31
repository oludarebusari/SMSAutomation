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
	
	public @FindBy(xpath = "//h4[normalize-space()=\"Broadcasts\"]") WebElement menu_Title;
	public @FindBy(xpath = "//a[text()=\"Create Broadcast\"]") WebElement menu_CreateBroadcast;
	public @FindBy(xpath = "//a[text()=\"Manage Broadcasts\"]") WebElement menu_ManageBroadcasts;
	public @FindBy(xpath = "//a[text()=\"Broadcast History\"]") WebElement menu_BroadcastHistory;


}
