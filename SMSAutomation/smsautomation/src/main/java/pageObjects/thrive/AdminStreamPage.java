package pageObjects.thrive;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AdminStreamPage extends BasePage {

	public AdminStreamPage() throws IOException {
		super();
	}

	private final String APPROVEDICON = "//label[contains(@class, \"toggle-on\")]";
	private final String SUPPRESSEDICON = "//label[contains(@class, \"toggle-off\")]";

	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Resellers & Business\"]]") WebElement filter_ResellerAndBusiness;
	public @FindBy(xpath = "//input[@id=\"filter-companies-selectized\"]") WebElement txtF_ResellerAndBusiness;
	public @FindBy(xpath = "(//div[@class=\"selectize-dropdown-content\"])[1]") WebElement resellerAndBusinessOptions;
	public @FindBy(xpath = "//div[@data-group=\"Licensees\"]") WebElement resellerDataGroup;
	public @FindBy(xpath = "//div[@data-group=\"Merchants\"]") WebElement businessDataGroup;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentElement;
	public WebElement selectResellerOrBusiness(String option) {
		return parentElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public @FindBy(xpath = "//div[contains(@class, \"selectize-input\")]") WebElement parentActiveResellerAndBusinessOptions;
	public WebElement activeResellerOrBusinessOption(String option) {
		return parentActiveResellerAndBusinessOptions.findElement(By.xpath("//div[contains(@class, \"item\") and text()=\'" + option + "']"));
	}
	public WebElement removeActiveResellerOrBusinessOption(String option) {
		return parentActiveResellerAndBusinessOptions.findElement(By.xpath("//div[contains(@class, \"item\") and text()=\'" + option + "']//a[@title=\"Remove\"]"));
	}
	public String displayedResellerOrBusinessLocator (String option) {
		return "//a[normalize-space()=\'" + option + "']";
	}

	public String getAPPROVEDICON() {
		return APPROVEDICON;
	}

	public String getSUPPRESSEDICON() {
		return SUPPRESSEDICON;
	}

	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Platforms\"]]") WebElement filter_Platform;
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Platforms\"]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_Platform;
	
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Read\"]]") WebElement filter_Read;
	public @FindBy(xpath = "//a[@title=\"Mark as Read\" and ./i[contains(@class, \"fa-envelope\")]]") WebElement btn_UnreadEnvelope;	
	public @FindBy(xpath = "//a[@title=\"Mark as unread\" and ./i[contains(@class, \"icon-envelope-open\")]]") WebElement btn_ReadEnvelope;
	public @FindBy(xpath = "//label[normalize-space()=\"Unread\"]") WebElement btn_Unread;
	public @FindBy(xpath = "//label[normalize-space()=\"Filter by Read\"]") WebElement btn_FilterByRead;
	
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Ratings\"]]") WebElement filter_Ratings;
	public @FindBy(xpath = "//label[@role=\"button\" and normalize-space()=\"All\"]]") WebElement btn_Ratings_All;
	public @FindBy(xpath = "//label[@role=\"button\" and ./input[@id=\"star-level5\"]]") WebElement btn_Ratings_5Stars;
	public @FindBy(xpath = "//label[@role=\"button\" and ./input[@id=\"star-level4\"]]") WebElement btn_Ratings_4Stars;
	public @FindBy(xpath = "//label[@role=\"button\" and ./input[@id=\"star-level3\"]]") WebElement btn_Ratings_3Stars;
	public @FindBy(xpath = "//label[@role=\"button\" and ./input[@id=\"star-level2\"]]") WebElement btn_Ratings_2Stars;
	public @FindBy(xpath = "//label[@role=\"button\" and ./input[@id=\"star-level1\"]]") WebElement btn_Ratings_1Star;
	
	public @FindBy(xpath = "//div[@data-rating=\"5\"]") WebElement fiveStars;
	public @FindBy(xpath = "//div[@data-rating=\"4\"]") WebElement fourStars;
	public @FindBy(xpath = "//div[@data-rating=\"3\"]") WebElement threeStars;
	public @FindBy(xpath = "//div[@data-rating=\"2\"]") WebElement twoStars;
	public @FindBy(xpath = "//div[@data-rating=\"1\"]") WebElement oneStar;
	
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Status\"]]") WebElement filter_Status;
	public @FindBy(xpath = "//label[normalize-space()=\"Approved\"]") WebElement btn_Approved;
	public @FindBy(xpath = "//label[normalize-space()=\"Suppressed\"]") WebElement btn_Suppressed;
	public @FindBy(xpath = APPROVEDICON) WebElement approvedIcon;
	public @FindBy(xpath = SUPPRESSEDICON) WebElement suppressedIcon;
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Recency\"]]") WebElement filter_Recency;
	public @FindBy(xpath = "//label[normalize-space()=\"Newest First\"]") WebElement btn_NewestFirst;
	public @FindBy(xpath = "//small") WebElement newestFirstStream;
	public @FindBy(xpath = "//small") WebElement oldestFirstStream;
	public @FindBy(xpath = "//label[normalize-space()=\"Oldest First\"]") WebElement btn_OldestFirst;
	public @FindBy(xpath = "//div[contains(@class, \"panel-default\")]") WebElement panel_Streams;
	public @FindBy(xpath = "//p[@class=\"rating\"]/../div[@class=\"stream_type\"]") WebElement icon_Platform;
	public @FindBy(xpath = "//div[@class=\"toggle-group\"]") WebElement streamsStatus;
	public @FindBy(xpath = "//p[@class=\"rating\"]") WebElement ratingBlock;
	public @FindBy(xpath = "//a[@title=\"Reply\"]") WebElement btn_Reply;

	public WebElement replyToStream(String streamName) {
		return panel_Streams.findElement(By.xpath("//a[@data-title=\"Respond to " +  streamName +  "\"]"));
	}
	
	
}
