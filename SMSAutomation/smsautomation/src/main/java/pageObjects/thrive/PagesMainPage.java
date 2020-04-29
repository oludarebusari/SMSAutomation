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

	public @FindBy(xpath = "//h1[@class=\"pull-left\"]") WebElement pag_title;
	public @FindBy(xpath = "//table") WebElement parent_RecordElement;
	public WebElement searchPageByPageName(String pageName) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName + "']]"));
	}
	public String searchPageByNameLocator(String pageName) {
		return "//tr[td[text()=\'" + pageName + "']]";
	}
	public WebElement btn_EditPageByPageName(String pageName) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//a[@title=\"Edit Page\"]"));
	}
	public WebElement btn_ActionDropdownByPageName(String pageName) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//button[@data-toggle=\"dropdown\"]"));
	}
	public WebElement btn_ActivateActionOptByPageName(String pageName) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//a[@class=\"page-activate-action\"]"));
	}
	public WebElement btn_DeleteActionOptByPageName(String pageName) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//a[@class=\"page-delete-action\"]"));
	}
	public WebElement lbl_Status(String pageName, String status) {
		return parent_RecordElement.findElement(By.xpath("//tr[td[text()=\'" + pageName +"']]//td[text()=\'" + status + "']"));
	}

}
