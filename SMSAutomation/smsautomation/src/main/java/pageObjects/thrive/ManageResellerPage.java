package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageResellerPage extends BasePage {

	public ManageResellerPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//a[@id=\"create-entity\"]") WebElement btn_New;
	public @FindBy(xpath = "//input[@id=\"simple_search_searchText\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//button[@id=\"search-text-submit\"]") WebElement btn_Search;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Help;
	public @FindBy(xpath = "//tbody") WebElement parent;

	public WebElement opt_Reseller(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller + "']]"));
	}

	public WebElement btn_SignIn(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller + "']]//a[@title=\"Sign In\"]"));
	}
	
	public WebElement txt_Status(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller
				+ "']]//td[@class=\"company-status\"]"));
	}

	public WebElement btn_Edit_Dropdown(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller
				+ "']]//button[@data-toggle=\"dropdown\"]"));
	}

	// Dropdown Action options
	public WebElement btn_Edit(String reseller) {
		return parent.findElement(By.xpath(
				"//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller + "']]//ul[@class=\"dropdown-menu\"]//a[@title=\"Edit\"]"));
	}

	public WebElement btn_Enable_Services(String reseller) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + reseller + "']]//ul[@class=\"dropdown-menu\"]//a[@title=\"Enable Services\"]"));
	}

}
