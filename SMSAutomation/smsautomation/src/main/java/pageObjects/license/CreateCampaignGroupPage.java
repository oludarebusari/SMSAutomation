package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class CreateCampaignGroupPage extends BasePage {

	public CreateCampaignGroupPage() throws IOException {
		super();
	}

	// Page Elements
	
	public @FindBy(xpath = "//input[@name=\"name\"]") WebElement txt_Group_Name;
	public @FindBy(xpath = "//input[@name=\"keyword\"]") WebElement txt_Keyword;
	public @FindBy(xpath = "//input[@name=\"description\"]") WebElement txt_Description;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement lov_Campaigns;
	public @FindBy(xpath = "//div[contains(@class, \"plugin-remove_button\")]") WebElement parentBtn;

	public WebElement getCampaignOpt(String campaign) {
		return parentBtn.findElement(
				By.xpath("//div[contains(@class, \"selectize-dropdown-content\") and ./div[contains(text(), '"
						+ campaign + "')]]"));
	};

	public @FindBy(xpath = "//div[@class=\"toggle-group\"]//label[contains(@class, \"toggle-on\")]") WebElement btn_Allow_Group_Reward_Redemption;
	public @FindBy(xpath = "//button[contains(@class, \"btn-primary\")]") WebElement btn_Save_Campaign_Group;
	public @FindBy(xpath = "//label[@id=\"name-error\"]") WebElement errMsg_Group_Name;
	public @FindBy(xpath = "//label[@id=\"keyword-error\"]") WebElement errMsg_Keyword;
	public @FindBy(xpath = "//div[@class=\"form-group\"]") WebElement parentError;
	public @FindBy(xpath = "//div[@class=\"form-group\"]//label[@id=\"description-error\"]") WebElement errMsg_Description;
	public @FindBy(xpath = "//label[contains(text(), \"Group Name\")]//i[contains(@class, \"fa-question-circle text-info\")]") WebElement icon_Group_Name_Help;
	public @FindBy(xpath = "//label[contains(text(), \"Keyword\")]//i[contains(@class, \"fa-question-circle text-info\")]") WebElement icon_Keyword_Help;
	public @FindBy(xpath = "//label[contains(text(), \"Description\")]//i[contains(@class, \"fa-question-circle text-info\")]") WebElement icon_Description_Help;
	public @FindBy(xpath = "//label[contains(text(), \"Campaigns\")]//i[contains(@class, \"fa-question-circle text-info\")]") WebElement icon_Campaigns_Help;
	public @FindBy(xpath = "//div[@class=\"form-group\" and .//div[contains(@class, \"quarter-right\")]]//i[contains(@class, \"fa-question-circle text-info\")]") WebElement icon_Allow_group_reward_redemptions_Help;
	
	// Page Methods
	
	public CreateCampaignGroupPage sendTextToGroupNameTxtF(String groupName) throws Exception {
		sendKeysToWebElement(txt_Group_Name, groupName);
		return new CreateCampaignGroupPage();
	}
	
	public String getGroupNameTxtFValue() throws Exception {
		return txt_Group_Name.getAttribute("value");
	}
	
	public CreateCampaignGroupPage getGroupNameHelpMessage() throws Exception {
		waitAndClickElement(icon_Group_Name_Help);
		return new CreateCampaignGroupPage();
	}

	public CreateCampaignGroupPage sendTextToKeywordTxtF(String keyword) throws Exception {
		sendKeysToWebElement(txt_Keyword, keyword);
		return new CreateCampaignGroupPage();
	}

	public String getKeywordTxtFValue() throws Exception {
		return txt_Keyword.getAttribute("value");
	}
	
	public CreateCampaignGroupPage sendTextToDescriptionTxtF(String description) throws Exception {
		sendKeysToWebElement(txt_Description, description);
		return new CreateCampaignGroupPage();
	}

	public String getDescriptionTxtFValue() throws Exception {
		return txt_Description.getAttribute("value");
	}
	
	public CreateCampaignGroupPage clickCampaignsLOV(String campaignOpt) throws Exception {
		waitAndClickElement(lov_Campaigns);
		waitAndClickElement(getCampaignOpt(campaignOpt));
		return new CreateCampaignGroupPage();
	}

	public CreateCampaignGroupPage clickSaveCampaignGroup() throws Exception {
		waitAndClickElement(btn_Save_Campaign_Group);
		return new CreateCampaignGroupPage();
	}

		public CreateCampaignGroupPage getKeyWordHelpMessage() throws Exception {
		waitAndClickElement(icon_Keyword_Help);
		return new CreateCampaignGroupPage();
	}
	
	public CreateCampaignGroupPage getDescriptionHelpMessage() throws Exception {
		waitAndClickElement(icon_Description_Help);
		return new CreateCampaignGroupPage();
	}
	
	public CreateCampaignGroupPage getCampaignHelpMessage() throws Exception {
		waitAndClickElement(icon_Campaigns_Help);
		return new CreateCampaignGroupPage();
	}
	
	public CreateCampaignGroupPage getAllowGroupRewardRedemptionsHelpMessage() throws Exception {
		waitAndClickElement(icon_Allow_group_reward_redemptions_Help);
		return new CreateCampaignGroupPage();
	}
	
	public CreateCampaignGroupPage toggleAllowGroupRewardRedemptionsBtn() throws Exception {
		btn_Allow_Group_Reward_Redemption.click();
		return new CreateCampaignGroupPage();
	}
}
