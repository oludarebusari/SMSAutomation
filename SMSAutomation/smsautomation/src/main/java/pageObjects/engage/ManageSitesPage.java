package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageSitesPage extends BasePage {

	public ManageSitesPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = "//div[@class=\"col-xs-12\"]//h1[text()[normalize-space()=\"Manage Resellers\"]]") WebElement pag_Title;
	public @FindBy(xpath = "//button[@class=\"navbar-toggle collapsed\"]") WebElement tog_Navbar;
	public @FindBy(xpath = "//a[text()=\"Manage Resellers\"]") WebElement menu_Manage_Resellers;
	public @FindBy(xpath = "//a[text()=\"Business Search\"]") WebElement menu_Business_Search;
	public @FindBy(xpath = "//a[contains(text(), \"Edit\")]") WebElement menu_Edit;
	public @FindBy(xpath = "//a[contains(text(), \"Reports\")]") WebElement menu_Reports;
	public @FindBy(xpath = "//a[contains(text(), \"Engineering\")]") WebElement menu_Engineering;
	public @FindBy(xpath = "//a[contains(text(), \"Accounting\")]") WebElement menu_Accounting;
	public @FindBy(xpath = "//a[contains(text(), \"Other\")]") WebElement menu_Other;
	public @FindBy(xpath = "//button[@type=\"submit\"]") WebElement btn_Sing_Out;
	public @FindBy(xpath = "//input[@class=\"table-search form-control\"]") WebElement SearchTxtF;
	public @FindBy(xpath = "//table[@id=\"serviceTable\"]") WebElement table_Reseller;
	public String licenseLoginLocator = "//span[@class=\"licensee_login\"]";	
	public @FindBy(xpath = "//a[@aria-controls=\"serviceTable\"]//span[text()=\"Copy\"]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[@aria-controls=\"serviceTable\"]//span[text()=\"CSV\"]") WebElement btn_CSV;
	public @FindBy(xpath = "//tbody") WebElement Reseller;	
	public WebElement loginAS(String resellerName, String account) {
		return Reseller.findElement(
				By.xpath("//tr[@role=\"row\" and ./td[text()='" + resellerName + "']]//a[text()='" + account + "']"));
	}
	public @FindBy(xpath = "//tr[@role=\"row\"]") WebElement parent_ColumnName;
	public WebElement colByName(String name) {
		return parent_ColumnName.findElement(By.xpath("//th[@aria-controls=\"serviceTable\" and text()=\'" + name + "']"));
	}
	
}
