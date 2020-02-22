package pageObjects.thrive;

import java.io.IOException;

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
	
	// Record elements
	

}
