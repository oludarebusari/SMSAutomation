package pageObjects.engage.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateRewardModal extends BasePage {

	public CreateRewardModal() throws IOException {
		super();
	}

	public @FindBy (xpath = "//h3[@class=\"modal-title\" and text()=\"Create Reward\"]") WebElement mod_Title;
	public @FindBy (xpath = "//input[@id=\"reward_birthday\"]") WebElement txtF_DaysBeforeBirthday;
	public @FindBy (xpath = "//label[@for=\"reward_delay\"]//label[text()=\"No\"]") WebElement tog_PreventSameDayUsage;
	public @FindBy (xpath = "//label[@for=\"reward_expires\"]//label[text()=\"No\"]") WebElement tog_LimitedTimeOffer;
	public @FindBy (xpath = "//input[@id=\"reward_name\"]") WebElement txtF_RewardName;
	public @FindBy (xpath = "//label[@for=\"reward_text_mms\" and .//span[contains(text(), \"Send as MMS (with photo)\")]]//label[text()=\"No\"]") WebElement tog_SendASMMS;
	public @FindBy (xpath = "//textarea[@id=\"reward_text\"]") WebElement txtA_Message;
	public @FindBy (xpath = "//button[@id=\"save_reward\"]") WebElement btn_AddReward;
	
	
	
}
