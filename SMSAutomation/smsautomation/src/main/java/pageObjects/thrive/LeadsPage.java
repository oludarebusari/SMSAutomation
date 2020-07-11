package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//th[text()=\"Reseller Name\"]") WebElement col_ResellerName;
	public @FindBy(xpath = "'//a[text()=\"Company\"]") WebElement col_Company;
	public @FindBy(xpath = "//a[text()=\"Location\"]") WebElement col_Location;
	public @FindBy(xpath = "//a[text()=\"Ratings\"]") WebElement col_Ratings;
	public @FindBy(xpath = "//th[text()=\"Vertical\"]") WebElement col_Vertical;
	public @FindBy(xpath = "//a[text()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[text()=\"Note\"]") WebElement col_Note;
	public @FindBy(xpath = "//a[text()=\"Appt Date\"]") WebElement col_ApptDate;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	
	public @FindBy(xpath = "//tbody") WebElement parentElemOpen;
	public WebElement btn_Open (String company) {
		return parentElemOpen.findElement(By.xpath("//tr[td[normalize-space()=\'" + company + "']]//a[text()=\"Open\"]"));
	}
	
	
}
