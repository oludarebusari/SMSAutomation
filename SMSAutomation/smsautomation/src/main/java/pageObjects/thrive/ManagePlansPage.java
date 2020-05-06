package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManagePlansPage extends BasePage {

	public ManagePlansPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//a[normalize-space()=\"Plan\"]") WebElement col_Plan;
	public @FindBy(xpath = "//a[normalize-space()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"plans-fees\"]") WebElement col_Fees;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[normalize-space()=\"Action\"]") WebElement col_Action;
}
