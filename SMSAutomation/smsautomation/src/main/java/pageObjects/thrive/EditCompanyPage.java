package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditCompanyPage extends BasePage {

	public EditCompanyPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//h1[contains(@class, \"pull-left\")]") WebElement pag_Title;
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]//p[normalize-space()]") WebElement txt_Action_Notification;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_name\"]") WebElement txtF_BusinessName;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_supportEmail\"]") WebElement txtF_SupportEmail;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_supportEmail\"]") WebElement txtF_BusinessPhone;
	public @FindBy(xpath = "//input[@id=\"company_merchant_type_logoFile\"]") WebElement btn_ChooseFile;
	
	
}
