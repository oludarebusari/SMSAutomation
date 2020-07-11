package pageObjects.engage.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SingleCampaignSummaryModal extends BasePage {

	public SingleCampaignSummaryModal() throws IOException {
		super();
	}
	
	public @FindBy (xpath = "//div[@class=\"modal-body\" and ./h2[contains(text(), \"summary\")]]") WebElement mod_Title;
	public @FindBy (xpath = "//div[contains(@class, \"col-xs-12\")]//button[normalize-space()=\"Close\"]") WebElement btn_Close;
	public @FindBy (xpath = "//div[contains(@class, \"col-xs-12\")]//button[normalize-space()=\"Campaign Summary\"]") WebElement btn_CampaignSummary;

}
