package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AddAndEditPlansPage extends BasePage {

	public AddAndEditPlansPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//input[@id=\"plan_type_name\"]") WebElement txtF_PlanName;
	public @FindBy(xpath = "//textarea[@id=\"plan_type_description\"]") WebElement txtA_PlanDescription;
	public @FindBy(xpath = "//select[@id=\"plan_type_status\"]") WebElement statusDDown;
	public @FindBy(xpath = "//button[@id=\"submit-btn\"]") WebElement btn_SavePlan;	
	
	//feature
	public @FindBy(xpath = "//div[@id=\"plan-action\"]//button[contains(@class, \"add-module-item\")]") WebElement addFeatureTopBtn;
	public @FindBy(xpath = "//div[@class=\"panel-footer\"]//button[contains(@class, \"add-module-item\")]") WebElement addFeatureBotBtn;
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement featureDDown;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_1_setupFee\"]") WebElement txtF_OneTimePrice;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_1_monthlyFee\"]") WebElement txtF_RecurringPrice;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_1_startDate\"]") WebElement txtF_Date;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentBtn;
	public WebElement selectFeature(String feature) {
		return parentBtn.findElement(By.xpath("//div[text()=\'" + feature + "']"));
	}
	public @FindBy(xpath = "(//td[contains(@class, \"active\")])[3]") WebElement activeDate;
	public @FindBy(xpath = "//li[@class=\"list-group-item\"]") WebElement parentFeature;
	public WebElement feature(String featureName) {
		return parentFeature.findElement(By.xpath("//strong[text()=\'" + featureName + "']"));
	}
	public @FindBy(xpath = "//ul[@class=\"modules-list list-group\"]") WebElement parentRemove;
	public WebElement removeFeature(String feature) {
		return parentRemove.findElement(By.xpath("//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]//button[@id=\"plan_type_planModules_1_delete\"]"));
	}
}
