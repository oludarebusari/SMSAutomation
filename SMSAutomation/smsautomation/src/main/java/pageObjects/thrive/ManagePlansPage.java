package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManagePlansPage extends BasePage {

	public ManagePlansPage() throws IOException {
		super();
	}

	
	private final String PLANLOCATOR = "//tr[td[text()=\"Automation Plan - Edited\"]]";
	
	public @FindBy(xpath = "//a[normalize-space()=\"Plan\"]") WebElement col_Plan;
	public @FindBy(xpath = "//a[normalize-space()=\"Description\"]") WebElement col_Description;
	public @FindBy(xpath = "//th[@id=\"plans-fees\"]") WebElement col_Fees;
	public @FindBy(xpath = "//a[normalize-space()=\"Status\"]") WebElement col_Status;
	public @FindBy(xpath = "//th[normalize-space()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//tbody") WebElement parentElement;
	public WebElement getCellValue(String value) {
		return parentElement.findElement(By.xpath("//tr//td[text()=\'" + value + "']"));
	}
	
	public WebElement getPriceByPlanName(String planName, String price) {
		return parentElement.findElement(By.xpath("//tr[td[text()=\'" + planName + "']]//span[contains(text(), \'" + price + "')]"));
	}
	
	public WebElement editBtn(String planName) {
		return parentElement.findElement(By.xpath("//tr[td[text()=\'" + planName + "']]//a[text()=\"Edit\"]"));
	}
	
	public WebElement planActionDDown(String planName) {
		return parentElement.findElement(By.xpath("//tr[td[text()=\'" + planName + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement ActionDDownOption(String planName, String option) {
		return parentElement.findElement(By.xpath("//tr[td[text()=\'" + planName + "']]//ul[@class=\"dropdown-menu\"]//a[@title=\'" + option + "']"));
	}

	public String getPLANLOCATOR() {
		return PLANLOCATOR;
	}

}
