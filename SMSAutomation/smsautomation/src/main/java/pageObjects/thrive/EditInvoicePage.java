package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditInvoicePage extends BasePage {

	public EditInvoicePage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//a[text()=\"Invoices\"]]") WebElement panel_Invoices;
	public @FindBy(xpath = "//div[@id=\"invoice-heading-feature\"]") WebElement col_Feature;
	public @FindBy(xpath = "//div[@id=\"invoice-heading-onetime\"]") WebElement col_OneTimePrice;
	public @FindBy(xpath = "//div[@id=\"invoice-heading-recurring\"]") WebElement col_RecurringPrice;
	
	public @FindBy(xpath = "//a[@id=\"edit-recurring-plan\"]") WebElement lnk_EditRecurringPlan;
	public @FindBy(xpath = "//a[@id=\"edit-billing-info\"]") WebElement lnk_EditBillingInformation;
	
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h3[text()=\"Company Information\"]]") WebElement panel_CompanyInformation;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h3[text()=\"Users\"]]") WebElement panel_Users;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h3[text()=\"Transaction History\"]]") WebElement panel_TransactionHistory;
	
}
