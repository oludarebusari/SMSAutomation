package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateEditModulePage extends BasePage {

	public CreateEditModulePage() throws IOException {
		super();
	}

	private final String BLANKERRORMSG = "Please enter a value";
	private final String SHORTVALERRORMSG = "This value is too short. It should have 3 characters or more.";
	private final String FEATUREBLANKERRORMSG = "This value should not be blank.";
	
	public String getBLANKERRORMSG() {
		return BLANKERRORMSG;
	}

	
	public String getSHORTVALERRORMSG() {
		return SHORTVALERRORMSG;
	}

	public String getFEATUREBLANKERRORMSG() {
		return FEATUREBLANKERRORMSG;
	}

	public @FindBy(xpath = "//input[@id=\"module_type_name\"]") WebElement txtF_ModuleName;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Module Name\"]]//small") WebElement lbl_ModuleNameErrorMsg;
	public @FindBy(xpath = "//textarea[@id=\"module_type_description\"]") WebElement txtA_ModuleDescription;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Module Description\"]]//small") WebElement lbl_ModuleDescriptionErrorMsg;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Categories\"]]//div[contains(@class, \"selectize-input\")]") WebElement categoriesDDown;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement par_OptionElement;
	public WebElement categoriesOption(String option) {
		return par_OptionElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Icon\"]]//div[contains(@class, \"selectize-input\")]") WebElement iconDDown;
	public WebElement iconOption (String option) {
		return par_OptionElement.findElement(By.xpath("//i[normalize-space()=\'" + option + "']"));
	}
	
	public @FindBy(xpath = "//input[@id=\"module_type_subModules_0_name\"]") WebElement txtF_Feature;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./input[@id=\"module_type_subModules_0_name\"]]//small") WebElement lbl_FeatureErrorMsg;
	public @FindBy(xpath = "//input[@id=\"module_type_subModules_0_price\"]") WebElement txtF_Price;
	public @FindBy(xpath = "//select[@id=\"module_type_subModules_0_interval\"]") WebElement intervalDDown;
	public WebElement intervalOption(String option) {
		return intervalDDown.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}
	
	public @FindBy(xpath = "//div[contains(@class, \"panel-heading\")]//button[contains(@class, \"add-submodule-item\")]") WebElement btn_AddSubModuleFromHeadingPanel;
	public @FindBy(xpath = "//div[contains(@class, \"panel-footer\")]//button[contains(@class, \"add-submodule-item\")]") WebElement btn_AddSubModuleFromFooterPanel;
	
	public @FindBy(xpath = "//button[@id=\"submit-btn\"]") WebElement btn_SaveModule;
}
