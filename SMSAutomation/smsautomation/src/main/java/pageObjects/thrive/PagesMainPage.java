package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PagesMainPage extends BasePage {

	public PagesMainPage() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//tr") WebElement parrent_RecordElement;
	public WebElement searchPageByPageName(String pageName) {
		return parrent_RecordElement.findElement(By.xpath("[td[text()=\'" + pageName +"']]"));
	}
	public WebElement btn_EditPageByPageName(String pageName) {
		return parrent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//td[contains(@style, \"padding-bottom\")]//a[@title=\"Edit Page\"]"));
	}
	public WebElement btn_ActionDropdownByPageName(String pageName) {
		return parrent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//td[contains(@style, \"padding-bottom\")]//button[@data-toggle=\"dropdown\"]"));
	}
	public WebElement btn_ActivateActionOptByPageName(String pageName) {
		return parrent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//td[contains(@style, \"padding-bottom\")]//a[@class=\"page-activate-action\"]"));
	}
	public WebElement btn_DeleteActionOptByPageName(String pageName) {
		return parrent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//td[contains(@style, \"padding-bottom\")]//a[@class=\"page-delete-action\"]"));
	}

}
