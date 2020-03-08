package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class MessageTemplatesPage extends BasePage {

	public MessageTemplatesPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//th[@id=\"email-templates-title\"]//a[text()=\"Title\"]") WebElement col_Title;
	public @FindBy(xpath = "//th[@id=\"email-templates-subject\"]//a[text()=\"Subject\"]") WebElement col_Subject;
	public @FindBy(xpath = "//th[@id=\"email-templates-description\"]//a[text()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"email-templates-updated\"]//a[text()=\"Updated\"]") WebElement col_Updated;
	public @FindBy(xpath = "//th[@id=\"email-templates-action\" and text()=\"Action\"]") WebElement col_Action;
}
