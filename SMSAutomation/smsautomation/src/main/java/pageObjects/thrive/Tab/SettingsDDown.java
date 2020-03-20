package pageObjects.thrive.Tab;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class SettingsDDown extends BasePage {

	public SettingsDDown() throws IOException {
		super();
	}

	// Page elements
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Settings\"]]") WebElement opt_Settings;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Language Strings\"]]") WebElement opt_Language_Strings;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Message Templates\"]]") WebElement opt_Message_Templates;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Page Templates\"]]") WebElement opt_Page_Templates;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Screen Templates\"]]") WebElement opt_Screen_Templates;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Image Gallery\"]]") WebElement opt_Image_Gallery;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Video Gallery\"]]") WebElement opt_Video_Gallery;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Alerts\"]]") WebElement opt_Alerts;
	public @FindBy(xpath = "//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Tours\"]]") WebElement opt_Tours;

	// Thrive Setting Menu Options
	
	  public @FindBy(xpath = "//a[text()[normalize-space()=\"Language Strings\"]]")  WebElement opt_LanguageStrings; 
	  public @FindBy(xpath = "//a[text()[normalize-space()=\"Message Templates\"]]") WebElement opt_MessageTemplates;
	 
	// Page methods

	public SettingsDDown clickSettingOpt() throws Exception {
		waitAndClickElement(opt_Settings);
		return new SettingsDDown();
	}

	public SettingsDDown clickLanguageStringsOpt() throws Exception {
		waitAndClickElement(opt_Language_Strings);
		return new SettingsDDown();
	}

	public SettingsDDown clickMessageTemplatesOpt() throws Exception {
		waitAndClickElement(opt_Message_Templates);
		return new SettingsDDown();
	}

	public SettingsDDown clickPageTemplatesOpt() throws Exception {
		waitAndClickElement(opt_Page_Templates);
		return new SettingsDDown();
	}

	public SettingsDDown clickScreenTemplatesOpt() throws Exception {
		waitAndClickElement(opt_Screen_Templates);
		return new SettingsDDown();
	}

	public SettingsDDown clickImageGalleryOpt() throws Exception {
		waitAndClickElement(opt_Image_Gallery);
		return new SettingsDDown();
	}

	public SettingsDDown clickVideoGalleryOpt() throws Exception {
		waitAndClickElement(opt_Video_Gallery);
		return new SettingsDDown();
	}

	public SettingsDDown clickAlertsOpt() throws Exception {
		waitAndClickElement(opt_Alerts);
		return new SettingsDDown();
	}
}
