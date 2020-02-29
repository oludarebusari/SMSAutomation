package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BillingPage extends BasePage {

	public BillingPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[contains(@class, \"pull-left\")]") WebElement pag_Title;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-due\"]") WebElement tile_CurrentBalance;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-method\"]") WebElement tile_InvoicePaymentMethod;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-email\"]") WebElement tile_BillingInformation;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\")]//h4[text()=\"Invoice History\"]") WebElement InvoiceHistory;
	public @FindBy(xpath = "//a[text()[normalize-space()=\"View Invoice\"]]") WebElement lnk_ViewInvoice;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-due\"]//h1[@class=\"text-right\"]") WebElement CurrentBalance;
	public @FindBy(xpath = "//a[@class=\"text-info\"]") WebElement lnk_EditPaymentMethod;
	public @FindBy(xpath = "//a[@class=\"text-default\"]") WebElement lnk_EditBillingInformation;
}
