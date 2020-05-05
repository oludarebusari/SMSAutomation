package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ModulesPage extends BasePage {

	public ModulesPage() throws IOException {
		super();
	}

	
	private final String MODULELOCATOR = "//h4[text()=\"Automation Testing Module - Edited\"]";
	
	//menu options
	public @FindBy(xpath = "//div[@class=\"panel panel-default\"]") WebElement AllModules;
	public @FindBy(xpath = "//div[@id=\"manage-modules\"]") WebElement parentModuleElement;
	public WebElement modulePanel(String moduleName) {
		return parentModuleElement.findElement(By.xpath("//div[@class=\"panel panel-default\" and .//h4[text()=\'" + moduleName + "']]"));
	}
	
	public WebElement editModuleBtn(String moduleName) {
		return parentModuleElement.findElement(By.xpath("//div[@class=\"panel panel-default\" and .//h4[text()=\'" + moduleName + "']]//a[text()=\"Edit\"]"));
	}
	
	public WebElement moduleDDown(String moduleName) {
		return parentModuleElement.findElement(By.xpath("//div[@class=\"panel panel-default\" and .//h4[text()=\'" + moduleName + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement deleteModuleBtn(String moduleName) {
		return parentModuleElement.findElement(By.xpath("//div[@class=\"panel panel-default\" and .//h4[text()=\'" + moduleName + "']]//a[@data-action=\"delete\"]"));
	}
		
	public @FindBy(xpath = "//div[@role=\"alert\"]//p") WebElement NotificationAlert;
	public WebElement tile_ModuleName(String name) {
		return AllModules.findElement(By.xpath("//h4[text()=\'" + name + "']"));
	}
    public WebElement tile_ModuleDescription(String description) {
    	return AllModules.findElement(By.xpath("//p[text()=\'" + description + "']"));
    }
    public WebElement tile_Price(String price) {
    	return AllModules.findElement(By.xpath("//span[contains(text(), \"" + "$" + price + ")]"));
    }
	public String getMODULELOCATOR() {
		return MODULELOCATOR;
	}


	public @FindBy(xpath = "//div[@role=\"alert\"]//p") WebElement tile_ModuleDescription;
	public @FindBy(xpath = "//div[@role=\"alert\"]//p") WebElement tile_Price;
	
}
