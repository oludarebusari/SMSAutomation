package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PagesConfigurationPage extends BasePage {

	public PagesConfigurationPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//a[@id=\"edit-settings\"]") WebElement btn_Settings;
	public @FindBy(xpath = "//a[@href=\"/merchant/pages/\" and text()=\"Pages\"]") WebElement lnk_Pages;
	public @FindBy(xpath = "//div[@class=\"btn-group\"]//button[contains(@class, \"ladda-button\")]") WebElement btn_Save;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Header\"]]") WebElement sideMenu_Header;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Footer\"]]") WebElement sideMenu_Footer;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Content\"]]") WebElement sideMenu_Content;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Media\"]]") WebElement sideMenu_Media;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Easy Connect\"]]") WebElement sideMenu_EasyConnect;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Streams\"]]") WebElement sideMenu_Streams;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Parallax\"]]") WebElement sideMenu_Parallax;
}
