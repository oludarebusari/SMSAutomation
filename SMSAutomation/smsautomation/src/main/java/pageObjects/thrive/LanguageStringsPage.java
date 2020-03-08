package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LanguageStringsPage extends BasePage{

	public LanguageStringsPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//th[@id=\"string-title\"]//a[text()=\"Title\"]") WebElement col_Title;
	public @FindBy(xpath = "//th[@id=\"string-section\"]//a[text()=\"Group\"]") WebElement col_Group;
	public @FindBy(xpath = "//th[@id=\"string-group\"]//a[text()=\"Access Level\"]") WebElement col_AccessLevel;
	public @FindBy(xpath = "//th[@id=\"string-value\"]//a[text()=\"Value\"]") WebElement col_Value;
	public @FindBy(xpath = "//th[@id=\"string-description\"]//a[text()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"string-updated\"]//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[@id=\"string-action\" and text()=\"Action\"]") WebElement col_Action;

}
