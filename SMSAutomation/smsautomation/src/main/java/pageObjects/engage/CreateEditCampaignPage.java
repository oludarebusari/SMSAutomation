package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateEditCampaignPage extends BasePage{

	public CreateEditCampaignPage() throws IOException {
		super();
	}
	
	public @FindBy (xpath = "//h1[contains(text(), \"Create A Campaign\") or contains(text(), \"Edit Campaign\")]") WebElement page_Title;
	public @FindBy (xpath = "//div[@id=\"panel_1\"]") WebElement panel_BusinessType;
	public @FindBy (xpath = "//div[@id=\"panel_1\"]//div[contains(@class, \"selectize-input\")]") WebElement campaignDDown;
	public @FindBy (xpath = "//div[@id=\"panel_1\"]//a[text()=\"Continue\"]") WebElement businessTypeContinueBtn;
	public @FindBy (xpath = "//div[contains(@class, \"selectize-dropdown-conten\")]") WebElement parentBtn;
	public WebElement selectCampaign(String campaignName) {
		return parentBtn.findElement(By.xpath("//div[@class=\"option\" and text()=" + campaignName + "]"));
	}
	public @FindBy (xpath = "//div[@id=\"panel_2\"]") WebElement panel_LoyaltyTablet;
	public @FindBy (xpath = "//div[@id=\"panel_2\"]//div[contains(@class, \"col-xs-12\") and ./a[text()=\"Yes\"]]") WebElement loyaltyTabletYesBtn;
	public @FindBy (xpath = "//div[@id=\"panel_2\"]//div[contains(@class, \"col-xs-12\") and ./a[text()=\"No\"]]") WebElement loyaltyTabletNoBtn;
	public @FindBy (xpath = "//div[@id=\"panel_3\"]") WebElement panel_CampaignInformation;
	public @FindBy (xpath = "//div[@id=\"panel_3\"]//div[@class=\"step-panel-content\"]") WebElement campaignInformationContent;
	public @FindBy (xpath = "//input[@name=\"campaign__name\"]") WebElement txtF_CampaignName;
	public @FindBy (xpath = "//input[@name=\"campaign__keyword\"]") WebElement txtF_Keyword;
	public @FindBy (xpath = "//div[@id=\"panel_3\"]//div[contains(@class, \"selectize-input\")]") WebElement messageSettingDDown;
	public WebElement selectMessagesPerMonth(String messageNumber) {
		return parentBtn.findElement(By.xpath("//div[@class=\"option\" and text()=\'" + messageNumber + "']"));
	}
	public @FindBy (xpath = "//div[@id=\"panel_3\"]//a[text()=\"Continue\"]") WebElement messageSettingsContinueBtn;
	public @FindBy (xpath = "//div[@id=\"panel_3\"]//label[contains(@class, \"toggle-on\")]") WebElement tog_AgeGateEnabled;
	public @FindBy (xpath = "//div[@id=\"panel_3\"]//label[contains(@class, \"toggle-off\")]") WebElement tog_AgeGateDisabled;
	public @FindBy (xpath = "//input[@id=\"campaign__message_age_gate\"]") WebElement txtF_AgeGate;
	public @FindBy (css = "#campaign__message_age_gate") WebElement txtF_AgeGateCSS;
	public @FindBy (xpath = "//label[@id=\"campaign__message_age_gate-error\"]") WebElement ageGateMsg;
	public @FindBy (xpath = "//div[@id=\"panel_4\"]") WebElement panel_Texts;
	public @FindBy (xpath = "//div[@id=\"panel_4\"]//textarea[@id=\"texts__first_message\"]") WebElement txtA_Message;
	public @FindBy (xpath = "//div[@id=\"panel_4\"]//a[text()=\"Continue\"]") WebElement textsContinueBtn;
	public @FindBy (xpath = "//div[@id=\"panel_5\"]") WebElement panel_Rewards;
	public @FindBy (xpath = "//div[@id=\"panel_5\"]//a[normalize-space()=\"Create A Birthday Reward\"]") WebElement createBirthdayRewardBtn;
	public @FindBy (xpath = "//div[@id=\"panel_5\"]//a[normalize-space()=\"Disable Birthday Club\"]") WebElement diableBirthDayClubBtn;
	public @FindBy (xpath = "//div[@id=\"panel_5\"]//a[text()=\"Continue\"]") WebElement rewardssContinueBtn;
	public @FindBy (xpath = "//div[@id=\"panel_6\"]") WebElement panel_Engagement;
	public @FindBy (xpath = "//div[@id=\"panel_6\"]//a[normalize-space()=\"Add\"]") WebElement btn_EngagementAdd;
	public @FindBy (xpath = "//div[@id=\"panel_6\"]//a[text()=\"Continue\"]") WebElement engagementsContinueBtn;
	public @FindBy (xpath = "//div[@id=\"panel_7\"]") WebElement panel_TabletDesign;
	public @FindBy (xpath = "//a[@id=\"save_campaign\"]") WebElement btn_SaveToCompleteSetup;
	

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
	public @FindBy(xpath = "//div[@class=\"panel-body\" and .//h4[text()=\"Upsell Screen\"]]//label[contains(@class, \"toggle-off\")]") WebElement tog_UpsellDisabled;
	public @FindBy(xpath = "//div[@class=\"panel-body\" and .//h4[text()=\"Upsell Screen\"]]//label[contains(@class, \"toggle-on\")]") WebElement tog_UpsellEnabled;
	public @FindBy(xpath = "//div[contains(@class, \"option-settings__upsell\")]") WebElement set_UpsellScreen;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()=\"Upsell Item\"]]//span[@class=\"count\"]") WebElement upsellItemCount;
	public @FindBy(xpath = "//input[@name=\"settings__upsell_item\"]") WebElement txtF_UpsellItem;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()=\"Upsell Item Description\"]]//span[@class=\"count\"]") WebElement upsellItemDescriptionCount;
	public @FindBy(xpath = "//input[@name=\"settings__upsell_message\"]") WebElement txtF_UpsellDescription;
	public @FindBy(xpath = "//input[@id=\"thumb_2\"]") WebElement img_UpsellImage;
	
	
}
