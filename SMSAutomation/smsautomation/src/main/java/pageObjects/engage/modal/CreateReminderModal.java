package pageObjects.engage.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateReminderModal extends BasePage {

	public CreateReminderModal() throws IOException {
		super();
	}

	public @FindBy (xpath = "//h3[@class=\"modal-title\" and text()=\"Create Reminder\"]") WebElement mod_Title;
	public @FindBy (xpath = "//input[@id=\"engagement_days_after\"]") WebElement txtF_DaysAfterJoiningCampaign;
	public @FindBy (xpath = "//label[@for=\"engagement_text_mms\" and .//span[contains(text(), \"Send as MMS (with photo)\")]]//label[text()=\"No\"]") WebElement tog_SendASMMS;
	public @FindBy (xpath = "//textarea[@id=\"engagement_text\"]") WebElement txtA_Message;
	public @FindBy (xpath = "//button[@id=\"save_engagement\"]") WebElement btn_AddMessage;
}
