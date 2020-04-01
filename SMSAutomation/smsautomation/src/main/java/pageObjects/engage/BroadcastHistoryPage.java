package pageObjects.engage;

import java.io.IOException;
import java.util.List;

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

	public @FindBy(xpath = "//div[contains(@class, \"dataTables_paginate\")]//ul") WebElement paginationOptions;
	public @FindBy(xpath = "//div[contains(@class, \"btn-group-sm\")]//span[text()=\"Copy\"]") WebElement btn_Copy;
	public @FindBy(xpath = "//div[contains(@class, \"btn-group-sm\")]//span[text()=\"CSV\"]") WebElement btn_CSV;
	public @FindBy(xpath = "//select[contains(@class, \"form-control\")]") WebElement pageCountDDown;
	public @FindBy(xpath = "//div[@class=\"dataTables_info\"]") WebElement broadcast_Info;

	public WebElement pageCountOptions(String option) {
		return pageCountDDown.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}

	public @FindBy(xpath = "//th[contains(@class, \"no-export\") and text()=\"Message\"]") WebElement col_Message;
	public @FindBy(xpath = "//tr[1]//td[contains(@class, \"no-export\")]") WebElement txt_FirstMessage;
	public @FindBy(xpath = "//div[@id=\"datatables_buttons_info\"]//div") WebElement copyToClipboard;
	public @FindBy(xpath = "//tbody") WebElement row_Parent_Element;

	public WebElement selectRecordByCampaignName(String campaignName) {
		return row_Parent_Element.findElement(By.xpath("//tr//td[text()=" + campaignName + "]"));
	}

	public WebElement btn_ActionDDownByCampaignName(String campaignName) {
		return row_Parent_Element
				.findElement(By.xpath("//tr[td[text()=" + campaignName + "]]//button[@data-toggle=\"dropdown\"]"));
	}

	public WebElement btn_Details(String campaignName) {
		return row_Parent_Element
				.findElement(By.xpath("//tr[td[text()=" + campaignName + "]]//a[text()=\"Details\"]"));
	}
	
	public WebElement actionDDownOption(String campaignName, String option) {
		return row_Parent_Element
				.findElement(By.xpath("//tr[td[text()=" + campaignName + "]]//a[text()=\'" + option + "']"));
	}

	public List<WebElement> btn_DetailsSize() {
		return row_Parent_Element
				.findElements(By.xpath("//div[contains(@class, \"table-menu\")]//a[text()=\"Details\"]"));
	}

}
