package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateEditBroadcastPage extends BasePage {

	public CreateEditBroadcastPage() throws IOException {
		super();
	}

	// Page Element
	public @FindBy(xpath = "//div[contains(@class, \"page-heading\") and ./h1]") WebElement pag_Title;

	// Settings
	public @FindBy(xpath = "//div[@class=\"panel-body\" and ./h2[text()=\"Settings\"]]//div[contains(@class, \"selectize-input\")]") WebElement chooseCampaignsToSendToDDown;
	public @FindBy(xpath = "//label[@id=\"lists-selectized-error\"]") WebElement chooseCampaignsToSendToErrorMsg;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentBtn;
	
	public WebElement campaignOption(String option) {
		return parentBtn.findElement(By.xpath("//strong[text()=" + option + "]"));
	}
	
	public WebElement removeCampaign(String campaignName) {
		return chooseCampaignsToSendToDDown.findElement(By.xpath("//div[text()=" + campaignName + "]//a[@class=\"remove\"]"));
	}

	public @FindBy(xpath = "//label[@for=\"option-mms\" and .//span[contains(text(), \"MMS\")]]//div[@data-toggle=\"toggle\"]") WebElement toggle_Send_As_MMS;
	public @FindBy(xpath = "//label[@for=\"option-redeemable\" and .//span[contains(text(), \"Redeemable\")]]//div[@data-toggle=\"toggle\"]") WebElement toggle_Create_Redeemable_Offer;
	public @FindBy(xpath = "//label[@for=\"option-schedule\" and text()[normalize-space()=\"Schedule\"]]//div[@data-toggle=\"toggle\"]") WebElement toggle_Schedule;
	public @FindBy(xpath = "//label[@for=\"option-filters\" and .//span[contains(text(), \"Apply\")]]//div[@data-toggle=\"toggle\"]") WebElement toggle_Apply_Filters_To_Subscribers;

	// Compose
	public @FindBy(xpath = "//textarea[@id=\"message\"]") WebElement txtF_Message;
	public @FindBy(xpath = "(//button[text()=\"Preview Broadcast\"])[1]") WebElement btn_PreviewBroadcast;
	public @FindBy(xpath = "(//button[text()=\"Send Broadcast\"])[1]") WebElement btn_SendBroadcast;
	public @FindBy(xpath = "(//button[text()=\"Schedule Broadcast\"])[1]") WebElement btn_ScheduleBroadcast;

	// Redeemable Offer Details
	public @FindBy(xpath = "//input[@name=\"offer-item\"]") WebElement txtF_OfferItem;
	public @FindBy(xpath = "//label[@for=\"option-activation\" and .//span[contains(text(), \"Delay use\")]]//div[@data-toggle=\"toggle\"]") WebElement toggle_DelayUse;
	public @FindBy(xpath = "//label[@for=\"option-expiration\" and .//span[contains(text(), \"Limited time offer\")]]//div[@data-toggle=\"toggle\"]") WebElement toggle_LimitedTimeOffer;
	public @FindBy(xpath = "//input[@name=\"offer-end\"]") WebElement txtF_OfferExpiration;

	// Apply Filters to Subscribers
	public @FindBy(xpath = "//div[@id=\"broadcast-filters-group\"]//div[contains(@class, \"selectize-input\")]") WebElement txtF_ApplyFiltersToSubscribers;

}
