package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateOrder extends BasePage {

	public CreateOrder() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//div[@id=\"order-details\"]") WebElement sec_OrderDetails;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement sec_AcquireLeads;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Business Name\"]]//div[contains(@class, \"selectize-input\")]") WebElement businessNameDDown;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Payment Type\"]]//div[contains(@class, \"selectize-input\")]") WebElement paymentTypeDDown;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Order Type\"]]//div[contains(@class, \"selectize-input\")]") WebElement orderTypeDDown;
	public @FindBy(xpath = "//input[@id=\"create_work_order_appointment_count\"]") WebElement txtF_Appointments;
	public @FindBy(xpath = "//input[@id=\"create_work_order_start_date\"]") WebElement txtF_StartDate;
	public @FindBy(xpath = "//input[@id=\"create_work_order_due_date\"]") WebElement txtF_DueDate;
	public @FindBy(xpath = "//textarea[@id=\"create_work_order_workOrderNotes_note\"]") WebElement txtArea_Notes;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Verticals\"]]//div[contains(@class, \"selectize-input\")]") WebElement verticalsDDown;
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Postal Codes\"]]") WebElement postalCodesDDown;
	public @FindBy(xpath = "//div[contains(@class, \"add-bottom\") and .//label[normalize-space()=\"Number of Reviews\"]]//div[contains(@class, \"selectize-input\")]") WebElement numberOfReviewsDDown;
	public @FindBy(xpath = "//input[@id=\"create_work_order_leads_query_lead_query_filter__review_count__primary_comparison\"]") WebElement txtF_LowerLimit;
	public @FindBy(xpath = "//input[@id=\"create_work_order_leads_query_lead_query_filter__review_count__secondary_comparison\"]") WebElement txtF_UpperLimit;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./select[@id=\"create_work_order_leads_query_lead_query_filter__average_rating__operator\"]]//div[contains(@class, \"selectize-input\")]") WebElement averageRatingDDOwn;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./select[@id=\"create_work_order_leads_query_lead_query_filter__average_rating__primary_comparison\"]]//div[contains(@class, \"selectize-input\")]") WebElement averageRatingNumberDDown;
	public WebElement opt_BusinessName(String option) {
		return businessNameDDown.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public WebElement opt_PaymentType(String option) {
		return paymentTypeDDown.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public WebElement opt_OrderType(String option) {
		return orderTypeDDown.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public WebElement opt_Verticals(String option) {
		return verticalsDDown.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	public WebElement opt_PostalCodes(String option) {
		return postalCodesDDown.findElement(By.xpath("//div[contains(@class, \"selectize-control\")]//span[text()=\'" + option + "']"));
	}
	
	public @FindBy(xpath = "//div[contains(@class, \"form-group\") and ./label[normalize-space()=\"Verticals\"]]") WebElement verticalContainer;
	public WebElement removeVerticalsOption(String verticalsName) {
		return verticalContainer.findElement(By.xpath("//div[@class=\"item\" and text()=\'" + verticalsName + "']//a[@title=\"Remove\"]"));
	}
	
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Business Name\"]]//small[@class=\"help-block\"]") WebElement errorMsg_BusinessName;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Order Type\"]]//small[@class=\"help-block\"]") WebElement errorMsg_OrderType;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Appointments\"]]//small[text()=\"Please enter a value\"]") WebElement errorMsg_Appointments;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Due Date\"]]//small[@data-fv-for=\"create_work_order[due_date]\"]") WebElement errorMsg_DueDate;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Verticals\"]]//small[@class=\"help-block\"]") WebElement errorMsg_Verticals;
	public @FindBy(xpath = "//button[@id=\"create_work_order_leads_query_submit\"]") WebElement btn_AcquireLeads;
	
//	Calendar day selection option
	public @FindBy(xpath = "//body") WebElement par_CalendarElement;
	public WebElement calendarDay(String day) {
		return par_CalendarElement.findElement(By.xpath("//div[5]/div[1]//tr[5]/td[text()=\'" + day + "']"));
	}
	
	
}
