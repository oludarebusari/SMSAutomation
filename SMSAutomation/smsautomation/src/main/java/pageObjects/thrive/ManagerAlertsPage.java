package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManagerAlertsPage extends BasePage {

	public ManagerAlertsPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//tbody") WebElement par_Element;
	public WebElement searchAlertByAlertText(String alertText) {
		return par_Element.findElement(By.xpath("//tr[td[text()=\'" + alertText + "']]"));
	}
	public WebElement editAlert(String alertText) {
		return par_Element.findElement(By.xpath("//tbody//tr[td[text()=\'" + alertText + "']]//a[text()[normalize-space()=\"Edit\"]]"));			
	}
	public WebElement btn_ActionDDOwn(String alertText) {
		return par_Element.findElement(By.xpath("//tbody//tr[td[text()=\'" + alertText + "']]//button[@data-toggle=\"dropdown\"]"));			
	}
	
	//Alerts Action Dropdown options
	public WebElement btn_Activate(String alertText) {
	return par_Element.findElement(By.xpath("//tr[td[text()=\'" + alertText + "']]//a[@data-action=\"activate\"]"));	
	}
	public WebElement btn_Deactivate(String alertText) {
		return par_Element.findElement(By.xpath("//tr[td[text()=\'" + alertText + "']]//a[@data-action=\"deactivate\"]"));	
	}
	public WebElement btn_Delete(String alertText) {
		return par_Element.findElement(By.xpath("//tr[td[text()=\'" + alertText + "']]//a[@data-action=\"delete\"]"));	
	}
	public WebElement actionDDownMenu(String alertText) {
		return par_Element.findElement(By.xpath("//tr[td[text()=\'" + alertText + "']]//ul[@class=\"dropdown-menu\"]"));
	}
	
}
