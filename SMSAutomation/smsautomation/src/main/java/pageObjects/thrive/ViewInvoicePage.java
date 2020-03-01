package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ViewInvoicePage extends BasePage {

	public ViewInvoicePage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[contains(@class, \"pull-left\")]") WebElement pag_Title;
	public @FindBy(xpath = "//a[contains(@class, \"add-left\")]") WebElement btn_Print;
	public @FindBy(xpath = "//a[contains(@class, \"add-left\")]") WebElement col_OneTimePrice;
	public @FindBy(xpath = "//a[contains(@class, \"add-left\")]") WebElement col_RecurringPrice;
	public @FindBy(xpath = "//a[contains(@class, \"add-left\")]") WebElement col_Date;
	public @FindBy(xpath = "//div[@id=\"invoice-status\"]") WebElement InvoiceBalance;
	public @FindBy(xpath = "//a[contains(@class, \"add-left\") and text()[normalize-space()]]") WebElement lnk_Print;
	
	public @FindBy(xpath = "//div[@id=\"content\"]/embed") WebElement mod_PrintWindow;
	public @FindBy(xpath = "//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[1]") WebElement btn_WindowsPrint;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h3[text()=\"Company Information\"]]") WebElement tile_CompanyInformation;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h3[text()=\"Company Information\"]]//a[contains(@class, \"pull-right\")]") WebElement btn_CompanyInformationEdit;
}
