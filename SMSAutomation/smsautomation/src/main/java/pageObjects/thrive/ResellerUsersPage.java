package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ResellerUsersPage extends BasePage {

	public ResellerUsersPage() throws IOException {
		super();
	}

	public @FindBy (xpath = "//a[@id=\"create-entity\"]") WebElement btn_New;
	public @FindBy (xpath = "//a[normalize-space()=\"First Name\"]") WebElement col_FirstName;
	public @FindBy (xpath = "//a[normalize-space()=\"Last Name\"]") WebElement col_LastName;
	public @FindBy (xpath = "//a[normalize-space()=\"Company\"]") WebElement col_Company;
	public @FindBy (xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy (xpath = "//a[normalize-space()=\"Updated\"]") WebElement col_Updated;
	public @FindBy (xpath = "//th[@class=\"table-actions\"]") WebElement col_Action;
	
	
	public @FindBy(xpath = "//tbody") WebElement parentElemUser;
	public WebElement btn_SignIn (String userName) {
		return parentElemUser.findElement(By.xpath("//tr[td[text()=\'" + userName + "']]//a[@title=\"Sign in as\"]"));
	}
	public WebElement userDDown (String userName) {
		return parentElemUser.findElement(By.xpath("//tr[td[text()=\'" + userName + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement editAction (String userName) {
		return parentElemUser.findElement(By.xpath("//tr[td[text()=\'" + userName + "']]//ul//a[@title=\"Edit\"]"));
	}
	
	public WebElement deleteAction (String userName) {
		return parentElemUser.findElement(By.xpath("//tr[td[text()=\'" + userName + "']]//ul//a[@class=\"user-delete-action\"]"));
	}
}
