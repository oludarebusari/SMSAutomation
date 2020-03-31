package pageObjects.engage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class BroadcastHistoryPage extends BasePage {

	public BroadcastHistoryPage() throws IOException {
		super();
	}
	
	
	// Page Elements
		public @FindBy(xpath = "//div[contains(@class, \"page-heading\") and ./h1]") WebElement pag_Title;
		public @FindBy(xpath = "//div[@id=\"report-range\"]") WebElement lov_DatesDDown;
		public @FindBy(xpath = "//ul") WebElement date_Element;
		public WebElement dateOption(String option) {
			return date_Element.findElement(By.xpath("//li[text()=\'" + option + "']"));
		}
		public @FindBy(xpath = "//button[text()=\"Apply\"]") WebElement btn_Apply;
		public @FindBy(xpath = "//button[text()=\"Cancel\"]") WebElement btn_Cancel;
		public @FindBy(xpath = "//div[@id=\"broadcast-table_info\"]") WebElement dataTableInfo;

}
