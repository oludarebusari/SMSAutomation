package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreatePageTemplatePage extends BasePage {

	public CreatePageTemplatePage() throws IOException {
		super();
	}

	 public @FindBy(xpath = "//h4[@class=\"modal-title\" and normalize-space()=\"Create Page Template\"]") WebElement mod_Title;
	 public @FindBy(xpath = "//input[@id=\"page_template_type_name\"]") WebElement txtF_Name;
	 public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement categoriesDDown;
	 public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentElement;
	 public WebElement selectCategoriesh(String option) {
			return parentElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
		}
	 public @FindBy(xpath = "//button[@type=\"submit\" and normalize-space()=\"Create Page Template\"]") WebElement btn_CreatePageTemplate;
	 public @FindBy(xpath = "//small[@data-fv-result=\"INVALID\"]") WebElement nameFieldErrorMsg;
	 
}
