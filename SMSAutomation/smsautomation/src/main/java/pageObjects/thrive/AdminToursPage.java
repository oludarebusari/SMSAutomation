package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class AdminToursPage extends BasePage {

	public AdminToursPage() throws IOException {
		super();
	}
	
	// Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\"]") WebElement pag_Title;
	public @FindBy(xpath = "//a[@id=\"create-entity\"]") WebElement btn_New;
	public @FindBy(xpath = "//button[@id=\"search-text-submit\"]") WebElement btn_Search;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Help;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Edit;
	public @FindBy(xpath = "//ul[@class=\"dropdown-menu\"]//a[@data-action=\"deactivate\"]") WebElement btn_Deactivate;
	public @FindBy(xpath = "//ul[@class=\"dropdown-menu\"]//a[@data-action=\"activate\"]") WebElement btn_Activate;
	public @FindBy(xpath = "//ul[@class=\"dropdown-menu\"]//a[@data-action=\"delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//input[@id=\"simple_search_searchText\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//tbody") WebElement parentBtn;
	public WebElement btn_EditByTourName(String TourName) {
		return parentBtn.findElement(By.xpath("//tr[//td[(.)=\'" + TourName + "']][1]//a[(.)=\"Edit\"]"));
	}
	public WebElement btn_EditDropdownByTourName(String TourName) {
		return parentBtn.findElement(By.xpath("//tr[//td[(.)=\'" + TourName + "']][1]//button[@data-toggle=\"dropdown\"]"));
	}
	public @FindBy(xpath = "//tbody//td[2]") WebElement txt_Role;
	public @FindBy(xpath = "//tbody//td[3]") WebElement txt_Status;

}
