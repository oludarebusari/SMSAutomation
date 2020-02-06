package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PurchaseMessageCreditsModal extends BasePage {

	public PurchaseMessageCreditsModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Purchase Message Credits\"]") WebElement mod_Purchase_Message_Credits;
	public @FindBy(xpath = "//div[contains(@class, \"list-group\")]") WebElement parent;

	public WebElement selectPurchaseMessageCredit(String purchaseMessageCredit) {
		return parent.findElement(By.xpath("//a[contains(@class, \"list-group-item\") and ./h3[text()=\'" + purchaseMessageCredit + "']]"));
	}
	
	public WebElement lab_CostOfMessages(String purchaseMessageCredit) {
		return parent.findElement(By.xpath("//a[contains(@class, \"list-group-item\") and ./h3[text()=\'" + purchaseMessageCredit + "']]//span[@class=\"small\"]"));
	}
	
	public @FindBy(xpath = "//p[@class=\"remove-bottom quarter-top\"]//b") WebElement lab_Amount_Due_Today;
	public @FindBy(xpath = "//button[@id=\"purchase-prepaid-blocks\"]") WebElement btn_Purchase_Now;

}
