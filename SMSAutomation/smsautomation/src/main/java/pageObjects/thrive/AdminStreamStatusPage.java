package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminStreamStatusPage extends BasePage {

	public AdminStreamStatusPage() throws IOException {
		super();
	}

	// Columns
	public @FindBy(xpath = "//a[normalize-space()=\"Reseller\"]") WebElement col_Reseller;
	public @FindBy(xpath = "//a[normalize-space()=\"Business\"]") WebElement col_Business;
	public @FindBy(xpath = "//a[normalize-space()=\"Site\"]") WebElement col_Site;
	public @FindBy(xpath = "//a[normalize-space()=\"Date Reported\"]") WebElement col_DateReported;
	public @FindBy(xpath = "//a[normalize-space()=\"Status Notes\"]") WebElement col_StatusNotes;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	
	public @FindBy(xpath = "//tbody") WebElement parentElement;
	public WebElement getFirstRowRecordResellerName(String reseller) {
		return parentElement.findElement(By.xpath("//tr[1][td=\'" + reseller + "']"));
	}

}
