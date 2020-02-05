package pageObjects.license;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class AddOnGiftbarPage extends BasePage {

	public AddOnGiftbarPage() throws IOException {
		super();
	}

	// Page Elements
	public @FindBy(xpath = "//h1[text()=\"Giftbar\"]") WebElement page_Title;
	public @FindBy(xpath = "//button[@id=\"notify_licensee_giftbar\"]") WebElement btn_Giftbar_Interested;
	public @FindBy(xpath = "//div[@id=\"notified_licensee_giftbar\"]") WebElement msg_Giftbar_Notification;

}
