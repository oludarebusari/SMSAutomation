package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditBusinessPlanPage extends BasePage {

	public EditBusinessPlanPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//input[@id=\"merchant_plan_type_plan_name\"]") WebElement txtF_PlanName;
	public @FindBy(xpath = "//textArea[@id=\"merchant_plan_type_plan_description\"]") WebElement txtA_PlanDescription;
	public @FindBy(xpath = "//select[@id=\"merchant_plan_type_plan_status\"]") WebElement statusDDown;
	public @FindBy(xpath = "//tbody") WebElement parent;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//div[normalize-space()=\"Feature\"]]") WebElement panel_Feature;
	public WebElement featureOption(String option) {
		return parent.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public @FindBy(xpath = "//div[contains(@class, \"panel-heading\")]//button[contains(@class, \"add-module-item\")]") WebElement btn_AddSubModuleFromHeadingPanel;
	public @FindBy(xpath = "//div[contains(@class, \"panel-footer\")]//button[contains(@class, \"add-module-item\")]") WebElement btn_AddSubModuleFromFooterPanel;
	public @FindBy(xpath = "//div[@class=\"form-group\"]//div[contains(@class, \"selectize-input\")]") WebElement featureDDown;
	public @FindBy(xpath = "//input[@id=\"merchant_plan_type_merchantModules_0_setupFee\"]") WebElement txtF_OneTimePrice;
	public @FindBy(xpath = "//input[@id=\"merchant_plan_type_merchantModules_0_monthlyFee\"]") WebElement txtF_RecurringPrice;
	public @FindBy(xpath = "//input[@id=\"merchant_plan_type_merchantModules_0_startDate\"]") WebElement txtF_Date;
	public @FindBy(xpath = "(//td[contains(@class, \"active\")])[7]") WebElement btn_Day;
	public @FindBy(xpath = "//button[text()=\"Save Plan\"]") WebElement btn_SavePlan;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\")]") WebElement parentElement;
	
	public WebElement selectFeature(String feature) {
		return parentElement.findElement(By.xpath("//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]"));
	}
	
	public WebElement removeFeatureBtn(String feature) {
		return parentElement.findElement(By.xpath("//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]//button[@id=\"merchant_plan_type_merchantModules_3_delete\"]"));
	}
    
	public WebElement txtF_OneTimePrice(String feature) {
		return parentElement.findElement(By.xpath("//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]//input[@id=\"merchant_plan_type_merchantModules_3_setupFee\"]"));
	}
	
	public WebElement txtF_RecurringPrice(String feature) {
		return parentElement.findElement(By.xpath("//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]//input[@id=\"merchant_plan_type_merchantModules_3_monthlyFee\"]"));
	}
	
	public String featureLocator(String feature) {
		return "//li[@class=\"list-group-item\" and .//strong[text()=\'" + feature + "']]";
	}
	
}
