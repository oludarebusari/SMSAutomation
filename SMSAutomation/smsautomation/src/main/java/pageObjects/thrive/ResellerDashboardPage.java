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

	private final String EDITBTN = "//a[text()=\"Edit\"]";
	public String getEDITBTN() {
		return EDITBTN;
	}
	
	public @FindBy(xpath = "//h4[text()=\"New Businesses\"]") WebElement page_Title;
	public @FindBy(xpath = "//*[@id=\"main-nav\"]/ul[1]/li[6]/a") WebElement menu_Settings;
	public @FindBy(xpath = "//tbody") WebElement parent;
	public WebElement btn_Edit(String business) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-merchant\") and ./td[text()=\'" + business + "']]//a[text()=\"Edit\"]"));
	}
	
	public WebElement btn_Edit_Dropdown(String business) {
		return parent.findElement(By.xpath("//tr[contains(@id, \"new-merchant\") and ./td[text()=\'" + business + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	public WebElement cellValue(String option) {
		return parent.findElement(By.xpath("//tr//td[normalize-space()=\'" + option + "']"));
	}
	
}
