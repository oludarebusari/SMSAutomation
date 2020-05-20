package pageObjects.thrive;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class PagesConfigurationPage extends BasePage {

	public PagesConfigurationPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//a[@id=\"edit-settings\"]") WebElement btn_Settings;
	public @FindBy(xpath = "//a[(@href=\"/merchant/pages/\" or @href=\"/admin/pages-templates/\") and text()=\"Pages\"]") WebElement lnk_Pages;
	public @FindBy(xpath = "//div[@class=\"btn-group\"]//button[contains(@class, \"ladda-button\")]") WebElement btn_Save;
	public @FindBy(xpath = "//small[span]") WebElement txt_SaveNotification;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Header\"]]") WebElement sideMenu_Header;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Footer\"]]") WebElement sideMenu_Footer;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Content\"]]") WebElement sideMenu_Content;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Media\"]]") WebElement sideMenu_Media;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Easy Connect\"]]") WebElement sideMenu_EasyConnect;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Streams\"]]") WebElement sideMenu_Streams;
	public @FindBy(xpath = "//h3[text()[normalize-space()=\"Parallax\"]]") WebElement sideMenu_Parallax;
	public @FindBy(xpath = "//div[contains(@class, \"ui-dragbox-outlined\")]//i[contains(@class, \"arrows\")]") WebElement snip_Pointer;
	public @FindBy(xpath = "//div[contains(@class, \"ui-dragbox-outlined\")]//i[contains(@class, \"fa-code\")]") WebElement snip_Html;
	public @FindBy(xpath = "//textarea[@id=\"txtHtml\"]") WebElement snip_HtmlTextArea;
	public @FindBy(xpath = "//button[@id=\"btnHtmlOk\"]") WebElement btn_HtmlTextAreaOK;
	public @FindBy(xpath = "//div[contains(@class, \"ui-dragbox-outlined\")]//i[contains(@class, \"fa-plus\")]") WebElement snip_Plus;
	public @FindBy(xpath = "//div[contains(@class, \"ui-dragbox-outlined\")]//i[contains(@class, \"fa-trash\")]") WebElement snip_Delete;
	public @FindBy(xpath = "//h1[@id=\"joinourloyaltyprogramgetamassage\"]") WebElement img_Text;
	public @FindBy(xpath = "//div[@class=\"filter-group active\"]") WebElement OptionDDown;
	public @FindBy(xpath = "//img[contains(@src, \"/thumbnails/47.png\")]") WebElement imgToDrag;
	public @FindBy(xpath = "//div[@id=\"content-to-edit\"]") WebElement emptyHeaderBox;
	public @FindBy(xpath = "//div[@id=\"promotions\"]") WebElement par_Imgae;
	public List<WebElement> getNumberOfImage(String imgText) {
		return par_Imgae.findElements(By.xpath("//h1[text()=\'"+ imgText +"']"));
	}

	public @FindBy(xpath = "//div[contains(@class, \"col-xs-12\") and ./h1[@id=\"aboutus\"]]//p[1]") WebElement textAreaForEdit;
	
	public @FindBy(xpath = "//div[@id=\"body-content\"]") WebElement image;


	
	public String HTMLText = "<div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/07.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Printing</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" + 
			"        </div>\r\n" + 
			"        <div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/08.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Typesetting</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" + 
			"        </div>";
	
	
	public String HTMLTextEdited = "<div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/07.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Printing</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" + 
			"        </div>\r\n" + 
			"        <div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/08.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Typesetting</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry Edited.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" +  
			"        </div>";
	public String getHTMLTextEdited() {
		return HTMLTextEdited;
	}
	
}
