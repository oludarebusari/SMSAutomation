package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class InvoicesPage extends BasePage {

	public InvoicesPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[normalize-space()=\"Invoice\"]") WebElement col_Invoice;
	public @FindBy(xpath = "//a[normalize-space()=\"Business\"]") WebElement col_Business;
	public @FindBy(xpath = "//a[normalize-space()=\"Payment Method\"]") WebElement col_PaymentMethod;
	public @FindBy(xpath = "//a[normalize-space()=\"Amount\"]") WebElement col_Amount;
	public @FindBy(xpath = "//a[normalize-space()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//a[normalize-space()=\"Due\"]") WebElement col_Due;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[normalize-space()=\"Action\"]") WebElement col_Action;
	
}
