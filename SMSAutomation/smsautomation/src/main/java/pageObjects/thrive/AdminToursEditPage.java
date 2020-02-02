package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminToursEditPage extends BasePage {

	public AdminToursEditPage() throws IOException {
		super();
	}

// Page elements
	public @FindBy(xpath = "//h1[text()[normalize-space()=\"Edit Tour\"]]") WebElement pag_Title;
	public @FindBy(xpath = "//input[@id=\"tour_type_title\"]") WebElement txtF_TourName;
	public @FindBy(xpath = "//input[@id=\"tour_type_path\"]") WebElement txtF_Path;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement lov_Role;
	public @FindBy(xpath = "//input[@id=\"tour_type_tourSteps_0_selector\"]") WebElement txtF_Selector;
	public @FindBy(xpath = "//input[@id=\"tour_type_tourSteps_0_title\"]") WebElement textF_Title;
	public @FindBy(xpath = "//input[@id=\"tour_type_tourSteps_0_path\"]") WebElement txtF_StepPath;
	public @FindBy(xpath = "//textArea[@id=\"tour_type_tourSteps_0_details\"]") WebElement txtF_Message;
	public @FindBy(xpath = "//div[@class=\"panel-heading\"]//button[contains(@class, \"add-step-item\")]") WebElement btn_AddStep;
	public @FindBy(xpath = "//button[@id=\"tour_type_tourSteps_0_delete\"]") WebElement btn_RemoveStep;
	public @FindBy(xpath = "//button[@id=\"submit-btn\"]") WebElement btn_SaveTour;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentBtn;
	public WebElement selectRole(String role) {
		return parentBtn.findElement(By.xpath("//div[text()=\'" + role + "']"));
	}

}
