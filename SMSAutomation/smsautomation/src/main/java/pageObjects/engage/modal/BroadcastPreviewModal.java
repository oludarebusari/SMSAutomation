package pageObjects.engage.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BroadcastPreviewModal extends BasePage {

	public BroadcastPreviewModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()[normalize-space()=\"Broadcast Preview\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//button[contains(@class, \"half-bottom\") and text()=\"Send Broadcast\"]") WebElement btn_SendBroadcast;
	public @FindBy(xpath = "//button[contains(@class, \"half-bottom\") and text()=\"Schedule Broadcast\"]") WebElement btn_ScheduleBroadcast;
	public @FindBy(xpath = "//button[@data-dismiss=\"modal\" and text()[normalize-space()=\"Edit Broadcast\"]]") WebElement mod_EditBroadcast;
	
}
