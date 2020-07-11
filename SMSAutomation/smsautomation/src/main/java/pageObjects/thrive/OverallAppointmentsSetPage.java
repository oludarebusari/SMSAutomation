package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class OverallAppointmentsSetPage extends BasePage {

	public OverallAppointmentsSetPage() throws IOException {
		super();

	}

	public @FindBy(xpath = "//input[@id=\"lead_filter_type_update_range\"]") WebElement txtF_LeadFilterRange;
	public @FindBy(xpath = "//input[@id=\"lead_filter_type_update_range\"]") WebElement btn_ThisMonth;
	public @FindBy(xpath = "//input[@id=\"lead_filter_type_update_range\"]") WebElement btn_LastMonth;
	public @FindBy(xpath = "//input[@id=\"lead_filter_type_update_range\"]") WebElement btn_CustomRange;
	public @FindBy(xpath = "//button[text()=\"Apply\"]") WebElement btn_Apply;
	
	
	public @FindBy(xpath = "//tbody") WebElement parentElemOpen;
	public WebElement btn_Open (String company) {
		return parentElemOpen.findElement(By.xpath("//tr[td[normalize-space()=\'" + company + "']]//a[text()=\"Open\"]"));
	}
	
	
}
