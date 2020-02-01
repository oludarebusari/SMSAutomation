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
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Deactivate;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//h1[@class=\"pull-left\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//tbody") WebElement parentBtn;
	public WebElement getEditBtnByTourName(String TourName) {
		return parentBtn.findElement(By.xpath("//tr[//td[(.)=\'" + TourName + "']][1]//a[(.)=\"Edit\"]"));
	}
	public @FindBy(xpath = "//tr[//td[(.)=\"Dashboard Overview\"]][1]//button[@data-toggle=\"dropdown\"]") WebElement btn_Edit_DropDown;
	
	
	// Page methods
    public String getToursPageTitle() throws Exception {
    	return getElementText(pag_Title);
    }
    
    public AdminToursPage clickToursNewBtn() throws Exception {
		waitAndClickElement(btn_New);
		return new AdminToursPage();
	}

    public AdminToursPage clickToursSearchBtn() throws Exception {
		waitAndClickElement(btn_Search);
		return new AdminToursPage();
	}

    public AdminToursPage clickToursHelpBtn() throws Exception {
		waitAndClickElement(btn_Help);
		return new AdminToursPage();
	}

    public AdminToursPage clickToursEditDropdownBtn() throws Exception {
		waitAndClickElement(btn_Edit_DropDown);
		return new AdminToursPage();
	}

    public AdminToursPage clickEditBtnByTourName() throws Exception {
		waitAndClickElement(getEditBtnByTourName("Aclate QA"));
		return new AdminToursPage();
	}

}
