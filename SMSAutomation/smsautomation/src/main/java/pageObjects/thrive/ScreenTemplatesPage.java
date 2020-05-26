package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ScreenTemplatesPage extends BasePage  {

	public ScreenTemplatesPage() throws IOException {
		super();
	}
	
	private final String DEACTIVATEBTN = "//a[@data-action=\"deactivate\"]";
	
	public String getDEACTIVATEBTN() {
		return DEACTIVATEBTN;
	}
	
	public @FindBy(xpath = "//a[text()=\"Name\"]") WebElement col_Name;
	public @FindBy(xpath = "//a[text()=\"Template\"]") WebElement col_Template;
	public @FindBy(xpath = "//th[text()=\"Verticals\"]") WebElement col_Verticals;
	public @FindBy(xpath = "//a[text()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//tbody") WebElement par_PageElement;
	public WebElement CellValue(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]"));
	}
		
	public WebElement CellValueByName(String name, String value) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//td[text()=\'" + value + "']"));
	}
	
	public WebElement btn_DeactivateByName(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//a[normalize-space()=\"Deactivate\"]"));
	}
	
	public WebElement btn_ActivateByName(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//a[normalize-space()=\"Activate\"]"));
	}
	
	public @FindBy(xpath = "//input[@id=\"screen_template_filter_type_businessCategory-selectized\"]") WebElement txtF_Verticals;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement VerticalOptions;
	public WebElement verticalsOpt(String optName) {
		return VerticalOptions.findElement(By.xpath("//div[text()=\'" +  optName + "']"));
	}
}
