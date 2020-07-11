	package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AnalyticsPage extends BasePage {

	public AnalyticsPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = "//div[contains(@class, \"page-heading\") and ./h1]") WebElement pag_Title;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./select[@name=\"advertiser\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Advertiser;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./select[@name=\"campaigns\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Campaigns;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./select[@name=\"locations\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Location;
	public @FindBy(xpath = "//button[@id=\"print-me\"]") WebElement printButton;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h2[text()=\"Offers\"]]") WebElement panel_Offers;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h2[text()=\"Subscribers\"]]") WebElement panel_Subscribers;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h2[text()=\"Messages\"]]") WebElement panel_Messages;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h2[text()=\"Tablet\"]]") WebElement panel_Tablet;
	public @FindBy(xpath = "//div[@id=\"piechart\"]") WebElement panel_RepeatVisitors;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\") and .//h2[text()=\"Rewards\"]]") WebElement panel_Rewards;
	public @FindBy(xpath = "//div[@class=\"panel-heading\" and ./h4[normalize-space()=\"Rewards/Offers\"]]") WebElement panel_RewardsOfferstable;
}
