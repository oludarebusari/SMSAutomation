package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CreateOrder extends BasePage {

	public CreateOrder() throws IOException {
		super();
	}

	
	public @FindBy(xpath = "//div[@id=\"order-details\"]") WebElement sec_OrderDetails;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement sec_AcquireLeads;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Business Name\"]]//div[contains(@class, \"selectize-input\")]") WebElement businessNameDDown;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[normalize-space()=\"Payment Type\"]]//div[contains(@class, \"selectize-input\")]") WebElement PaymentTypeDDown;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Order Type\"]]//div[contains(@class, \"selectize-input\")]") WebElement orderTypeDDown;
	public @FindBy(xpath = "//input[@id=\"create_work_order_appointment_count\"]") WebElement txtF_Appointments;
	public @FindBy(xpath = "//input[@id=\"create_work_order_start_date\"]") WebElement txtF_StartDate;
	public @FindBy(xpath = "//input[@id=\"create_work_order_due_date\"]") WebElement txtF_DueDate;
	public @FindBy(xpath = "//textarea[@id=\"create_work_order_workOrderNotes_note\"]") WebElement txtArea_Notes;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Verticals\"]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_Verticals;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement txtF_PostalCodes;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement numberOfReviewsDDown;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement txtF_LowerLimit;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement txtF_HigherLimit;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement averageRatingDDOwn;
	public @FindBy(xpath = "//div[@id=\"order-acquire-leads\"]") WebElement averageRatingNumberDDown;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Business Name\"]]//small[@class=\"help-block\"]") WebElement errorMsg_BusinessName;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Order Type\"]]//small[@class=\"help-block\"]") WebElement errorMsg_OrderType;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Appointments\"]]//small[text()=\"Please enter a value\"]") WebElement errorMsg_Appointments;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Due Date\"]]//small[@data-fv-for=\"create_work_order[due_date]\"]") WebElement errorMsg_DueDate;
	public @FindBy(xpath = "//div[contains(@class, \"has-error\") and ./label[normalize-space()=\"Verticals\"]]//small[@class=\"help-block\"]") WebElement errorMsg_Verticals;
	public @FindBy(xpath = "//button[@id=\"create_work_order_leads_query_submit\"]") WebElement btn_AcquireLeads;
	
}
