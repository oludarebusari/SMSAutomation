package pageObjects.license;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencsv.exceptions.CsvException;

import pageObjects.BasePage;

public class CampaignGroupsPage extends BasePage {

	public CampaignGroupsPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = "//a[contains(@class, \"btn-primary\")]") WebElement btn_CampaignGroupsNewBtn;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-copy\") and ./span[(.)=\"Copy\"]]") WebElement btn_Copy;
	public @FindBy(xpath = "//a[contains(@class, \"buttons-csv\") and ./span[(.)=\"CSV\"]]") WebElement btn_CSV;
	public @FindBy(xpath = "//a[@aria-controls=\"groups\" and ./i[contains(@class, \"fa-angle-left\")]]") WebElement btn_Page_Left_Arrow;
	public @FindBy(xpath = "//a[@aria-controls=\"groups\" and ./i[contains(@class, \"fa-angle-right\")]]") WebElement btn_Page_Right_Arrow;
	public @FindBy(xpath = "//div[@id=\"datatables_buttons_info\"]") WebElement btn_Copy_Info;
	public @FindBy(xpath = "//select[@name=\"groups_length\"]") WebElement drp_Group_Length;

	public WebElement getOption(String value) {
		return drp_Group_Length.findElement(By.xpath("//option[(.)=\'" + value + "']"));
	}

	public @FindBy(xpath = "") WebElement drp_Page_Count;
	public @FindBy(xpath = "//tbody") WebElement parentBtn;

	public WebElement btn_EditByName(String name) {
		return parentBtn.findElement(
				By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + name + "']]//button[@title=\"Edit Campaign\"]"));
	}

	public WebElement btn_EditDropDownByName(String name) {
		return parentBtn.findElement(
				By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + name + "']]//button[@data-toggle=\"dropdown\"]"));
	}

	public WebElement btn_Delete(String name) {
		return parentBtn.findElement(By.xpath("//tr[@role=\"row\" and .//td[text()='" + name
				+ "']]//ul[contains(@class, \"dropdown-menu\") and .//a[(.)=\"Delete\"]]"));
	}

	public CampaignGroupsPage waitForCampaignGroupToDisapper(String name) throws Exception {
		waitUntilPreLoadElementDissapears(By.xpath("//tr[@role=\"row\" and .//td[text()=\'" + name + "']]"));
		return new CampaignGroupsPage();
	}

	// Page Functions
	public CampaignGroupsPage clickCampaignGroupsNewBtn() throws Exception {
		waitAndClickElement(btn_CampaignGroupsNewBtn);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsCampaignEditBtn(String campaignName) throws Exception {
		waitAndClickElement(btn_EditByName(campaignName));
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsCampaignEditDDownBtn(String campaignName) throws Exception {
		waitAndClickElement(btn_EditDropDownByName(campaignName));
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsCampaignDeleteBtn(String name) throws Exception {
		waitAndClickElement(btn_Delete(name));
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsPageLeftArrow() throws Exception {
		waitAndClickElement(btn_Page_Left_Arrow);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsPageRightArrow() throws Exception {
		waitAndClickElement(btn_Page_Right_Arrow);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage copyCampaignGroups() throws Exception {
		waitAndClickElement(btn_Copy);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage exportCampaignGroups() throws Exception {
		waitAndClickElement(btn_CSV);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage clickCampaignGroupsPageGroupsLength() throws Exception {
		waitAndClickElement(drp_Group_Length);
		return new CampaignGroupsPage();
	}

	public CampaignGroupsPage selectCampaignGroupsPageGroupsLength(String value) throws Exception {
		clickOnTextFromDropdownList(drp_Group_Length, value);
		return new CampaignGroupsPage();
	}

	public String[] getCampaignGroupsPageLength() throws Exception {
		String[] pageLength = drp_Group_Length.getText().split("\n");
		return pageLength;
	}

	public int getNumberOfCampaignGroups(String path) throws Exception {
		Thread.sleep(500);
		return getNumberOfRowsInASpreadsheet(path);
	}

	public void deleteDownloadedFile(String filename) throws Exception {
		// Delete a file
		File file = new File(filename);
		file.delete();
	}

}
