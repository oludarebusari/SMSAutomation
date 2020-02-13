package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class SendMessageModal extends BasePage {

	public SendMessageModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Send Message\"]") WebElement mod_Title;
	public @FindBy(xpath = "//label[contains(@class, \"toggle-off\")]") WebElement tog_Send_As_MMS;
	public @FindBy(xpath = "//input[@name=\"reply_message_subject\"]") WebElement txt_Introduction;
	public @FindBy(xpath = "//textarea[@name=\"reply_message\"]") WebElement txt_Message;
	public @FindBy(xpath = "//form[@class=\"modal-content\" and .//h4[@id=\"replyModalLabel\"]]//button[@type=\"submit\" and text()=\"Send\"]") WebElement btn_Send;
	public @FindBy(xpath = "//form[@class=\"modal-content\" and .//h4[@id=\"replyModalLabel\"]]//button[@data-dismiss=\"modal\" and text()=\"Close\"]") WebElement btn_Close;
	
}
