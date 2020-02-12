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
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement drpd_Campaign_To_Send_From;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement opt_parent;
	public WebElement opt_Campaign(String CampaignName) {
		return opt_parent.findElement(By.xpath("//div[contains(@class, \"option selected\") and text()=\'" + CampaignName +"']"));
	}
	public @FindBy(xpath = "//button[@data-dismiss=\"modal\" and text()=\"Close\"]") WebElement btn_Cancel;
	public @FindBy(xpath = "//button[@type=\"submit\" and text()=\"Send\"]") WebElement btn_Send;
	
}
