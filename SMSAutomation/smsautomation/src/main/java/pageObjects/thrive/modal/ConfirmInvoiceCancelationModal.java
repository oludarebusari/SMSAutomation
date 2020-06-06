package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ConfirmInvoiceCancelationModal extends BasePage {

	public ConfirmInvoiceCancelationModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[normalize-space()=\"Confirm Invoice Cancelation\"]") WebElement mod_Title;
	public @FindBy(xpath = "//input[@id=\"invoice_status_type_sendEmail\"]") WebElement chkBox_SendEmail;
	public @FindBy(xpath = "//button[text()=\"Cancel Invoice\"]") WebElement btn_CancelInvoice;
	
}
