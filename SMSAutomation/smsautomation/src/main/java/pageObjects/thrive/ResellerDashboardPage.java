package pageObjects.thrive;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class ResellerDashboardPage extends BasePage {

	public ResellerDashboardPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h4[text()=\"New Businesses\"]") WebElement page_Title;
	public @FindBy(xpath = "//tbody") WebElement parent;
	public WebElement btn_Edit(String business) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-merchant\") and ./td[text()=\'" + business + "']]//a[text()=\"Edit\"]"));
	}
	
	public WebElement btn_Edit_Dropdown(String business) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-merchant\") and ./td[text()=\'" + business + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	
}
