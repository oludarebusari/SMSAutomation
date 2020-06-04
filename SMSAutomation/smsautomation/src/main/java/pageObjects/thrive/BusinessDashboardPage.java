package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BusinessDashboardPage extends BasePage {

	public BusinessDashboardPage() throws IOException {
		super();
	}

	
	//Menu elements
	
	
	//Page body  elements
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement tab_SocialActivity;
	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement tab_WebActivity;
	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement tab_DemographicStats;
	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement btn_Help;
	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement btn_StartSetup;
   
}