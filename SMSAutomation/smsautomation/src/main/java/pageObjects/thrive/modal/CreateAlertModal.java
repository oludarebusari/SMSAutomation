package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateAlertModal extends BasePage  {

	public CreateAlertModal() throws IOException {
		super();
	
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()=\"Create Alert\"]") WebElement mod_Title;
	public @FindBy(xpath = "//input[@id=\"alert_form_type_text\"]") WebElement txtF_Text;
	public @FindBy(xpath = "//input[@id=\"alert_form_type_date\"]") WebElement txtF_Date;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement lov_Roles;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement par_Element;
	public WebElement rolesOption(String role) {
		return par_Element.findElement(By.xpath("//div[text()=\'" + role + "']"));		
	}
	public @FindBy(xpath = "//button[contains(@class, \"submit-alert\")]") WebElement btn_ScheduleThisAlert;
	
}
