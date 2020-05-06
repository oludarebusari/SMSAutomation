package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateEditPlanPage extends BasePage {

	public CreateEditPlanPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//input[@id=\"plan_type_name\"]") WebElement txtF_PlanName;
	public @FindBy(xpath = "//textArea[@id=\"plan_type_description\"]") WebElement txtA_PlanDescription;
	public @FindBy(xpath = "//select[@id=\"plan_type_status\"]") WebElement statusDDown;
	public @FindBy(xpath = "//a[normalize-space()=\"Plan\"]") WebElement col_Plan;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement par_OptionElement;
	public WebElement statusOption(String option) {
		return par_OptionElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//div[normalize-space()=\"Feature\"]]") WebElement panel_Feature;
	public @FindBy(xpath = "//div[contains(@class, \"panel-heading\")]//button[contains(@class, \"add-module-item\")]") WebElement btn_AddSubModuleFromHeadingPanel;
	public @FindBy(xpath = "//div[contains(@class, \"panel-footer\")]//button[contains(@class, \"add-module-item\")]") WebElement btn_AddSubModuleFromFooterPanel;
	public @FindBy(xpath = "//div[@class=\"form-group\"]//div[contains(@class, \"selectize-input\")]") WebElement featureDDown;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_0_setupFee\"]") WebElement txtF_OneTimePrice;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_0_monthlyFee\"]") WebElement txtF_RecurringPrice;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_0_startDate\"]") WebElement txtF_Date;
	public @FindBy(xpath = "//input[@id=\"plan_type_planModules_0_startDate\"]") WebElement btn_SavePlan;
	
}
