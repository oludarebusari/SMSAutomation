package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class RespondToStreamModal extends BasePage {

	public RespondToStreamModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "(//h4[@class=\"modal-title\"])[2]") WebElement mod_Title;
	public @FindBy(xpath = "//textarea[@id=\"stream_response_message\"]") WebElement txtA_YourResponse;
	public @FindBy(xpath = "//small[@data-fv-result=\"INVALID\"]") WebElement lbl_YourResponseMsg;
	public @FindBy(xpath = "//input[@id=\"stream_response_name\"]") WebElement txtF_TemplateTitle;
	public @FindBy(xpath = "//input[@id=\"stream_response_isCreate\"]") WebElement chk_CreateATemplateFromThisResponse;
	public @FindBy(xpath = "//button[@id=\"stream_response_submit\"]") WebElement btn_Reply;
	
		
}
