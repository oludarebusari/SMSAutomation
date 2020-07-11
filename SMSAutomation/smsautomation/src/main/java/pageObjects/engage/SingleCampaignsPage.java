package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SingleCampaignsPage extends BasePage{

	public SingleCampaignsPage() throws IOException {
		super();
	}

	
	public @FindBy (xpath = "//h1[contains(text(), \"Single Campaigns\")]") WebElement page_Title;
	public @FindBy (xpath = "//a[normalize-space()=\"New\"]") WebElement newBtn;
	public @FindBy(xpath = "//tbody") WebElement parent;
	
	public WebElement campignEditBtn (String campaignName) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and td[text()=\'" + campaignName + "']]//button[@title=\"Edit Campaign\"]"));
	}
	
	public WebElement actionDDown (String campaignName) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and td[text()=\'" + campaignName + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement actionDDownOpt(String campaignName) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and td[text()=\'" + campaignName + "']]//ul[@class=\"dropdown-menu\"]//a[@title=\"Delete Campaign\"]"));
	}
	
	public WebElement selectSingleCampaignByName (String campaignName) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and td[text()=\'" + campaignName + "']]"));
	}
	
	
}
