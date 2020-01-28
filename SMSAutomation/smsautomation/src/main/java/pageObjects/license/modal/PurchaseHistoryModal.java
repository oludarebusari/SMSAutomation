package pageObjects.license.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
//import pageObjects.license.MyAccountPage;


public class PurchaseHistoryModal extends BasePage {

	public PurchaseHistoryModal() throws IOException {
		super();
	}
	
	// Purchase History
	public @FindBy(xpath = "//h3[@class=\"modal-title\" and text()=\"Purchase History\"]") WebElement mod_Purchase_History;
	public @FindBy(xpath = "//select[@name=\"purchase-history_length\"]") WebElement dropdown_Page_Size;
	public @FindBy(xpath = "//div[contains(@class, \"input-group-sm\")]") WebElement parentSize;
	public WebElement num_PageSize(String num) {
		return parentSize.findElement(By.xpath("//option[text()='" + num + "']"));
	};
	public @FindBy(xpath = "//a[@aria-controls=\"purchase-history\" and ./span[text()=\"Copy\"]]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[@aria-controls=\"purchase-history\" and ./span[text()=\"CSV\"]]") WebElement btn_CSV;
	public @FindBy(xpath = "//div[@id=\"purchase-history_info\"]") WebElement txt_Purchase_History_Info;
	

	// Purchase History methods
	public String getPurchaseHistoryTitle() throws Exception {
		return getElementText(mod_Purchase_History);
	}

	public PurchaseHistoryModal clickPurchaseHistoryPageSizedropDown() throws Exception {
		waitAndClickElement(dropdown_Page_Size);
		return new PurchaseHistoryModal();
	}
	
	public String getPurchaseHistoryPageSize(String size) throws InterruptedException {
		return getElementText(num_PageSize(size));
	}

	public PurchaseHistoryModal clickPurchaseHistoryPageSize(String size) throws Exception {
		waitAndClickElement(num_PageSize(size));
		return new PurchaseHistoryModal();
	}

	public String getPurchaseHistoryPageInfo() throws Exception {
		return getElementText(txt_Purchase_History_Info).substring(2, 4);
	}
	
	public String getPurchaseHistoryPageCopyTxt() throws Exception {
		return getElementText(btn_Copy);
	}
	
	public String getPurchaseHistoryPageCSVTxt() throws Exception {
		return getElementText(btn_CSV);
	}
	
	public PurchaseHistoryModal clickPurchaseHistoryPageCopyBtn() throws Exception {
		waitAndClickElement(btn_Copy);
		return new PurchaseHistoryModal();
	}
	
	public PurchaseHistoryModal clickPurchaseHistoryPageCSVBtn() throws Exception {
		waitAndClickElement(btn_CSV);
		return new PurchaseHistoryModal();
	}
	
}
