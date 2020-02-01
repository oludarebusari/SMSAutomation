package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BillingDDown extends BasePage {

	public BillingDDown() throws IOException {
		super();
	}

	
	// Page elements
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Plans\"]]") WebElement opt_Plans;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Add Plan\"]]") WebElement opt_Add_Plan;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Modules\"]]") WebElement opt_Modules;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\\\"Add Module\\\"]]") WebElement opt_Add_Module;


    // Page methods
	public BillingDDown clicPlansOpt() throws Exception {
		waitAndClickElement(opt_Plans);
		return new BillingDDown();
	}
	
	public BillingDDown clickAddPlanOpt() throws Exception {
		waitAndClickElement(opt_Add_Plan);
		return new BillingDDown();
	}
	
	public BillingDDown clickModulesOpt() throws Exception {
		waitAndClickElement(opt_Modules);
		return new BillingDDown();
	}
	
	public BillingDDown clickAddModuleOpt() throws Exception {
		waitAndClickElement(opt_Add_Module);
		return new BillingDDown();
	}
	
		
}
