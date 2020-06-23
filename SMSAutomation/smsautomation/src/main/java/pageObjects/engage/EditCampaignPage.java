package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditCampaignPage extends BasePage {

	public EditCampaignPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[contains(text(), \"Edit Campaign\")]") WebElement page_Title;
	public @FindBy(xpath = "//a[text()=\"configure advanced settings\"]") WebElement configAdvancedSettings;
	
	// Advanced Settings Elements
	public @FindBy(xpath = "//button[contains(@class, \"half-bottom\") and text()=\"Save Settings\"]") WebElement saveSettingTopBtn;
	public @FindBy(xpath = "//button[contains(@class, \"half-top\") and text()=\"Save Settings\"]") WebElement saveSettingBotBtn;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Basic Tablet Preferences\"]") WebElement basicTabletPrefLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Social Button\"]") WebElement socialButtonLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Legacy Tablet Configuration\"]") WebElement legacyTabletConfigurationLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Legacy Community Portal\"]") WebElement legacyCommunityPortalLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Advanced Check-in & Campaign Options\"]") WebElement advancedCheckInAndCampaignOptLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Account Admin Options\"]") WebElement accountAdminOptionsLnk;
	public @FindBy(xpath = "//a[@data-toggle=\"collapse\" and text()=\"Upsell Screen\"]") WebElement upsellScreenLnk;
	public @FindBy(xpath = "//div[@id=\"advanced_settings\" and .//h2[text()=\"Advanced Settings\"]]") WebElement section_AdvancedSetttings;
	public @FindBy(xpath = "//div[@class=\"panel-body\" and .//h4[text()=\"Upsell Screen\"]]") WebElement section_UpsellScreen;
	public @FindBy(xpath = "//div[@class=\"panel-body\" and .//h4[text()=\"Upsell Screen\"]]//label[contains(@class, \"toggle-off\")]") WebElement tog_Disabled;
	public @FindBy(xpath = "//div[@class=\"panel-body\" and .//h4[text()=\"Upsell Screen\"]]//label[contains(@class, \"toggle-on\")]") WebElement tog_Enabled;
	public @FindBy(xpath = "//div[contains(@class, \"option-settings__upsell\")]") WebElement set_UpsellScreen;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()=\"Upsell Item\"]]//span[@class=\"count\"]") WebElement upsellItemCount;
	public @FindBy(xpath = "//input[@name=\"settings__upsell_item\"]") WebElement txtF_UpsellItem;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()=\"Upsell Item Description\"]]//span[@class=\"count\"]") WebElement upsellItemDescriptionCount;
	public @FindBy(xpath = "//input[@name=\"settings__upsell_message\"]") WebElement txtF_UpsellDescription;
	public @FindBy(xpath = "//input[@id=\"thumb_2\"]") WebElement img_UpsellImage;
	
}
