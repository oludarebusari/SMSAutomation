package pageObjects.engage.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class TriggerModal extends BasePage {

	public TriggerModal() throws IOException {
		super();
	}

	public @FindBy (xpath = "//h3[@class=\"modal-title\" and text()=\"Choose a Trigger\"]") WebElement mod_Title;
	public @FindBy (xpath = "//button[@data-group=\"engagement-group-join\"]") WebElement btn_JoinTheCampaign;
	public @FindBy (xpath = "//button[text()=\"Not Checking In Frequently\"]") WebElement btn_NotCheckingInFrequently;
	
}
