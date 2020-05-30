package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BusinessReportsPage extends BasePage {

	public BusinessReportsPage() throws IOException {
		super();
	}

	private final String ACTIVEBUSINESSESDESCRIPTION = "The total number of businesses that were active for any portion of the selected period.";
	private final String NEWBUSINESSDESCRIPTION = "The total number of businesses added during the selected period.";
	private final String CANCELEDBUSINESSESDESCRIPTION = "The total number of businesses that canceled services during the selected period.";
	private final String PERIODNETBUSINESSESDESCRIPTION = "The net change to the reseller's business count during the selected period.";
	
	
	public String getACTIVEBUSINESSESDESCRIPTION() {
		return ACTIVEBUSINESSESDESCRIPTION;
	}

	public String getNEWBUSINESSDESCRIPTION() {
		return NEWBUSINESSDESCRIPTION;
	}

	public String getCANCELEDBUSINESSESDESCRIPTION() {
		return CANCELEDBUSINESSESDESCRIPTION;
	}

	public String getPERIODNETBUSINESSESDESCRIPTION() {
		return PERIODNETBUSINESSESDESCRIPTION;
	}

	public @FindBy(xpath = "//a[text()=\"Date\"]") WebElement col_Date;
	public @FindBy(xpath = "//a[text()=\"Active Businesses\"]") WebElement col_ActiveBusinessess;
	public @FindBy(xpath = "//a[text()=\"New Business\"]") WebElement col_NewBusiness;
	public @FindBy(xpath = "//a[text()=\"Canceled Businesses\"]") WebElement col_CanceledBusiness;
	public @FindBy(xpath = "//a[text()=\"Period Net Businesses\"]") WebElement col_PeriodNetBusinesses;
	
	public @FindBy(xpath = "//div[contains(@class, \"popover\") and .//h3[text()=\"Active Businesses\"]]//div[@class=\"popover-content\"]") WebElement activeBusinessDescription;
	public @FindBy(xpath = "//div[contains(@class, \"popover\") and .//h3[text()=\"New Business\"]]//div[@class=\"popover-content\"]") WebElement newBusinessDescription;
	public @FindBy(xpath = "//div[contains(@class, \"popover\") and .//h3[text()=\"Canceled Businesses\"]]//div[@class=\"popover-content\"]") WebElement canceledBusinessesDescription;
	public @FindBy(xpath = "//div[contains(@class, \"popover\") and .//h3[text()=\"Period Net Businesses\"]]//div[@class=\"popover-content\"]") WebElement periodNetBusinessesDescription;
}
