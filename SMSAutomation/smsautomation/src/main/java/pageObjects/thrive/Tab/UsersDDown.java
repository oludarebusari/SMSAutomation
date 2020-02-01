package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class UsersDDown extends BasePage {

	public UsersDDown() throws IOException {
		super();
	}
	
	// Page elements
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Admin\"]]") WebElement opt_Admin;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Resellers\"]]") WebElement opt_Resellers;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Businesses\"]]") WebElement opt_Businesses;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Permissions Templates\"]]") WebElement opt_Permissions_Template;
		
		
	// Page methods
	public UsersDDown clickAdminOpt() throws Exception {
		waitAndClickElement(opt_Admin);
		return new UsersDDown();
	}
	
	public UsersDDown clickResellersOpt() throws Exception {
		waitAndClickElement(opt_Resellers);
		return new UsersDDown();
	}
	
	public UsersDDown clickBusinessesOpt() throws Exception {
		waitAndClickElement(opt_Businesses);
		return new UsersDDown();
	}
	
	public UsersDDown clickPermissionsTemplateOpt() throws Exception {
		waitAndClickElement(opt_Permissions_Template);
		return new UsersDDown();
	}

}
