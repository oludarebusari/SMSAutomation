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
	
	
}
