package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PageSettingsModal extends BasePage {

	public PageSettingsModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[@class=\"close\"]") WebElement btn_Close;

}

