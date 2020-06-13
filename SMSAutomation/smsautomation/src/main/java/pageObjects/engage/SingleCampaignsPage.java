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

	
	public @FindBy(xpath = "//h1[contains(text(), \"Single Campaigns\")]") WebElement page_Title;
	public @FindBy(xpath = "//tbody") WebElement parent;
	
	public WebElement campignEditBtn (String campaignName) {
		return parent.findElement(By.xpath("//tr[@role=\"row\" and td[text()=\'" + campaignName + "']]//button[@title=\"Edit Campaign\"]"));
	}
	
	
}
