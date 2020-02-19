package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BusinessPage extends BasePage {

	public BusinessPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[contains(@class, \"no-padding\")]") WebElement pag_Title;
	public @FindBy(xpath = "//a[@class=\"text-danger\"]") WebElement lnk_View_Late_Payments;
	public @FindBy(xpath = "//a[@class=\"text-warning\"]") WebElement lnk_View_Pending_Payments;
	public @FindBy(xpath = "//a[@class=\"text-success\"]") WebElement lnk_View_Payments_Received;
	public @FindBy(xpath = "//a[@class=\"text-info\"]") WebElement lnk_View_Payments_Received_Revenue;
	
	public @FindBy(xpath = "//div[@id=\"summary-tiles-late\"]") WebElement tab_Late_Payments;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-risk\"]") WebElement tab_Late_Pending_Payments;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-paid\"]") WebElement tab_Late_Payments_Received;
	public @FindBy(xpath = "//div[@id=\"summary-tiles-revenue\"]") WebElement tab_Late_Payments_Received_Revenue;
	public @FindBy(xpath = "//div[@id=\"new-merchants-overview\"]") WebElement panel_Business;
	public @FindBy(xpath = "//li[@class=\"first\"]//a[@class=\"dropdown-toggle\"]") WebElement drpD_LoggedInUser;
	public @FindBy(xpath = "//li[contains(@class, \"first\")]//ul[contains(@class, \"dropdown-menu\")]") WebElement menu_LoggedInUser;
	
}
