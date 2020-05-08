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

	
	private final String UNREADENVELOPELOCATOR = "//a[@title=\"Mark as Read\" and ./i[contains(@class, \"fa-envelope\")]]";
	private final String READENVELOPELOCATOR = "//a[@title=\"Mark as Read\" and ./i[contains(@class, \"icon-envelope-open\")]]";
	
	public String getUNREADENVELOPELOCATOR() {
		return UNREADENVELOPELOCATOR;
	}
	public String getREADENVELOPELOCATOR() {
		return READENVELOPELOCATOR;
	}


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
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Platforms\"]]") WebElement filter_Platform;
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Platforms\"]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_Platform;
	
	public @FindBy(xpath = "//div[contains(@class, \"filter-group-visible\") and ./h3[normalize-space()=\"Read\"]]") WebElement filter_Read;
	public @FindBy(xpath = UNREADENVELOPELOCATOR) WebElement btn_UnreadEnvelope;	
	public @FindBy(xpath = READENVELOPELOCATOR) WebElement btn_ReadEnvelope;
	public @FindBy(xpath = "//label[normalize-space()=\"Unread\"]") WebElement btn_Unread;
	public @FindBy(xpath = "//label[normalize-space()=\"Filter by Read\"]") WebElement btn_FilterByRead;
	
}
