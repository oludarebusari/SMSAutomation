package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class DateSelectionModal extends BasePage {

	public DateSelectionModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//div[contains(@class, \"dropdown-menu\")]") WebElement mod_Date;
	public @FindBy(xpath = "//div[contains(@class, \"dropdown-menu\")]//div[contains(@class, \"right\")]") WebElement calendar_Right;
	public @FindBy(xpath = "//div[contains(@class, \"dropdown-menu\")]//div[contains(@class, \"left\")]") WebElement calendar_Left;
	public WebElement btn_Calendar_Right_Prev () {
		return calendar_Right.findElement(By.xpath("//th[contains(@class, \"prev\")]"));
	}
	public WebElement btn_Calendar_Right_Next() {
		return calendar_Right.findElement(By.xpath("//th[contains(@class, \"next\")]"));
	}
	public WebElement pickDayInDateForCalendarRight(String day) {
		return calendar_Right.findElement(By.xpath("//td[(@class=\"available\" or @class=\"available in-range\") and text()=\'" + day + "']"));
	}
	public @FindBy(xpath = "(//div[contains(@class, \"dropdown-menu\")]//div[contains(@class, \"right\")]//select[@class=\"hourselect\"])[2]") WebElement hourSelectCalendarRight;
	public @FindBy(xpath = "//div[contains(@class, \"dropdown-menu\")]//div[contains(@class, \"left\")]") WebElement lov_HourSelect;
	public WebElement btn_Calendar_Left_Prev () {
		return calendar_Left.findElement(By.xpath("//th[contains(@class, \"prev\")]"));
	}
	public WebElement btn_Calendar_Left_Next() {
		return calendar_Left.findElement(By.xpath("//th[contains(@class, \"next\")]"));
	}
	public @FindBy(xpath = "//li[text()=\"This Month\"]") WebElement btn_DateThisMonth;
	public @FindBy(xpath = "(//li[text()=\"Last Month\"])[2]") WebElement btn_DateLastMonth;
	public @FindBy(xpath = "(//li[text()=\"Custom Range\"])[2]") WebElement btn_DateCustomRange;
	public @FindBy(xpath = "//input[@name=\"daterangepicker_start\"]") WebElement txtF_From;
	public @FindBy(xpath = "//input[@name=\"daterangepicker_end\"]") WebElement txtF_To;
	public @FindBy(xpath = "//button[contains(@class, \"applyBtn\")]") WebElement btn_Apply;
	public @FindBy(xpath = "(//button[text()=\"Cancel\"])[2]") WebElement btn_Cancel;
	
}
