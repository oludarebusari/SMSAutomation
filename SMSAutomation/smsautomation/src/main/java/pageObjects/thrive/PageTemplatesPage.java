package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PageTemplatesPage extends BasePage {

	public PageTemplatesPage() throws IOException {
		super();
	}

	private final String EDITBUTTONLOCATOR = "//a[text()=\"Edit\"]";

	public String getEDITBUTTONLOCATOR() {
		return EDITBUTTONLOCATOR;
	}

	public String CELLVALUELOCATOR(String value) {
		return "//tr//td[text()=\'" + value + "']";
	}

	// Column options
	public @FindBy(xpath = "//a[@class=\"sorting\" and text()[normalize-space()=\"Page\"]]") WebElement col_Page;
	public @FindBy(xpath = "//a[@class=\"sorting\" and text()[normalize-space()=\"User\"]]") WebElement col_User;
	public @FindBy(xpath = "//a[@class=\"sorting\" and text()[normalize-space()=\"Status\"]]") WebElement col_Status;
	public @FindBy(xpath = "//a[@class=\"sorting\" and text()[normalize-space()=\"Updated\"]]") WebElement col_Updated;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	public @FindBy(xpath = "//a[text()=\"Edit\"]") WebElement btn_Edit;

	public @FindBy(xpath = "//tbody") WebElement par_PageElement;

	public WebElement btn_Edit(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//a[text()=\"Edit\"]"));
	}

	public WebElement btn_EditDDown(String name) {
		return par_PageElement
				.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//button[@data-toggle=\"dropdown\"]"));
	}

	public WebElement btn_MakeActive(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name
				+ "']]//ul[@class=\"dropdown-menu\"]//a[normalize-space()=\"Make Active\"]"));
	}

	public WebElement btn_MakeInactive(String name) {
		return par_PageElement.findElement(By.xpath("//tr[td[text()=\'" + name
				+ "']]//ul[@class=\"dropdown-menu\"]//a[normalize-space()=\"Make Inactive\"]"));
	}

	public WebElement btn_Delete(String name) {
		return par_PageElement.findElement(By.xpath(
				"//tr[td[text()=\'" + name + "']]//ul[@class=\"dropdown-menu\"]//a[normalize-space()=\"Delete\"]"));
	}

	public WebElement SortedCellValue(String value) {
		return par_PageElement.findElement(By.xpath("//tr[1][td[text()=\'" + value + "']]"));
	}

	public WebElement CellValue(String value) {
		return par_PageElement.findElement(By.xpath("//tr//td[text()=\'" + value + "']"));
	}

	public @FindBy(xpath = "//ul[@class=\"pagination\"]") WebElement paginationBlock;
	
	  public WebElement pageButtonNumber(String pageNumber) { 
		  return paginationBlock.findElement(By.xpath("//li[contains(@class, \"page-away\") and (.//span[contains(text(), \'" + pageNumber + "')] or .//a[contains(text(), \'" + pageNumber + "')])]"));
	  
	  }
}
