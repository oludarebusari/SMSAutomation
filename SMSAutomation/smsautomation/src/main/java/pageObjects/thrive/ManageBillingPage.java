package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageBillingPage extends BasePage {

	public ManageBillingPage() throws IOException {
		super();
	}

	// Columns
	public @FindBy(xpath = "//a[text()=\"Due\"]") WebElement col_Due;
	public @FindBy(xpath = "//a[text()=\"Merchant\"]") WebElement col_Merchant;
	public @FindBy(xpath = "//a[text()=\"Payment Method\"]") WebElement col_PaymentMethod;
	public @FindBy(xpath = "//a[text()=\"Amount\"]") WebElement col_Amount;
	public @FindBy(xpath = "//a[text()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;

	// Filters
	public @FindBy(xpath = "//li[@role=\"presentation\" and ./a[text()=\"Overview\"]]") WebElement filter_Overview;
	public @FindBy(xpath = "//a[text()=\"Cancelled\"]") WebElement filter_Cancelled;
	public @FindBy(xpath = "//a[text()=\"Late\"]") WebElement filter_Late;
	public @FindBy(xpath = "//a[text()=\"Pending\"]") WebElement filter_Pending;
	public @FindBy(xpath = "//a[text()=\"Paid\"]") WebElement filter_Paid;
	public @FindBy(xpath = "//tbody") WebElement parent;
	public WebElement cellValue(String option) {
		return parent.findElement(By.xpath("//tr//td[normalize-space()=" + option + "]"));
	}
	
	public WebElement ActionDDown(String business) {
		return parent.findElement(By.xpath("//tr[td[text()=\'" + business + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement btn_View(String business) {
		return parent.findElement(By.xpath("//tr[td[text()=\'" + business + "']]//a[normalize-space()=\"View\"]"));
	}
	
	public WebElement ActionDDownOption(String business, String option) {
		return parent.findElement(By.xpath("//tr[td[text()=\'" + business + "']]//ul[@class=\"dropdown-menu\"]//a[text()=\'" + option + "']"));
	}
}
