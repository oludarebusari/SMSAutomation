package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateDigitalAuditModal extends BasePage {

	public CreateDigitalAuditModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Create Digital Audit\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//input[@id=\"site_audit_type_url\"]") WebElement txtF_URL;
	public @FindBy(xpath = "//input[@id=\"site_audit_type_keyword\"]") WebElement txtF_Keyword;
	public @FindBy(xpath = "//button[normalize-space()=\"Close\"]") WebElement Close;
	public @FindBy(xpath = "//button[normalize-space()=\"Add\"]") WebElement Add;
	
}
