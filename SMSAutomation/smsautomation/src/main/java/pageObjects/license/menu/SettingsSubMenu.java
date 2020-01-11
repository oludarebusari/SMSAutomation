package pageObjects.license.menu;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SettingsSubMenu extends BasePage{

	public SettingsSubMenu() throws IOException {
		super();
	}
	
	//Menu Elements
	
	public @FindBy(xpath = "//a[text()=\"Account Defaults\"]") WebElement menu_Account_Defaults;
	public @FindBy(xpath = "//a[text()=\"Social Media\"]") WebElement menu_Social_Media;
	public @FindBy(xpath = "//a[text()=\"Web Widget\"]") WebElement menu_Web_Widget;
	
	
	// Menu Methods
	
	public SettingsSubMenu clickAccountDefaults() throws Exception {
		waitAndClickElement(menu_Account_Defaults);
		return new SettingsSubMenu();
	}
	
	public SettingsSubMenu clickSocialMedia() throws Exception {
		waitAndClickElement(menu_Social_Media);
		return new SettingsSubMenu();
	}
	
	public SettingsSubMenu clickWebWidget() throws Exception {
		waitAndClickElement(menu_Web_Widget);
		return new SettingsSubMenu();
	}

}
