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
	
	public @FindBy(xpath = "//li[contains(@class, \"list-group-item\")]") WebElement listOfSteps;
	public WebElement txtF_Selector(String num) {
		return listOfSteps.findElement(By.xpath("//input[@name=\"tour_type[tourSteps][" + num + "][selector]\"]"));
	}
	public WebElement txtF_Title(String num) {
		return listOfSteps.findElement(By.xpath("//input[@name=\"tour_type[tourSteps][" + num + "][title]\"]"));
	}
	public WebElement txtF_StepPath(String num) {
		return listOfSteps.findElement(By.xpath("//input[@name=\"tour_type[tourSteps][" + num + "][path]\"]"));
	}
	public WebElement txtF_Message(String num) {
		return listOfSteps.findElement(By.xpath("//textarea[@name=\"tour_type[tourSteps][" + num + "][details]\"]"));
	}

	public @FindBy(xpath = "//div[@class=\"panel-heading\"]//button[contains(@class, \"add-step-item\")]") WebElement btn_AddStep;
	public @FindBy(xpath = "//button[@id=\"submit-btn\"]") WebElement btn_SaveTour;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentBtn;
	public WebElement selectRole(String role) {
		return parentBtn.findElement(By.xpath("//div[text()=\'" + role + "']"));
	}
	public WebElement removeRole(String role) {
		return parentBtn.findElement(By.xpath("//div[text()=\'" + role + "']//a[@class=\"remove\"]"));
	}

	/*
	 * public @FindBy(xpath = "//li[contains(@class, \"list-group-item\")]")
	 * WebElement parentTourStep; public WebElement selectTourStep(String step) {
	 * return parentBtn.findElement(By.
	 * xpath("//li[contains(@class, \"list-group-item\")]//div[@class=\"row\" and ./div[text()[normalize-space()="
	 * + step + "]]]")); }
	 */
	public WebElement btn_RemoveStep(String step) {
		return listOfSteps.findElement(By.xpath("//button[@name=\"tour_type[tourSteps][" + step +"][delete]\"]"));
	}
	
}
