package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SalesLeadsPage extends BasePage {

	public SalesLeadsPage() throws IOException {
		super();
	}
	
	    private final String LISTVIEW = "//tr[@class=\"lead-item\"]";
	    private final String CARDVIEW = "//div[@id=\"leads-stream\"]//div[contains(@class, \"lead-item\")]";
	    private final String CALENDARVIEW = "//div[@class=\"fc-bg\"]";
	
	
	// Filter fields
		public @FindBy(xpath = "//input[@id=\"lead_filter_type_businessCategory-selectized\"]") WebElement txtF_VerticalDDown;
		public @FindBy(xpath = "//div[contains(@class, \"selectize-input\") and .//input[@id=\"lead_filter_type_business-selectized\"]]") WebElement txtF_Business;
		public @FindBy(xpath = "//input[@id=\"lead_filter_type_zip_codes-selectized\"]") WebElement txtF_ZipCodes;
		public @FindBy(xpath = "//input[@id=\"lead_filter_type_status-selectized\"]") WebElement txtF_StatusDDown;
		public @FindBy(xpath = "//label[contains(@class, \"toggle-off\")]") WebElement viewAllLeads;
		public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement parentVerticalElement;
		public WebElement verticalOption (String option) {
			return parentVerticalElement.findElement(By.xpath("//div[@data-value=\'" + option + "']"));
		}
		
		public WebElement zipCodeOption (String option) {
			return parentVerticalElement.findElement(By.xpath("//div[@data-value=\'" + option + "']"));
		}
		public WebElement filterOptionRemoveBtn (String option) {
			return parentVerticalElement.findElement(By.xpath("//div[@data-value=\'" + option + "']//a"));
		}
		public @FindBy(xpath = "//label[contains(@class, \"toggle-off\")]") WebElement tog_ShowOnlyLeads;
		public @FindBy(xpath = "//button[@id=\"lead_filter_type_export\"]") WebElement btn_Export;
		public @FindBy(xpath = "//label[@for=\"lead_filter_type_view_as_1\"]") WebElement btn_ListView;
		public @FindBy(xpath = "//tr[@class=\"lead-item\"]") WebElement ListView;
		public @FindBy(xpath = "//label[@for=\"lead_filter_type_view_as_2\"]") WebElement btn_CardView;
		public @FindBy(xpath = "//div[@id=\"leads-stream\"]//div[contains(@class, \"lead-item\")]") WebElement cardView;
		public @FindBy(xpath = "//label[@for=\"lead_filter_type_view_as_3\"]") WebElement btn_CalendarView;
		public @FindBy(xpath = "//div[@class=\"fc-bg\"]") WebElement calendarView;
		
		
	// Columns
		public @FindBy(xpath = "//th[normalize-space()=\"Reseller Name\"]") WebElement col_ResellerName;
		public @FindBy(xpath = "//th[normalize-space()=\"Company\"]") WebElement col_Company;
		public @FindBy(xpath = "//th[normalize-space()=\"Location\"]") WebElement col_Location;
		public @FindBy(xpath = "//th[normalize-space()=\"Ratings\"]") WebElement col_Ratings;
		public @FindBy(xpath = "//th[normalize-space()=\"Vertical\"]") WebElement col_Vertical;
		public @FindBy(xpath = "//th[normalize-space()=\"Status\"]") WebElement col_Status;
		public @FindBy(xpath = "//th[normalize-space()=\"Updated\"]") WebElement col_Updated;
		public @FindBy(xpath = "//th[normalize-space()=\"Note\"]") WebElement col_Note;
		public @FindBy(xpath = "//th[normalize-space()=\"Appt Date\"]") WebElement col_ApptDate;
	    public @FindBy(xpath = "//th[normalize-space()=\"Action\"]") WebElement col_Action;
	    
		public String veriticalOptionLocator (String option) {
			return "//tr//td[normalize-space()=\'" + option + "']";
		}

		public String getLISTVIEW() {
			return LISTVIEW;
		}

		public String getCARDVIEW() {
			return CARDVIEW;
		}

		public String getCALENDARVIEW() {
			return CALENDARVIEW;
		}
}
