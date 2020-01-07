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

	public @FindBy(xpath = "//h1[text()=\"Giftbar\"]") WebElement page_Heading;
	public @FindBy(xpath = "//button[@id=\"notify_licensee_giftbar\"]") WebElement btn_Giftbar_Interested;

	// Page Methods

	public String getPageHeading() throws Exception {
		return page_Heading.getText();
	}

	public AddOnGiftbarPage clickGiftbarInterestedBtn() throws Exception {
		waitAndClickElement(btn_Giftbar_Interested);
		return new AddOnGiftbarPage();
	}

}
