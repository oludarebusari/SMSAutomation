package pageObjects.thrive.modal;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreatepagePage extends BasePage{

	public CreatepagePage() throws IOException {
		super();
	
	}

	public @FindBy(xpath = "//h4[@class=\"modal-title\" and text()[normalize-space()=\"Create Page\"]]") WebElement mod_Title;
	public @FindBy(xpath = "//input[@id=\"page_type_name\"]") WebElement txtF_Name;
	public @FindBy(xpath = "//button[text()[normalize-space()=\"Create Page\"]]") WebElement btn_CreatePage;
	public @FindBy(xpath = "//img[@title=\"spa.png\"]") WebElement template_Spa;
	
	
}
