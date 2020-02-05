package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AutoPurchaseModal extends BasePage {

	public AutoPurchaseModal() throws IOException {
		super();
	}

	// Auto Purchase elements
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Auto Purchase Plans\"]") WebElement mod_Auto_Purchase_Title;
	public @FindBy(xpath = "//div[contains(@class, \"list-group\")]") WebElement parent;

	public WebElement selectAutoPurchasePlan(String autoPurchasePlanName) {
		return parent.findElement(By.xpath("//a[contains(@class, \"list-group-item\") and ./h3[text()=\'" + autoPurchasePlanName + "']]"));
	}
	public @FindBy(xpath = "//button[@id=\"change-autopurchase\"]") WebElement btn_Change_Plan;

}
