package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class RestoreInvoiceModal extends BasePage {

	public RestoreInvoiceModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[normalize-space()=\"Restore Invoice\"]") WebElement mod_Title;
	public @FindBy(xpath = "//input[@id=\"invoice_status_type_dueDate\"]") WebElement txtF_dueDate;
	public @FindBy(xpath = "//input[@id=\"invoice_status_type_sendEmail\"]") WebElement chkBok_SendEmail;
	public @FindBy(xpath = "//button[text()=\"Restore Invoice\"]") WebElement btn_RestoreInvoice;
	
}
