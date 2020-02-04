package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;
import pageObjects.thrive.AdminToursPage;

public class AdminToursHelpModal extends BasePage {

	public AdminToursHelpModal() throws IOException {
		super();
	}
	
	// Modal elements
	public @FindBy(xpath = "//h3[@class=\"popover-title\"]") WebElement mod_Tours_Help_Title;
	public @FindBy(xpath = "//button[@data-role=\"prev\"]") WebElement btn_Tours_Help_Prev;
	public @FindBy(xpath = "//button[@data-role=\"next\"]") WebElement btn_Tours_Help_Next;
	public @FindBy(xpath = "//button[@data-role=\"end\"]") WebElement btn_Tours_Help_EndTour;
	public @FindBy(xpath = "//div[contains(@class, \"tour-mmd-tour\")]") WebElement mod_Tours;
	
	// Modal methods
	public String getToursHelpModalTitle() throws Exception {
    	return getElementText(mod_Tours_Help_Title);
    }
    
    public AdminToursPage clickToursHelpPrevBtn() throws Exception {
		waitAndClickElement(btn_Tours_Help_Prev);
		return new AdminToursPage();
	}

    public AdminToursPage clickToursHelpNextBtn() throws Exception {
		waitAndClickElement(btn_Tours_Help_Next);
		return new AdminToursPage();
	}
    
    public AdminToursPage clickToursHelpEndTourBtn() throws Exception {
		waitAndClickElement(btn_Tours_Help_EndTour);
		return new AdminToursPage();
	}
}
