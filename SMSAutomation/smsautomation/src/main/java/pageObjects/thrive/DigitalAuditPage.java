package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DigitalAuditPage extends BasePage {

	public DigitalAuditPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[normalize-space()=\"URL\"]") WebElement col_URL;
	public @FindBy(xpath = "//a[normalize-space()=\"Keyword\"]") WebElement col_Keyword;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//a[normalize-space()=\"Created\"]") WebElement col_Created;
	public @FindBy(xpath = "//th[normalize-space()=\"Actions\"]") WebElement col_Actions;
	
	public @FindBy(xpath = "//tbody") WebElement parent_Record;	
	public WebElement cellValue(String option) {
		return parent_Record.findElement(By.xpath("//tr//td[normalize-space()=\'" + option + "']"));
	}
	
	
}
