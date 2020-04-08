package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageBroadcastsPage extends BasePage {

	public ManageBroadcastsPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//div[contains(@class, \"page-heading\") and ./h1]") WebElement pag_Heading;
	public @FindBy(xpath = "//input[@class=\"table-search form-control\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//tbody") WebElement tableBody;
	public WebElement rowByMessage(String message) {
		return tableBody.findElement(By.xpath("//tr[td[text()=" + message + "]]"));
	}
	public WebElement editRecord(String message) {
		return tableBody.findElement(By.xpath("//tr[td[contains(@class, \"no-export\")]//div[contains(text(), " + message + ")]]//a[text()=\"Edit\"]"));
	}
	public WebElement actionDDown(String message) {
		return tableBody.findElement(By.xpath("//tr[td[contains(@class, \"no-export\")]//div[contains(text(), " + message + ")]]//button[@data-toggle=\"dropdown\"]"));
	}
	public WebElement deleteOption(String message) {
		return tableBody.findElement(By.xpath("//tr[td[contains(@class, \"no-export\")]//div[contains(text(), " + message + ")]]//a[text()=\"Delete\"]"));
	}
	
	public @FindBy(xpath = "//a[contains(@class, \"buttons-copy\")]") WebElement btn_CSV;
	public @FindBy(xpath = "'//a[contains(@class, \"buttons-csv\")]") WebElement btn_Copy;
	
	// Column Icon
	public @FindBy(xpath = "//th[contains(@aria-label, \"Campaign\") and text()=\"Campaign\"]") WebElement col_CampaignIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"Keyword\") and text()=\"Keyword\"]") WebElement col_KeywordIcon;
	public @FindBy(xpath = "(//th[contains(@aria-label, \"Message\") and text()=\"Message\"])[2]") WebElement col_MessageIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"Type\") and text()=\"Type\"]") WebElement col_TypeIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"Frequency\") and text()=\"Frequency\"]") WebElement col_FrequencyIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"Start Date\") and text()=\"Start Date\"]") WebElement col_StartDateIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"Next Date\") and text()=\"Next Date\"]") WebElement col_NextDateIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"End Date\") and text()=\"End Date\"]") WebElement col_EndDateIcon;
	public @FindBy(xpath = "//th[contains(@aria-label, \"End Date\") and text()=\"End Date\"]") WebElement col_ActionIcon;
	public @FindBy(xpath = "//tr[1]//td[contains(@class, \"no-export\")]") WebElement txt_FirstMessage;
}
