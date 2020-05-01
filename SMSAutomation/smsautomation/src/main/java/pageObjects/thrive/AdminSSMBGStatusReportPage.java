package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminSSMBGStatusReportPage extends BasePage {

	public AdminSSMBGStatusReportPage() throws IOException {
		super();
	}

	private final String VIEWAPPOINTMENTLOCATOR = "//a[normalize-space()=\"View Appointments\"]";
	
	public String getVIEWAPPOINTMENTLOCATOR() {
		return VIEWAPPOINTMENTLOCATOR;
	}
	
	// Columns
	public @FindBy(xpath = "//a[normalize-space()=\"Sales Count\"]") WebElement col_SalesCount;
	public @FindBy(xpath = "//a[normalize-space()=\"Sales Required\"]") WebElement col_SalesRequired;
	public @FindBy(xpath = "//a[normalize-space()=\"Due Date\"]") WebElement col_DueDate;
	public @FindBy(xpath = "//a[normalize-space()=\"Reseller\"]") WebElement col_Reseller;
	public @FindBy(xpath = "//a[normalize-space()=\"ISS Associate\"]") WebElement col_ISSAssociate;
	public @FindBy(xpath = "//a[normalize-space()=\"ISS Days Left\"]") WebElement col_ISSDaysLeft;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//a[normalize-space()=\"Date Completed\"]") WebElement col_DateComplated;
	public @FindBy(xpath = "//a[normalize-space()=\"Reseller Testimonial\"]") WebElement col_ResellerTestimonial;
    public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
    public @FindBy(xpath = VIEWAPPOINTMENTLOCATOR) WebElement btn_ViewAppointments;
    
}
