package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PageSettingsModal extends BasePage {

	public PageSettingsModal() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h4[@class=\"modal-title\" and normalize-space()=\"Settings\"]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[@class=\"close\"]") WebElement btn_Close;
	public @FindBy(xpath = "//input[@id=\"page_template_image_type_image\"]") WebElement txtF_ChooseFile;
	public @FindBy(xpath = "//button[normalize-space()=\"Save Settings\"]") WebElement btn_SaveSettings;
	public @FindBy(xpath = "//img[@title=\"auto_gallery_small.jpeg\"]") WebElement settings_Image;
}

