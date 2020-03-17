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
	
	public @FindBy(xpath = "(//div[@class=\"row-tool\"]//i[contains(@class, \"arrows\")])[1]") WebElement snip_Pointer;
	public @FindBy(xpath = "(//div[@class=\"row-html\"]//i[contains(@class, \"fa fa-code\")])[1]") WebElement snip_Html;
	public @FindBy(xpath = "//textarea[@id=\"txtHtml\"]") WebElement snip_HtmlTextArea;
	public @FindBy(xpath = "(//div[@class=\"row-copy\"]//i[contains(@class, \"fa-plus\")])[1]") WebElement snip_Plus;
	public @FindBy(xpath = "(//div[@class=\"row-remove\"]//i[contains(@class, \"fa-trash\")])[1]") WebElement snip_Delete;
	
	public @FindBy(xpath = "//h1[text()=\"Tagline for your business\"]") WebElement img_Text;
	


}
