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
    
    public WebElement SortedCellValue(String value) {
    	return par_PageElement.findElement(By.xpath("//tr[1][td[text()=\'" +  value + "']]"));
    }


     
}
