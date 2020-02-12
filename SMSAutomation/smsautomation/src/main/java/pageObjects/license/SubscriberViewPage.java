package pageObjects.license;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.elements.CommonElementLocator;
import pageObjects.BasePage;

public class SubscriberViewPage extends BasePage {

	public SubscriberViewPage() throws IOException {
		super();
	}

	//Page elements
	
	public @FindBy(xpath = CommonElementLocator.ELEM_PAGE_TITLE) WebElement pag_Title;
	public @FindBy(xpath = CommonElementLocator.ELEM_SEARCH_TEXTFIELD) WebElement txt_SearchTxtF;
	public @FindBy(xpath = "//a[@data-target=\"#replyModal\"]") WebElement btn_Send_Message;
	public @FindBy(xpath = "//a[text()=\"Edit User Details\"]") WebElement btn_Edit_User_Details;
	public @FindBy(xpath = "//a[text()=\"View Full Subscriber History\"]") WebElement btn_View_Full_Subscriber_History;
	public @FindBy(xpath = "//button[contains(@class, \"btn-default\") and text()[normalize-space()=\"Back\"]]") WebElement btn_Back;
	
}
