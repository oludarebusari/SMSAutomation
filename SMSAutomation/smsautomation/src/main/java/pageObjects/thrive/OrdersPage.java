package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class OrdersPage extends BasePage {

	public OrdersPage() throws IOException {
		super();

	}
	
	
	public @FindBy(xpath = "//a[text()=\"Order #\"]") WebElement col_Order;
	public @FindBy(xpath = "//a[text()=\"Business Name\"]") WebElement col_BusinessName;
	public @FindBy(xpath = "//a[text()=\"Progress\"]") WebElement col_Progress;
	public @FindBy(xpath = "//a[text()=\"Due\"]") WebElement col_Due;
	public @FindBy(xpath = "//a[text()=\"# Appointments\"]") WebElement col_Appointments;
	public @FindBy(xpath = "//a[text()=\"# Required\"]") WebElement col_Required;
	public @FindBy(xpath = "//a[text()=\"# Leads\"]") WebElement col_Leads;
	public @FindBy(xpath = "//th[text()=\"Action\"]") WebElement col_Action;
	
	public @FindBy(xpath = "//input[@id=\"work_order_filter_type_licensee-selectized\"]") WebElement lov_Reseller;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Reseller\"]]//div[contains(@class, \"selectize-dropdown\")]") WebElement resellerContent;
	public WebElement resellerOpt(String resellerName) {
		return resellerContent.findElement(By.xpath("//div[text()=" + resellerName + "]"));
	}
	
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Status\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Status;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement statusOrderContent;
	public WebElement statusOpt(String status) {
		return statusOrderContent.findElement(By.xpath("//div[text()=\'" + status + "']"));
	}
	public WebElement removeStatusOpt(String status) {
		return statusOrderContent.findElement(By.xpath("//div[@class=\"item\" and text()=\'" + status + "']//a[@title=\"Remove\"]"));
	}
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Order #\"]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Order;
	public WebElement orderOpt(String number) {
		return statusOrderContent.findElement(By.xpath("//div[text()=\'" + number + "']"));
	}
	
	public @FindBy(xpath = "//a[text()=\"Edit\"]") WebElement btn_AllEdit;
	public @FindBy(xpath = "//tbody") WebElement parentElemOrder;
	
	public WebElement firstOrderInASortedList(String order) {
		return parentElemOrder.findElement(By.xpath("//tr[1][td[normalize-space()=\'" + order + "']]"));
	}
	
	public WebElement selectOrder(String order) {
		return parentElemOrder.findElement(By.xpath("//tr[td[text()=\'" + order + "']]"));
	}
	
	public WebElement btn_Edit(String order) {
		return parentElemOrder.findElement(By.xpath("//tr[td[text()=\'" + order + "']]//a[text()=\"Edit\"]"));
	}
	public WebElement actionDDown(String order) {
		return parentElemOrder.findElement(By.xpath("//tr[td[text()=\'" + order + "']]//button[@data-toggle=\"dropdown\"]"));
	}
	
	public WebElement actionDDownOpt(String order, String option) {
		return parentElemOrder.findElement(By.xpath("//tr[td[text()=\'" + order + "']]//ul[@class=\"dropdown-menu\"]//a[text()=\'" +  option + "']"));
	}
	
	public WebElement btn_ViewLeads(String order) {
		return parentElemOrder.findElement(By.xpath("//tr[td[text()=\'" + order + "']]//a[text()=\"View Leads\"]"));
	}
	
	public String getVIEWLEADSLOCATOR() {
		return "//a[text()=\"View Leads\"]";
	}
	
	public String getEDITLOCATOR() {
		return "//a[text()=\"Edit\"]";
	}

	public String getVIEWPERFORMANCELOCATOR() {
		return "//ul[@class=\"dropdown-menu\"]//a[text()=\"View Performance\"]";
	}
	
	
	
	
}
