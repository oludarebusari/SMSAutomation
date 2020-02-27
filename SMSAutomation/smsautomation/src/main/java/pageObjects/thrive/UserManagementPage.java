package pageObjects.thrive;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class UserManagementPage extends BasePage {

	public UserManagementPage() throws IOException {
		super();
	}

	//Page elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//a[@id=\"create-entity\"]") WebElement btn_New;
	public @FindBy(xpath = "//input[@id=\"simple_search_searchText\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//button[@id=\"search-text-submit\"]") WebElement btn_Search;
	public @FindBy(xpath = "//span[@id=\"pagination-total\"]") WebElement lbl_PaginationTotal;
	

	// User display area Column header elements
	public @FindBy(xpath = "//a[text()=\"First Name\"]") WebElement col_FirstName;
	public @FindBy(xpath = "//a[text()=\"Last Name\"]") WebElement col_LastName;
	public @FindBy(xpath = "//a[text()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//tr") WebElement parent;
	public WebElement btn_UserEdit(String userName) {
		return parent.findElement(By.xpath("//td[text()=\'" + userName + "']/..//div[contains(@class, \"btn-group-sm\")]//a[@title=\"Edit\"]"));
	}
	public WebElement btn_ActionDropdown(String userName) {
		return parent.findElement(By.xpath("//td[text()=\'" + userName + "']/..//div[contains(@class, \"btn-group-sm\")]//button[@data-toggle=\"dropdown\"]"));
	}
	public WebElement btn_DropdownDeleteOpt(String userName) {
		return parent.findElement(By.xpath("//td[text()=\'" + userName + "']/..//div[contains(@class, \"btn-group-sm\")]//a[@class=\"user-delete-action\"]"));
	}
	
	public WebElement selectColumnByName(String name) {
		return parent.findElement(By.xpath("//td[text()=\'" + name + "']"));
	}
	public @FindBy(xpath = "//table[@id=\"data-table\"]") WebElement table_Users;
	public List<WebElement> all_Users() {
		return table_Users.findElements(By.xpath("//tbody/tr"));
	}
	
	public @FindBy(xpath = "//div[contains(@class, \"alert-success\")]//p[normalize-space()]") WebElement txt_Action_Notification;
	
	
	

}
