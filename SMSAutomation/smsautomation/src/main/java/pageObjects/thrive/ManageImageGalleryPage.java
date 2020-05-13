package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageImageGalleryPage extends BasePage {

	public ManageImageGalleryPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[normalize-space()=\"Name\"]") WebElement col_Name;
	public @FindBy(xpath = "//th[normalize-space()=\"Count\"]") WebElement col_Count;
	public @FindBy(xpath = "//th[normalize-space()=\"Actions\"]") WebElement col_Actions;
	
	public @FindBy(xpath = "//tbody") WebElement par_ManageElement;
    public WebElement btn_Manage(String name) {
    	return par_ManageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//a[normalize-space()=\"Manage\"]"));
    }
 	
    public WebElement btn_Manage(int value, String name) {
    	return par_ManageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']][" + value + "]//a[normalize-space()=\"Manage\"]"));
    }
 	
    public WebElement countValue(String name) {
    	return par_ManageElement.findElement(By.xpath("//tr[td[text()=\'" + name + "']]//td[2]"));
    }
}
